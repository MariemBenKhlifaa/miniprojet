package tn.esprit.projet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.projet.entities.DetailEquipe;
@Repository
public interface InterfaceDtailEquipejpa extends JpaRepository<DetailEquipe,Long> {
    @Query("Select d from DetailEquipe d where d.Equipe.idEquipe=:idEquipe")
    public DetailEquipe findDetailEquipeByEquipeIdEquipe(@PathVariable("idEquipe") Long idEquipe);
}
