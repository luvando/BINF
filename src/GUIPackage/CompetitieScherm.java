/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import ijshockey.Competitie;
import ijshockey.DBException;
import ijshockey.DriverManager;
import ijshockey.Seizoen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import ijshockey.DriverManager.closeConnection;
//import ijshockey.DriverManager.getConnection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.text.Position;

/**
 *
 * @author ekmaes
 */
public class CompetitieScherm extends javax.swing.JFrame {

    public static DriverManager dManager;

    private void FillLijst(DefaultListModel DLM) {
        try {

            LijstCompetities.setModel(DLM);

        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    public CompetitieScherm() {
        initComponents();
    }

    DefaultListModel DLM;

    public CompetitieScherm(DriverManager dManager) throws DBException, SQLException {
        this.dManager = dManager;
        initComponents();
        FillLijst(ijshockey.DriverManager.FillLijstCompetities(DLM));
        setLocationRelativeTo(null);

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
        LijstCompetities = new javax.swing.JList();
        VorigeButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        LijstSeizoenen = new javax.swing.JList<String>();
        SearchText = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        NieuwSeizoen = new javax.swing.JTextField();
        NieuwSeizoenButton = new javax.swing.JButton();
        AddSpeeldagButton = new javax.swing.JButton();
        TeamToevoegenButton = new javax.swing.JButton();
        TeamBewerkenButton = new javax.swing.JButton();
        addCompetitieButton = new javax.swing.JButton();
        Competitienaam = new javax.swing.JTextField();
        WedstrijdBewerkenButton = new javax.swing.JButton();
        DeelnameTeamToevoegen = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bestaande competitie");

        LijstCompetities.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LijstCompetities.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LijstCompetities.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                LijstCompetitiesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(LijstCompetities);

        VorigeButton.setBackground(new java.awt.Color(255, 204, 204));
        VorigeButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        VorigeButton.setText("Vorige");
        VorigeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VorigeButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Selecteer Seizoen");

        LijstSeizoenen.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LijstSeizoenen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LijstSeizoenen.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                LijstSeizoenenValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(LijstSeizoenen);

        SearchText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SearchText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchTextActionPerformed(evt);
            }
        });

