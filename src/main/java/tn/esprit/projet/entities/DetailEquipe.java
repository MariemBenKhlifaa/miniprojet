package tn.esprit.projet.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Getter
@Setter
@AllArgsConstructor

@Table( name = "DetailEquipe")
@ToString
public class DetailEquipe  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idDetailEquipe")
    private Long idDetailEquipe;
    private Long salle;
    private String thematique;
    @OneToOne(mappedBy = "detailEquipe")
    private  Equipe Equipe;

    public DetailEquipe(){

}
    @JsonBackReference
    public Equipe getEquipe() {
        return Equipe;
    }
}
