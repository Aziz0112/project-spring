package org.example.first_project4sae.Entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    private String idReservation;

    private Date anneeUniversitaire;

    private boolean estValide;




    @ManyToMany(mappedBy = "reservations")
    private List<Etudiant> etudiants;
}
