package tn.esprit.projet.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projet.Repository.Inrerfacedepjap;
import tn.esprit.projet.Repository.UniversiteRepository;
import tn.esprit.projet.entities.Departement;
import tn.esprit.projet.entities.Universite;

import java.util.List;
import java.util.Set;

@Service
public class DepartementService implements IDepartement{
    @Autowired
    Inrerfacedepjap inrerfacedepjap;
    UniversiteRepository universiteRepository;
    @Override
    public List<Departement> getalldep() {
        return inrerfacedepjap.findAll();
    }

    @Override
    public Departement Adddep(Departement e) {
        return inrerfacedepjap.save(e);
    }

    @Override
    public Departement findedep(Long id) {
        return inrerfacedepjap.findById(id).get();
    }

    @Override
    public Departement updatedep(Departement e) {
        return inrerfacedepjap.save(e);
    }

    @Override
    public void deletedep(Long id) {
        inrerfacedepjap.deleteById(id);

    }
    @Override
public Set<Departement> retrieveDepartementByUniversite(long idUniversite){
     Universite u = universiteRepository.findById(idUniversite).orElse(null);
     return u.getDepartements();
    }
}
