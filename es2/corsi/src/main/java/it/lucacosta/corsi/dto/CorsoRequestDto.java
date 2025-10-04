package it.lucacosta.corsi.dto;

import java.time.LocalDateTime;

public class CorsoRequestDto {
    private String titolo;
    private LocalDateTime data_ora_inizio;
    private String luogo;
    private int disponibilita;

    // Default constructor
    public CorsoRequestDto() {
    }

    // All-args constructor
    public CorsoRequestDto(String titolo, LocalDateTime data_ora_inizio, String luogo, int disponibilita) {
        this.titolo = titolo;
        this.data_ora_inizio = data_ora_inizio;
        this.luogo = luogo;
        this.disponibilita = disponibilita;
    }

    // Getters and Setters
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDateTime getData_ora_inizio() {
        return data_ora_inizio;
    }

    public void setData_ora_inizio(LocalDateTime data_ora_inizio) {
        this.data_ora_inizio = data_ora_inizio;
    }

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public int getDisponibilita() {
        return disponibilita;
    }

    public void setDisponibilita(int disponibilita) {
        this.disponibilita = disponibilita;
    }
}
