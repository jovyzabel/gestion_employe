package Models;

import Enum.def.StatutDemande;

public class DemandeConge {
    private  String dateDebut;
    private  String dateFin;
    private  String dateDemande;
    private  String motif;
    private StatutDemande statutDemande;
    private Employe employe;

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public DemandeConge(String dateDebut, String dateFin, String motif, Employe employe) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.dateDemande = java.time.LocalDate.now().toString();
        this.motif = motif;
        this.statutDemande = StatutDemande.EN_ATTENTE;
        this.employe = employe;
    }


    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public StatutDemande getStatutDemande() {
        return statutDemande;
    }
    public String getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(String dateDemande) {
        this.dateDemande = dateDemande;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public void setStatutDemande(StatutDemande statutDemande) {
        this.statutDemande = statutDemande;
    }

    @Override
    public String toString() {
        return "Models.DemandeConge{" +
                "dateDebut='" + dateDebut + '\'' +
                ", dateFin='" + dateFin + '\'' +
                ", dateDemande='" + dateDemande + '\'' +
                ", motif='" + motif + '\'' +
                ", statutDemande=" + statutDemande +", Employé='" + employe + '\''+
                '}';
    }
}
