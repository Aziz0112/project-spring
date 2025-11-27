package org.example.first_project4sae.Services;

import org.example.first_project4sae.Entities.Bloc;
import org.example.first_project4sae.Entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
     Etudiant addEtudiant(Etudiant etudiant);
    Etudiant updateEtudiant(Etudiant etudiant);
    void deleteEtudiant(Long id);
    Etudiant getEtudiant(Long id);
    List<Etudiant> getAllEtudiant();
}
