package tn.esprit.projet.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@Table( name = "Etudiant")

public class Etudiant implements Serializable {
    //many to many uni wala bi +1 to many -->dima iji table association

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idEtudiant")
    private Integer idEtudiant; // Clé primaire
    private String prenom;
    private String nom;
    @Enumerated(EnumType.STRING)
    private Option option;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    Departement departement;
    @JsonIgnore

    @OneToMany(mappedBy = "etudiant")
    private Set<Contrat> contrats;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)

    private List<Equipe> Equipes;

    public Etudiant() {
    }

}
