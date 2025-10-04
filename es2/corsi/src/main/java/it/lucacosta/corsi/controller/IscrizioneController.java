package it.lucacosta.corsi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.lucacosta.corsi.controller.api.IIscrizioneController;
import it.lucacosta.corsi.dto.IscrizioneRequestDto;
import it.lucacosta.corsi.dto.IscrizioneResponseDto;
import it.lucacosta.corsi.service.IscrizioneService;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class IscrizioneController implements IIscrizioneController {

    @Autowired
    private IscrizioneService iscrizioneService;

    @Override
    public ResponseEntity<List<IscrizioneResponseDto>> getIscrizioni(
            String titolo, Long corso_id, String email, String luogo) {
        return new ResponseEntity<>(
            iscrizioneService.getIscrizione(corso_id, titolo, email, luogo), 
            HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<IscrizioneResponseDto> addIscrizione(
            @Valid @RequestBody IscrizioneRequestDto iscrizione) {
        return new ResponseEntity<>(
            iscrizioneService.addIscrizione(iscrizione), 
            HttpStatus.OK
        );
    }
}