package Models;

import java.util.List;

public interface IDirecteur {
    public boolean validerConge(DemandeConge conge);
    public boolean refuserConge(DemandeConge conge);
    public boolean ajouterEmployes(List<Employe> employeList);
    public boolean ajouterEmploye(Employe employe);
    public boolean retirerEmploye(Employe employe) ;
    public boolean retirerEmployes(List<Employe> employeList) ;

}
