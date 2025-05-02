package Enum.def;

public enum Role {
    DESIGNER("Designer", 450000.000),
    FRONTEND("Frontend", 455500.000),
    BACKEND("Backend", 500000.000),
    FULLSTACK("Fullstack", 720000.000),
    CHEF_PROJET("Chef Projet", 815500.000),
    DIRECTEUR("Directeur", 1200000.000);

    private String role;

    @Override
    public String toString() {
        return "Role{" +
                "role='" + role + '\'' +
                ", salaireDeBase=" + salaireDeBase +
                '}';
    }

    private Double salaireDeBase;

    private Role(String role, Double salaireDeBase){
        this.role = role;
        this.salaireDeBase = salaireDeBase;
    }


}
