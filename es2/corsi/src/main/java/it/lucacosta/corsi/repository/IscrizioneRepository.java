package it.lucacosta.corsi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.lucacosta.corsi.model.Iscrizione;

public interface IscrizioneRepository extends JpaRepository<Iscrizione, Long> {

    @Query("SELECT i FROM Iscrizione i WHERE " +
            "(:titolo IS NULL OR LOWER(i.corso.titolo) LIKE LOWER(CONCAT('%', :titolo, '%'))) AND " +
            "(:email IS NULL OR LOWER(i.partecipante_email) LIKE LOWER(CONCAT('%', :email, '%'))) AND " +
            "(:luogo IS NULL OR LOWER(i.corso.luogo) LIKE LOWER(CONCAT('%', :luogo, '%')))")
    List<Iscrizione> findByTitoloCorsoAndEmailContaining(
            @Param("titolo") String titolo,
            @Param("email") String email,
            @Param("luogo") String luogo);



        //Find all iscrizioni by corso_id
        @Query("SELECT i FROM Iscrizione i WHERE i.corso.corso_id = :corso_id")
        Optional<List<Iscrizione>> findAll(@Param("corso_id") Long corso_id);

}
