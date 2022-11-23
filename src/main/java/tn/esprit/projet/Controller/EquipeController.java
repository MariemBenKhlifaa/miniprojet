package tn.esprit.projet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projet.Service.IEquipe;
import tn.esprit.projet.Service.IEtudiant;
import tn.esprit.projet.entities.Equipe;
import tn.esprit.projet.entities.Etudiant;

import java.util.List;
import java.util.Set;

@RestController
public class EquipeController {
    @Autowired
    IEquipe iEquipe;


    @GetMapping("/getequipe")
    public List<Equipe> getallEquipe()
    {
        return iEquipe.getallEquipe();
    }
    @PostMapping("addequipe")
    public Equipe AddEquipe(@RequestBody Equipe e)
    {
        return iEquipe.AddEquipe(e);
    }
    @GetMapping("/getuneequipe/{id}")
    public Equipe findeEquipe(@PathVariable Long id)
    {
        return iEquipe.findeEquipe(id);
    }
    @PutMapping("/updateequipe")
    public Equipe updateEquipe(@RequestBody Equipe e)
    {
        return iEquipe.updateEquipe(e);
    }
    @DeleteMapping("/deleteequipe/{id}")
    public void deleteEquipe(@PathVariable Long id)
    {
        iEquipe.deleteEquipe(id);
    }
    @ResponseBody
    @GetMapping("/getetud/{idetudiant}")

    public List<Equipe> findbyetudiantidetudiant(@PathVariable Long idetudiant){

        return iEquipe.findetudiantidetudiant(idetudiant);
    }
    @ResponseBody
    @GetMapping("/findthematique/{thematique}")
    public List<Equipe> findEquipeByDetailEquipethematique(@PathVariable String thematique)
    {
        return iEquipe.findEquipeByDetailEquipethematique(thematique);
    }
    @ResponseBody
    @GetMapping("/getetudnotnull/{idEtudiant}")

    public List<Equipe> findByetudiantsidEtudiantAnddetailEquipeThematiqueNotNull(@PathVariable Long idEtudiant)
    {
        return iEquipe.findByetudiantsidEtudiantAnddetailEquipeThematiqueNotNull(idEtudiant);
    }
    @ResponseBody
    @GetMapping("/getetudiantanddepart/{idEtudiant}/{iddepart}")

    public List<Equipe> findByetudiantsbyidetudiantandetudiatiddepart(@PathVariable Long idEtudiant , Long iddepart)
    {
        return iEquipe.findEquipeByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(idEtudiant,iddepart);
    }


}
