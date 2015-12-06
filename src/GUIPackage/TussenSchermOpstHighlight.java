/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import static GUIPackage.TussenSchermWedOpst.dManager;
import ijshockey.DriverManager;
import ijshockey.Wedstrijd;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Viktor
 */
public class TussenSchermOpstHighlight extends javax.swing.JFrame {

    /**
     * Creates new form TussenSchermOpstHighlight
     */
    public static DriverManager dManager;
    private Wedstrijd wedstrijd;
    private AddOpstelling oldForm;

    public TussenSchermOpstHighlight() {
        initComponents();
    }

    public TussenSchermOpstHighlight(DriverManager dManager, Wedstrijd wedstrijd, AddOpstelling oldForm) {
        super("Message");
        this.wedstrijd = wedstrijd;
        TussenSchermWedOpst.dManager = dManager;
        this.oldForm = oldForm;

        initComponents();
        this.setjLabetTop("Opstelling en wissels opgeslaan voor  " + wedstrijd.getThuisTeam().getNaam() + " tegen : " + wedstrijd.getUitTeam().getNaam() + "!");
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
        jButtonAddHighlight = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("jLabel1");

        jButtonAddHighlight.setText("Highlights toevoegen");
        jButtonAddHighlight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddHighlightActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jButtonAddHighlight))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addContainerGap(240, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addComponent(jButtonAddHighlight)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddHighlightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddHighlightActionPerformed
        AddHighlight updateForm = null;

        updateForm = new AddHighlight(dManager, wedstrijd);

        updateForm.setVisible(true);
        oldForm.setVisible(false);
        this.setVisible(false);


    }//GEN-LAST:event_jButtonAddHighlightActionPerformed

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
            java.util.logging.Logger.getLogger(TussenSchermOpstHighlight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TussenSchermOpstHighlight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TussenSchermOpstHighlight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TussenSchermOpstHighlight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TussenSchermOpstHighlight().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddHighlight;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    private void setjLabetTop(String string) {
        this.jLabel1.setText(string);
    }
}
