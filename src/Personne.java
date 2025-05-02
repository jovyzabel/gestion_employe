import Enum.def.StatutMatrimonial;

public abstract class Personne {
    protected String nom;
    protected String prenom;
    protected StatutMatrimonial statutMatrimonial;

    public Personne(String nom, String prenom, StatutMatrimonial statutMatrimonial) {
        this.nom = nom;
        this.prenom = prenom;
        this.statutMatrimonial = statutMatrimonial;
    }


}
