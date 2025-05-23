package com.employe.org.presentation;

import com.employe.org.dao.repository.EmployeDAOImpl;
import com.employe.org.domain.Employe;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class ListeEmployeUI extends JFrame {
    private JTable tableEmployes;
    private DefaultTableModel tableModel;
    private EmployeDAOImpl employeDAO;

    public ListeEmployeUI() {
        // Initialisation de la DAO
        employeDAO = new EmployeDAOImpl();

        // Configuration de la fenêtre
        setTitle("Liste des Employés");
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Création des composants
        initComponents();

        // Chargement des données
        loadEmployeData();
    }

    private void initComponents() {
        // Création du modèle de table avec colonnes
        String[] columnNames = {"ID", "Matricule", "Nom", "Prénom", "Statut Matrimonial",
                "Date Fonction", "Rôle", "Catégorie", "Salaire Base", "Salaire Final"};
        tableModel = new DefaultTableModel(columnNames, 0);
        tableEmployes = new JTable(tableModel);

        // Configuration de la table
        tableEmployes.setFillsViewportHeight(true);
        tableEmployes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        // Création d'un JScrollPane pour la table
        JScrollPane scrollPane = new JScrollPane(tableEmployes);

        // Création du panneau pour les boutons
        JPanel buttonPanel = new JPanel();
        JButton refreshButton = new JButton("Actualiser");
        JButton addButton = new JButton("Ajouter");
        JButton editButton = new JButton("Modifier");
        JButton deleteButton = new JButton("Supprimer");

        // Ajout des boutons au panneau
        buttonPanel.add(refreshButton);
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        // Ajout des composants à la fenêtre
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Configuration des actions des boutons
        refreshButton.addActionListener(e -> loadEmployeData());

        // Action pour le bouton supprimer

    }

    private void loadEmployeData() {
        // Vider la table
        tableModel.setRowCount(0);

        try {
            // Récupérer tous les employés
            List<Employe> employes = employeDAO.getAll();

            // Ajouter chaque employé à la table
            for (Employe employe : employes) {
                Object[] rowData = {
                        employe.getId(),
                        employe.getMatricule(),
                        employe.getNom(),
                        employe.getPrenom(),
                        employe.getStatutMatrimonial() != null ? employe.getStatutMatrimonial().getStatut() : "N/A",
                        employe.getDateFonction(),
                        employe.getRole() != null ? employe.getRole().getRole() : "N/A",
                        employe.getCategorie() != null ? employe.getCategorie().getCategorie() : "N/A",
                        employe.getSalaireBase(),
                        employe.getSalaireFinal()
                };
                tableModel.addRow(rowData);
            }

            // Notifier que des modifications ont été apportées
            tableModel.fireTableDataChanged();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
