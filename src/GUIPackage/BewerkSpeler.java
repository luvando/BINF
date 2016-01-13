/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import ijshockey.DBException;
import ijshockey.DriverManager;
import ijshockey.Speler;
import ijshockey.Team;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.Position;

/**
 *
 * @author Viktor
 */
public class BewerkSpeler extends javax.swing.JFrame {

    private Team team;
    public static DriverManager dManager;
    DefaultListModel DLM;

    /**
     * Creates new form BewerkSpeler
     */
    public BewerkSpeler() {
        initComponents();
    }

    public BewerkSpeler(DriverManager dManager, Team team) throws SQLException {
        super("Bewerk speler");
        BewerkSpeler.dManager = dManager;
        this.team = team;

        initComponents();
        setLocationRelativeTo(null);
        this.FillLijstSpelers(ijshockey.DriverManager.FillLijstSpelers(DLM, team));
        this.FillLijstTeams(ijshockey.DriverManager.FillLijstTeamAll(DLM));
        this.setjLabelTop("Speler bewerken voor team : " + team.getNaam());

    }

    private void FillLijstSpelers(DefaultListModel DLM) {
        try {

            LijstSpelers.setModel(DLM);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void FillLijstTeams(DefaultListModel DLM) {

        try {

            jListTeam.setModel(DLM);

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

        jButtonStore = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextAchternaam = new javax.swing.JTextField();
        jTextVoornaam = new javax.swing.JTextField();
        jTextGeboortedatum = new javax.swing.JTextField();
        VorigeButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        LijstSpelers = new javax.swing.JList();
        jLabelSpeler = new javax.swing.JLabel();
        jComboBoxPositie = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListTeam = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        SearchButton = new javax.swing.JButton();
        SearchText = new javax.swing.JTextField();
        jLabelTop = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonStore.setBackground(java.awt.SystemColor.activeCaption);
        jButtonStore.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonStore.setText("Store");
        jButtonStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStoreActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Achternaam");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Voornaam");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Geboortedatum");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Voorkeurspositie aanpassen");

        jTextAchternaam.setEditable(false);
        jTextAchternaam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextVoornaam.setEditable(false);
        jTextVoornaam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextGeboortedatum.setEditable(false);
        jTextGeboortedatum.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        VorigeButton.setBackground(new java.awt.Color(255, 204, 204));
        VorigeButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        VorigeButton.setText("Vorige");
        VorigeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VorigeButtonActionPerformed(evt);
            }
        });

        LijstSpelers.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                LijstSpelersValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(LijstSpelers);

        jLabelSpeler.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelSpeler.setText("Kies speler ");

        jComboBoxPositie.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxPositie.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Goalie", "Defender", "Forward" }));

        jListTeam.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jListTeam);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Team speler aanpassen");

        SearchButton.setBackground(java.awt.SystemColor.activeCaption);
        SearchButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SearchButton.setText("Team zoeken");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        SearchText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SearchText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchTextActionPerformed(evt);
            }
        });

        jLabelTop.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTop.setText("jLabel6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(VorigeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonStore, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabelSpeler)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(SearchText)
                                    .addComponent(SearchButton, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jComboBoxPositie, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextGeboortedatum, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextAchternaam, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextVoornaam, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2)))
                            .addComponent(jLabelTop))
                        .addGap(0, 18, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTop)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSpeler))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextVoornaam, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextAchternaam, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextGeboortedatum, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxPositie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VorigeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonStore, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStoreActionPerformed
        Team newTeam = null;
        String teamstring = (String) jListTeam.getSelectedValue();
        String[] teama = teamstring.split("-");
        String teamstr = teama[teama.length - 1].trim();
        int stamnr = Integer.parseInt(teamstr);

        String listValue = (String) LijstSpelers.getSelectedValue();
        String[] array = listValue.split("-");
        String lidnrStr = array[array.length - 1].trim();
        int lidnr = Integer.parseInt(lidnrStr);
        try {
            newTeam = DriverManager.getTeam(stamnr);

            Speler speler = new Speler(lidnr, jTextVoornaam.getText(), jTextAchternaam.getText(),
                    jTextGeboortedatum.getText(), (String) this.jComboBoxPositie.getSelectedItem(),
                    newTeam);
            DriverManager.bewerkSpeler(speler);
            this.FillLijstSpelers(ijshockey.DriverManager.FillLijstSpelers(DLM, team));
            this.jListTeam.clearSelection();
            JOptionPane.showMessageDialog(null, "Speler bewerkt!");

        } catch (DBException ex) {
            Logger.getLogger(AddSpeler.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BewerkSpeler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonStoreActionPerformed

    private void VorigeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VorigeButtonActionPerformed
        BewerkTeam updateForm = null;

        try {
            updateForm = new BewerkTeam(dManager);

        } catch (SQLException ex) {
            Logger.getLogger(AddSpeler.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        updateForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_VorigeButtonActionPerformed

    private void LijstSpelersValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_LijstSpelersValueChanged
        if (LijstSpelers.isSelectionEmpty()) {

        } else {
            String listValue = (String) LijstSpelers.getSelectedValue();
            String[] array = listValue.split("-");
            String lidnrStr = array[array.length - 1].trim();
            int lidnr = Integer.parseInt(lidnrStr);
            Speler speler = null;
            try {
                speler = DriverManager.getSpeler(lidnr);
                this.setjTextVoornaam(speler.getVoornaam());
                this.setjTextAchternaam(speler.getAchternaam());
                this.setjTextGeboortedatum(speler.getGeboortedatum());
                this.setjTextVoorkeurspositie(speler.getVoorkeurpositie());
                this.jListTeam.setSelectedValue(speler.getTeam().getNaam() + " - " + speler.getTeam().getStamNr(), true);
            } catch (DBException ex) {
                Logger.getLogger(BewerkSpeler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_LijstSpelersValueChanged

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        int zoekresultaat = jListTeam.getNextMatch(SearchText.getText(), 0, Position.Bias.Forward);
        jListTeam.setSelectedIndex(zoekresultaat);
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void SearchTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchTextActionPerformed
    }//GEN-LAST:event_SearchTextActionPerformed

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
            java.util.logging.Logger.getLogger(BewerkSpeler.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BewerkSpeler.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BewerkSpeler.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BewerkSpeler.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BewerkSpeler().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList LijstSpelers;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTextField SearchText;
    private javax.swing.JButton VorigeButton;
    private javax.swing.JButton jButtonStore;
    private javax.swing.JComboBox jComboBoxPositie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelSpeler;
    private javax.swing.JLabel jLabelTop;
    private javax.swing.JList jListTeam;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextAchternaam;
    private javax.swing.JTextField jTextGeboortedatum;
    private javax.swing.JTextField jTextVoornaam;
    // End of variables declaration//GEN-END:variables

    public void setjLabelTop(String jTextTeam) {
        this.jLabelTop.setText(jTextTeam);
    }

    public JTextField getjTextAchternaam() {
        return jTextAchternaam;
    }

    public void setjTextAchternaam(String jTextAchternaam) {
        this.jTextAchternaam.setText(jTextAchternaam);
    }

    public JTextField getjTextGeboortedatum() {
        return jTextGeboortedatum;
    }

    public void setjTextGeboortedatum(String jTextGeboortedatum) {
        this.jTextGeboortedatum.setText(jTextGeboortedatum);
    }

    public void setjTextVoorkeurspositie(String jTextVoorkeurspositie) {
        this.jComboBoxPositie.setSelectedItem(jTextVoorkeurspositie);
    }

    public JTextField getjTextVoornaam() {
        return jTextVoornaam;
    }

    public void setjTextVoornaam(String jTextVoornaam) {
        this.jTextVoornaam.setText(jTextVoornaam);
    }

}
