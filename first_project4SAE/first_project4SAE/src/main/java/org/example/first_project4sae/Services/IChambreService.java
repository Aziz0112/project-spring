package org.example.first_project4sae.Services;

import org.example.first_project4sae.Entities.Chambre;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IChambreService {

    Chambre addChambre(Chambre chambre);

    Chambre updateChambre(Chambre chambre);


    void deleteChambre(Long id);

    Chambre getChambreById(Long id);

    List<Chambre> getAllChambre();
    List<Chambre> findChambresBy();
    List<Chambre> findChambreByBloc(Long idBloc);
    void affecterChambresAbloc(List<Long> numChambres, String nomBloc);
}
