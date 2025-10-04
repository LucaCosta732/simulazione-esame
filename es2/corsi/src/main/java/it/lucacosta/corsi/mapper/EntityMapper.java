package it.lucacosta.corsi.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.lucacosta.corsi.dto.CorsoRequestDto;
import it.lucacosta.corsi.dto.CorsoResponseDto;
import it.lucacosta.corsi.dto.IscrizioneRequestDto;
import it.lucacosta.corsi.dto.IscrizioneResponseDto;
import it.lucacosta.corsi.model.Corso;
import it.lucacosta.corsi.model.Iscrizione;

@Mapper(componentModel = "spring")
public interface EntityMapper {
    

    //Corso mapper
    @Mapping(target = "corso_id", ignore = true)
    Corso toCorsoEntity(CorsoRequestDto corsoRequestDto);
    List<Corso> toCorsoEntity(List<CorsoRequestDto> corsoRequestDto);

    CorsoResponseDto toCorsoResponseDto(Corso corso);
    List<CorsoResponseDto> toCorsoResponseDto(List<Corso> corsi);

    //Iscrizione mapper
    @Mapping(target = "iscrizione_id", ignore = true)
    @Mapping(target = "corso", ignore = true)
    @Mapping(target = "data_ora_iscrizione", ignore = true)
    Iscrizione toIscrizioneEntity(IscrizioneRequestDto iscrizioneRequestDto);
    List<Iscrizione> toIscrizioneEntity(List<IscrizioneRequestDto> iscrizioniRequestDto);

    IscrizioneResponseDto toIscrizioneResponseDto(Iscrizione iscrizione);
    List<IscrizioneResponseDto> toIscrizioneResponseDto(List<Iscrizione> iscrizioni);



}
