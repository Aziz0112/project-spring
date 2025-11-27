package org.example.first_project4sae.Repositories;

import org.example.first_project4sae.Entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationReposotory extends JpaRepository<Reservation, String> {
}
