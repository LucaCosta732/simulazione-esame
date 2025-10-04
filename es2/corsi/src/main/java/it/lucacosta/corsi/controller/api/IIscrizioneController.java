package it.lucacosta.corsi.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.lucacosta.corsi.dto.IscrizioneRequestDto;
import it.lucacosta.corsi.dto.IscrizioneResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Tag(name = "Iscrizioni", description = "API per la gestione delle iscrizioni ai corsi")
public interface IIscrizioneController {

    @Operation(summary = "Ottieni iscrizioni", description = "Recupera la lista delle iscrizioni filtrate per titolo, email e luogo")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista iscrizioni recuperata con successo"),
        @ApiResponse(responseCode = "500", description = "Errore interno del server")
    })
    @GetMapping("/enrollments")
    ResponseEntity<List<IscrizioneResponseDto>> getIscrizioni(
        @Parameter(description = "Filtra per titolo del corso") @RequestParam(defaultValue = "", required = false) String titolo,
        @Parameter(description = "Filtra per corso_id") @RequestParam(required = false) Long corso_id,
        @Parameter(description = "Filtra per email dello studente") @RequestParam(defaultValue = "", required = false) String email,
        @Parameter(description = "Filtra per luogo del corso") @RequestParam(defaultValue = "", required = false) String luogo);

    @Operation(summary = "Aggiungi iscrizione", description = "Crea una nuova iscrizione a un corso")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Iscrizione creata con successo"),
        @ApiResponse(responseCode = "400", description = "Dati iscrizione non validi"),
        @ApiResponse(responseCode = "500", description = "Errore interno del server")
    })
    @PostMapping("/enrollments")
    ResponseEntity<IscrizioneResponseDto> addIscrizione(
        @Parameter(description = "Dati dell'iscrizione da creare") @Valid @RequestBody IscrizioneRequestDto iscrizione);
}