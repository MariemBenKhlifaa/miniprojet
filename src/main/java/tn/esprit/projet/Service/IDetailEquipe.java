package tn.esprit.projet.Service;

import tn.esprit.projet.entities.DetailEquipe;
import tn.esprit.projet.entities.Etudiant;

import java.util.List;

public interface IDetailEquipe {
    public List<DetailEquipe> getalldetailequipe();
    public DetailEquipe Adddetailequipe(DetailEquipe e);
    public DetailEquipe finddetailequipe(Long id);
    public DetailEquipe updatedetailequipe(DetailEquipe e);
    public void deletedetailequipe(Long id);
}
