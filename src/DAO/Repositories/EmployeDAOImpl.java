package DAO.Repositories;

import DAO.Interfaces.EmployeDAO;
import Database.connection.Database;
import Enum.def.Categorie;
import Enum.def.Role;
import Enum.def.StatutMatrimonial;
import Models.Employe;
import org.mariadb.jdbc.Statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeDAOImpl implements EmployeDAO {

    @Override
    public Employe get(int id) throws SQLException {
        Connection connection = Database.getConnection();
        Employe employe = null;

        String sql = "Select * from employe where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int oid = rs.getInt("id");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            String matricule = rs.getString("matricule");
            String dateFonction = rs.getString("dateFonction");
            double salaireBase = rs.getDouble("salaire_base");
            double salaireFinal = rs.getDouble("salaire_final");
            String role = rs.getString("role");
            String categorie = rs.getString("categorie");
            String statutMatrimonial = rs.getString("statut_matrimonial");


//            Role roleEnum = Role.valueOf(role);
//            Categorie categorieEnum = Categorie.valueOf(categorie);
//            StatutMatrimonial statutMatrimonialEnum = StatutMatrimonial.valueOf(statutMatrimonial);

            Role roleEnum = null;
            Categorie categorieEnum = null;
            StatutMatrimonial statutMatrimonialEnum = null;

            try {
                roleEnum = Role.valueOf(role.toUpperCase()); // Convert to uppercase
                categorieEnum = Categorie.valueOf(categorie.toUpperCase()); // Convert to uppercase
                statutMatrimonialEnum = StatutMatrimonial.valueOf(statutMatrimonial.toUpperCase()); // Convert to uppercase
            } catch (IllegalArgumentException e) {
                System.err.println("Warning: Invalid role string found: " + role);
                System.err.println("Warning: Invalid Categorie string found: " + role);
                System.err.println("Warning: Invalid StatutMatrinonial string found: " + role);

            }
            // checking of Enums

//            employe = new Employe(nom,prenom,statutMatrimonial,matricule,dateFonction,role,categorie,salaireBase,salaireFinal);
            employe = new Employe(nom, prenom, statutMatrimonialEnum, matricule, dateFonction, roleEnum, categorieEnum);
        }
        Database.closeResultSet(rs);
        Database.closePrepareStatement(ps);
        Database.closeConnection(connection);

        return employe;
    }

    @Override
    public List<Employe> getAll() throws SQLException {
        Connection connection = Database.getConnection();
        String sql = "Select * from employe";
        ArrayList<Employe> employes = new ArrayList<>();

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int oid = rs.getInt("id");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            String matricule = rs.getString("matricule");
            String dateFonction = rs.getString("dateFonction");
            double salaireBase = rs.getDouble("salaire_base");
            double salaireFinal = rs.getDouble("salaire_final");
            String role = rs.getString("role");
            String categorie = rs.getString("categorie");
            String statutMatrimonial = rs.getString("statut_matrimonial");

            // checking of Enums

            Role roleEnum = null;
            Categorie categorieEnum = null;
            StatutMatrimonial statutMatrimonialEnum = null;
            try {
                roleEnum = Role.valueOf(role.toUpperCase()); // Convert to uppercase
                categorieEnum = Categorie.valueOf(categorie.toUpperCase()); // Convert to uppercase
                statutMatrimonialEnum = StatutMatrimonial.valueOf(statutMatrimonial.toUpperCase()); // Convert to uppercase
            } catch (IllegalArgumentException e) {
                System.err.println("Warning: Invalid role string found: " + role);
                System.err.println("Warning: Invalid Categorie string found: " + role);
                System.err.println("Warning: Invalid StatutMatrinonial string found: " + role);

            }

//          employe = new Employe(nom,prenom,statutMatrimonial,matricule,dateFonction,role,categorie,salaireBase,salaireFinal);
            employes.add(new Employe(nom, prenom, statutMatrimonialEnum, matricule, dateFonction, roleEnum, categorieEnum));
        }
        Database.closeResultSet(rs);
        Database.closePrepareStatement(preparedStatement);
        Database.closeConnection(connection);

        return employes;
    }

    @Override
    public Employe create(Employe employe) throws SQLException {
        Connection connection = Database.getConnection();
        String sql = "INSERT INTO employe (nom, prenom, statut_matrimonial, matricule, dateFonction, salaire_base, salaire_final, categorie, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, employe.getNom());
        preparedStatement.setString(2, employe.getPrenom());
        preparedStatement.setString(3, employe.getStatutMatrimonial().name());
        preparedStatement.setString(4, employe.getMatricule());
        preparedStatement.setString(5, employe.getDateFonction());
        preparedStatement.setDouble(6, employe.getRole().getSalaireDeBase());
        preparedStatement.setDouble(7, employe.getSalaireFinal());
        preparedStatement.setString(8, employe.getCategorie().name());
        preparedStatement.setString(9, employe.getRole().name());

        int result = preparedStatement.executeUpdate();

        ResultSet genKeys = preparedStatement.getGeneratedKeys();
        Employe insertedEmploye = null;

        if (result > 0 && genKeys.next()) {
            int newId = genKeys.getInt(1);
            insertedEmploye = new Employe();
            insertedEmploye.setId(newId);
            insertedEmploye.setNom(employe.getNom());
            insertedEmploye.setPrenom(employe.getPrenom());
            insertedEmploye.setStatutMatrimonial(employe.getStatutMatrimonial());
            insertedEmploye.setMatricule(employe.getMatricule());
            insertedEmploye.setDateFonction(employe.getDateFonction());
            insertedEmploye.setSalaireBase(employe.getRole().getSalaireDeBase());
            insertedEmploye.setSalaireFinal(employe.getSalaireFinal());
            insertedEmploye.setCategorie(employe.getCategorie());
            insertedEmploye.setRole(employe.getRole());
        }

        Database.closePrepareStatement(preparedStatement);
        Database.closeConnection(connection);

        return insertedEmploye;
    }

    @Override
    public int delete(Employe employe) throws SQLException {
        Connection connection = Database.getConnection();
        String sql = "Delete from employe where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1,employe.getId());
        int result = preparedStatement.executeUpdate();

        Database.closePrepareStatement(preparedStatement);
        Database.closeConnection(connection);

        return result ;
    }

}
