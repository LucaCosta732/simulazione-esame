package it.lucacosta.corsi.dto;

import java.time.LocalDateTime;

public class IscrizioneResponseDto {
    private Long iscrizione_id;
    private CorsoResponseDto corso;
    private String partecipante_nome;
    private String partecipante_cognome;
    private String partecipante_email;
    private LocalDateTime data_ora_iscrizione;

    // Default constructor
    public IscrizioneResponseDto() {
    }

    // All-args constructor
    public IscrizioneResponseDto(Long iscrizione_id, CorsoResponseDto corso, String partecipante_nome,
            String partecipante_cognome, String partecipante_email, LocalDateTime data_ora_iscrizione) {
        this.iscrizione_id = iscrizione_id;
        this.corso = corso;
        this.partecipante_nome = partecipante_nome;
        this.partecipante_cognome = partecipante_cognome;
        this.partecipante_email = partecipante_email;
        this.data_ora_iscrizione = data_ora_iscrizione;
    }

    // Getters and Setters
    public Long getIscrizione_id() {
        return iscrizione_id;
    }

    public void setIscrizione_id(Long iscrizione_id) {
        this.iscrizione_id = iscrizione_id;
    }

    public CorsoResponseDto getCorso() {
        return corso;
    }

    public void setCorso(CorsoResponseDto corso) {
        this.corso = corso;
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

    public LocalDateTime getData_ora_iscrizione() {
        return data_ora_iscrizione;
    }

    public void setData_ora_iscrizione(LocalDateTime data_ora_iscrizione) {
        this.data_ora_iscrizione = data_ora_iscrizione;
    }
}
