/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import static GUIPackage.CompetitieScherm.dManager;
import ijshockey.DBException;
import ijshockey.DriverManager;
//import static ijshockey.DriverManager.closeConnection;
//import static ijshockey.DriverManager.getConnection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.text.Position;

public class CompetitieOpvragen extends javax.swing.JFrame {

    public static DriverManager dManager;

    public CompetitieOpvragen() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public CompetitieOpvragen(DriverManager dManager) throws DBException {
        this.dManager = dManager;
        initComponents();
        FillList();
        setLocationRelativeTo(null);

    }

    final void FillList() throws DBException {
        Connection con = null;
        try {
            con = DriverManager.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM competitie ";

            ResultSet srs = stmt.executeQuery(sql);

            DefaultListModel DLM = new DefaultListModel();

            while (srs.next()) {
                DLM.addElement(srs.getString(1));
            }

            LijstCompetities.setModel(DLM);

        } catch (Exception ex) {
            ex.printStackTrace();
            DriverManager.closeConnection(con);
            throw new DBException(ex);
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
        LijstCompetities = new javax.swing.JList();
        VolgendeButton = new javax.swing.JButton();
        VorigeButton = new javax.swing.JButton();
        SearchButton = new javax.swing.JButton();
        SearchText = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        LijstSeizoenen = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Competitie kiezen");

        LijstCompetities.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LijstCompetities.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                LijstCompetitiesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(LijstCompetities);

        VolgendeButton.setBackground(java.awt.SystemColor.activeCaption);
        VolgendeButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        VolgendeButton.setText("Volgende");
        VolgendeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolgendeButtonActionPerformed(evt);
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

        SearchButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SearchButton.setText("Zoek competitie");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        SearchText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        LijstSeizoenen.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane2.setViewportView(LijstSeizoenen);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Selecteer seizoen");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(VorigeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(VolgendeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SearchText, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(SearchButton, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(SearchText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VolgendeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VorigeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VolgendeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolgendeButtonActionPerformed
        // TODO add your handling code here:
        GegevensOpvragen updateForm = null;
        updateForm = new GegevensOpvragen(dManager, (String) LijstCompetities.getSelectedValue(), 
                Integer.parseInt((String) LijstSeizoenen.getSelectedValue()));
        updateForm.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_VolgendeButtonActionPerformed

    private void VorigeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VorigeButtonActionPerformed
        // TODO add your handling code here:
        Startscherm updateForm = new Startscherm(dManager);
        updateForm.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_VorigeButtonActionPerformed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        int zoekresultaat = LijstCompetities.getNextMatch(SearchText.getText(), 0, Position.Bias.Forward);
        LijstCompetities.setSelectedIndex(zoekresultaat);
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void LijstCompetitiesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_LijstCompetitiesValueChanged
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(CompetitieOpvragen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompetitieOpvragen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompetitieOpvragen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompetitieOpvragen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompetitieOpvragen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList LijstCompetities;
    private javax.swing.JList<String> LijstSeizoenen;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTextField SearchText;
    private javax.swing.JButton VolgendeButton;
    private javax.swing.JButton VorigeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
