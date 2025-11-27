package org.example.first_project4sae.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idUniversite;

    private String nomUniversite;
    private String adresse;
    @OneToOne(cascade = CascadeType.ALL)
    private Foyer foyer;
}
