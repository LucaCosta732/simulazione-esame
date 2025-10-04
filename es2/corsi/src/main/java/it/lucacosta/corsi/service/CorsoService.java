package it.lucacosta.corsi.service;

import java.util.List;

import it.lucacosta.corsi.dto.CorsoResponseDto;

public interface CorsoService {

    List<CorsoResponseDto> getCorso(String param);
    
}
