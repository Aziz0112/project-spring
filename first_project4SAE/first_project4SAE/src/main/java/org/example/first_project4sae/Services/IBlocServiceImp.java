package org.example.first_project4sae.Services;
import org.example.first_project4sae.Entities.Bloc;
import org.example.first_project4sae.Repositories.BlocReposotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class IBlocServiceImp implements IBlocService {

    @Autowired
    private BlocReposotory blocRepository;

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }
    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }
    @Override
    public void deleteBloc(Long id) {
        blocRepository.deleteById(id);
    }
    @Override
    public Bloc getBlocById(Long id) {
        return blocRepository.findById(id).orElse(null);
    }
    @Override
    public List<Bloc> getAllBloc() {
        return blocRepository.findAll();
    }
    @Override
    public Bloc getBlocByNom(String nomBloc) {
        return blocRepository.findByNomBloc(nomBloc);
    }
    @Override
    public List<Bloc> searchBlocsByNomContaining(String keyword) {
        return blocRepository.findByNomBlocContaining(keyword);
    }
    @Override
    public List<Bloc> getBlocsWithCapaciteGreaterThan(Long capacite) {
        return blocRepository.findByCapaciteBlocGreaterThan(capacite);
    }

    @Override
    public List<Bloc> getBlocsByFoyerNom(String nomFoyer) {
        return blocRepository.findByFoyer_NomFoyer(nomFoyer);
    }

    @Override
    public List<Bloc> getAllBlocsSortedByCapaciteDesc() {
        return blocRepository.findAllByOrderByCapaciteBlocDesc();
    }

    @Override
    public List<Bloc> getBlocsByCapaciteBetween(Long min, Long max) {
        return blocRepository.findByCapaciteBlocBetween(min, max);
    }

}
