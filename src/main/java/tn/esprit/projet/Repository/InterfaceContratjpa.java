package tn.esprit.projet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.projet.entities.Contrat;
@Repository
public interface InterfaceContratjpa extends JpaRepository<Contrat,Long> {
}
