package Models;

public interface IEmploye {
    public void poserConge(String dateDebut, String dateFin, String motif );
    public void poserConge(DemandeConge demandeConge);

}
