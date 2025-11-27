package org.example.first_project4sae.Controllers;

import lombok.AllArgsConstructor;
import org.example.first_project4sae.Entities.Foyer;
import org.example.first_project4sae.Services.IFoyerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foyer")
@AllArgsConstructor
public class FoyerController {

    private final IFoyerService foyerService;

    @PostMapping("/ajouterFoyer")
    public Foyer ajouterFoyer(@RequestBody Foyer foyer) {
        return foyerService.addFoyer(foyer);
    }

    @PutMapping("/modifierFoyer")
    public Foyer modifierFoyer(@RequestBody Foyer foyer) {
        return foyerService.updateFoyer(foyer);
    }

    @DeleteMapping("/supprimerFoyer/{id}")
    public void supprimerFoyer(@PathVariable Long id) {
        foyerService.deleteFoyer(id);
    }

    @GetMapping("/getFoyer/{id}")
    public Foyer getFoyerById(@PathVariable Long id) {
        return foyerService.getFoyerById(id);
    }

    @GetMapping("/getAllFoyer")
    public List<Foyer> getAllFoyer() {
        return foyerService.getAllFoyer();
    }
}
