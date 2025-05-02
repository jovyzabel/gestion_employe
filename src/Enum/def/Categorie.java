package Enum.def;

public enum Categorie {
    A("Nouveau"),
    AB("AB"),
    B("B"),
    C("C");


    private String categorie;

    private Categorie(String categorie){
        this.categorie = categorie;
    }
}
