package tn.esprit.projet.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.projet.entities.Universite;

import java.util.Optional;

public interface UniversiteRepository extends JpaRepository <Universite,Long> {

}
