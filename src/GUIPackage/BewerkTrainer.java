/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

/**
 *
 * @author Viktor
 */
public class BewerkTrainer extends javax.swing.JFrame {

    /**
     * Creates new form BewerkTrainer
     */
//    public BewerkTrainer() {
//        initComponents();
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    /*
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AchternaamTrainer = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Store = new javax.swing.JButton();
        jButtonTerug = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        VoornaamTrainer = new javax.swing.JTextField();
        GeboortedatumTrainer = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AchternaamTrainer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AchternaamTrainer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AchternaamTrainerActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Achternaam");

        Store.setBackground(java.awt.SystemColor.activeCaption);
        Store.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Store.setText("Store");
        Store.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StoreActionPerformed(evt);
            }
        });

        jButtonTerug.setBackground(new java.awt.Color(255, 204, 204));
        jButtonTerug.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonTerug.setText("Vorige");
        jButtonTerug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTerugActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Voornaam");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Geboortedatum");

        VoornaamTrainer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        VoornaamTrainer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoornaamTrainerActionPerformed(evt);
            }
        });

        GeboortedatumTrainer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        GeboortedatumTrainer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GeboortedatumTrainerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonTerug, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Store, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AchternaamTrainer, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(58, 58, 58)
                        .addComponent(GeboortedatumTrainer, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(VoornaamTrainer, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(70, 70, 70))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(299, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VoornaamTrainer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AchternaamTrainer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GeboortedatumTrainer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonTerug, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Store, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AchternaamTrainerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AchternaamTrainerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AchternaamTrainerActionPerformed

    private void StoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StoreActionPerformed

        Trainer tr = new Trainer(VoornaamTrainer.getText(), AchternaamTrainer.getText(), GeboortedatumTrainer.getText());
        Team te = new Team(Integer.parseInt(Stamnummer.getText()), TeamNaam.getText(), Thuisarena.getText(), tr);
        AchternaamTrainer.setText("");
        VoornaamTrainer.setText("");
        GeboortedatumTrainer.setText("");
        TeamNaam.setText("");
        Thuisarena.setText("");
        Stamnummer.setText("");

        try {

            DriverManager.addTrainer(tr);
            int lidnrtrainer = DriverManager.getRecentLidnrTrainer();
            Trainer trFinal = DriverManager.getTrainer(lidnrtrainer);
            DriverManager.addTeam(te, trFinal);
            JOptionPane.showMessageDialog(null, "Team en Trainer opgeslagen!");
        } catch (DBException ex) {
            Logger.getLogger(AddTeamEnTrainer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_StoreActionPerformed

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
    }//GEN-LAST:event_jButtonTerugActionPerformed

    private void VoornaamTrainerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoornaamTrainerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VoornaamTrainerActionPerformed

    private void GeboortedatumTrainerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GeboortedatumTrainerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GeboortedatumTrainerActionPerformed

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
            java.util.logging.Logger.getLogger(BewerkTrainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BewerkTrainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BewerkTrainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BewerkTrainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BewerkTrainer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AchternaamTrainer;
    private javax.swing.JTextField GeboortedatumTrainer;
    private javax.swing.JButton Store;
    private javax.swing.JTextField VoornaamTrainer;
    private javax.swing.JButton jButtonTerug;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
