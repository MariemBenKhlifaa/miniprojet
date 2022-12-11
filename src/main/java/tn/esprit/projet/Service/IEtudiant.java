package tn.esprit.projet.Service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import tn.esprit.projet.Repository.InterfaceJPA;
import tn.esprit.projet.entities.Contrat;
import tn.esprit.projet.entities.Equipe;
import tn.esprit.projet.entities.Etudiant;

import java.util.List;
import java.util.Set;


public interface IEtudiant {
    public List<Etudiant> getallEtudiantt();
    public Etudiant AddEtudiant(Etudiant e);
    public Etudiant findetudiant(int id);
    public Etudiant updateEtudiant(Etudiant e);
    public void deleteEtudiant(int id);
    public Etudiant findetudiantbynom(String nom);
    public void affecteretudiantdepartement(int idetudiant,Long iddepartement);
    public Etudiant addetudianttoequipeandecontrat(Etudiant e,Long idc,Long idE);
    //public Etudiant affectcontrattoetudiant(Contrat contrat,String nom,String prenom);
    public List<Etudiant> findEtudiantByDepartement_idDepart(Long idDepart);

}
