package tn.esprit.projet.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projet.Repository.InterfaceContratjpa;
import tn.esprit.projet.Repository.InterfaceJPA;
import tn.esprit.projet.entities.Contrat;
import tn.esprit.projet.entities.Etudiant;
import tn.esprit.projet.entities.Specialite;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContratService implements IContrat {
    @Autowired
    InterfaceContratjpa interfaceContratjpa;
    @Autowired
    InterfaceJPA interfaceJPA;

    @Override
    public List<Contrat> getallContrat() {
        return interfaceContratjpa.findAll();
    }

    @Override
    public Contrat AddContrat(Contrat e) {
        return interfaceContratjpa.save(e);
    }

    @Override
    public Contrat findContrat(Long id) {
        return interfaceContratjpa.findById(id).get();
    }

    @Override
    public Contrat updateContrat(Contrat e) {
        return interfaceContratjpa.save(e);
    }

    @Override
    public void deleteContrat(Long id) {
        interfaceContratjpa.deleteById(id);

    }

    @Override
    public Contrat affectcontrattoetudiant(Contrat contrat, String nom, String prenom) {
        Etudiant e = interfaceJPA.findEtudiantByNomAndPrenom(nom, prenom);

        //   e.getContrats().add(contrat);
        contrat.setEtudiant(e);
        interfaceContratjpa.save(contrat);


        return contrat;
    }

    @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        List<Contrat> contrats = new ArrayList<>();
        contrats = interfaceContratjpa.findAll();
      int monthes= ((endDate.getYear()-startDate.getYear())*12)+(endDate.getMonth()-startDate.getMonth())+((endDate.getDay()-startDate.getDay())/30);
        for(Specialite specialite:Specialite.values())
        {
            if(specialite.toString().equals("IA")) {
                float prixai= contrats.stream().filter(e -> e.getSpecialite().toString().equals(Specialite.IA)&& e.isArchive()==false && e.getDateDebutContrat().equals(startDate) && e.getDateFinContrat().equals(endDate)).count();

              return   prixai*300*monthes;
            }
            else if (specialite.toString().equals("CLOUD")){
                float prixai= contrats.stream().filter(e -> e.getSpecialite().toString().equals(Specialite.CLOUD)&& e.isArchive()==false && e.getDateDebutContrat().equals(startDate) && e.getDateFinContrat().equals(endDate)).count();

             return    prixai*400*monthes;
            }
            else if (specialite.toString().equals("SECURITE"))
            {
                float prixai= contrats.stream().filter(e -> e.getSpecialite().toString().equals(Specialite.SECURITE)&& e.isArchive()==false && e.getDateDebutContrat().equals(startDate) && e.getDateFinContrat().equals(endDate)).count();

              return   prixai*350*monthes;

            }
            else if(specialite.toString().equals("RESEAUX"))
            {
                float prixai= contrats.stream().filter(e -> e.getSpecialite().toString().equals(Specialite.RESEAUX)&& e.isArchive()==false && e.getDateDebutContrat().equals(startDate) && e.getDateFinContrat().equals(endDate)).count();

              return   prixai*450*monthes;

            }


        }


        return 0;
    }

    @Override
    public Long countContrat() {
        return interfaceContratjpa.count();
    }

    @Override
    public Long ContContratArchive() {

        return  interfaceContratjpa.ContContratArchive();
    }

    @Override
    public Long MontantMaxContrat() {
        return interfaceContratjpa.MontantMaxContrat();
    }

    @Override
    public void desaffecterEtudiantAuContrat(Long id) {
        Contrat as = interfaceContratjpa.findById(id).orElse(null);
        as.setEtudiant(null);  ;
        interfaceContratjpa.save(as);
    }



}