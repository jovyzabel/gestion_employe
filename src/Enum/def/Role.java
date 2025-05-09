package Enum.def;

public enum Role {
    DESIGNER("Designer", 450000.000),
    FRONTEND("Frontend", 455500.000),
    BACKEND("Backend", 500000.000),
    FULLSTACK("Fullstack", 720000.000),
    CHEF_PROJET("Chef Projet", 815500.000),
    DIRECTEUR("Directeur", 1200000.000);

    private String role;

    public Double getSalaireDeBase() {
        return salaireDeBase;
    }

    public String getRole() {
        return role;
    }


    private Double salaireDeBase;

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