        SearchButton.setBackground(java.awt.SystemColor.activeCaption);
        SearchButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SearchButton.setText("Zoek Competitie");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        NieuwSeizoen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        NieuwSeizoenButton.setBackground(java.awt.SystemColor.activeCaption);
        NieuwSeizoenButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NieuwSeizoenButton.setText("Voeg seizoen toe");
        NieuwSeizoenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NieuwSeizoenButtonActionPerformed(evt);
            }
        });

        AddSpeeldagButton.setBackground(java.awt.SystemColor.activeCaption);
        AddSpeeldagButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AddSpeeldagButton.setText("Speeldag / Wedstrijd toevoegen");
        AddSpeeldagButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddSpeeldagButtonActionPerformed(evt);
            }
        });

        TeamToevoegenButton.setBackground(java.awt.SystemColor.activeCaption);
        TeamToevoegenButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TeamToevoegenButton.setText("Team toevoegen");
        TeamToevoegenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TeamToevoegenButtonActionPerformed(evt);
            }
        });

        TeamBewerkenButton.setBackground(java.awt.SystemColor.activeCaption);
        TeamBewerkenButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TeamBewerkenButton.setText("Team bewerken");
        TeamBewerkenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TeamBewerkenButtonActionPerformed(evt);
            }
        });

        addCompetitieButton.setBackground(java.awt.SystemColor.activeCaption);
        addCompetitieButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addCompetitieButton.setText("Voeg competitie toe");
        addCompetitieButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCompetitieButtonActionPerformed(evt);
            }
        });

        Competitienaam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        WedstrijdBewerkenButton.setBackground(java.awt.SystemColor.activeCaption);
        WedstrijdBewerkenButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        WedstrijdBewerkenButton.setText("Wedstrijd bewerken");
        WedstrijdBewerkenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WedstrijdBewerkenButtonActionPerformed(evt);
            }
        });

        DeelnameTeamToevoegen.setBackground(java.awt.SystemColor.activeCaption);
        DeelnameTeamToevoegen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DeelnameTeamToevoegen.setText("Deelname team toevoegen");
        DeelnameTeamToevoegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeelnameTeamToevoegenActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Kies Competitie en Seizoen");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("-----------------------------------");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(VorigeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(379, 379, 379)
                                .addComponent(TeamToevoegenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(SearchText, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SearchButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addCompetitieButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Competitienaam, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(84, 84, 84)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(NieuwSeizoen)
                                                .addComponent(NieuwSeizoenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(95, 95, 95)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(TeamBewerkenButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                            .addComponent(WedstrijdBewerkenButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(AddSpeeldagButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(DeelnameTeamToevoegen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(117, 117, 117)
                                        .addComponent(jLabel2)))))
                        .addGap(45, 45, 45))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Competitienaam, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addCompetitieButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchText, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(NieuwSeizoen, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NieuwSeizoenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DeelnameTeamToevoegen, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AddSpeeldagButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(WedstrijdBewerkenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(14, 14, 14)
                        .addComponent(TeamBewerkenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TeamToevoegenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VorigeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VorigeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VorigeButtonActionPerformed
        // TODO add your handling code here:
        Startscherm updateForm = new Startscherm(dManager);
        updateForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_VorigeButtonActionPerformed

    private void LijstCompetitiesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_LijstCompetitiesValueChanged
        Connection con = null;
        try {
            con = dManager.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "SELECT jaar FROM seizoen WHERE competitienaam = " + "'" + LijstCompetities.getSelectedValue() + "'";

            ResultSet srs = stmt.executeQuery(sql);

            DefaultListModel DLM2 = new DefaultListModel();

            while (srs.next()) {
                DLM2.addElement(srs.getString("jaar"));
            }

            LijstSeizoenen.setModel(DLM2);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
            dManager.closeConnection(con);
        } catch (DBException ex) {
            Logger.getLogger(CompetitieScherm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_LijstCompetitiesValueChanged

    private void LijstSeizoenenValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_LijstSeizoenenValueChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_LijstSeizoenenValueChanged

    private void SearchTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchTextActionPerformed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        // TODO add your handling code here:
        int zoekresultaat = LijstCompetities.getNextMatch(SearchText.getText(), 0, Position.Bias.Forward);
        LijstCompetities.setSelectedIndex(zoekresultaat);
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void NieuwSeizoenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NieuwSeizoenButtonActionPerformed
        // TODO add your handling code here:
        Connection con = null;
        try {
            con = dManager.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "INSERT INTO seizoen (competitienaam, jaar) " + " VALUES ('" + LijstCompetities.getSelectedValue() + "', '" + NieuwSeizoen.getText() + "')";

            stmt.execute(sql);

            DefaultListModel DLM2 = new DefaultListModel();

            String query = "SELECT jaar FROM seizoen WHERE competitienaam = " + "'" + LijstCompetities.getSelectedValue() + "'";

            ResultSet srs = stmt.executeQuery(query);

            while (srs.next()) {
                DLM2.addElement(srs.getString("jaar"));
            }

            LijstSeizoenen.setModel(DLM2);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
            dManager.closeConnection(con);
        } catch (DBException ex) {
            Logger.getLogger(CompetitieScherm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_NieuwSeizoenButtonActionPerformed

    private void AddSpeeldagButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddSpeeldagButtonActionPerformed
        AddWedstrijd updateForm = null;
        Competitie c = DriverManager.getCompetitie((String) LijstCompetities.getSelectedValue());
        Seizoen s = DriverManager.getSeizoen(Integer.parseInt(LijstSeizoenen.getSelectedValue()), c.getCompetitienaam());
        try {
            updateForm = new AddWedstrijd(dManager, c, s);
        } catch (SQLException ex) {
            Logger.getLogger(CompetitieScherm.class.getName()).log(Level.SEVERE, null, ex);
        }
        updateForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_AddSpeeldagButtonActionPerformed

    private void TeamToevoegenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TeamToevoegenButtonActionPerformed
        // TODO add your handling code here:
        AddTeamEnTrainer updateForm = null;
        Competitie c = DriverManager.getCompetitie((String) LijstCompetities.getSelectedValue());
        Seizoen s = DriverManager.getSeizoen(Integer.parseInt(LijstSeizoenen.getSelectedValue()), c.getCompetitienaam());
        try {
            updateForm = new AddTeamEnTrainer(dManager, c, s);
        } catch (SQLException ex) {
            Logger.getLogger(CompetitieScherm.class.getName()).log(Level.SEVERE, null, ex);
        }
        updateForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_TeamToevoegenButtonActionPerformed

    private void TeamBewerkenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TeamBewerkenButtonActionPerformed
        // TODO add your handling code here:
        BewerkTeam updateForm = null;
        Competitie c = DriverManager.getCompetitie((String) LijstCompetities.getSelectedValue());
        Seizoen s = DriverManager.getSeizoen(Integer.parseInt(LijstSeizoenen.getSelectedValue()), c.getCompetitienaam());

        try {
            updateForm = new BewerkTeam(dManager, c, s);
        } catch (SQLException ex) {
            Logger.getLogger(CompetitieScherm.class.getName()).log(Level.SEVERE, null, ex);
        }
        updateForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_TeamBewerkenButtonActionPerformed

    private void addCompetitieButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCompetitieButtonActionPerformed

        Competitie c = new Competitie(this.getCompetitieNaam());
        Competitienaam.setText("");
        try {
            DriverManager.addComp(c);
            FillLijst(ijshockey.DriverManager.FillLijstCompetities(DLM));
            JOptionPane.showMessageDialog(null, "Competitie opgeslagen!");
        } catch (DBException | SQLException ex) {
            Logger.getLogger(CompetitieScherm.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_addCompetitieButtonActionPerformed

    private void WedstrijdBewerkenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WedstrijdBewerkenButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_WedstrijdBewerkenButtonActionPerformed

    private void DeelnameTeamToevoegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeelnameTeamToevoegenActionPerformed
        AddDeelname updateForm = null;
        Competitie c = DriverManager.getCompetitie((String) LijstCompetities.getSelectedValue());
        Seizoen s = DriverManager.getSeizoen(Integer.parseInt(LijstSeizoenen.getSelectedValue()), c.getCompetitienaam());
        try {
            updateForm = new AddDeelname(dManager, c, s);
        } catch (SQLException ex) {
            Logger.getLogger(CompetitieScherm.class.getName()).log(Level.SEVERE, null, ex);
        }
        updateForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_DeelnameTeamToevoegenActionPerformed

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
            java.util.logging.Logger.getLogger(CompetitieScherm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompetitieScherm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompetitieScherm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompetitieScherm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompetitieScherm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddSpeeldagButton;
    private javax.swing.JTextField Competitienaam;
    private javax.swing.JButton DeelnameTeamToevoegen;
    private javax.swing.JList LijstCompetities;
    private javax.swing.JList<String> LijstSeizoenen;
    private javax.swing.JTextField NieuwSeizoen;
    private javax.swing.JButton NieuwSeizoenButton;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTextField SearchText;
    private javax.swing.JButton TeamBewerkenButton;
    private javax.swing.JButton TeamToevoegenButton;
    private javax.swing.JButton VorigeButton;
    private javax.swing.JButton WedstrijdBewerkenButton;
    private javax.swing.JButton addCompetitieButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
 public String getCompetitieNaam() {
        return Competitienaam.getText();
    }

}
