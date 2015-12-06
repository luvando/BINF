/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import ijshockey.DBException;
import ijshockey.DriverManager;
import ijshockey.Speler;
import ijshockey.Team;
import ijshockey.Trainer;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author ekmaes
 */
public class AddSpeler extends javax.swing.JFrame {

    public static DriverManager dManager;
    public Team team;

    /**
     * Creates new form AddSpeler
     */
    public AddSpeler() {
        initComponents();
    }

    public AddSpeler(DriverManager dManager, Team team) {
        this.dManager = dManager;
        this.team = team;

        initComponents();
        this.setjLabelTop("Speler toevoegen aan : " + team.getNaam());
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextAchternaam = new javax.swing.JTextField();
        jTextVoornaam = new javax.swing.JTextField();
        jTextGeboortedatum = new javax.swing.JTextField();
        NaarStartschermButton = new javax.swing.JButton();
        AddSpelerButton = new javax.swing.JButton();
        VorigeButton = new javax.swing.JButton();
        jLabelTop = new javax.swing.JLabel();
        jButtonStore = new javax.swing.JButton();
        jTextVoorkeurspositie = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Speler Toevoegen");

        jLabel1.setText("Naam");

        jLabel2.setText("Voornaam");

        jLabel3.setText("Geboortedatum");

        jLabel4.setText("Voorkeurspositie");

        NaarStartschermButton.setText("Naar Startscherm");
        NaarStartschermButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NaarStartschermButtonActionPerformed(evt);
            }
        });

        AddSpelerButton.setText("Nog een speler toevoegen");
        AddSpelerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddSpelerButtonActionPerformed(evt);
            }
        });

        VorigeButton.setText("Vorige");
        VorigeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VorigeButtonActionPerformed(evt);
            }
        });

        jButtonStore.setText("Store");
        jButtonStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStoreActionPerformed(evt);
            }
        });

        jTextVoorkeurspositie.setText("jTextField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(VorigeButton)
                        .addGap(0, 286, Short.MAX_VALUE))
                    .addComponent(NaarStartschermButton, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddSpelerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(139, 139, 139))
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTop)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButtonStore)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addGap(26, 26, 26)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextAchternaam, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(jTextVoornaam)
                                .addComponent(jTextGeboortedatum)
                                .addComponent(jTextVoorkeurspositie)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTop)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextAchternaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextVoornaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextGeboortedatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextVoorkeurspositie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jButtonStore)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(AddSpelerButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NaarStartschermButton)
                .addGap(36, 36, 36)
                .addComponent(VorigeButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddSpelerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddSpelerButtonActionPerformed


    }//GEN-LAST:event_AddSpelerButtonActionPerformed

    private void NaarStartschermButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NaarStartschermButtonActionPerformed
        // TODO add your handling code here:
        Startscherm updateForm = new Startscherm(dManager);
        updateForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_NaarStartschermButtonActionPerformed

    private void VorigeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VorigeButtonActionPerformed
      
    }//GEN-LAST:event_VorigeButtonActionPerformed

    private void jButtonStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStoreActionPerformed
        Speler speler = new Speler(jTextVoornaam.getText(), jTextAchternaam.getText(), jTextGeboortedatum.getText(), jTextVoorkeurspositie.getText(), team);

        try {

            DriverManager.addSpeler(speler);

            JOptionPane.showMessageDialog(null, "Speler opgeslagen!");
            jTextAchternaam.setText("");
            jTextVoornaam.setText("");
            jTextGeboortedatum.setText("");
            jTextVoorkeurspositie.setText("");
        } catch (DBException ex) {
            Logger.getLogger(AddNieuweCompetitie.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonStoreActionPerformed

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
            java.util.logging.Logger.getLogger(AddSpeler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddSpeler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddSpeler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddSpeler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddSpeler().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddSpelerButton;
    private javax.swing.JButton NaarStartschermButton;
    private javax.swing.JButton VorigeButton;
    private javax.swing.JButton jButtonStore;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelTop;
    private javax.swing.JTextField jTextAchternaam;
    private javax.swing.JTextField jTextGeboortedatum;
    private javax.swing.JTextField jTextVoorkeurspositie;
    private javax.swing.JTextField jTextVoornaam;
    // End of variables declaration//GEN-END:variables

    public JLabel getjLabelTop() {
        return jLabelTop;
    }

    public void setjLabelTop(String string) {
        this.jLabelTop.setText(string);
    }

}
