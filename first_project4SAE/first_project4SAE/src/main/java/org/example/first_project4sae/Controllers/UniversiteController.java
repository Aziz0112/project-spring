package org.example.first_project4sae.Controllers;


import lombok.AllArgsConstructor;
import org.example.first_project4sae.Entities.Foyer;
import org.example.first_project4sae.Entities.Universite;
import org.example.first_project4sae.Services.IUniversiteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Universite")
@AllArgsConstructor

public class UniversiteController {

    private final IUniversiteService universiteService;

    @PostMapping("/ajouterUniversite")
    public Universite ajouterUniversite(@RequestBody Universite universite) {
        return universiteService.addUniversite(universite);
    }
    @PutMapping("/modifierUniversite")
    public Universite modifierUniversite(@RequestBody Universite universite) {
        return universiteService.updateUniversite(universite);
    }
    @DeleteMapping("/supprimerUniversite/{id}")
    public void supprimerUniversite(@PathVariable Long id) {
        universiteService.deleteUniversite(id);
    }
    @GetMapping("/getUniversite/{id}")
    public Universite getUniversiteById(@PathVariable Long id) {
        return universiteService.getUniversiteById(id);
    }
    @GetMapping("/getAllUniversite")
    public List<Universite> getAllUniversite() {
        return universiteService.getAllUniversites();
    }

    @PutMapping("/{idUniversite}/affecterFoyer/{idFoyer}")
    public Universite affecterFoyerAUniversite(@PathVariable Long idUniversite, @PathVariable Long idFoyer) {
        return universiteService.affecterFoyerAuniversite(idFoyer, idUniversite);
    }

    @PutMapping("/{idUniversite}/desaffecterFoyer")
    public Universite desaffecterFoyerAUniversite(@PathVariable Long idUniversite) {
        return universiteService.desaffecterFoyerAuniversite(idUniversite);
    }

    @PostMapping("/{idUniversite}/ajouterFoyer")
    public Universite ajouterFoyerEtAffecterAUniversite(@PathVariable Long idUniversite, @RequestBody Foyer foyer) {
        return universiteService.ajouterFoyerEtAffecterAuniversite(foyer, idUniversite);
    }





}
