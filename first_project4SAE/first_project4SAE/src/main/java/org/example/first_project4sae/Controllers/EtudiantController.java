package org.example.first_project4sae.Controllers;

import lombok.AllArgsConstructor;
import org.example.first_project4sae.Entities.Etudiant;
import org.example.first_project4sae.Services.IEtudiantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
@AllArgsConstructor
public class EtudiantController {

    private final IEtudiantService etudiantService;

    @PostMapping("/ajouterEtudiant")
    public Etudiant ajouterEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.addEtudiant(etudiant);
    }

    @PutMapping("/modifierEtudiant")
    public Etudiant modifierEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.updateEtudiant(etudiant);
    }

    @DeleteMapping("/supprimerEtudiant/{id}")
    public void supprimerEtudiant(@PathVariable Long id) {
        etudiantService.deleteEtudiant(id);
    }

    @GetMapping("/getEtudiant/{id}")
    public Etudiant getEtudiantById(@PathVariable Long id) {
        return etudiantService.getEtudiant(id);
    }

    @GetMapping("/getAllEtudiant")
    public List<Etudiant> getAllEtudiant() {
        return etudiantService.getAllEtudiant();
    }
}
