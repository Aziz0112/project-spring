package org.example.first_project4sae.Services;

import jakarta.transaction.Transactional;
import org.example.first_project4sae.Entities.Chambre;
import org.example.first_project4sae.Entities.Etudiant;
import org.example.first_project4sae.Entities.Reservation;
import org.example.first_project4sae.Entities.TypeChambre;
import org.example.first_project4sae.Repositories.ChambreRepository;
import org.example.first_project4sae.Repositories.EtudiantReposotory;
import org.example.first_project4sae.Repositories.ReservationReposotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class IReservationServiceImp implements IReservationService {
    @Autowired
    private ReservationReposotory reservationRepository;
    @Autowired
    private ChambreRepository chambreRepository;
    @Autowired
    private EtudiantReposotory etudiantRepository;

    @Override
    public Reservation addReservation(Reservation reservation)
    {
        return reservationRepository.save(reservation);
    }
    @Override
    public Reservation updateReservation(Reservation reservation)
    {
        return reservationRepository.save(reservation);
    }
    @Override
    public void deleteReservation(String id) {
        reservationRepository.deleteById(id);
    }
    @Override
    public Reservation getReservationById(String id) {
        return reservationRepository.findById(id).orElse(null);
    }
    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    @Transactional
    public Reservation ajouterReservationEtAffecterAChambreEtEtudiant(Long idChambre, Long idEtudiant, Date anneeUniversitaire) {
        Chambre chambre = chambreRepository.findById(idChambre)
                .orElseThrow(() -> new IllegalArgumentException("Chambre introuvable avec l'id " + idChambre));

        Etudiant etudiant = etudiantRepository.findById(idEtudiant)
                .orElseThrow(() -> new IllegalArgumentException("Étudiant introuvable avec l'id " + idEtudiant));

        TypeChambre typeChambre = chambre.getTypeChambre();
        int capaciteMaximale;
        switch (typeChambre) {
            case SIMPLE:
                capaciteMaximale = 1;
                break;
            case DOUBLE:
                capaciteMaximale = 2;
                break;
            case TRIPLE:
                capaciteMaximale = 3;
                break;
            default:
                throw new IllegalArgumentException("Type de chambre invalide : " + typeChambre);
        }

        List<Reservation> reservationsChambre = chambre.getReservations();
        if (reservationsChambre == null) {
            reservationsChambre = new ArrayList<>();
        }
        long nombreReservationsValides = reservationsChambre.stream()
                .filter(Reservation::isEstValide)
                .count();

        if (nombreReservationsValides >= capaciteMaximale) {
            throw new IllegalStateException(
                    "La chambre " + chambre.getNumeroChambre() + " a atteint sa capacité maximale (" 
                    + capaciteMaximale + " réservation(s)). Impossible d'ajouter une nouvelle réservation.");
        }

        Long numeroChambre = chambre.getNumeroChambre();
        Long cinEtudiant = etudiant.getCin();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String anneeUniv = sdf.format(anneeUniversitaire);
        
        String idReservation = numeroChambre + "-" + cinEtudiant + "-" + anneeUniv;

        Reservation reservation = new Reservation();
        reservation.setIdReservation(idReservation);
        reservation.setAnneeUniversitaire(anneeUniversitaire);
        reservation.setEstValide(true);

        reservation = reservationRepository.save(reservation);

        if (!reservationsChambre.contains(reservation)) {
            reservationsChambre.add(reservation);
            chambre.setReservations(reservationsChambre);
            chambreRepository.save(chambre);
        }

         List<Reservation> reservationsEtudiant = etudiant.getReservations();
        if (reservationsEtudiant == null) {
            reservationsEtudiant = new ArrayList<>();
        }
        if (!reservationsEtudiant.contains(reservation)) {
            reservationsEtudiant.add(reservation);
            etudiant.setReservations(reservationsEtudiant);
            etudiantRepository.save(etudiant);
        }

        return reservation;
    }
}
