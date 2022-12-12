package tn.esprit.projet.Repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.projet.entities.Equipe;
import tn.esprit.projet.entities.Niveau;
import tn.esprit.projet.entities.Option;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public interface InterfaceEquipejpa extends JpaRepository<Equipe,Long>,PagingAndSortingRepository<Equipe,Long> , JpaSpecificationExecutor<Equipe> {
    List<Equipe> findEquipeByEtudiantsIdEtudiant(Long idetudiant);
    List<Equipe> findEquipeBydetailEquipeThematiqueContains (String thematique);
    List<Equipe> findEquipeByetudiants_idEtudiantAndDetailEquipe_ThematiqueNotNull (Long idEtudiant);
    List<Equipe>findEquipeByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(Long idEtudiant,Long idDepart);
    ////////////////////////
    List<Equipe>findEquipeByEtudiantsNomAndEtudiantsPrenom(String nom, String prenom);
    List<Equipe> findEquipeByNiveau(Niveau niveau);

    List<Equipe>findEquipeByNiveauAndEtudiantsOption(Niveau niveau, Option option);

    @Query("Select eq.niveau, count(eq) FROM Equipe eq group by eq.niveau order by count(eq) desc")
    public String[] getNiv();

    List<Equipe>findEquipeByEtudiantsIdEtudiantOrDetailEquipeIdDetailEquipe( Integer idE,Long idD);

    List<Equipe>findEquipeByEtudiantsDepartementNomDepart(String dept);



}