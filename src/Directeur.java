import Enum.def.Categorie;
import Enum.def.Role;
import Enum.def.StatutDemande;
import Enum.def.StatutMatrimonial;

import java.util.ArrayList;
import java.util.List;

public class Directeur extends  Employe implements IDirecteur{
    private  List<Employe> employes;
    private  int nbreEmploye;
    private double primeMatrimonial;
    private List<DemandeConge> demandesConges;


    public List<DemandeConge> getDemandesConges() {
        return demandesConges;
    }

    public void setDemandesConges(List<DemandeConge> demandesConges) {
        this.demandesConges = demandesConges;
    }

    public void addDemandesConges(List<DemandeConge> demandesConges){
        this.demandesConges.addAll(demandesConges);
    }

    public Directeur(String nom, String prenom, StatutMatrimonial statutMatrimonial, String matricule, String dateFonction, Role role, Categorie categorie) {
        super(nom, prenom, statutMatrimonial, matricule, dateFonction, role, categorie);
        this.employes = new ArrayList<>();
        this.nbreEmploye = this.setNbreEmploye(this.employes.size());
        this.primeMatrimonial= 0.0;
        this.demandesConges = new ArrayList<>();
    }


    public int getNbreEmploye() {
        return nbreEmploye;
    }

    public int setNbreEmploye(int nbreEmploye) {
        return this.nbreEmploye = nbreEmploye;
    }

    @Override
    public boolean validerConge(DemandeConge conge){
        conge.setStatutDemande(StatutDemande.APPROUVEE);
        System.out.println("Le directeur valide les congés de "+conge.getEmploye().nom);
        return true;
    }
    @Override
    public boolean refuserConge(DemandeConge conge) {
        conge.setStatutDemande(StatutDemande.REFUSEE);
        System.out.println("Le directeur refuse les congés de "+conge.getEmploye().nom);
        return true;
    }

    @Override
    public boolean ajouterEmployes(List<Employe> employeList) {
        if(this.employes.addAll(employeList)){
            System.out.println("Vous avez ajouté "+employeList.size()+" employé(s) avec succès");
            this.nbreEmploye = this.setNbreEmploye(this.employes.size());
            employeList.forEach(employe -> employe.setDirecteur(this));
            return true;
        }
        return false;
    }

    public void showAllDemandes(){
        this.demandesConges.forEach(System.out::println);
        System.out.println(this.demandesConges.size());
    }
    @Override
    public boolean ajouterEmploye(Employe employe) {
        this.employes.add(employe);
        System.out.println("Un employé a été ajouté avec succès");
        this.nbreEmploye = this.setNbreEmploye(this.employes.size());
        employe.setDirecteur(this);
        return true;

    }

    @Override
    public boolean retirerEmploye(Employe employe) {
        employes.remove(employe);
        this.nbreEmploye = this.setNbreEmploye(this.employes.size());
        return true;
    }
    @Override
    public boolean retirerEmployes(List<Employe> employeList) {
        if(this.employes.removeAll(employeList)){
            System.out.println(employeList.size()+" employé(s) retiré(s) avec succès");
            this.employes.removeAll(employeList);
        }
        this.nbreEmploye = this.setNbreEmploye(this.employes.size());
        return false;

    }

    @Override
    public void poserConge(String dateDebut, String dateFin, String motif){
        System.out.println("Le directeur "+ getNom()+" "+getPrenom()+" pose des congés de "+
                dateDebut+" à "+dateFin);
        System.out.println("les congés sont automatiquement validés");
    }

    @Override
    public void calculerSalaire() {
        this.primeMatrimonial = this.statutMatrimonial.getPrime();
        this.SalaireFinal = role.getSalaireDeBase() + categorie.getPrime()* role.getSalaireDeBase() + this.primeMatrimonial;
        System.out.println(this.SalaireFinal);
    }

    public void show(){
        this.employes.forEach(System.out::println);
        System.out.println("Nombres total d'employé(s) "+this.nbreEmploye);
    }

    @Override
    public String toString() {
        return "Directeur{" +
                "nbreEmploye=" + nbreEmploye +
                ", Matricule='" + Matricule + '\'' +
                ", date de Fonction='" + dateFonction + '\'' +

                ", role=" + role.getRole() +
                ", categorie=" + categorie.getCategorie() +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", statut Matrimonial=" + statutMatrimonial.getStatut() +
                '}';
    }

}
