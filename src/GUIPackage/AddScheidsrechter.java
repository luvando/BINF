/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import ijshockey.Competitie;
import ijshockey.DBException;
import ijshockey.DriverManager;
import ijshockey.Scheidsrechter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ekmaes
 */
public class AddScheidsrechter extends javax.swing.JFrame {

    public static DriverManager dManager;

    /**
     * Creates new form AddScheidsrechter
     */
    public AddScheidsrechter() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public AddScheidsrechter(DriverManager dManager) {
        this.dManager = dManager;
        initComponents();
        setLocationRelativeTo(null);
        Store.addActionListener(new AddScheidsrechter.EventHandler(this));
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
        jTextVoornaam = new javax.swing.JTextField();
        jTextGeboortedatum = new javax.swing.JTextField();
        jTextNaam = new javax.swing.JTextField();
        AddAnotherScheidsrechterButton = new javax.swing.JButton();
        AddTeamButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        VorigeButton = new javax.swing.JButton();
        Store = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Voeg scheidsrechter toe");

        jLabel1.setText("Naam");

        jLabel2.setText("Voornaam");

        jLabel3.setText("Geboortedatum");

        AddAnotherScheidsrechterButton.setText("Nog een scheidsrechter toevoegen");
        AddAnotherScheidsrechterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddAnotherScheidsrechterButtonActionPerformed(evt);
            }
        });

        AddTeamButton.setText("Team toevoegen");
        AddTeamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddTeamButtonActionPerformed(evt);
            }
        });

        CancelButton.setText("Beëindig");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        VorigeButton.setText("Vorige");
        VorigeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VorigeButtonActionPerformed(evt);
            }
        });

        Store.setText("Store");
        Store.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StoreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AddAnotherScheidsrechterButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextGeboortedatum, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextVoornaam, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextNaam, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(AddTeamButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(VorigeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(89, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Store)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextNaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextVoornaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextGeboortedatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Store)
                .addGap(3, 3, 3)
                .addComponent(AddAnotherScheidsrechterButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddTeamButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(VorigeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CancelButton)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddTeamButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddTeamButtonActionPerformed
        // TODO add your handling code here:
        AddTeamEnTrainer updateForm = new AddTeamEnTrainer(dManager);
        updateForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_AddTeamButtonActionPerformed

    private void AddAnotherScheidsrechterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddAnotherScheidsrechterButtonActionPerformed
        // TODO add your handling code here:
        AddScheidsrechter updateForm = new AddScheidsrechter(dManager);
        updateForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_AddAnotherScheidsrechterButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void VorigeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VorigeButtonActionPerformed
        // TODO add your handling code here:
        AddNieuweCompetitie updateForm = new AddNieuweCompetitie(dManager);
        updateForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_VorigeButtonActionPerformed

    private void StoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StoreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StoreActionPerformed

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
            java.util.logging.Logger.getLogger(AddScheidsrechter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddScheidsrechter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddScheidsrechter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddScheidsrechter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddScheidsrechter().setVisible(true);
            }
        });
    }

    private class EventHandler implements ActionListener {

        private AddScheidsrechter form;

        public EventHandler(AddScheidsrechter anr) {
            form = anr;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == Store) {

                Scheidsrechter scheids = new Scheidsrechter(form.getjTextVoornaam(), form.getjTextNaam(), form.getjTextGeboortedatumString());
                jTextNaam.setText("");
                jTextVoornaam.setText("");
                jTextGeboortedatum.setText("");
                try {
                    DriverManager.addScheids(scheids);

                    JOptionPane.showMessageDialog(null, "Scheidsrechter opgeslagen!");
                } catch (DBException ex) {
                    Logger.getLogger(AddNieuweCompetitie.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddAnotherScheidsrechterButton;
    private javax.swing.JButton AddTeamButton;
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton Store;
    private javax.swing.JButton VorigeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextGeboortedatum;
    private javax.swing.JTextField jTextNaam;
    private javax.swing.JTextField jTextVoornaam;
    // End of variables declaration//GEN-END:variables

//    public Date getjTextGeboortedatum() {
//        String datum = this.getjTextGeboortedatumString();
//        String[] array = datum.split("-");
//        int year = Integer.parseInt(array[0]);
//        int month = Integer.parseInt(array[1]);
//        int day = Integer.parseInt(array[2]);
//        Date geboortedatum = new Date(year, month, day);
//        return geboortedatum;
//
//    }

    public String getjTextGeboortedatumString() {
        return jTextGeboortedatum.getText();
    }

    public void setjTextGeboortedatum(JTextField jTextGeboortedatum) {
        this.jTextGeboortedatum = jTextGeboortedatum;
    }

    public String getjTextNaam() {
        return jTextNaam.getText();
    }

    public void setjTextNaam(JTextField jTextNaam) {
        this.jTextNaam = jTextNaam;
    }

    public String getjTextVoornaam() {
        return jTextVoornaam.getText();
    }

    public void setjTextVoornaam(JTextField jTextVoornaam) {
        this.jTextVoornaam = jTextVoornaam;
    }

}
