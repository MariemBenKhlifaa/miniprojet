package tn.esprit.projet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.projet.entities.Departement;

@Repository
public interface Inrerfacedepjap extends JpaRepository<Departement,Long> {
}
