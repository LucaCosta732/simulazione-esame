package it.lucacosta.corsi.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.lucacosta.corsi.dto.CorsoResponseDto;
import it.lucacosta.corsi.dto.IscrizioneRequestDto;
import it.lucacosta.corsi.dto.IscrizioneResponseDto;
import it.lucacosta.corsi.exception.CorsoNonTrovatoException;
import it.lucacosta.corsi.exception.PostoNonDisponibileException;
import it.lucacosta.corsi.mapper.EntityMapper;
import it.lucacosta.corsi.model.Corso;
import it.lucacosta.corsi.model.Iscrizione;
import it.lucacosta.corsi.repository.CorsoRepository;
import it.lucacosta.corsi.repository.IscrizioneRepository;
import it.lucacosta.corsi.service.IscrizioneService;

@Service
public class IscrizioneServiceImpl implements IscrizioneService {

    @Autowired
    private IscrizioneRepository iscrizioneRepository;

    @Autowired
    private CorsoRepository corsoRepository;

    @Autowired
    private EntityMapper entityMapper;

    @Override
    public List<IscrizioneResponseDto> getIscrizione(Long corso_id, String corso, String email, String luogo) {

        if (corso_id != null) {

            List<Iscrizione> iscrizione = iscrizioneRepository.findAll(corso_id)
                    .orElseThrow(() -> new CorsoNonTrovatoException("Il corso non esiste"));

            return entityMapper.toIscrizioneResponseDto(iscrizione);
        }

        if (corso.isBlank() && email.isBlank() && luogo.isBlank()) {
            return entityMapper.toIscrizioneResponseDto(iscrizioneRepository.findAll());
        }

        return entityMapper
                .toIscrizioneResponseDto(iscrizioneRepository.findByTitoloCorsoAndEmailContaining(corso, email, luogo));
    }

    @Override
    public IscrizioneResponseDto addIscrizione(IscrizioneRequestDto iscrizioneRequestDto) {

        // Recupero e validazione del corso
        Corso corso = corsoRepository.findById(iscrizioneRequestDto.getCorso_id())
                .orElseThrow(() -> new CorsoNonTrovatoException("Il corso non esiste"));

        // Verifica posti disponibili
        if (corso.getDisponibilita() <= 0) {
            throw new PostoNonDisponibileException("Non ci sono posti disponibili per questo corso");
        }

        // Aggiorna posti disponibili (se necessario)
        corso.setDisponibilita(corso.getDisponibilita() - 1);
        corsoRepository.save(corso);

        // Creazione e salvataggio dell'iscrizione
        Iscrizione iscrizione = entityMapper.toIscrizioneEntity(iscrizioneRequestDto);
        iscrizione.setCorso(corso);
        iscrizione.setData_ora_iscrizione(LocalDateTime.now());
        iscrizione = iscrizioneRepository.save(iscrizione);

        // Preparazione della risposta
        CorsoResponseDto corsoResponseDto = entityMapper.toCorsoResponseDto(corso);
        IscrizioneResponseDto iscrizioneResponseDto = entityMapper.toIscrizioneResponseDto(iscrizione);
        iscrizioneResponseDto.setCorso(corsoResponseDto);

        return iscrizioneResponseDto;
    }

}
