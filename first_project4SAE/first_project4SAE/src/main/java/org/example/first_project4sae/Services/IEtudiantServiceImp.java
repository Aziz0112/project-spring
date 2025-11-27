package org.example.first_project4sae.Services;
import org.example.first_project4sae.Entities.Etudiant;
import org.example.first_project4sae.Repositories.EtudiantReposotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class IEtudiantServiceImp implements IEtudiantService {

    @Autowired
    private EtudiantReposotory etudiantRepository;

    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }
    @Override
    public Etudiant updateEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }
    @Override
    public void deleteEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }
    @Override
    public Etudiant getEtudiant(Long id) {
        return etudiantRepository.findById(id).orElse(null);
    }
    @Override
    public List<Etudiant> getAllEtudiant() {
        return etudiantRepository.findAll();
    }
}

