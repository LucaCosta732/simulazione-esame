package it.lucacosta.corsi.service;

import java.util.List;

import it.lucacosta.corsi.dto.IscrizioneRequestDto;
import it.lucacosta.corsi.dto.IscrizioneResponseDto;

public interface IscrizioneService {
    List<IscrizioneResponseDto> getIscrizione(Long corso_id, String corso, String email, String luogo);

    IscrizioneResponseDto addIscrizione(IscrizioneRequestDto iscrizione);
}
