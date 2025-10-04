package it.lucacosta.corsi.dto;

public class CorsoResponseDto {
    private Long corso_id;
    private String titolo;
    private String data_ora_inizio;
    private String luogo;
    private int disponibilita;

    // Default constructor
    public CorsoResponseDto() {
    }

    // All-args constructor
    public CorsoResponseDto(Long corso_id, String titolo, String data_ora_inizio, String luogo, int disponibilita) {
        this.corso_id = corso_id;
        this.titolo = titolo;
        this.data_ora_inizio = data_ora_inizio;
        this.luogo = luogo;
        this.disponibilita = disponibilita;
    }

    // Getters and Setters
    public Long getCorso_id() {
        return corso_id;
    }

    public void setCorso_id(Long corso_id) {
        this.corso_id = corso_id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getData_ora_inizio() {
        return data_ora_inizio;
    }

    public void setData_ora_inizio(String data_ora_inizio) {
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
