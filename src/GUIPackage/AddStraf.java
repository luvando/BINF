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
        this.setjLabelTop("Highlight toevoegen voor : " + speler.getVoornaam() + " " + speler.getAchternaam() + ", minuut : " + minuut);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextMinuut = new javax.swing.JTextField();
        StoreButton = new javax.swing.JButton();
        VoegNieuweHighlightToeButton = new javax.swing.JButton();
        VorigeButton = new javax.swing.JButton();
        jLabelTop = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextReden = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Voeg straf toe");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Reden van straf");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Aantal minuten geschorst");

        jTextMinuut.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextMinuut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextMinuutActionPerformed(evt);
            }
        });

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
        jLabelTop.setText("jLabel3");

        jTextReden.setColumns(20);
        jTextReden.setRows(5);
        jScrollPane1.setViewportView(jTextReden);

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
                        .addGap(126, 126, 126)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(VoegNieuweHighlightToeButton, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(VorigeButton, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jTextMinuut)
                            .addComponent(StoreButton, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addContainerGap(119, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(137, 137, 137))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(171, 171, 171))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTop)
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextMinuut;
    private javax.swing.JTextArea jTextReden;
    // End of variables declaration//GEN-END:variables

    private void setjLabelTop(String string) {
        this.jLabelTop.setText(string);
    }
}
