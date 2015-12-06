/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import ijshockey.DBException;
import ijshockey.DriverManager;
import ijshockey.Speler;
import ijshockey.Straf;
import ijshockey.Wedstrijd;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Wim
 */
public class AddStraf extends javax.swing.JFrame {

    public static DriverManager dManager;
    private Wedstrijd wedstrijd;
    private Speler speler;
    private int minuut;

    /**
     * Creates new form AddStraf
     */
    public AddStraf() {
        initComponents();
    }

    public AddStraf(DriverManager dManager, Wedstrijd wedstrijd, Speler speler, int minuut) {
        AddStraf.dManager = dManager;
        this.wedstrijd = wedstrijd;
        this.speler = speler;
        this.minuut = minuut;
        initComponents();
        setLocationRelativeTo(null);
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

        jLabel1 = new javax.swing.JLabel();
        jTextReden = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextMinuut = new javax.swing.JTextField();
        StoreButton = new javax.swing.JButton();
        VoegNieuweHighlightToeButton = new javax.swing.JButton();
        VorigeButton = new javax.swing.JButton();
        jLabelTop = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Voeg straf toe");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Reden van straf");

        jTextReden.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextReden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextRedenActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Aantal minuten geschorst");

        jTextMinuut.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextMinuut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextMinuutActionPerformed(evt);
            }
        });

        StoreButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        StoreButton.setText("Store");
        StoreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StoreButtonActionPerformed(evt);
            }
        });

        VoegNieuweHighlightToeButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        VoegNieuweHighlightToeButton.setText("Voeg nieuwe highlight toe");
        VoegNieuweHighlightToeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoegNieuweHighlightToeButtonActionPerformed(evt);
            }
        });

        VorigeButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        VorigeButton.setText("Vorige");
        VorigeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VorigeButtonActionPerformed(evt);
            }
        });

        jLabelTop.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabelTop.setText("jLabel3");

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
                        .addGap(190, 190, 190)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(StoreButton, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VoegNieuweHighlightToeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VorigeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextReden, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextMinuut, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(jLabel1)))
                .addContainerGap(161, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTop)
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextReden, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextMinuut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(StoreButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(VoegNieuweHighlightToeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(VorigeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextRedenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextRedenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextRedenActionPerformed

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
        String reden = jTextReden.getText();
        int aantalMinuut = Integer.parseInt(jTextMinuut.getText());
        Straf s = null;
        s = new Straf(minuut, reden, aantalMinuut, speler, wedstrijd);
        try {
            DriverManager.addStraf(s);
            jTextMinuut.setText("");
            jTextReden.setText("");
            JOptionPane.showMessageDialog(null, "Straf opgeslaan!");
        } catch (DBException ex) {
            Logger.getLogger(AddStraf.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_StoreButtonActionPerformed

    private void jTextMinuutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextMinuutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextMinuutActionPerformed

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
            java.util.logging.Logger.getLogger(AddStraf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddStraf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddStraf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddStraf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddStraf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton StoreButton;
    private javax.swing.JButton VoegNieuweHighlightToeButton;
    private javax.swing.JButton VorigeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelTop;
    private javax.swing.JTextField jTextMinuut;
    private javax.swing.JTextField jTextReden;
    // End of variables declaration//GEN-END:variables

    private void setjLabelTop(String string) {
        this.jLabelTop.setText(string);
    }
}
