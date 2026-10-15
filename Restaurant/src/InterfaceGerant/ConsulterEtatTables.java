package InterfaceGerant;
import Restaurant.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ConsulterEtatTables extends javax.swing.JPanel {

    public ConsulterEtatTables() {
        initComponents();
        afficherEtatTables(); // Charger et afficher l'état des tables dès l'initialisation
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonRetour = new javax.swing.JButton();
        jScrollPaneTable = new javax.swing.JScrollPane();
        jTableEtatTables = new javax.swing.JTable(); // Initialisation de la table

        setPreferredSize(new java.awt.Dimension(700, 500));

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Andalus", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("État des Tables");

        jButtonRetour.setBackground(new java.awt.Color(255, 102, 102));
        jButtonRetour.setText("Retour");
        jButtonRetour.addActionListener(evt -> jButtonRetourActionPerformed(evt));

        // Configuration de la JTable (vide initialement, remplie par afficherEtatTables())
        jTableEtatTables.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{}, // Pas de données initiales
                new String[]{"ID Table", "État"} // En-têtes de colonnes
        ));
        jScrollPaneTable.setViewportView(jTableEtatTables);

        // Layout du panneau principal
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addComponent(jButtonRetour, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(156, 156, 156)
                                                .addComponent(jLabel1))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addComponent(jScrollPaneTable, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jButtonRetour, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addComponent(jScrollPaneTable, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        // Layout du panneau principal
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

    // Charger et afficher l'état des tables dans la JTable
    private void afficherEtatTables() {
        Gerant gerant = new Gerant(); // Instanciation de la classe Gerant
        JTable tableEtat = gerant.consulterEtatTables(); // Récupération de la JTable

        // Récupérer le modèle de table et l'appliquer à jTableEtatTables
        jTableEtatTables.setModel(tableEtat.getModel());
    }

    private void jButtonRetourActionPerformed(java.awt.event.ActionEvent evt) {
        JFrame Returnfram = new JFrame("Routeur Gestion des tables");
        Returnfram.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Ajouter le panneau Gestion des Tables
        GestionTables Panel = new GestionTables();
        Returnfram.getContentPane().add(Panel);

        Returnfram.setSize(700, 500);
        Returnfram.setLocationRelativeTo(null); // Centrer la fenêtre
        Returnfram.setVisible(true);

        // Fermer la fenêtre actuelle
        JFrame serveurFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        serveurFrame.dispose();
    }

    // Variables declaration
    private javax.swing.JButton jButtonRetour;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPaneTable;
    private javax.swing.JTable jTableEtatTables;
    // End of variables declaration
}

