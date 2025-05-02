import Enum.def.Categorie;
import Enum.def.Role;
import Enum.def.StatutMatrimonial;

import java.util.ArrayList;
import java.util.List;

public class Directeur extends  Employe implements IDirecteur{
    private List<Employe> employes = new ArrayList<>();
    private  int nbreEmploye;

    public Directeur(String nom, String prenom, StatutMatrimonial statutMatrimonial, String matricule, String dateFonction, Role role, Categorie categorie, int nbreEmploye) {
        super(nom, prenom, statutMatrimonial, matricule, dateFonction, role, categorie);
        this.nbreEmploye = nbreEmploye;
    }


    public int getNbreEmploye() {
        return nbreEmploye;
    }

    public void setNbreEmploye(int nbreEmploye) {
        this.nbreEmploye = nbreEmploye;
    }

    @Override
    public boolean validerConge(Conge conge, Employe employe){
        System.out.println("Le directeur valide les congés de "+employe);
        return true;
    }
    @Override
    public boolean refuterConge(Conge conge, Employe employe) {
        System.out.println("Le directeur refute les congés de "+employe);
        return true;
    }

    @Override
    public List<Employe> ajouterEmployes(List<Employe> employeList) {
        employes.addAll(employeList);
        return employes;
    }

    @Override
    public Employe ajouterEmploye(Employe employe) {
        employes.add(employe);
        return employe;
    }

    @Override
    public void poserConge(String dateDebut, String dateFin){
        System.out.println("Le directeur "+ getNom()+" "+getPrenom()+" pose des congés de "+
                dateDebut+" à "+dateFin);
        System.out.println("les congés sont automatiquement validés");
    }


    @Override
    public String toString() {
        return "Directeur{" +
                "nbreEmploye=" + nbreEmploye +
                ", Matricule='" + Matricule + '\'' +
                ", dateFonction='" + dateFonction + '\'' +

                ", role=" + role +
                ", categorie=" + categorie +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", statutMatrimonial=" + statutMatrimonial +
                '}';
    }

}
