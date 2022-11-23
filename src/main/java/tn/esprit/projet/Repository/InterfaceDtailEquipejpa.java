package tn.esprit.projet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.projet.entities.DetailEquipe;
@Repository
public interface InterfaceDtailEquipejpa extends JpaRepository<DetailEquipe,Long> {
}
