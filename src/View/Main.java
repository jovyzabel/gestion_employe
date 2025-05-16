package View;

import DAO.Interfaces.EmployeDAO;
import Database.connection.Database;
import Enum.def.Categorie;
import Enum.def.Role;
import Enum.def.StatutMatrimonial;
import Models.Employe;
import DAO.Repositories.EmployeDAOImpl;
import Services.EmployeService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        Connection connection = Database.getConnection();

        if(connection != null)
            System.out.println("Successfully connected !");

        EmployeDAO employeDAO = new EmployeDAOImpl();
        EmployeService employeService = new EmployeService(employeDAO);
//      Employe employe = employeDAO.get(2);

        Employe employe = new Employe("Jobby","Mak",StatutMatrimonial.VEUF,"Mk78","0000-00-00 ",Role.DIRECTEUR, Categorie.C);
//        employeService.calculerSalaire(employe);
//         System.out.println(employeDAO.create(employe));

        List<Employe> employes = employeDAO.getAll();
        employeDAO.delete(employe);

        System.out.println(employeDAO.get(4));






    /*
        Employe employe1 = new Employe("Mohamed", "Hassan", StatutMatrimonial.FIANCE,"DEVINFO20", "21/02/2022", Role.DESIGNER, Categorie.AB);
        Employe employe2 = new Employe("Boubakar", "Ben Saïd", StatutMatrimonial.CELIBATAIRE,"DEVINFO20", "21/02/2022", Role.DESIGNER,Categorie.AB);
        Employe employe3 = new Employe("Serge", "Anani", StatutMatrimonial.CELIBATAIRE,"DEV3.0", "21/02/2023", Role.FRONTEND,Categorie.AB);
        Employe employe4 = new Employe("Nicodeme", "Vodonou", StatutMatrimonial.MARIE,"DEV3.0", "21/02/2023", Role.BACKEND,Categorie.AB);
        Employe employe5 = new Employe("Sidonie", "F", StatutMatrimonial.CELIBATAIRE,"DEV3.0", "21/02/2023" , Role.CHEF_PROJET,Categorie.AB);
        Directeur directeur1 = new Directeur("David", "Koné", StatutMatrimonial.MARIE, "DGN2","15/01/2020",Role.DIRECTEUR, Categorie.C );

        List<Employe> employeList = Arrays.asList(employe1, employe3, employe4, employe5);

        directeur1.ajouterEmployes(employeList);
        directeur1.retirerEmployes(Arrays.asList(employe3,employe5));
        directeur1.show();

        employe1.poserConge(new DemandeConge("27/08/25", "10/09/25","Voyage fam", employe1));
        employe3.poserConge(new DemandeConge("24/05/25", "02/06/25","Congé Maladie", employe2));

        directeur1.showAllDemandes();


     */
    }
}