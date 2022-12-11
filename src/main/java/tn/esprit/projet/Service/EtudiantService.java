package tn.esprit.projet.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.projet.Repository.Inrerfacedepjap;
import tn.esprit.projet.Repository.InterfaceContratjpa;
import tn.esprit.projet.Repository.InterfaceEquipejpa;
import tn.esprit.projet.Repository.InterfaceJPA;
import tn.esprit.projet.entities.Contrat;
import tn.esprit.projet.entities.Departement;
import tn.esprit.projet.entities.Equipe;
import tn.esprit.projet.entities.Etudiant;

import java.util.*;
import java.util.function.Function;
@Service
public class
EtudiantService implements IEtudiant {

      @Autowired

        InterfaceJPA interfacejpa ;
      @Autowired
    Inrerfacedepjap inrerfacedepjap;
    @Autowired
      InterfaceContratjpa interfaceContratjpa;
    @Autowired
    InterfaceEquipejpa interfaceEquipejpa;
    Set<Contrat> contrats=new HashSet<>();
    List<Equipe>equipes= new ArrayList<>();

    @Override
    public List<Etudiant> getallEtudiantt() {
    return interfacejpa.findAll();
    }

    @Override
    public Etudiant AddEtudiant(Etudiant e) {
        return interfacejpa.save(e);
    }

    @Override
    public Etudiant findetudiant(int id) {
        return interfacejpa.findById(id).get();

    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return interfacejpa.save(e);
    }

    @Override
    public void deleteEtudiant(int id) {
         interfacejpa.deleteById(id);

    }

    @Override
    public Etudiant findetudiantbynom(String nom) {
       return interfacejpa.findEtudiantByNom(nom);
    }

    @Override
    public void affecteretudiantdepartement(int idetudiant, Long iddepartement) {
       Etudiant etu=interfacejpa.findById(idetudiant).get();
        Departement departement=inrerfacedepjap.findById(iddepartement).get();

        etu.setDepartement(departement);
        interfacejpa.save(etu);


    }


    @Override
    public Etudiant addetudianttoequipeandecontrat(Etudiant e, Long idc, Long idE) {

        Contrat c=interfaceContratjpa.findById(idc).get();
       // contrats.add(c);
        Equipe equipe= interfaceEquipejpa.findById(idE).get();
        equipes.add(equipe);
        c.setEtudiant(e);
        e.setEquipes(equipes);
        interfacejpa.save(e);
     //  equipe.getEtudiants().add(e);

        //@transactional ki nmesou plusieurs tables
        return e;
    }

    @Override
    public List<Etudiant> findEtudiantByDepartement_idDepart(Long idDepart) {
        return interfacejpa.findEtudiantByDepartement_idDepart(idDepart);
    }


}
