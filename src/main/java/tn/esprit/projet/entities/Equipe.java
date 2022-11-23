package tn.esprit.projet.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@Table( name = "Equipe")

public class Equipe implements  Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idEquipe")
    private Long idEquipe; // Clé primaire
    private String nomEquipe;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;
    @JsonIgnore
    @OneToOne
    private DetailEquipe detailEquipe1;
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "Equipes",fetch = FetchType.EAGER)
    private List<Etudiant> etudiants ;
// Constructeur et accesseurs (getters) et mutateurs (setters)

    public Equipe() {
    }
}
