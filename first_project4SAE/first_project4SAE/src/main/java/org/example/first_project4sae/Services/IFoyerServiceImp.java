package org.example.first_project4sae.Services;

import org.example.first_project4sae.Entities.Foyer;
import org.example.first_project4sae.Repositories.FoyerReposotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class IFoyerServiceImp implements IFoyerService {
    @Autowired
    private FoyerReposotory foyerRepository;

    @Override
    public Foyer addFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }
    @Override
    public Foyer updateFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }
    @Override
    public void deleteFoyer(Long id) {
        foyerRepository.deleteById(id);
    }
    @Override
    public Foyer getFoyerById(Long id) {
       return foyerRepository.findById(id).orElse(null);
    }
    @Override
    public List<Foyer> getAllFoyer() {
        return foyerRepository.findAll();
    }
}
