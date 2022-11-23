package tn.esprit.projet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.projet.entities.Equipe;

import java.util.List;
import java.util.Set;

@Repository
public interface InterfaceEquipejpa extends JpaRepository<Equipe,Long> {
    List<Equipe> findEquipeByEtudiantsIdEtudiant(Long idetudiant);
    List<Equipe> findEquipeBydetailEquipe1ThematiqueContains (String thematique);
    List<Equipe> findEquipeByetudiants_idEtudiantAndDetailEquipe1_ThematiqueNotNull (Long idEtudiant);
    List<Equipe>findEquipeByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(Long idEtudiant,Long idDepart);
}