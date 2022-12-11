package tn.esprit.projet.Service;

import tn.esprit.projet.entities.Contrat;
import tn.esprit.projet.entities.Etudiant;

import java.util.Date;
import java.util.List;

public interface IContrat {
    public List<Contrat> getallContrat();
    public Contrat AddContrat(Contrat e);
    public Contrat findContrat(Long id);
    public Contrat updateContrat(Contrat e);
    public void deleteContrat(Long id);
    public Contrat affectcontrattoetudiant(Contrat contrat, String nom, String prenom);
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);
    public Long countContrat();
    public Long ContContratArchive();
    public Long MontantMaxContrat();

   public  void desaffecterEtudiantAuContrat( Long id );


}
