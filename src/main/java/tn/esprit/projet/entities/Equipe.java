package tn.esprit.projet.entities;
import com.fasterxml.jackson.annotation.*;
import lombok.*;

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
  //  @JsonIgnore
  @OneToOne
    private DetailEquipe detailEquipe;
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "Equipes",fetch = FetchType.EAGER)
    private List<Etudiant> etudiants ;

public Equipe(){}

    @JsonManagedReference
    public DetailEquipe getDetailEquipe() {
        return detailEquipe;
    }

    public String getNiveau() {
        return niveau.toString();
    }
}
