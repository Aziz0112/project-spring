package org.example.first_project4sae.Controllers;

import lombok.AllArgsConstructor;
import org.example.first_project4sae.Entities.Reservation;
import org.example.first_project4sae.Services.IReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
@AllArgsConstructor
public class ReservationController {

    private final IReservationService reservationService;

    @PostMapping("/ajouterReservation")
    public Reservation ajouterReservation(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @PutMapping("/modifierReservation")
    public Reservation modifierReservation(@RequestBody Reservation reservation) {
        return reservationService.updateReservation(reservation);
    }

    @DeleteMapping("/supprimerReservation/{id}")
    public void supprimerReservation(@PathVariable String id) {
        reservationService.deleteReservation(id);
    }

    @GetMapping("/getReservation/{id}")
    public Reservation getReservationById(@PathVariable String id) {
        return reservationService.getReservationById(id);
    }

    @GetMapping("/getAllReservation")
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @PostMapping("/ajouterReservationEtAffecter/{idChambre}/{idEtudiant}")
    public Reservation ajouterReservationEtAffecter(
            @PathVariable Long idChambre,
            @PathVariable Long idEtudiant,
            @RequestBody java.util.Map<String, String> requestBody) {
        String dateStr = requestBody.get("anneeUniversitaire");
        java.util.Date anneeUniversitaire;
        try {
            if (dateStr.contains("-")) {
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                anneeUniversitaire = sdf.parse(dateStr);
            } else {
                anneeUniversitaire = new java.util.Date(Long.parseLong(dateStr));
            }
        } catch (Exception e) {
            anneeUniversitaire = new java.util.Date();
        }
        return reservationService.ajouterReservationEtAffecterAChambreEtEtudiant(idChambre, idEtudiant, anneeUniversitaire);
    }
}
