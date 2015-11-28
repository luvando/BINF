/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import ijshockey.DriverManager;

/**
 *
 * @author favdndor
 */
public class BewerkCompetitieScherm extends javax.swing.JFrame {

    public static DriverManager dManager;

    /**
     * Creates new form BewerkScherm
     */
    public BewerkCompetitieScherm() {
        initComponents();
    }

    BewerkCompetitieScherm(DriverManager dManager) {
        this.dManager = dManager;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SeizoenToevoegenButton = new javax.swing.JButton();
        TeamToevoegenButton = new javax.swing.JButton();
        TeamBewerkenButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        SeizoenBewerkenButton = new javax.swing.JButton();
        VorigeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bewerken");

        SeizoenToevoegenButton.setText("Seizoen toevoegen");
        SeizoenToevoegenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeizoenToevoegenButtonActionPerformed(evt);
            }
        });

        TeamToevoegenButton.setText("Team toevoegen");
        TeamToevoegenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TeamToevoegenButtonActionPerformed(evt);
            }
        });

        TeamBewerkenButton.setText("Team bewerken");
        TeamBewerkenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TeamBewerkenButtonActionPerformed(evt);
            }
        });

        CancelButton.setText("Beëindig");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        SeizoenBewerkenButton.setText("Seizoen bewerken");
        SeizoenBewerkenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeizoenBewerkenButtonActionPerformed(evt);
            }
        });

        VorigeButton.setText("Vorige");
        VorigeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VorigeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(SeizoenToevoegenButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TeamToevoegenButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TeamBewerkenButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SeizoenBewerkenButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(194, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(VorigeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CancelButton)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(SeizoenToevoegenButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SeizoenBewerkenButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TeamToevoegenButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TeamBewerkenButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelButton)
                    .addComponent(VorigeButton))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SeizoenToevoegenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeizoenToevoegenButtonActionPerformed
        // TODO add your handling code here:
         AddSeizoen updateForm = new AddSeizoen(dManager);
        updateForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_SeizoenToevoegenButtonActionPerformed

    private void TeamToevoegenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TeamToevoegenButtonActionPerformed
        // TODO add your handling code here:
        AddTeamEnTrainer updateForm = new AddTeamEnTrainer(dManager);
        updateForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_TeamToevoegenButtonActionPerformed

    private void TeamBewerkenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TeamBewerkenButtonActionPerformed
        // TODO add your handling code here:
        BewerkTeam updateForm = new BewerkTeam(dManager);
        updateForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_TeamBewerkenButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void SeizoenBewerkenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeizoenBewerkenButtonActionPerformed
        // TODO add your handling code here:
        BewerkSeizoen updateForm = new BewerkSeizoen(dManager);
        updateForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_SeizoenBewerkenButtonActionPerformed

    private void VorigeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VorigeButtonActionPerformed
        // TODO add your handling code here:
        KeuzeSchermBestaandeCompetitie updateForm = new KeuzeSchermBestaandeCompetitie(dManager);
        updateForm.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_VorigeButtonActionPerformed

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
            java.util.logging.Logger.getLogger(BewerkCompetitieScherm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BewerkCompetitieScherm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BewerkCompetitieScherm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BewerkCompetitieScherm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BewerkCompetitieScherm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton SeizoenBewerkenButton;
    private javax.swing.JButton SeizoenToevoegenButton;
    private javax.swing.JButton TeamBewerkenButton;
    private javax.swing.JButton TeamToevoegenButton;
    private javax.swing.JButton VorigeButton;
    // End of variables declaration//GEN-END:variables
}
