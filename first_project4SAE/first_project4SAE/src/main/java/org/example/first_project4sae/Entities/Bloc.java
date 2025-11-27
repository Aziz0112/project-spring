package org.example.first_project4sae.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;

    private String nomBloc;
    private Long capaciteBloc;


    @ManyToOne
    private Foyer foyer;

    @OneToMany(mappedBy = "bloc")
    private List<Chambre> chambres;
}
