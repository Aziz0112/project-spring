package org.example.first_project4sae.Repositories;

import org.example.first_project4sae.Entities.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlocReposotory extends JpaRepository<Bloc, Long> {

    Bloc findByNomBloc(String nomBloc);

    List<Bloc> findByNomBlocContaining(String keyword);

    List<Bloc> findByCapaciteBlocGreaterThan(Long capacite);

    List<Bloc> findByFoyer_NomFoyer(String nomFoyer);

    List<Bloc> findAllByOrderByCapaciteBlocDesc();

    List<Bloc> findByCapaciteBlocBetween(Long min, Long max);
}
