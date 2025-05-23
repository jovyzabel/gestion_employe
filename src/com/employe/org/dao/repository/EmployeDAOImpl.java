package com.employe.org.dao.repository;

import com.employe.org.dao.database.ISQLFunction;
import com.employe.org.dao.interfce.IEmployeDAO;
import com.employe.org.dao.database.Database;
import com.employe.org.domain.enumeration.Categorie;
import com.employe.org.domain.enumeration.Role;
import com.employe.org.domain.enumeration.StatutMatrimonial;
import com.employe.org.domain.Employe;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mariadb.jdbc.Statement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeDAOImpl implements IEmployeDAO {

    private static Logger logger = LogManager.getLogger(EmployeDAOImpl.class);

    private <T> T connect(ISQLFunction<T> function) throws SQLException {
        try (Connection connection = Database.getConnection()) {
            return function.apply(connection);
        }
    }

    @Override
    public Employe get(int id) throws SQLException {
        return connect(connection -> {
            Employe employe = null;
            String sql = "Select * from employe where id = ?";

            try(PreparedStatement ps = connection.prepareStatement(sql)){

                ps.setInt(1, id);

                try(ResultSet rs = ps.executeQuery();) {
//                ResultSet rs = ps.executeQuery();

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

                        // checking of Enums

                        Role roleEnum = null;
                        Categorie categorieEnum = null;
                        StatutMatrimonial statutMatrimonialEnum = null;

                        try {
                            roleEnum = Role.valueOf(role.toUpperCase()); // Convert to uppercase
                            categorieEnum = Categorie.valueOf(categorie.toUpperCase()); // Convert to uppercase
                            statutMatrimonialEnum = StatutMatrimonial.valueOf(statutMatrimonial.toUpperCase()); // Convert to uppercase
                        } catch (IllegalArgumentException e) {
                            logger.warn("Invalid role string found: " + e);
                        }

                        employe = new Employe(nom, prenom, statutMatrimonialEnum, matricule, dateFonction, roleEnum, categorieEnum);
                    }

                }

            }
            catch (SQLSyntaxErrorException eSynthax){
                logger.error(eSynthax.getMessage());
            }
            return employe;
        });

    }

    @Override
    public List<Employe> getAll() throws SQLException {
        return connect(connection -> {
            ArrayList<Employe> employes = new ArrayList<>();
            String sql = "Select * from employe";
            //            Connection connection = Database.getConnection();
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql);){

                try (ResultSet rs = preparedStatement.executeQuery();){
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
                            logger.warn("Invalid role string found: " + e);
                        }

//          employe = new Employe(nom,prenom,statutMatrimonial,matricule,dateFonction,role,categorie,salaireBase,salaireFinal);
                        employes.add(new Employe(nom, prenom, statutMatrimonialEnum, matricule, dateFonction, roleEnum, categorieEnum));
                    }

                }
                catch (SQLSyntaxErrorException eSynthax){
                    logger.error(eSynthax.getMessage());
                }
                return employes;
                }
        });
    }

    @Override
    public Employe create(Employe employe) throws SQLException {
//        Connection connection = Database.getConnection();
        String sql = "INSERT INTO employe (nom, prenom, statut_matrimonial, matricule, dateFonction, salaire_base, salaire_final, categorie, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return connect(connection -> {
            Employe insertedEmploye = null;
            try {

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
            }
            catch (SQLSyntaxErrorException eSynthax){
                logger.error(eSynthax.getMessage());
            }
            return insertedEmploye;

        });


    }

    public int update(Employe employe) throws SQLException {
//        Connection connection = Database.getConnection();
        return connect(connection -> {
            int result = 0;
            String sql = "UPDATE employe SET nom = ?, prenom = ?, statut_matrimonial = ?, matricule = ?, dateFonction = ?, salaire_base = ?, salaire_final = ?, categorie = ?, role = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);){

                preparedStatement.setString(1, employe.getNom());
                preparedStatement.setString(2, employe.getPrenom());
                preparedStatement.setString(3, employe.getStatutMatrimonial().name());
                preparedStatement.setString(4, employe.getMatricule());
                preparedStatement.setString(5, employe.getDateFonction());
                preparedStatement.setDouble(6, employe.getSalaireBase());
                preparedStatement.setDouble(7, employe.getSalaireFinal());
                preparedStatement.setString(8, employe.getCategorie().name());
                preparedStatement.setString(9, employe.getRole().name());
                preparedStatement.setInt(10, employe.getId()); // WHERE id = ?

                result = preparedStatement.executeUpdate();

//                Database.closePrepareStatement(preparedStatement);
//                Database.closeConnection(connection);

            }
            catch (SQLSyntaxErrorException eSynthax){
                logger.error(eSynthax.getMessage());
            }

            return result;
        });
    }

    @Override
    public int delete(Employe employe) throws SQLException {
//        Connection connection = Database.getConnection();
        return connect(connection -> {
            int result = 0;
            String sql = "Delete from employe where id=?";
            try( PreparedStatement preparedStatement = connection.prepareStatement(sql);){

                preparedStatement.setInt(1,employe.getId());
                result = preparedStatement.executeUpdate();

                Database.closePrepareStatement(preparedStatement);
                Database.closeConnection(connection);
            }
            catch (SQLSyntaxErrorException eSynthax){
                logger.error(eSynthax.getMessage());
            }
            return result ;
        });
    }

}
