package tn.esprit.projet.Service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.projet.entities.*;

import java.util.List;
import java.util.Set;

public interface IEquipe {
    public List<Equipe> getallEquipe();
    public Equipe AddEquipe(Equipe e);
    public Equipe findeEquipe(Long id);
    public Equipe updateEquipe(Equipe e);
    public void deleteEquipe(Long id);
    public List<Equipe> findetudiantidetudiant(Long idetudiant);
    List<Equipe> findEquipeByDetailEquipethematique (String thematique);
    List<Equipe> findByetudiantsidEtudiantAndDetailEquipeThematiqueNotNull (Long idEtudiant);
    List<Equipe>findEquipeByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(Long idEtudiant,Long idDepart);

    ////////////////////////////

    public List<Equipe> get(Specification<Equipe> spec, Pageable pageable) ;
    public String[] getNiv() ;

    List<Equipe>findEquipeByEtudiantsNomAndPrenom(String nom, String prenom);

    List<Equipe> findeq(Niveau niveau);

    List<Equipe>findEquipeByNiveauAndEtudiantsOption(Niveau niveau, Option option);
    List<Equipe>findId( Integer idE, Long idD);

    List<Equipe>findEquipeByEtudiantsDepartementNomDepart(String dept);

    public void affecterEquipeToDetail(Long idE, Long idD);


}
