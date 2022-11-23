package tn.esprit.projet.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projet.Repository.InterfaceDtailEquipejpa;
import tn.esprit.projet.entities.DetailEquipe;

import java.util.List;
@Service
public class DetailEquipeService implements IDetailEquipe{
    @Autowired
    InterfaceDtailEquipejpa interfaceDtailEquipejpa;
    @Override
    public List<DetailEquipe> getalldetailequipe() {
       return interfaceDtailEquipejpa.findAll();
    }

    @Override
    public DetailEquipe Adddetailequipe(DetailEquipe e) {
        return interfaceDtailEquipejpa.save(e);
    }

    @Override
    public DetailEquipe finddetailequipe(Long id) {
        return interfaceDtailEquipejpa.findById(id).get();
    }

    @Override
    public DetailEquipe updatedetailequipe(DetailEquipe e) {
        return interfaceDtailEquipejpa.save(e);
    }

    @Override
    public void deletedetailequipe(Long id) {
      interfaceDtailEquipejpa.deleteById(id);

    }
}
