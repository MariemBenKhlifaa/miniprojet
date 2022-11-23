package tn.esprit.projet.Service;

import tn.esprit.projet.entities.Equipe;
import tn.esprit.projet.entities.Etudiant;

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
    List<Equipe> findByetudiantsidEtudiantAnddetailEquipeThematiqueNotNull (Long idEtudiant);
    List<Equipe>findEquipeByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(Long idEtudiant,Long idDepart);
}
