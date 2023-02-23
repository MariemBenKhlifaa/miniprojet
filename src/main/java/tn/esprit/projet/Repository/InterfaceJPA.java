package tn.esprit.projet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import tn.esprit.projet.entities.Equipe;
import tn.esprit.projet.entities.Etudiant;

import java.util.List;
import java.util.Set;

@Repository
public interface InterfaceJPA extends JpaRepository<Etudiant,Integer> {


    Etudiant findEtudiantByNom(String nom);
    Etudiant findEtudiantByNomAndPrenom(String nom,String prenom);

   public List<Etudiant> findEtudiantByDepartement_idDepart(Long idDepart);
    public  List<Etudiant> findEtudiantByContratsIdContrat(Long idContrat);
}
