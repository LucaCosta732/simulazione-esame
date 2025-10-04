package it.lucacosta.corsi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.lucacosta.corsi.controller.api.ICorsoController;
import it.lucacosta.corsi.dto.CorsoResponseDto;
import it.lucacosta.corsi.service.CorsoService;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CorsoController implements ICorsoController {

    @Autowired
    private CorsoService corsoService;

    @Override
    public ResponseEntity<List<CorsoResponseDto>> getCorsi(String titolo) {
        return new ResponseEntity<>(corsoService.getCorso(titolo), HttpStatus.OK);
    }
}