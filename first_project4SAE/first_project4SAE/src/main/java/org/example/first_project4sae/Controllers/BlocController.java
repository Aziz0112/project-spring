package org.example.first_project4sae.Controllers;

import lombok.AllArgsConstructor;
import org.example.first_project4sae.Entities.Bloc;
import org.example.first_project4sae.Services.IBlocService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bloc")
@AllArgsConstructor
public class BlocController {

    private final IBlocService blocService;

    // ➤ Ajouter un bloc
    @PostMapping("/ajouterBloc")
    public Bloc ajouterBloc(@RequestBody Bloc bloc) {
        return blocService.addBloc(bloc);
    }

    // ➤ Modifier un bloc
    @PutMapping("/modifierBloc")
    public Bloc modifierBloc(@RequestBody Bloc bloc) {
        return blocService.updateBloc(bloc);
    }

    // ➤ Supprimer un bloc par ID
    @DeleteMapping("/supprimerBloc/{id}")
    public void supprimerBloc(@PathVariable Long id) {
        blocService.deleteBloc(id);
    }

    // ➤ Récupérer un bloc par ID
    @GetMapping("/getBloc/{id}")
    public Bloc getBlocById(@PathVariable Long id) {
        return blocService.getBlocById(id);
    }

    // ➤ Récupérer la liste de tous les blocs
    @GetMapping("/getAllBloc")
    public List<Bloc> getAllBloc() {
        return blocService.getAllBloc();
    }

    @GetMapping("/search")
    public List<Bloc> searchBlocsByNomContaining(@RequestParam String keyword) {
        return blocService.searchBlocsByNomContaining(keyword);
    }

    @GetMapping("/capaciteMin/{min}")
    public List<Bloc> getBlocsWithCapaciteGreaterThan(@PathVariable Long min) {
        return blocService.getBlocsWithCapaciteGreaterThan(min);
    }

    @GetMapping("/foyer/{nomFoyer}")
    public List<Bloc> getBlocsByFoyerNom(@PathVariable String nomFoyer) {
        return blocService.getBlocsByFoyerNom(nomFoyer);
    }

    @GetMapping("/sortedByCapacite")
    public List<Bloc> getAllBlocsSortedByCapaciteDesc() {
        return blocService.getAllBlocsSortedByCapaciteDesc();
    }

    @GetMapping("/capaciteBetween/{min}/{max}")
    public List<Bloc> getBlocsByCapaciteBetween(@PathVariable Long min, @PathVariable Long max) {
        return blocService.getBlocsByCapaciteBetween(min, max);
    }
}
