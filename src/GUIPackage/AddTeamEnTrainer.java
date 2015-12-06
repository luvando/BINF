/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import static GUIPackage.CompetitieScherm.dManager;
import ijshockey.Competitie;
import ijshockey.DBException;
import ijshockey.DriverManager;
import ijshockey.Scheidsrechter;
import ijshockey.Seizoen;
import ijshockey.Team;
import ijshockey.Trainer;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ekmaes
 */
public class AddTeamEnTrainer extends javax.swing.JFrame {

    public static DriverManager dManager;

    /**
     * Creates new form AddTeam
     */
    public AddTeamEnTrainer() {
        initComponents();
    }
    private Competitie competitie;
    private Seizoen seizoen;
    DefaultListModel DLM;

    public AddTeamEnTrainer(DriverManager dManager) {
        AddTeamEnTrainer.dManager = dManager;
        initComponents();
        setLocationRelativeTo(null);
        Store.addActionListener(new AddTeamEnTrainer.EventHandler(this));

    }

    public AddTeamEnTrainer(DriverManager dManager, Competitie competitie, Seizoen seizoen) throws SQLException {
        AddTeamEnTrainer.dManager = dManager;
        initComponents();
        setLocationRelativeTo(null);
        Store.addActionListener(new AddTeamEnTrainer.EventHandler(this));
        this.competitie = competitie;
        this.seizoen = seizoen;
        this.FillLijstTeams(ijshockey.DriverManager.FillLijstTeamAll(DLM));
        this.setjLabelTop("Team toevoegen aan " + competitie.getCompetitienaam() + " seizoen : " + seizoen.getJaar());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Stamnummer = new javax.swing.JTextField();
        TeamNaam = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Thuisarena = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        VoornaamTrainer = new javax.swing.JTextField();
        GeboortedatumTrainer = new javax.swing.JTextField();
        AchternaamTrainer = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Store = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabelBestaandTeam = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListTeam = new javax.swing.JList();
        jLabelTop = new javax.swing.JLabel();
        jButtonTerug = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Team toevoegen");

        jLabel1.setText("Stamnummer");

        jLabel2.setText("Naam");

        Stamnummer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StamnummerActionPerformed(evt);
            }
        });
        Stamnummer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                StamnummerKeyReleased(evt);
            }
        });

        jLabel3.setText("Thuisarena");

        jLabel4.setText("Trainer");

        jLabel5.setText("Voornaam");

        jLabel6.setText("Geboortedatum");

        VoornaamTrainer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoornaamTrainerActionPerformed(evt);
            }
        });

        GeboortedatumTrainer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GeboortedatumTrainerActionPerformed(evt);
            }
        });

        AchternaamTrainer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AchternaamTrainerActionPerformed(evt);
            }
        });

        jLabel7.setText("Achternaam");

        Store.setText("Store");

        jLabel8.setText("Nieuw team toevoegen ");

        jLabelBestaandTeam.setText("Bestaan team toevoegen ");

        jListTeam.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListTeam);

        jLabelTop.setText("jLabel9");

        jButtonTerug.setText("Terug");
        jButtonTerug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTerugActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Thuisarena, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TeamNaam, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Stamnummer, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelTop)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButtonTerug)
                                .addGap(77, 77, 77)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(VoornaamTrainer, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AchternaamTrainer, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GeboortedatumTrainer, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Store))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(251, 251, 251))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelBestaandTeam)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(AchternaamTrainer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(GeboortedatumTrainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Store)
                            .addComponent(jButtonTerug))
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabelBestaandTeam))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Stamnummer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(TeamNaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Thuisarena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(12, 12, 12)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(VoornaamTrainer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(111, 111, 111))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StamnummerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StamnummerActionPerformed

    }//GEN-LAST:event_StamnummerActionPerformed

    private void VoornaamTrainerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoornaamTrainerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VoornaamTrainerActionPerformed

    private void GeboortedatumTrainerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GeboortedatumTrainerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GeboortedatumTrainerActionPerformed

    private void AchternaamTrainerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AchternaamTrainerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AchternaamTrainerActionPerformed

    private void StamnummerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_StamnummerKeyReleased
        if (Stamnummer.getText().equalsIgnoreCase("")) {
            Stamnummer.setBackground(Color.white);
        } else {
            int stamNr = Integer.parseInt(Stamnummer.getText());
            try {
                if (DriverManager.getTeam(stamNr) != null) {
                    Stamnummer.setBackground(Color.red);
                } else {
                    Stamnummer.setBackground(Color.green);
                }
            } catch (DBException ex) {
                Logger.getLogger(AddTeamEnTrainer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_StamnummerKeyReleased

    private void jButtonTerugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTerugActionPerformed
        CompetitieScherm updateForm = null;
        try {
            updateForm = new CompetitieScherm(dManager);
        } catch (DBException ex) {
            Logger.getLogger(AddTeamEnTrainer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddTeamEnTrainer.class.getName()).log(Level.SEVERE, null, ex);
        }
        updateForm.setVisible(true);
        this.setVisible(false);    }//GEN-LAST:event_jButtonTerugActionPerformed

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
            java.util.logging.Logger.getLogger(AddTeamEnTrainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddTeamEnTrainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddTeamEnTrainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddTeamEnTrainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddTeamEnTrainer().setVisible(true);
            }
        });
    }

    private void FillLijstTeams(DefaultListModel DLM) {

        try {

            jListTeam.setModel(DLM);

        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    private class EventHandler implements ActionListener {

        private AddTeamEnTrainer form;

        public EventHandler(AddTeamEnTrainer antr) {
            form = antr;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == Store) {
                Team te = new Team(form.getStamnummer(), form.getThuisArena(), form.getTeamNaam());
                Trainer tr = new Trainer(form.getVoornaamTrainer(), form.getAchternaamTrainer(), form.getGeboortedatumTrainer());
                AchternaamTrainer.setText("");
                VoornaamTrainer.setText("");
                GeboortedatumTrainer.setText("");
                TeamNaam.setText("");
                Thuisarena.setText("");
                Stamnummer.setText("");

                try {

                    DriverManager.addTrainer(tr);
                    DriverManager.addTeam(te, competitie.getCompetitienaam(), seizoen.getJaar());
                    JOptionPane.showMessageDialog(null, "Team en Trainer opgeslagen!");
                } catch (DBException ex) {
                    Logger.getLogger(AddNieuweCompetitie.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AchternaamTrainer;
    private javax.swing.JTextField GeboortedatumTrainer;
    private javax.swing.JTextField Stamnummer;
    private javax.swing.JButton Store;
    private javax.swing.JTextField TeamNaam;
    private javax.swing.JTextField Thuisarena;
    private javax.swing.JTextField VoornaamTrainer;
    private javax.swing.JButton jButtonTerug;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelBestaandTeam;
    private javax.swing.JLabel jLabelTop;
    private javax.swing.JList jListTeam;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public String getAchternaamTrainer() {
        return AchternaamTrainer.getText();
    }

    public String getGeboortedatumTrainer() {
        return GeboortedatumTrainer.getText();
    }

    public String getVoornaamTrainer() {
        return VoornaamTrainer.getText();
    }

    public String getTeamNaam() {
        return TeamNaam.getText();
    }

    public int getStamnummer() {
        return Integer.parseInt(Stamnummer.getText());
    }

    public String getThuisArena() {

        return Thuisarena.getText();
    }

    

    public void setjLabelTop(String jLabelTop) {
        this.jLabelTop.setText(jLabelTop);
    }

}
