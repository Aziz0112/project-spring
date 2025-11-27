package org.example.first_project4sae.Services;

import org.example.first_project4sae.Entities.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservationService {
    Reservation addReservation(Reservation reservation);
    void deleteReservation(String id);
    Reservation getReservationById(String id);
    List<Reservation> getAllReservations();
    Reservation updateReservation(Reservation reservation);
    Reservation ajouterReservationEtAffecterAChambreEtEtudiant(Long idChambre, Long idEtudiant, Date anneeUniversitaire);


}
