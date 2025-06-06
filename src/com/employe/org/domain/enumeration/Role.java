package com.employe.org.domain.enumeration;

public enum Role {
    DESIGNER("Designer", 450000.000),
    FRONTEND("Frontend", 455500.000),
    BACKEND("Backend", 500000.000),
    FULLSTACK("Fullstack", 720000.000),
    CHEF_PROJET("Chef Projet", 815500.000),
    DIRECTEUR("Models.Directeur", 1200000.000);

    private String role;

    public double getSalaireDeBase() {
        return salaireDeBase;
    }

    public String getRole() {
        return role;
    }


    private double salaireDeBase;

    private Role(String role, double salaireDeBase){
        this.role = role;
        this.salaireDeBase = salaireDeBase;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role='" + role + '\'' +
                ", salaireDeBase=" + salaireDeBase +
                '}';
    }


}
