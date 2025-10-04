package it.lucacosta.corsi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class IscrizioneRequestDto {
    
    @NotNull(message = "L'ID del corso non può essere null")
    private Long corso_id;

    @NotBlank(message = "Il nome è obbligatorio")
    private String partecipante_nome;

    @NotBlank(message = "Il cognome è obbligatorio")
    private String partecipante_cognome;

    @NotBlank(message = "L'email è obbligatoria")
    @Email(message = "Formato email non valido")
    private String partecipante_email;

    // Default constructor
    public IscrizioneRequestDto() {
    }

    // All-args constructor
    public IscrizioneRequestDto(Long corso_id, String partecipante_nome, String partecipante_cognome,
            String partecipante_email) {
        this.corso_id = corso_id;
        this.partecipante_nome = partecipante_nome;
        this.partecipante_cognome = partecipante_cognome;
        this.partecipante_email = partecipante_email;
    }

    // Getters and Setters
    public Long getCorso_id() {
        return corso_id;
    }

    public void setCorso_id(Long corso_id) {
        this.corso_id = corso_id;
    }

    public String getPartecipante_nome() {
        return partecipante_nome;
    }

    public void setPartecipante_nome(String partecipante_nome) {
        this.partecipante_nome = partecipante_nome;
    }

    public String getPartecipante_cognome() {
        return partecipante_cognome;
    }

    public void setPartecipante_cognome(String partecipante_cognome) {
        this.partecipante_cognome = partecipante_cognome;
    }

    public String getPartecipante_email() {
        return partecipante_email;
    }

    public void setPartecipante_email(String partecipante_email) {
        this.partecipante_email = partecipante_email;
    }

}
