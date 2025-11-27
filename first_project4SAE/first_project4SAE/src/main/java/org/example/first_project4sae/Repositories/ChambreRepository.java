package org.example.first_project4sae.Repositories;

import org.example.first_project4sae.Entities.Chambre;
import org.example.first_project4sae.Entities.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    @Query("SELECT c FROM Chambre c WHERE c.reservations IS EMPTY")
    List<Chambre> findChambresBy();

    @Query("SELECT c FROM Chambre c join c.bloc b where b.idBloc= :idBloc")
    List<Chambre> findChambreByBloc(@Param("idBloc") Long idBloc);

    Optional<Chambre> findByNumeroChambre(Long numeroChambre);

    List<Chambre> findByNumeroChambreIn(List<Long> numeroChambres);


}



