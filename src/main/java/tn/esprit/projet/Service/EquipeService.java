package tn.esprit.projet.Service;

import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.projet.Repository.InterfaceDtailEquipejpa;
import tn.esprit.projet.Repository.InterfaceEquipejpa;
import tn.esprit.projet.Repository.InterfaceJPA;
import tn.esprit.projet.entities.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class EquipeService implements  IEquipe{
    @Autowired
    InterfaceEquipejpa interfaceEquipejpa;
    @Autowired
    InterfaceDtailEquipejpa interfaceDtailEquipejpa;

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
        return interfaceEquipejpa.findEquipeBydetailEquipeThematiqueContains(thematique);
    }

    @Override
    public List<Equipe> findByetudiantsidEtudiantAndDetailEquipeThematiqueNotNull(Long idEtudiant) {
        return interfaceEquipejpa.findEquipeByetudiants_idEtudiantAndDetailEquipe_ThematiqueNotNull(idEtudiant);
    }

    @Override
    public List<Equipe> findEquipeByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(Long idEtudiant, Long idDepart) {
        return interfaceEquipejpa.findEquipeByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(idEtudiant,idDepart);
    }

    @Override
    public List<Equipe> get(Specification<Equipe> spec,Pageable pageable) {

        return interfaceEquipejpa.findAll(spec, pageable).toList();
        }

    @Override
    public String[] getNiv() {
        return interfaceEquipejpa.getNiv();
    }
    @Override
    public List<Equipe> findEquipeByEtudiantsNomAndPrenom(String nom, String prenom) {
        return interfaceEquipejpa.findEquipeByEtudiantsNomAndEtudiantsPrenom(nom, prenom);
    }

    @Override
    public List<Equipe> findeq(Niveau niveau){
        return interfaceEquipejpa.findEquipeByNiveau(niveau);
    }
@Override
public List<Equipe>findEquipeByNiveauAndEtudiantsOption(Niveau niveau, Option option){
        return interfaceEquipejpa.findEquipeByNiveauAndEtudiantsOption(niveau, option);

}
@Override
    public List<Equipe>findId( Integer idE,Long idD){
        return interfaceEquipejpa.findEquipeByEtudiantsIdEtudiantOrDetailEquipeIdDetailEquipe(idE,idD);
}
@Override
    public List<Equipe>findEquipeByEtudiantsDepartementNomDepart(String dept){
        return  interfaceEquipejpa.findEquipeByEtudiantsDepartementNomDepart(dept);

}
@Override
    public void affecterEquipeToDetail(Long idE, Long idD){
    Equipe eq=interfaceEquipejpa.findById(idE).get();
    DetailEquipe deq=interfaceDtailEquipejpa.findById(idD).get();
    eq.setDetailEquipe(deq);
    interfaceEquipejpa.save(eq);



}

}
