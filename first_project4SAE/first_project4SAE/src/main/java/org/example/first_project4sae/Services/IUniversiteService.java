package org.example.first_project4sae.Services;

import org.example.first_project4sae.Entities.Foyer;
import org.example.first_project4sae.Entities.Universite;

import java.util.List;

public interface IUniversiteService {

    Universite addUniversite(Universite universite);
    List<Universite> getAllUniversites();
    Universite updateUniversite(Universite universite);
    void deleteUniversite(Long id);
    Universite getUniversiteById(Long id);
    Universite affecterFoyerAuniversite(Long idFoyer, Long idUniversite);
    Universite desaffecterFoyerAuniversite(Long idUniversite);
    Universite ajouterFoyerEtAffecterAuniversite(Foyer foyer, Long idUniversite);

}
