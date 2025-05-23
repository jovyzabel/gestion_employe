package com.employe.org.domain.enumeration;

public enum StatutDemande {
    EN_ATTENTE("EN ATTENTE"),
    APPROUVEE("APPROUVEE"),
    REFUSEE("REFUSE");



    private String statut;

    StatutDemande(String statut){
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "StatutDemande{" +
                "statut='" + statut + '\'' +
                '}';
    }
}
