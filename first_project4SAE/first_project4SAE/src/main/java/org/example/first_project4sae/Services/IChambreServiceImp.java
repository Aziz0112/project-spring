package org.example.first_project4sae.Services;

import jakarta.transaction.Transactional;
import org.example.first_project4sae.Entities.Bloc;
import org.example.first_project4sae.Entities.Chambre;
import org.example.first_project4sae.Repositories.BlocReposotory;
import org.example.first_project4sae.Repositories.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class IChambreServiceImp implements IChambreService {
    @Autowired
    private ChambreRepository chambreRepository;
    @Autowired
    private BlocReposotory blocReposotory;

    @Override
    public Chambre addChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public void deleteChambre(Long id) {
        chambreRepository.deleteById(id);
    }

    @Override
    public Chambre getChambreById(Long id) {
        return chambreRepository.findById(id).orElse(null);
    }

    @Override
    public List<Chambre> getAllChambre() {
        return chambreRepository.findAll();
    }

    @Override
    public List<Chambre> findChambresBy() {
        return chambreRepository.findChambresBy();
    }

    @Override
    public List<Chambre> findChambreByBloc(Long idBloc) {
        return chambreRepository.findChambreByBloc(idBloc);
    }

    @Override
    @Transactional
    public void affecterChambresAbloc(List<Long> numChambres, String nomBloc) {
        if (numChambres == null || numChambres.isEmpty()) {
            throw new IllegalArgumentException("La liste des numéros de chambres ne peut pas être vide.");
        }
        Bloc bloc = blocReposotory.findByNomBloc(nomBloc);
        if (bloc == null) {
            throw new IllegalArgumentException("Bloc introuvable avec le nom " + nomBloc);
        }

        List<Chambre> chambres = chambreRepository.findByNumeroChambreIn(numChambres);
        Set<Long> foundNumbers = chambres.stream()
                .map(Chambre::getNumeroChambre)
                .collect(Collectors.toSet());
        List<Long> missing = numChambres.stream()
                .filter(numero -> !foundNumbers.contains(numero))
                .collect(Collectors.toList());
        if (!missing.isEmpty()) {
            throw new IllegalArgumentException("Chambres introuvables avec les numéros : " + missing);
        }

        chambres.forEach(chambre -> chambre.setBloc(bloc));
        chambreRepository.saveAll(chambres);
    }
}