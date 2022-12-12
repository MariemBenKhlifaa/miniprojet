package tn.esprit.projet.Controller;

import net.kaczmarzyk.spring.data.jpa.domain.In;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Join;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projet.Service.*;
import tn.esprit.projet.entities.Equipe;
import tn.esprit.projet.entities.Niveau;
import tn.esprit.projet.entities.Option;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class EquipeController {
    @Autowired
    IEquipe iEquipe;
    @Autowired
    IDetailEquipe iDetailEquipe;
    Equipe d = new Equipe();
    @GetMapping("/getequipe")
    public List<Equipe> get(@Join(path = "detailEquipe", alias = "d")
        @And({
                @Spec(path = "nomEquipe", params = "nomEquipe", spec = LikeIgnoreCase.class),
                @Spec(path = "niveau", params = "niveau", spec = In.class),
                @Spec(path = "d.thematique", params = "thematique", spec = LikeIgnoreCase.class),
                @Spec(path = "d.salle", params = "salle", spec = In.class)
        }) Specification<Equipe> spec, Pageable p) {
        return iEquipe.get(spec, p);
    }

   @GetMapping("/getequip")
           public List<Equipe> findAllEq()
   {
        return iEquipe.getallEquipe();
    }


    @PostMapping("/addequipe")
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

    public List<Equipe> findByetudiantsidEtudiantAndDetailEquipeThematiqueNotNull(@PathVariable Long idEtudiant)
    {
        return iEquipe.findByetudiantsidEtudiantAndDetailEquipeThematiqueNotNull(idEtudiant);
    }
    @ResponseBody
    @GetMapping("/getetudiantanddepart/{idEtudiant}/{iddepart}")

    public List<Equipe> findByetudiantsbyidetudiantandetudiatiddepart(@PathVariable Long idEtudiant , Long iddepart)
    {
        return iEquipe.findEquipeByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(idEtudiant,iddepart);
    }
//////////////////////////////////////----------------------------////////////////////
    @GetMapping("/niv")

    public String[] eqq()
    {
        return iEquipe.getNiv();
    }

    @GetMapping("/nompren/{np}/{pr}")
    public List<Equipe> findEquipeByEtudiantsNomAndPrenom(@PathVariable("np") String nom, @PathVariable("pr") String prenom) {
        return  iEquipe.findEquipeByEtudiantsNomAndPrenom(nom,prenom);
    }

    @GetMapping("/eqnivv/{niv}")
    public List<Equipe> findeq(@PathVariable("niv") Niveau niveau) {
        return  iEquipe.findeq(niveau);
    }

    @GetMapping("/eqnivopt/{niv}/{opt}")
    public List<Equipe> findeqnivop(@PathVariable("niv") Niveau niveau, @PathVariable("opt")Option opt) {
        return  iEquipe.findEquipeByNiveauAndEtudiantsOption(niveau, opt);
    }

    @GetMapping("/findidetudiantdetail/{id}")
    public List<Equipe> findId(@PathVariable("id") Integer idE, @PathVariable("id") Long idD) {
        return  iEquipe.findId(idE,idD);
    }
    @GetMapping("/finddept/{nom}")
    public List<Equipe> findId(@PathVariable("nom") String dept) {
        return  iEquipe.findEquipeByEtudiantsDepartementNomDepart(dept);
    }

    @PutMapping("/affeceqdet/{idE}/{idD}")
    public void affecterEquipeToDetail(@PathVariable("idE") Long idE, @PathVariable("idD") Long idD) {
        iEquipe.affecterEquipeToDetail(idE,idD);
    }



}
