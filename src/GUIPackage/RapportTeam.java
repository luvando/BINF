/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import static GUIPackage.CompetitieOpvragen.dManager;
import static GUIPackage.GegevensOpvragen.dManager;
import static GUIPackage.RapportSpeler.dManager;
import ijshockey.Competitie;
import ijshockey.DBException;
import ijshockey.DriverManager;
import ijshockey.Seizoen;
import ijshockey.Team;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Wim
 */
public class RapportTeam extends javax.swing.JFrame {

    public static DriverManager dManager;

    private Competitie competitie;
    private Seizoen seizoen;
    private Team team;
    DefaultListModel DLM;

    /**
     * Creates new form RapportTeam
     */
    public RapportTeam() {
        this.dManager = dManager;
        initComponents();
        setLocationRelativeTo(null);
    }

    public RapportTeam(DriverManager dManager, Competitie competitie, Seizoen seizoen) throws SQLException {
        super("Kies een team");
        this.dManager = dManager;
        this.competitie = competitie;
        this.seizoen = seizoen;

        initComponents();
        setLocationRelativeTo(null);
        this.FillLijstTeam(ijshockey.DriverManager.FillLijstTeam(DLM, competitie, seizoen));
    }

    private void FillLijstTeam(DefaultListModel DLM) {
        try {

            LijstTeams.setModel(DLM);

        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        LijstTeams = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        DrukRapportAfButton = new javax.swing.JButton();
        VorigeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rapport team");

        LijstTeams.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LijstTeams.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                LijstTeamsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(LijstTeams);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Kies team");

        DrukRapportAfButton.setBackground(java.awt.SystemColor.activeCaption);
        DrukRapportAfButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DrukRapportAfButton.setText("Druk rapport af");
        DrukRapportAfButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DrukRapportAfButtonActionPerformed(evt);
            }
        });

        VorigeButton.setBackground(new java.awt.Color(255, 204, 204));
        VorigeButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        VorigeButton.setText("Vorige");
        VorigeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VorigeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(VorigeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(DrukRapportAfButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DrukRapportAfButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VorigeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DrukRapportAfButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DrukRapportAfButtonActionPerformed
        // TODO add your handling code here:
        Team team = null;
        String thuis = (String) LijstTeams.getSelectedValue();

        String[] teamthuis = thuis.split("-");
        String teamthuistr = teamthuis[teamthuis.length - 1].trim();
        int stamnrthuis = Integer.parseInt(teamthuistr);
        try {
            team = DriverManager.getTeam(stamnrthuis);
        } catch (DBException ex) {
            Logger.getLogger(RapportTeam.class.getName()).log(Level.SEVERE, null, ex);
        }
        TeamRapport updateForm = null;
        try {
            updateForm = new TeamRapport(dManager, competitie, seizoen, team);
        } catch (DBException ex) {
            Logger.getLogger(RapportTeam.class.getName()).log(Level.SEVERE, null, ex);
        }
        updateForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_DrukRapportAfButtonActionPerformed

    private void VorigeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VorigeButtonActionPerformed
        // TODO add your handling code here:
        GegevensOpvragen updateForm = null;
        updateForm = new GegevensOpvragen(dManager, competitie, seizoen);
        updateForm.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_VorigeButtonActionPerformed

    private void LijstTeamsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_LijstTeamsValueChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_LijstTeamsValueChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RapportTeam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RapportTeam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RapportTeam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RapportTeam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RapportTeam().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DrukRapportAfButton;
    private javax.swing.JList LijstTeams;
    private javax.swing.JButton VorigeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
