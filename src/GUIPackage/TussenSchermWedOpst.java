/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import static GUIPackage.AddWedstrijd.dManager;
import ijshockey.DriverManager;
import ijshockey.Team;
import ijshockey.Wedstrijd;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Viktor
 */
public class TussenSchermWedOpst extends javax.swing.JFrame {

    private Team thuisTeam;
    private Team uitTeam;

    static DriverManager dManager;
    private Wedstrijd wedstrijd;
    private AddWedstrijd oldForm;
    private BewerkWedstrijd oldForm2;

    /**
     * Creates new form TussenSchermWedOpst
     */
    public TussenSchermWedOpst() {
        initComponents();
    }

    public TussenSchermWedOpst(DriverManager dManager, Wedstrijd wedstrijd, AddWedstrijd oldForm) {
        super("Message");
        this.wedstrijd = wedstrijd;
        this.thuisTeam = thuisTeam;
        this.uitTeam = uitTeam;
        TussenSchermWedOpst.dManager = dManager;
        this.oldForm = oldForm;
        setLocationRelativeTo(null);
        initComponents();
        this.setjLabetTop("Wedstrijd opgeslaan voor : " + wedstrijd.getThuisTeam().getNaam() + " - " + wedstrijd.getUitTeam().getNaam() + "!");
    }

    public TussenSchermWedOpst(DriverManager dManager, Wedstrijd wedstrijd, BewerkWedstrijd oldForm2) {
        super("Message");
        this.wedstrijd = wedstrijd;
        this.thuisTeam = thuisTeam;
        this.uitTeam = uitTeam;
        TussenSchermWedOpst.dManager = dManager;
        this.oldForm2 = oldForm2;
        setLocationRelativeTo(null);
        initComponents();
        this.setjLabetTop("Wedstrijd bewerkt voor : " + wedstrijd.getThuisTeam().getNaam() + " - " + wedstrijd.getUitTeam().getNaam() + "!");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAddOpstelling = new javax.swing.JButton();
        jLabelTop = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonAddOpstelling.setBackground(java.awt.SystemColor.activeCaption);
        jButtonAddOpstelling.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonAddOpstelling.setText("Opstelling en wissels toevoegen");
        jButtonAddOpstelling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddOpstellingActionPerformed(evt);
            }
        });

        jLabelTop.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTop.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTop, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jButtonAddOpstelling)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTop)
                .addGap(87, 87, 87)
                .addComponent(jButtonAddOpstelling, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddOpstellingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddOpstellingActionPerformed
        // TODO add your handling code here:
        AddOpstelling updateForm = null;

        try {
            updateForm = new AddOpstelling(dManager, wedstrijd);
        } catch (SQLException ex) {
            Logger.getLogger(AddWedstrijd.class.getName()).log(Level.SEVERE, null, ex);
        }

        updateForm.setVisible(true);
        if (oldForm == null) {
            oldForm2.setVisible(false);
        }
        if (oldForm == null) {
            oldForm2.setVisible(false);
        }
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAddOpstellingActionPerformed

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
            java.util.logging.Logger.getLogger(TussenSchermWedOpst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TussenSchermWedOpst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TussenSchermWedOpst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TussenSchermWedOpst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TussenSchermWedOpst().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddOpstelling;
    private javax.swing.JLabel jLabelTop;
    // End of variables declaration//GEN-END:variables
    public void setjLabetTop(String str) {
        this.jLabelTop.setText(str);

    }
}
