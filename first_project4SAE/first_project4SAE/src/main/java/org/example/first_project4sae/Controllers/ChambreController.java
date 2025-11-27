package org.example.first_project4sae.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.example.first_project4sae.Entities.Chambre;
import org.example.first_project4sae.Services.IChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Gestion des chambres ",description = "crud des chambre")


@RestController
@RequestMapping("/Chambre")
@AllArgsConstructor

public class ChambreController {
    /*@Autowired
    private IChambreService chambreService;*/

    private final IChambreService chambreService;

    @PostMapping("/ajouterChambre")

    public Chambre ajouterChambre(@RequestBody Chambre chambre) {
        return chambreService.addChambre(chambre);
    }

    @PutMapping("/modifierChambre")
    public Chambre modifierChambre(@RequestBody Chambre chambre) {
        return chambreService.updateChambre(chambre);

    }
    @DeleteMapping("/supprimerChambre/{id}")
    public void supprimerChambre(@PathVariable Long id) {
        chambreService.deleteChambre(id);
    }
    @GetMapping("/getChambre/{id}")
    public Chambre getChambreById(@PathVariable Long id) {
        return chambreService.getChambreById(id);
    }
    @Operation(summary = "Afficher toutes les chambres")
    @GetMapping("/getAllChambre")
    public List<Chambre> getAllChambre() {
        return chambreService.getAllChambre();
    }

    @GetMapping("/findChambreByBloc/{idBloc}")
    public List<Chambre> findChambreByBloc(@PathVariable Long idBloc){return  chambreService.findChambreByBloc(idBloc);};

    @PutMapping("/affecterChambresAbloc/{nomBloc}")
    public void affecterChambresAbloc(@PathVariable String nomBloc, @RequestBody List<Long> numChambres) {
        chambreService.affecterChambresAbloc(numChambres, nomBloc);
    }

}
