package Enum.def;

public enum Categorie {
    A("Nouveau", 0.0),
    AB("AB", 0.02),
    B("B", 0.08),
    C("C", 0.15);

    public String getCategorie() {
        return categorie;
    }

    public double getPrime() {
        return prime;
    }

    private String categorie;
    private double prime;

    private Categorie(String categorie, double prime){
        this.categorie = categorie;
        this.prime = prime;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "categorie='" + categorie + '\'' +
                '}';
    }


}
