/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import static GUIPackage.AddSpeler.dManager;
import ijshockey.Competitie;
import ijshockey.DBException;
import ijshockey.DriverManager;
import ijshockey.Scheidsrechter;
import ijshockey.Seizoen;
import ijshockey.Speeldag;
import ijshockey.Team;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.text.Position;

/**
 *
 * @author Wim
 */
public class BewerkTeam extends javax.swing.JFrame {

    public static DriverManager dManager;
    private Competitie competitie;
    private Seizoen seizoen;

    /**
     * Creates new form BewerkTeam
     */
    public BewerkTeam() {
        initComponents();
    }

    DefaultListModel DLM;

    public BewerkTeam(DriverManager dManager, Competitie competitie, Seizoen seizoen) throws SQLException {
        AddTeamEnTrainer.dManager = dManager;
        
        initComponents();
        this.seizoen = seizoen;
        this.competitie = competitie;
        setLocationRelativeTo(null);
        this.FillLijstTeams(ijshockey.DriverManager.FillLijstTeam(DLM, competitie, seizoen));

    }

    private void FillLijstTeams(DefaultListModel DLM) {

        try {

            jListTeam.setModel(DLM);

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
        jListTeam = new javax.swing.JList();
        AddSpelerButton = new javax.swing.JButton();
        SpelerBewerkenButton = new javax.swing.JButton();
        TrainerBewerkenButton = new javax.swing.JButton();
        SearchButton = new javax.swing.JButton();
        SearchText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Team bewerken");

        jListTeam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(jListTeam);

        AddSpelerButton.setBackground(java.awt.SystemColor.activeCaption);
        AddSpelerButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AddSpelerButton.setText("Speler toevoegen");
        AddSpelerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddSpelerButtonActionPerformed(evt);
            }
        });

        SpelerBewerkenButton.setBackground(java.awt.SystemColor.activeCaption);
        SpelerBewerkenButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SpelerBewerkenButton.setText("Speler bewerken");
        SpelerBewerkenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SpelerBewerkenButtonActionPerformed(evt);
            }
        });

        TrainerBewerkenButton.setBackground(java.awt.SystemColor.activeCaption);
        TrainerBewerkenButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TrainerBewerkenButton.setText("Trainer bewerken");
        TrainerBewerkenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrainerBewerkenButtonActionPerformed(evt);
            }
        });

        SearchButton.setBackground(java.awt.SystemColor.activeCaption);
        SearchButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SearchButton.setText("Team zoeken");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        SearchText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SearchText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchTextActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 204, 204));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Vorige");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(SearchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SearchText, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TrainerBewerkenButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddSpelerButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SpelerBewerkenButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(SearchText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(AddSpelerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SpelerBewerkenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(TrainerBewerkenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddSpelerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddSpelerButtonActionPerformed
        // TODO add your handling code here:
        Team team = null;
        AddSpeler updateForm = null;
        String teamstring = (String) jListTeam.getSelectedValue();

        String[] teama = teamstring.split("-");
        String teamstr = teama[teama.length - 1].trim();
        int stamnr = Integer.parseInt(teamstr);
        try {
            team = DriverManager.getTeam(stamnr);
            updateForm = new AddSpeler(dManager, team, competitie, seizoen);

        } catch (DBException ex) {
            Logger.getLogger(BewerkTeam.class.getName()).log(Level.SEVERE, null, ex);
        }

        updateForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_AddSpelerButtonActionPerformed

    private void SpelerBewerkenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SpelerBewerkenButtonActionPerformed
        Team team = null;
        BewerkSpeler updateForm = null;
        String teamstring = (String) jListTeam.getSelectedValue();

        String[] teama = teamstring.split("-");
        String teamstr = teama[teama.length - 1].trim();
        int stamnr = Integer.parseInt(teamstr);
        try {
            team = DriverManager.getTeam(stamnr);
            updateForm = new BewerkSpeler(dManager, team, competitie, seizoen);

        } catch (DBException ex) {
            Logger.getLogger(BewerkTeam.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BewerkTeam.class.getName()).log(Level.SEVERE, null, ex);
        }

        updateForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_SpelerBewerkenButtonActionPerformed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        // TODO add your handling code here:
        int zoekresultaat = jListTeam.getNextMatch(SearchText.getText(), 0, Position.Bias.Forward);
        jListTeam.setSelectedIndex(zoekresultaat);
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void SearchTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchTextActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CompetitieScherm updateForm = null;
        try {
            updateForm = new CompetitieScherm(dManager);
        } catch (DBException ex) {
            Logger.getLogger(BewerkTeam.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BewerkTeam.class.getName()).log(Level.SEVERE, null, ex);
        }
        updateForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TrainerBewerkenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrainerBewerkenButtonActionPerformed

        Team team = null;
        BewerkTrainer updateForm = null;
        String teamstring = (String) jListTeam.getSelectedValue();

        String[] teama = teamstring.split("-");
        String teamstr = teama[teama.length - 1].trim();
        int stamnr = Integer.parseInt(teamstr);

        try {
            team = DriverManager.getTeam(stamnr);
             updateForm = new BewerkTrainer(dManager, team , competitie, seizoen);
        } catch (DBException | SQLException ex) {
            Logger.getLogger(BewerkTeam.class.getName()).log(Level.SEVERE, null, ex);
        }
       

        updateForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_TrainerBewerkenButtonActionPerformed

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
            java.util.logging.Logger.getLogger(BewerkTeam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BewerkTeam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BewerkTeam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BewerkTeam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BewerkTeam().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddSpelerButton;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTextField SearchText;
    private javax.swing.JButton SpelerBewerkenButton;
    private javax.swing.JButton TrainerBewerkenButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JList jListTeam;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
