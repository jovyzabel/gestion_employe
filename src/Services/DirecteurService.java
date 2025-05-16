package Services;

import DAO.Interfaces.DirecteurDAO;
import Models.Employe;

import java.util.List;

public class DirecteurService {
    private DirecteurDAO directeurDAO;

    public DirecteurService(DirecteurDAO directeurDAO){
        this.directeurDAO = directeurDAO;
    }

    public boolean ajouterEmployes(List<Employe> employeList) {

        return false;
    }
    public boolean ajouterEmploye(Employe employe) {

        return true;

    }
    public boolean retirerEmploye(Employe employe) {

        return true;
    }
    public boolean retirerEmployes(List<Employe> employeList) {

        return false;

    }
}
