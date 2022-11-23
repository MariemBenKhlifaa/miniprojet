package tn.esprit.projet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projet.Service.IContrat;
import tn.esprit.projet.entities.Contrat;

import java.util.Date;
import java.util.List;

@RestController
public class ContratController {
    @Autowired
    IContrat iContrat;
    @GetMapping("/getcontrat")
    public List<Contrat> getallContrat(){return iContrat.getallContrat();}

    @PostMapping("/addcontrat")
    public Contrat AddContrat(Contrat e){return iContrat.AddContrat(e);}
    @GetMapping("/getonecontrat/{id}")
    public Contrat findContrat(@PathVariable Long id){return iContrat.findContrat(id);}
    @PutMapping("/updatecontrat")
    public Contrat updateContrat(Contrat e){return iContrat.updateContrat(e);}
    @DeleteMapping("/deletecontrat/{id}")
    public void deleteContrat( @PathVariable Long id){iContrat.deleteContrat(id);}
    @PostMapping("/addcon/{nom}/{prenom}")
    Contrat affectcontrattoetudiant(@RequestBody Contrat contrat, @PathVariable("nom") String nom,@PathVariable("prenom") String prenom)
    {
     return    iContrat.affectcontrattoetudiant(contrat,nom,prenom);
    }
    @GetMapping("/getchiffre/{startDate}/{endDate}")
    public float getChiffreAffaireEntreDeuxDate(@PathVariable("startDate") Date startDate,@PathVariable("endDate") Date endDate)
    {
        return iContrat.getChiffreAffaireEntreDeuxDate(startDate,endDate);
    }
}
