package tn.esprit.projet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projet.Service.IDepartement;
import tn.esprit.projet.Service.IDetailEquipe;
import tn.esprit.projet.entities.Departement;
import tn.esprit.projet.entities.DetailEquipe;

import java.util.List;
@RestController
public class DepController {
    @Autowired
    IDepartement iDepartement;
    @GetMapping("/getdep")
    public List<Departement> getalldep(){return iDepartement.getalldep();}
    @PostMapping("/adddep")
    public Departement Adddep(@RequestBody Departement e){return iDepartement.Adddep(e);}
    @GetMapping("/getonedep/{id}")
    public Departement findedep(@PathVariable Long id){return iDepartement.findedep(id);}
    @PutMapping("/updatedep")
    public Departement updatedep(@RequestBody Departement e){return iDepartement.updatedep(e);}
    @DeleteMapping("/deletedep/{id}")
    public void deletedep(@PathVariable Long  id){iDepartement.deletedep(id);}
}
