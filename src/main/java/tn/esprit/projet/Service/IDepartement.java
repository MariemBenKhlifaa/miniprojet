package tn.esprit.projet.Service;

import tn.esprit.projet.entities.Departement;
import tn.esprit.projet.entities.Etudiant;

import java.util.List;

public interface IDepartement {
    public List<Departement> getalldep();
    public Departement Adddep(Departement e);
    public Departement findedep(Long id);
    public Departement updatedep(Departement e);
    public void deletedep(Long  id);
}
