package it.lucacosta.corsi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.lucacosta.corsi.dto.CorsoResponseDto;

import it.lucacosta.corsi.mapper.EntityMapper;
import it.lucacosta.corsi.repository.CorsoRepository;
import it.lucacosta.corsi.service.CorsoService;

@Service
public class CorsoServiceImpl implements CorsoService {

    @Autowired
    private CorsoRepository corsoRepository;

    @Autowired
    private EntityMapper entityMapper;

    @Override
    public List<CorsoResponseDto> getCorso(String param) {

        if (param.isBlank()) {
            return entityMapper.toCorsoResponseDto(corsoRepository.findByDisponibilitaGreaterThan(0));
        }

        return entityMapper.toCorsoResponseDto(
                corsoRepository.findByTitoloContainingIgnoreCaseAndDisponibilitaGreaterThan(param, 0));

    }

}
