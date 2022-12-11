package tn.esprit.projet.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@Table( name = "Contrat")

public class Contrat implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idContrat")
    private Long idContrat; // Clé primaire
    @Temporal (TemporalType.DATE)
    private Date DateDebutContrat;
    @Temporal (TemporalType.DATE)
    private Date DateFinContrat;
    private  boolean archive;
    private Integer montantContrat;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    @JsonIgnore

    @ManyToOne(cascade = CascadeType.ALL)
    Etudiant Etudiant;

    public Contrat() {
    }
// Constructeur et accesseurs (getters) et mutateurs (setters)

}
