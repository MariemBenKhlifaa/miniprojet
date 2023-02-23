package tn.esprit.projet.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projet.Service.EtudiantService;
import tn.esprit.projet.Service.IEtudiant;
import tn.esprit.projet.entities.Equipe;
import tn.esprit.projet.entities.Etudiant;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class EtudiantController {


    @Autowired
   IEtudiant iEtudiant;



    @PostMapping("/addetudiant")
    public Etudiant addetudiant(@RequestBody Etudiant e)
    {
       return iEtudiant.AddEtudiant(e);

    }
    @GetMapping("/getetudiant")
    public List<Etudiant> getalletudiant()
    {
        return iEtudiant.getallEtudiantt();
    }

    @GetMapping("/getetudiant/{id}")
    public Etudiant findetudiant(@PathVariable int id)
    {
      return   iEtudiant.findetudiant(id);


    }
    @PutMapping("/updateetudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant e)
    {
      return   iEtudiant.updateEtudiant(e);


    }
    @DeleteMapping("/deleteEtudiant")
    public void deleteEtudiant(@PathVariable int id)
    {
         iEtudiant.deleteEtudiant(id);

    }
    @GetMapping("/getetudiantbynom/{nom}")

    Etudiant findetudiantbynom(@PathVariable String nom)
    {
       return iEtudiant.findetudiantbynom(nom);
    }

   @PutMapping("/affect/{idetudiant}/{iddepartement}")
    public void affecteretudiantdepartement(@PathVariable("idetudiant") int idetudiant,@PathVariable("iddepartement") Long iddepartement)
{
    iEtudiant.affecteretudiantdepartement(idetudiant,iddepartement);
}

@PostMapping("/addetu/{IdE}/{Idc}")

    public Etudiant affecteratudiantcontratequipe(@PathVariable("IdE") Long ide,@PathVariable("Idc") Long idC,@RequestBody Etudiant e ) {
        return iEtudiant.addetudianttoequipeandecontrat(e,idC,ide);
    }
    @GetMapping("/etudpardepat/{idDepart}")
    public List<Etudiant> findEtudiantByDepartement_idDepart(@PathVariable("idDepart") Long idDepart){
        return iEtudiant.findEtudiantByDepartement_idDepart(idDepart);
    }
    @ResponseBody
    @GetMapping (value = "/getContE/{idContrat}")
    public List<Etudiant>findEtudiantByContratsIdContrat(@PathVariable ("idContrat" ) Long idContrat){

        return iEtudiant.findEtudiantByContratsIdContrat(idContrat);
    }

}
