/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import ijshockey.DBException;
import ijshockey.DriverManager;
import ijshockey.Goal;
import ijshockey.Penalty;
import ijshockey.Speler;
import ijshockey.Wedstrijd;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Wim
 */
public class AddPenalty extends javax.swing.JFrame {

    public static DriverManager dManager;
    private int minuut;
    private Speler speler;
    private Wedstrijd wedstrijd;

    /**
     * Creates new form AddPenalty
     */
    public AddPenalty() {
        initComponents();
    }

    public AddPenalty(DriverManager dManager, Wedstrijd wedstrijd, Speler speler, int minuut) {
        this.dManager = dManager;
        this.wedstrijd = wedstrijd;
        this.speler = speler;
        this.minuut = minuut;
        initComponents();
        this.setjLabelTop("Highlight toevoegen voor : " + speler.getVoornaam() + " " + speler.getAchternaam() + ", minuut : " + minuut);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jRadioButtonJa = new javax.swing.JRadioButton();
        jRadioButtonNee = new javax.swing.JRadioButton();
        StoreButton = new javax.swing.JButton();
        VoegNieuweHighlightToeButton = new javax.swing.JButton();
        VorigeButton = new javax.swing.JButton();
        jLabelTop = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Voeg penalty toe");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Penalty gescoord ?");

        buttonGroup1.add(jRadioButtonJa);
        jRadioButtonJa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonJa.setText("ja");
        jRadioButtonJa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonJaActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonNee);
        jRadioButtonNee.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonNee.setText("nee");

        StoreButton.setBackground(java.awt.SystemColor.activeCaption);
        StoreButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        StoreButton.setText("Store");
        StoreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StoreButtonActionPerformed(evt);
            }
        });

        VoegNieuweHighlightToeButton.setBackground(java.awt.SystemColor.activeCaption);
        VoegNieuweHighlightToeButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        VoegNieuweHighlightToeButton.setText("Voeg nieuwe highlight toe");
        VoegNieuweHighlightToeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoegNieuweHighlightToeButtonActionPerformed(evt);
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

        jLabelTop.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTop.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelTop))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(StoreButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VoegNieuweHighlightToeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VorigeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(76, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonNee)
                            .addComponent(jRadioButtonJa))))
                .addGap(125, 125, 125))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTop)
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jRadioButtonJa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonNee)
                .addGap(31, 31, 31)
                .addComponent(StoreButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(VoegNieuweHighlightToeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(VorigeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonJaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonJaActionPerformed


    }//GEN-LAST:event_jRadioButtonJaActionPerformed

    private void VoegNieuweHighlightToeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoegNieuweHighlightToeButtonActionPerformed
        // TODO add your handling code here:
        AddHighlight updateForm = new AddHighlight(dManager, wedstrijd);
        updateForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_VoegNieuweHighlightToeButtonActionPerformed

    private void VorigeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VorigeButtonActionPerformed
        // TODO add your handling code here:
        AddHighlight updateForm = new AddHighlight(dManager, wedstrijd);
        updateForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_VorigeButtonActionPerformed

    private void StoreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StoreButtonActionPerformed
        Penalty p = null;
       
        if (this.jRadioButtonJa.isSelected()) {
            int gescoord = 1;
            p = new Penalty(minuut, speler, wedstrijd, gescoord);

           
            try {
                DriverManager.addPenalty(p);

                this.jRadioButtonJa.setSelected(false);
                JOptionPane.showMessageDialog(null, "Penalty opgeslaan");
            } catch (DBException ex) {
                Logger.getLogger(AddPenalty.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (this.jRadioButtonNee.isSelected()) {
            int gescoord = 0;
            p = new Penalty(minuut, speler, wedstrijd, gescoord);
            try {
                DriverManager.addPenalty(p);
                this.jRadioButtonNee.setSelected(false);
                JOptionPane.showMessageDialog(null, "Penalty opgeslaan");
            } catch (DBException ex) {
                Logger.getLogger(AddPenalty.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_StoreButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AddPenalty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddPenalty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddPenalty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddPenalty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddPenalty().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton StoreButton;
    private javax.swing.JButton VoegNieuweHighlightToeButton;
    private javax.swing.JButton VorigeButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelTop;
    private javax.swing.JRadioButton jRadioButtonJa;
    private javax.swing.JRadioButton jRadioButtonNee;
    // End of variables declaration//GEN-END:variables

    private void setjLabelTop(String string) {
        this.jLabelTop.setText(string);
    }
}
