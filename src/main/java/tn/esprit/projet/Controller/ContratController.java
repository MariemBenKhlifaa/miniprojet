package tn.esprit.projet.Controller;

import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projet.Service.ContratService;
import tn.esprit.projet.Service.IContrat;
import tn.esprit.projet.entities.Contrat;
import tn.esprit.projet.Service.PdfService;
import tn.esprit.projet.entities.Specialite;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ContratController {
    @Autowired
    IContrat iContrat;

    @Autowired
    PdfService pdfService;
    @Autowired
    ContratService  contratService;
    @GetMapping("/getcontrat")
    public List<Contrat> getallContrat(){return iContrat.getallContrat();}

    @PostMapping("/addcontrat")
    public Contrat AddContrat( @RequestBody Contrat e){return iContrat.AddContrat(e);}
    @GetMapping("/getonecontrat/{id}")
    public Contrat findContrat(@PathVariable Long id){return iContrat.findContrat(id);}
    @PutMapping("/updatecontrat")
    public Contrat updateContrat(@RequestBody Contrat e){return iContrat.updateContrat(e);}
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

    @GetMapping("/pdf/generate")
    public void generatePDF(HttpServletResponse response) throws IOException, DocumentException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

      this.pdfService.generate(getallContrat() ,response);
    }
    @GetMapping("/numberOfContrat")
    @ResponseBody
    public Long countReclamation() {
        Long countContrat = iContrat.countContrat() ;
        return countContrat;
    }
    @GetMapping( value = "/ContContratMontant")
    @ResponseBody
    public Long ContContratArchive(){
        Long avg=  iContrat.ContContratArchive();
         return  avg;
    }

    @GetMapping( value = "/MontantMaxContrat")
    @ResponseBody
    public Long MontantMaxContrat(){
        Long Mnt=  iContrat.MontantMaxContrat();
        return  Mnt;
    }
    @PutMapping( value ="/desaffecterEtudiantAuContrat/{id}")
    public void desaffecterEtudiantAuContrat(@PathVariable("id")Long idContrat ){
        iContrat.desaffecterEtudiantAuContrat(idContrat);
    }
    @GetMapping( value ="/SomeSpecContrat/{specialite}")
    public float SommeMontantSelonSpecialie( @PathVariable( "specialite") Specialite specialite){

      return   iContrat.SommeMontantSelonSpecialie(specialite);
    }

    @GetMapping( value = "/MontantMin")
    @ResponseBody
    public  Long MontantMinContrant(){
        return  iContrat.MontantMinContrat();
    }



}
