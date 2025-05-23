package com.employe.org.presentation;

import com.employe.org.dao.interfce.IDirecteurDAO;
import com.employe.org.dao.interfce.IEmployeDAO;
import com.employe.org.dao.repository.DirecteurImpl;
import com.employe.org.dao.repository.EmployeDAOImpl;
import com.employe.org.domain.DemandeConge;
import com.employe.org.domain.Directeur;
import com.employe.org.domain.Employe;
import com.employe.org.domain.enumeration.Categorie;
import com.employe.org.domain.enumeration.Role;
import com.employe.org.domain.enumeration.StatutMatrimonial;
import com.employe.org.service.DirecteurService;
import com.employe.org.service.EmployeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    private static Logger logger = LogManager.getLogger(Main.class);


    public static void main(String[] args) throws SQLException {
        logger.info("Test Logs");
//        // connexion à la bd
//        Connection connection = Database.getConnection();
//        if(connection != null)
//            logger.info("Successfully connected !");

        // declarations
        Directeur directeur = new Directeur("Alder","Yahn", StatutMatrimonial.FIANCE,"MY33", LocalDate.now().toString(), Role.FRONTEND, Categorie.AB);
        Employe employe = new Employe("Postiga","Vincent", StatutMatrimonial.MARIE,"ZAB54","0000-00-00 ", Role.FRONTEND, Categorie.AB);
        Employe emp1 = new Employe("Doe", "John", StatutMatrimonial.CELIBATAIRE, "E001", "2022-01-01", Role.FULLSTACK, Categorie.B);
        Employe emp2 = new Employe("Smith", "Alice", StatutMatrimonial.MARIE, "E002", "2023-02-01", Role.CHEF_PROJET, Categorie.C);

        IDirecteurDAO directeurDAO = null;
        DirecteurService directeurService = new DirecteurService(directeurDAO, directeur);
        directeurService.ajouterEmployes(Arrays.asList(employe, emp1, emp2));

        directeur.show();

        IEmployeDAO employeDAO = new EmployeDAOImpl();
//
        EmployeService employeService = new EmployeService(employeDAO);
        employeService.poserConge(new DemandeConge("20-10-24", "20-12-24", "Repos", employe));

        DemandeConge demande = new DemandeConge("2025-06-01", "2025-06-10", "Vacances", emp1);
        directeur.addDemandesConges(Arrays.asList(demande));
        directeurService.validerConge(demande);


//      logger.warn(directeur.getDemandesConges());

//        directeurService.showAllDemandes();


        // appel à la method
        employeDAO.create(emp2);
        var employes = employeDAO.getAll();
        logger.info(employes);

//        Employe employe1 = employeDAO.get(2);
//        Employe employe2 = employeDAO.get(3);

//        logger.info(employe2);

        // affichage
//        logger.info(employes);







//        SwingUtilities.invokeLater(() -> {
//            ListeEmployeUI ui = new ListeEmployeUI();
//            ui.setVisible(true);
//        });









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