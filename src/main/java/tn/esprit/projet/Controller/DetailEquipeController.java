package tn.esprit.projet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projet.Service.IDetailEquipe;
import tn.esprit.projet.entities.DetailEquipe;

import java.util.List;
@RestController
public class DetailEquipeController {
    @Autowired
    IDetailEquipe iDepartement;
    @GetMapping("/getdetailequipe")
    public List<DetailEquipe> getalldetailequipe(){return iDepartement.getalldetailequipe();}
    @PostMapping("/adddetailequipe")
    public DetailEquipe Adddetailequipe(@RequestBody DetailEquipe e){return  iDepartement.Adddetailequipe(e);}
    @GetMapping("/getundatail/{id}")
    public DetailEquipe finddetailequipe(@PathVariable Long id){return iDepartement.finddetailequipe(id);}
    @PutMapping("/updatedetailequipe")
    public DetailEquipe updatedetailequipe(@RequestBody DetailEquipe e){return iDepartement.updatedetailequipe(e);}
    @DeleteMapping("/deletedetailequipe/{id}")
    public void deletedetailequipe(@PathVariable Long id){ iDepartement.deletedetailequipe(id);}
}
