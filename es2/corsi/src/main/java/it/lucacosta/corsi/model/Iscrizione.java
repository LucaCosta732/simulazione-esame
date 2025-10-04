package it.lucacosta.corsi.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Iscrizione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iscrizione_id;

    @ManyToOne
    @JoinColumn(name = "corso_id")
    private Corso corso;

    private String partecipante_nome;
    private String partecipante_cognome;
    private String partecipante_email;
    private LocalDateTime data_ora_iscrizione;

    public Iscrizione(Long iscrizione_id, Corso corso, String partecipante_nome, String partecipante_cognome,
            String partecipante_email, LocalDateTime data_ora_iscrizione) {
        this.iscrizione_id = iscrizione_id;
        this.corso = corso;
        this.partecipante_nome = partecipante_nome;
        this.partecipante_cognome = partecipante_cognome;
        this.partecipante_email = partecipante_email;
        this.data_ora_iscrizione = data_ora_iscrizione;
    }

    public Iscrizione() {
    }

    public Long getIscrizione_id() {
        return this.iscrizione_id;
    }

    public void setIscrizione_id(Long iscrizione_id) {
        this.iscrizione_id = iscrizione_id;
    }

    public Corso getCorso() {
        return this.corso;
    }

    public void setCorso(Corso corso) {
        this.corso = corso;
    }

    public String getPartecipante_nome() {
        return this.partecipante_nome;
    }

    public void setPartecipante_nome(String partecipante_nome) {
        this.partecipante_nome = partecipante_nome;
    }

    public String getPartecipante_cognome() {
        return this.partecipante_cognome;
    }

    public void setPartecipante_cognome(String partecipante_cognome) {
        this.partecipante_cognome = partecipante_cognome;
    }

    public String getPartecipante_email() {
        return this.partecipante_email;
    }

    public void setPartecipante_email(String partecipante_email) {
        this.partecipante_email = partecipante_email;
    }

    public LocalDateTime getData_ora_iscrizione() {
        return this.data_ora_iscrizione;
    }

    public void setData_ora_iscrizione(LocalDateTime data_ora_iscrizione) {
        this.data_ora_iscrizione = data_ora_iscrizione;
    }

}
