package it.lucacosta.corsi.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.lucacosta.corsi.dto.CorsoResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Tag(name = "Corso", description = "API per la gestione dei corsi")
public interface ICorsoController {

    @Operation(summary = "Recupera lista corsi", description = "Ottiene la lista dei corsi filtrati opzionalmente per titolo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Corsi trovati con successo"),
            @ApiResponse(responseCode = "404", description = "Nessun corso trovato")
    })
    @GetMapping("/courses")
    ResponseEntity<List<CorsoResponseDto>> getCorsi(
            @Parameter(description = "Titolo del corso da cercare (opzionale)") @RequestParam(name = "name", defaultValue = "", required = false) String titolo);
}