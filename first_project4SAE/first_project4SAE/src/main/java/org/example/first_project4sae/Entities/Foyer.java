package org.example.first_project4sae.Entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer;

    private String nomFoyer;
    private Long capaciteFoyer;
    @OneToOne(mappedBy = "foyer")
    Universite universite;
    @OneToMany(mappedBy = "foyer")
    private List<Bloc> blocs;
}
