package tn.esprit.projet.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projet.Repository.InterfaceEquipejpa;
import tn.esprit.projet.Repository.InterfaceJPA;
import tn.esprit.projet.entities.Equipe;

import java.util.List;
import java.util.Set;

@Service
public class EquipeService implements  IEquipe{
    @Autowired
    InterfaceEquipejpa interfaceEquipejpa;

    @Override
    public List<Equipe> getallEquipe() {
        return interfaceEquipejpa.findAll();
    }

    @Override
    public Equipe AddEquipe(Equipe e) {
        return interfaceEquipejpa.save(e);
    }

    @Override
    public Equipe findeEquipe(  Long id) {
        return interfaceEquipejpa.findById(id).get();
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return interfaceEquipejpa.save(e);
    }

    @Override
    public void deleteEquipe(Long id) {
        interfaceEquipejpa.deleteById(id);

    }

    @Override
    public List<Equipe> findetudiantidetudiant(Long idetudiant) {
        return interfaceEquipejpa.findEquipeByEtudiantsIdEtudiant(idetudiant);
    }

    @Override
    public List<Equipe> findEquipeByDetailEquipethematique(String thematique) {
        return interfaceEquipejpa.findEquipeBydetailEquipe1ThematiqueContains(thematique);
    }

    @Override
    public List<Equipe> findByetudiantsidEtudiantAnddetailEquipeThematiqueNotNull(Long idEtudiant) {
        return interfaceEquipejpa.findEquipeByetudiants_idEtudiantAndDetailEquipe1_ThematiqueNotNull(idEtudiant);
    }

    @Override
    public List<Equipe> findEquipeByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(Long idEtudiant, Long idDepart) {
        return interfaceEquipejpa.findEquipeByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(idEtudiant,idDepart);
    }

}
