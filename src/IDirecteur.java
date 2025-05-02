import java.util.List;

public interface IDirecteur {
    public boolean validerConge(Conge conge, Employe employe);
    public boolean refuterConge(Conge conge, Employe employe);
    public List<Employe> ajouterEmployes(List<Employe> employeList);
    public Employe ajouterEmploye(Employe employe);

}
