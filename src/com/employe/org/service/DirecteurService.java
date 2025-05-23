package com.employe.org.service;

import com.employe.org.dao.interfce.IDirecteurDAO;
import com.employe.org.domain.DemandeConge;
import com.employe.org.domain.Directeur;
import com.employe.org.domain.Employe;
import com.employe.org.domain.enumeration.StatutDemande;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class DirecteurService implements IDirecteurService{
    private IDirecteurDAO directeurDAO;
    private Directeur directeur;
    private Logger logger = LogManager.getLogger();
    public DirecteurService(IDirecteurDAO directeurDAO, Directeur directeur){
        this.directeurDAO = directeurDAO;
        this.directeur = directeur;

    }

    @Override
    public boolean validerConge(DemandeConge conge){
        conge.setStatutDemande(StatutDemande.APPROUVEE);
        System.out.println("Le directeur valide les congés de "+conge.getEmploye().getNom());
        return true;
    }
    @Override
    public boolean refuserConge(DemandeConge conge) {
        conge.setStatutDemande(StatutDemande.REFUSEE);
        System.out.println("Le directeur refuse les congés de "+conge.getEmploye().getNom());
        return true;
    }

//    @Override
//    public boolean ajouterEmployes(List<Employe> employeList) {
//
//        if(directeur.getEmployes().addAll(employeList)){
//            System.out.println("Vous avez ajouté "+employeList.size()+" employé(s) avec succès");
//            directeur.setNbreEmploye(directeur.getEmployes().size());
//            employeList.forEach(employe -> employe.setDirecteur(directeur));
//            System.out.println(directeur.getNom());
//            return true;
//        }
//        return false;
//    }
@Override
public boolean ajouterEmployes(List<Employe> employeList) {
    if (employeList == null || employeList.isEmpty()) {
        logger.warn("La liste des employés est vide.");
        return false;
    }

    AtomicBoolean auMoinsUnAjoute = new AtomicBoolean(false);

    employeList.forEach(employe  -> {
        if (!directeur.getEmployes().contains(employe)) {
            directeur.getEmployes().add(employe);
            employe.setDirecteur(directeur);
            auMoinsUnAjoute.set(true);
        }
    });



    if (auMoinsUnAjoute.get()) {
        directeur.setNbreEmploye(directeur.getEmployes().size());
        logger.info("Employés ajoutés avec succès.");
        return true;
    } else {
        logger.warn("Aucun nouvel employé n’a été ajouté (doublons).");
        return false;
    }
}

    public void showAllDemandes(){
        directeur.getDemandesConges().forEach(demandeConge -> logger.info(demandeConge));
        logger.info(directeur.getDemandesConges().size());
    }
    @Override
    public boolean ajouterEmploye(Employe employe) {
        if(!directeur.getEmployes().contains(employe)){
            directeur.getEmployes().add(employe);
            employe.setDirecteur(directeur);
            directeur.setNbreEmploye(directeur.getEmployes().size());
            return true;
        }
        return false;
    }

    @Override
    public boolean retirerEmploye(Employe employe) {
        if (directeur.getEmployes().remove(employe)) {
            directeur.setNbreEmploye(directeur.getEmployes().size());
            return true;
        }
        return false;
    }
    @Override
    public boolean retirerEmployes(List<Employe> employeList) {
        if (directeur.getEmployes().removeAll(employeList)) {
            directeur.setNbreEmploye(directeur.getEmployes().size());
            return true;
        }
        return false;

    }
}
