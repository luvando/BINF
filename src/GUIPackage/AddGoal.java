/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import ijshockey.DBException;
import ijshockey.DriverManager;
import ijshockey.Goal;
import ijshockey.Speler;
import ijshockey.Wedstrijd;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Wim
 */
public class AddGoal extends javax.swing.JFrame {

    public static DriverManager dManager;
    private Wedstrijd wedstrijd;
    private int minuut;
    private Speler speler;
    DefaultListModel DLM;

    /**
     * Creates new form AddGoal
     */
    public AddGoal() {
        initComponents();
    }

    public AddGoal(DriverManager dManager, Wedstrijd wedstrijd, Speler speler, int minuut) throws SQLException {
        this.dManager = dManager;
        this.wedstrijd = wedstrijd;
        this.speler = speler;
        this.minuut = minuut;
        initComponents();
        setLocationRelativeTo(null);
        this.setjLabelTop("Highlight toevoegen voor : " + speler.getVoornaam() + " " + speler.getAchternaam() + ", minuut : " + minuut);
        FillLijstSpelertjes(DriverManager.FillLijstSpelers(DLM, speler.getTeam().getStamNr()));
    }

    private void FillLijstSpelertjes(DefaultListModel DLM) {
        try {

            jListSpeler.setModel(DLM);

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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListSpeler = new javax.swing.JList();
        StoreButton = new javax.swing.JButton();
        VoegNieuweHighlightToeButton = new javax.swing.JButton();
        VorigeButton = new javax.swing.JButton();
        jLabelTop = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Voeg goal toe");

        jLabel1.setText("indien van toepassing, kies assistgever");

        jListSpeler.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListSpeler);

        StoreButton.setText("Store");
        StoreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StoreButtonActionPerformed(evt);
            }
        });

        VoegNieuweHighlightToeButton.setText("Voeg nieuwe highlight toe");
        VoegNieuweHighlightToeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoegNieuweHighlightToeButtonActionPerformed(evt);
            }
        });

        VorigeButton.setText("Vorige");
        VorigeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VorigeButtonActionPerformed(evt);
            }
        });

        jLabelTop.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(StoreButton)
                            .addComponent(VoegNieuweHighlightToeButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTop)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(VorigeButton)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTop)
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StoreButton)
                .addGap(18, 18, 18)
                .addComponent(VoegNieuweHighlightToeButton)
                .addGap(28, 28, 28)
                .addComponent(VorigeButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        String listValue = (String) jListSpeler.getSelectedValue();
        String[] array = listValue.split("-");
        String lidnrStr = array[array.length - 1].trim();
        int lidnr = Integer.parseInt(lidnrStr);
        Speler spelerAss = null;
        Goal g = null;
        try {
            spelerAss = DriverManager.getSpeler(lidnr);
            g = new Goal(minuut, speler, wedstrijd, spelerAss);
            DriverManager.addGoal(g);
            JOptionPane.showMessageDialog(null, "Goal opgeslaan");
        } catch (DBException ex) {
            Logger.getLogger(AddHighlight.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(AddGoal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddGoal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddGoal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddGoal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddGoal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton StoreButton;
    private javax.swing.JButton VoegNieuweHighlightToeButton;
    private javax.swing.JButton VorigeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelTop;
    private javax.swing.JList jListSpeler;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void setjLabelTop(String string) {
        this.jLabelTop.setText(string);
    }
}
