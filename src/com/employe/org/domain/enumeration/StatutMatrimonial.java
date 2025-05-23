package com.employe.org.domain.enumeration;

public enum StatutMatrimonial {
    MARIE("Marié", 270700.00),
    FIANCE("Fiancé", 0.00),
    CELIBATAIRE("Celibataire",0.00),
    VEUVE("Veuve",0.00),
    VEUF("Veuf",0.00);

    public String getStatut() {
        return statut;
    }

    public double getPrime() {
        return prime;
    }

    private String statut;
    private double prime;

    StatutMatrimonial(String statut, double prime){
        this.statut = statut;
        this.prime = prime;
    }

    @Override
    public String toString() {
        return "StatutMatrimonial{" +
                "statut='" + statut + '\'' +
                ", prime=" + prime +
                '}';
    }
}
