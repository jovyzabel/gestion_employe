public interface IEmploye {
    public void poserConge(String dateDebut, String dateFin, String motif );
    public void poserConge(DemandeConge demandeConge);
//    public void calculerSalaire(Employe employe);
    public void calculerSalaire();
}
