package tn.esprit.projet.entities;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "Universite")

public class Universite   implements Serializable{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idUni")
    private Long idUni; // Clé primaire
    private String nomUni;
    @OneToMany()
    private Set<Departement> Departements;


}
