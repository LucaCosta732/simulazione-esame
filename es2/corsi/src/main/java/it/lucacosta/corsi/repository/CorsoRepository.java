package it.lucacosta.corsi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.lucacosta.corsi.model.Corso;

public interface CorsoRepository extends JpaRepository<Corso, Long> {



    //Find by titolo disponibilita > 0
    List<Corso> findByTitoloContainingIgnoreCaseAndDisponibilitaGreaterThan(String titolo, int disponibilita);
    
    //Find all disponibilita > 0
    List<Corso> findByDisponibilitaGreaterThan(int disponibilita);

}
