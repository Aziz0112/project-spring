package org.example.first_project4sae.Services;

import org.example.first_project4sae.Entities.Bloc;

import java.util.List;

public interface IBlocService {
    Bloc addBloc(Bloc bloc);

    Bloc updateBloc(Bloc bloc);
    void deleteBloc(Long id);

    Bloc getBlocById(Long id);
    List<Bloc> getAllBloc();

    Bloc getBlocByNom(String nomBloc);
    List<Bloc> searchBlocsByNomContaining(String keyword);
    List<Bloc> getBlocsWithCapaciteGreaterThan(Long capacite);
    List<Bloc> getBlocsByFoyerNom(String nomFoyer);
    List<Bloc> getAllBlocsSortedByCapaciteDesc();
    List<Bloc> getBlocsByCapaciteBetween(Long min, Long max);
}
