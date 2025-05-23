package com.employe.org.service;

import com.employe.org.domain.DemandeConge;
import com.employe.org.domain.Employe;

public interface IEmployeService {
    public void calculerSalaire(Employe employe);
    public void poserConge(String dateDebut, String dateFin, String motif );
    public void poserConge(DemandeConge demandeConge);
}
