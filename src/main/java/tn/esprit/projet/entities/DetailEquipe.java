package tn.esprit.projet.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
    @Column(name="IdEquipe")
    private Long IdEquipe;
    private Long salle;
    private String thematique;
    @OneToOne(mappedBy = "detailEquipe1")
    private  Equipe Equipe;

    public DetailEquipe() {
    }
}
