package it.lucacosta.corsi.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "corso")
@Entity
public class Corso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long corso_id;
    private String titolo;
    private LocalDateTime data_ora_inizio;
    private String luogo;
    private int disponibilita;

     
    public Corso(Long corso_id, String titolo, LocalDateTime data_ora_inizio, String luogo, int disponibilita) {
        this.corso_id = corso_id;
        this.titolo = titolo;
        this.data_ora_inizio = data_ora_inizio;
        this.luogo = luogo;
        this.disponibilita = disponibilita;
    }

    public Corso() {
    }

    public Long getCorso_id() {
        return this.corso_id;
    }

    public void setCorso_id(Long corso_id) {
        this.corso_id = corso_id;
    }

    public String getTitolo() {
        return this.titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDateTime getData_ora_inizio() {
        return this.data_ora_inizio;
    }

    public void setData_ora_inizio(LocalDateTime data_ora_inizio) {
        this.data_ora_inizio = data_ora_inizio;
    }

    public String getLuogo() {
        return this.luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public int getDisponibilita() {
        return this.disponibilita;
    }

    public void setDisponibilita(int disponibilita) {
        this.disponibilita = disponibilita;
    }

}
