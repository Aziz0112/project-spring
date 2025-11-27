package org.example.first_project4sae.Services;
import jakarta.transaction.Transactional;
import org.example.first_project4sae.Entities.Foyer;
import org.example.first_project4sae.Entities.Universite;
import org.example.first_project4sae.Repositories.FoyerReposotory;
import org.example.first_project4sae.Repositories.UniversiteReposotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class IUniversiteServiceImp implements IUniversiteService {

    @Autowired
    private UniversiteReposotory universiteRepository;
    @Autowired
    private FoyerReposotory foyerReposotory;
    @Override
    public Universite addUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }
    @Override
    public Universite updateUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }
    @Override
    public void deleteUniversite(Long id) {
        universiteRepository.deleteById(id);
    }
    @Override
    public Universite getUniversiteById(Long id) {
        return universiteRepository.findById(id).orElse(null);
    }
    @Override
    public List<Universite> getAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    @Transactional
    public Universite affecterFoyerAuniversite(Long idFoyer, Long idUniversite) {
        Foyer foyer = foyerReposotory.findById(idFoyer)
                .orElseThrow(() -> new IllegalArgumentException("Foyer introuvable avec l'id " + idFoyer));
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new IllegalArgumentException("Université introuvable avec l'id " + idUniversite));
        universite.setFoyer(foyer);
        foyer.setUniversite(universite);
        return universiteRepository.save(universite);
    }

    @Override
    @Transactional
    public Universite desaffecterFoyerAuniversite(Long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new IllegalArgumentException("Université introuvable avec l'id " + idUniversite));
        Foyer foyer = universite.getFoyer();
        if (foyer != null) {
            foyer.setUniversite(null);
            universite.setFoyer(null);
            foyerReposotory.save(foyer);
        }
        return universiteRepository.save(universite);
    }

    @Override
    @Transactional
    public Universite ajouterFoyerEtAffecterAuniversite(Foyer foyer, Long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new IllegalArgumentException("Université introuvable avec l'id " + idUniversite));
        foyer.setUniversite(universite);
        universite.setFoyer(foyer);
        return universiteRepository.save(universite);
    }
}
