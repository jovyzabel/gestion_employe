package com.employe.org.service;

import com.employe.org.dao.interfce.IEmployeDAO;
import com.employe.org.domain.DemandeConge;
import com.employe.org.domain.Employe;
import com.employe.org.domain.enumeration.StatutDemande;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class EmployeService implements IEmployeService {
    private IEmployeDAO employeDAO;
    private Logger logger = LogManager.getLogger(EmployeService.class);
    public EmployeService(IEmployeDAO employeDAO){
        this.employeDAO = employeDAO;
    }

    @Override
    public void calculerSalaire(Employe employe) {
        employe.setSalaireFinal(employe.getRole().getSalaireDeBase() + employe.getCategorie().getPrime()* employe.getRole().getSalaireDeBase());
    }

    @Override
    public void poserConge(String dateDebut, String dateFin, String motif) {

    }

    @Override
    public void poserConge(DemandeConge demandeConge) {
        Employe employe = demandeConge.getEmploye();
        demandeConge.setStatutDemande(StatutDemande.EN_ATTENTE);
        employe.getDirecteur().addDemandesConges(Arrays.asList(demandeConge));
        logger.info(employe);

    }

}
