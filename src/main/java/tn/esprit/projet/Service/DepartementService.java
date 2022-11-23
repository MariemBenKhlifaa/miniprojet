package tn.esprit.projet.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projet.Repository.Inrerfacedepjap;
import tn.esprit.projet.Repository.InterfaceEquipejpa;
import tn.esprit.projet.entities.Departement;

import java.util.List;

@Service
public class DepartementService implements IDepartement{
    @Autowired
    Inrerfacedepjap inrerfacedepjap;
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
}
