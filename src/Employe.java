import Enum.def.Categorie;
import Enum.def.Role;
import Enum.def.StatutMatrimonial;

public class Employe extends Personne implements IEmploye{
    protected String Matricule;
    protected String dateFonction;
//    protected Double SalaireBase;
    protected Role role;
    protected Categorie categorie;

    public Employe(String nom, String prenom, StatutMatrimonial statutMatrimonial, String matricule, String dateFonction, Role role, Categorie categorie) {
        super(nom, prenom, statutMatrimonial);
        this.Matricule = matricule;
        this.dateFonction = dateFonction;
//        this.SalaireBase = Role.DESIGNER;
        this.role = role;
        this.categorie = categorie;
    }


    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMatricule() {
        return Matricule;
    }

    public void setMatricule(String matricule) {
        Matricule = matricule;
    }

    public String getDateFonction() {
        return dateFonction;
    }

    public void setDateFonction(String dateFonction) {
        this.dateFonction = dateFonction;
    }

//    public Double getSalaireBase() {
//        return SalaireBase;
//    }
//
//    public void setSalaireBase(Double salaireBase) {
//        SalaireBase = salaireBase;
//    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public void poserConge(String dateDebut, String dateFin){
        System.out.println("L'employé "+ nom+" "+prenom+" pose des congés de "+
                dateDebut+" à "+dateFin);
        System.out.println("il attend la validation du directeur");
    }

    @Override
    public void poserConge(Conge conge){
        System.out.println("L'employé "+ nom+" "+prenom+" pose des congés de "+
                conge.getDateDebut()+" à "+conge.getDateFin());
        System.out.println("il attend la validation du directeur");
    }

    @Override
    public void calculerSalaire(Employe employe) {

    }

    @Override
    public String toString() {
        return "Employe{" +
                "Matricule='" + Matricule + '\'' +
                ", dateFonction='" + dateFonction + '\'' +

                ", role=" + role +
                ", categorie=" + categorie +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", statutMatrimonial=" + statutMatrimonial +
                '}';
    }
}
