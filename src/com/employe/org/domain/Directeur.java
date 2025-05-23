package com.employe.org.domain;

import com.employe.org.domain.enumeration.Categorie;
import com.employe.org.domain.enumeration.Role;
import com.employe.org.domain.enumeration.StatutMatrimonial;

import java.util.ArrayList;
import java.util.List;

public class Directeur extends  Employe {
    private  List<Employe> employes;
    private  int nbreEmploye;
    private double primeMatrimonial;
    private List<DemandeConge> demandesConges;

    public List<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }

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


//    @Override
//    public void poserConge(String dateDebut, String dateFin, String motif){
//        System.out.println("Le directeur "+ getNom()+" "+getPrenom()+" pose des congés de "+
//                dateDebut+" à "+dateFin);
//        System.out.println("les congés sont automatiquement validés");
//    }

//    @Override
//    public void calculerSalaire() {
//        this.primeMatrimonial = this.statutMatrimonial.getPrime();
//        this.SalaireFinal = role.getSalaireDeBase() + categorie.getPrime()* role.getSalaireDeBase() + this.primeMatrimonial;
//        System.out.println(this.SalaireFinal);
//    }

    public void show(){
        this.employes.forEach(System.out::println);
        System.out.println("Nombres total d'employé(s) "+this.nbreEmploye);
    }

    @Override
    public String toString() {
        return "Models.Directeur{" +
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
