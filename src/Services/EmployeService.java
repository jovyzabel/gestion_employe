package Services;

import DAO.Interfaces.EmployeDAO;
import Models.Employe;
import Models.ICalculSalaire;

public class EmployeService {
    private EmployeDAO employeDAO;

    public EmployeService(EmployeDAO employeDAO){
        this.employeDAO = employeDAO;
    }

    public void calculerSalaire(Employe employe) {
        employe.setSalaireFinal(employe.getRole().getSalaireDeBase() + employe.getCategorie().getPrime()* employe.getRole().getSalaireDeBase());
    }
}
