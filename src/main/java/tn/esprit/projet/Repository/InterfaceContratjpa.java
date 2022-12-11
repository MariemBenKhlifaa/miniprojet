package tn.esprit.projet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.projet.entities.Contrat;
import tn.esprit.projet.entities.Specialite;

import java.util.Date;
import java.util.Set;

@Repository
public interface InterfaceContratjpa extends JpaRepository<Contrat,Long> {
    @Query("select ct FROM Contrat ct where(?1 between  ct.DateDebutContrat and ct.DateFinContrat)")
    Set<Contrat> getContratBetweenDates(Date startDate, Date endDate);

    @Query(" select  SUM(ct.montantContrat) FROM Contrat ct")
    public Long ContContratArchive();
    @Query(" select  MAX(ct.montantContrat) FROM Contrat ct")

    public Long MontantMaxContrat();
    @Query(" select  SUM(ct.montantContrat) FROM Contrat ct where ct.specialite = :specialite")

    public float SommeMontantSelonSpecialie(Specialite specialite);

}