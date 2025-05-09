import Enum.def.Categorie;
import Enum.def.Role;
import Enum.def.StatutDemande;
import Enum.def.StatutMatrimonial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Employe extends Personne implements IEmploye{
    protected String Matricule;
    protected String dateFonction;
    protected double SalaireFinal;
    protected Role role;
    protected Categorie categorie;
    private DemandeConge demandeConge;
    private Directeur directeur;

    public Directeur getDirecteur() {
        return directeur;
    }

    public void setDirecteur(Directeur directeur) {
        this.directeur = directeur;
    }

    public Employe(String nom, String prenom, StatutMatrimonial statutMatrimonial, String matricule, String dateFonction, Role role, Categorie categorie) {
        super(nom, prenom, statutMatrimonial);
        this.Matricule = matricule;
        this.dateFonction = dateFonction;
        this.SalaireFinal = 0.0;
        this.role = role;
        this.categorie = categorie;
        this.statutMatrimonial = statutMatrimonial;
        this.demandeConge = null;

    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMatricule() {
        return Matricule;
    }

    public void setMatricule(String matricule) {
        Matricule = matricule;
    }

    public String getDateFonction() {
        return dateFonction;
    }

    public void setDateFonction(String dateFonction) {
        this.dateFonction = dateFonction;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public DemandeConge getDemandeConge() {
        return demandeConge;
    }

    public void setDemandeConge(DemandeConge demandeConge) {
        this.demandeConge = demandeConge;
    }

    @Override
    public void poserConge(String dateDebut, String dateFin, String motif){
        this.demandeConge = new DemandeConge(dateDebut, dateFin, motif, this);
        this.demandeConge.setStatutDemande(StatutDemande.EN_ATTENTE);
        this.getDirecteur().setDemandesConges(Arrays.asList(this.demandeConge));
        System.out.println("L'employé "+ nom+" "+prenom+" pose des congés de "+ dateDebut+" à "+dateFin);
        System.out.println("il attend la validation du directeur");
    }

    @Override
    public void poserConge(DemandeConge demandeConge){
        this.setDemandeConge(demandeConge);
        this.demandeConge.setStatutDemande(StatutDemande.EN_ATTENTE);
        this.getDirecteur().addDemandesConges(Arrays.asList(this.demandeConge));
        System.out.println("Congé posé !");
    }

    public List<DemandeConge> demanderConge(DemandeConge demandeConge){
        this.setDemandeConge(demandeConge);
        this.demandeConge.setStatutDemande(StatutDemande.EN_ATTENTE);
        this.getDirecteur().addDemandesConges(Arrays.asList(this.demandeConge));
        System.out.println("Congé posé !");
        return this.getDirecteur().getDemandesConges();
    }

    @Override
    public void calculerSalaire() {
        this.SalaireFinal = role.getSalaireDeBase() + categorie.getPrime()* role.getSalaireDeBase();
        System.out.println(this.SalaireFinal);
    }

    @Override
    public String toString() {
        return "Employe{" +
                "Matricule='" + Matricule + '\'' +
                ", Date de fonction='" + dateFonction + '\'' +
                ", Role=" + role.getRole() +
                ", Categorie=" + categorie.getCategorie() +
                ", Nom='" + nom + '\'' +
                ", Prenom='" + prenom + '\'' +
                ", Statut Matrimonial=" + statutMatrimonial.getStatut() +
                '}';
    }
}
