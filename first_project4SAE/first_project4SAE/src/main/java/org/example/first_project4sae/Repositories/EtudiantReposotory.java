package org.example.first_project4sae.Repositories;

import org.example.first_project4sae.Entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantReposotory extends JpaRepository<Etudiant, Long> {
}
