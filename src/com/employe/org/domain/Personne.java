package com.employe.org.domain;

import com.employe.org.domain.enumeration.StatutMatrimonial;

public abstract class Personne {
    protected int id;
    protected String nom;
    protected String prenom;
    protected StatutMatrimonial statutMatrimonial;

    public Personne(){

    }
    public Personne(String nom, String prenom, StatutMatrimonial statutMatrimonial) {
        this.nom = nom;
        this.prenom = prenom;
        this.statutMatrimonial = statutMatrimonial;
    }
    public Personne(int id, String nom, String prenom, StatutMatrimonial statutMatrimonial) {
        this.nom = nom;
        this.prenom = prenom;
        this.statutMatrimonial = statutMatrimonial;
        this.id = id;
    }

    public StatutMatrimonial getStatutMatrimonial() {
        return statutMatrimonial;
    }

    public void setStatutMatrimonial(StatutMatrimonial statutMatrimonial) {
        this.statutMatrimonial = statutMatrimonial;
    }

}
