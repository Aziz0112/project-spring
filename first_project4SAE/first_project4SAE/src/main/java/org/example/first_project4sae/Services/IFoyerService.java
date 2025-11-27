package org.example.first_project4sae.Services;

import org.example.first_project4sae.Entities.Foyer;

import java.util.List;

public interface IFoyerService {
    Foyer updateFoyer(Foyer foyer);
    List<Foyer> getAllFoyer();
    Foyer getFoyerById(Long id);
    Foyer addFoyer(Foyer foyer);
    void deleteFoyer(Long id);

}
