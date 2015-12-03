/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import ijshockey.DBException;
import ijshockey.DriverManager;
import ijshockey.Scheidsrechter;
import ijshockey.Speeldag;
import ijshockey.Wedstrijd;
import ijshockey.Team;
import ijshockey.Trainer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Wim
 */
public class AddWedstrijd extends javax.swing.JFrame {
    
    public static DriverManager dManager;

    /**
     * Creates new form kaka
     */
    public AddWedstrijd() {
        initComponents();
    }
    
    AddWedstrijd(DriverManager dManager) {
        this.dManager = dManager;
        initComponents();
    }
    private String competitie;
    private int seizoenInt;
    
    public AddWedstrijd(DriverManager dManager, String competitie, String seizoen) throws SQLException {
        AddWedstrijd.dManager = dManager;
        initComponents();
        this.seizoenInt = Integer.parseInt(seizoen);
        this.competitie = competitie;
        setLocationRelativeTo(null);
        this.setjLabelTop("Team toevoegen aan " + competitie + " seizoen : " + seizoenInt);
        this.FillLijstSpeeldag(ijshockey.DriverManager.FillLijstSpeeldagen(competitie, seizoenInt));
        this.FillLijstScheids(ijshockey.DriverManager.FillLijstScheids());
        this.FillLijstTeamthuis(ijshockey.DriverManager.FillLijstTeam(competitie, seizoenInt));
        this.FillLijstTeamuit(ijshockey.DriverManager.FillLijstTeam(competitie, seizoenInt));
    }
    
    private void FillLijstSpeeldag(ResultSet srs) {
        try {
            DefaultListModel DLM = new DefaultListModel();
            
            while (srs.next()) {
                DLM.addElement(srs.getString(1));
            }
            
            jListSpeeldag.setModel(DLM);
            
        } catch (Exception ex) {
            ex.printStackTrace();
            
        }
    }
    
    private void FillLijstScheids(ResultSet srs) {
        try {
            DefaultListModel DLM = new DefaultListModel();
            
            while (srs.next()) {
                int lidnr = srs.getInt("lidnr");
                DLM.addElement(DriverManager.getScheids(lidnr).getVoornaam() + " " + DriverManager.getScheids(lidnr).getAchternaam() + " - " + lidnr);
                
            }
            
            jListScheids.setModel(DLM);
            
        } catch (Exception ex) {
            ex.printStackTrace();
            
        }
    }
    
    private void FillLijstTeamthuis(ResultSet srs) {
        try {
            DefaultListModel DLM = new DefaultListModel();
            
            while (srs.next()) {
                int stamnr = srs.getInt("stamnr");
                DLM.addElement(DriverManager.getTeam(stamnr).getNaam() + " - " + stamnr);
                
            }
            
            jListThuisteam.setModel(DLM);
            
        } catch (Exception ex) {
            ex.printStackTrace();
            
        }
        
    }
    
    private void FillLijstTeamuit(ResultSet srs) {
        try {
            DefaultListModel DLM = new DefaultListModel();
            
            while (srs.next()) {
                int stamnr = srs.getInt("stamnr");
                DLM.addElement(DriverManager.getTeam(stamnr).getNaam() + " - " + stamnr);
                
            }
            DLM.removeElement(jListThuisteam.getSelectedValue());
            jListUitteam.setModel(DLM);
            
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

        jTextArena = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListSpeeldag = new javax.swing.JList();
        jTextDatum = new javax.swing.JTextField();
        jTextScoreThuis = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextScoreUit = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        OpstellingToevoegenButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextaddSpeeldag = new javax.swing.JTextField();
        jButtonaddSpeeldag = new javax.swing.JButton();
        Store = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListScheids = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListThuisteam = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListUitteam = new javax.swing.JList();
        jLabelTop = new javax.swing.JLabel();
        HighlightButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Voeg speeldag en wedstrijd toe");

        jLabel3.setText("Scheidsrechter");

        jLabel4.setText("Datum");

        jLabel7.setText("Score thuisteam");

        jLabel8.setText("Score uitteam");

        jScrollPane1.setViewportView(jListSpeeldag);

        jTextDatum.setToolTipText("YYYY-MM-DD");

        jLabel5.setText("Kies speeldag");

        jLabel2.setText("Arena");

        OpstellingToevoegenButton.setText("Opstelling toevoegen");
        OpstellingToevoegenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpstellingToevoegenButtonActionPerformed(evt);
            }
        });

        CancelButton.setText("Beëindig");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("Uitteam");

        jLabel9.setText("Thuisteam");

        jTextaddSpeeldag.setToolTipText("");

        jButtonaddSpeeldag.setText("Voeg speeldag toe");
        jButtonaddSpeeldag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonaddSpeeldagActionPerformed(evt);
            }
        });

        Store.setText("Store");
        Store.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StoreActionPerformed(evt);
            }
        });

        jListScheids.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jListScheids);

        jListThuisteam.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListThuisteam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MouseClickedEvent(evt);
            }
        });
        jScrollPane3.setViewportView(jListThuisteam);

        jListUitteam.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(jListUitteam);

        jLabelTop.setText("jLabel1");

        HighlightButton.setText("Highlight toevoegen");
        HighlightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HighlightButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6)
                    .addComponent(jTextaddSpeeldag)
                    .addComponent(jButtonaddSpeeldag, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Store)
                        .addGap(76, 76, 76)
                        .addComponent(OpstellingToevoegenButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextScoreUit)
                            .addComponent(jTextScoreThuis)
                            .addComponent(jTextDatum)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane4)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextArena, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HighlightButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CancelButton)
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(292, 292, 292)
                .addComponent(jLabelTop)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabelTop)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextaddSpeeldag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonaddSpeeldag)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextArena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextScoreThuis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextScoreUit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OpstellingToevoegenButton)
                    .addComponent(CancelButton)
                    .addComponent(Store)
                    .addComponent(HighlightButton))
                .addGap(47, 47, 47))
        );

        jTextaddSpeeldag.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void OpstellingToevoegenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpstellingToevoegenButtonActionPerformed
        // TODO add your handling code here:
        AddOpstelling updateForm = new AddOpstelling(dManager);
        updateForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_OpstellingToevoegenButtonActionPerformed

    private void jButtonaddSpeeldagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonaddSpeeldagActionPerformed
        
        Speeldag sp = new Speeldag(competitie, seizoenInt, this.getjTextaddSpeeldag());
        try {
            DriverManager.addSpeeldag(sp);
            FillLijstSpeeldag(ijshockey.DriverManager.FillLijstSpeeldagen(competitie, seizoenInt));
        } catch (DBException | SQLException ex) {
            Logger.getLogger(AddWedstrijd.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTextaddSpeeldag.setText("");
    }//GEN-LAST:event_jButtonaddSpeeldagActionPerformed

    private void StoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StoreActionPerformed
        
        Speeldag sp = null;
        Team thuisTeam = null;
        Team uitTeam = null;
        Scheidsrechter scheidsrechter = null;
        
        int speeldagnr = Integer.parseInt((String) jListSpeeldag.getSelectedValue());
        
        String arena = jTextArena.getText(); // Ook lijst maken?

        String thuis = (String) jListThuisteam.getSelectedValue();
        
        String[] teamthuis = thuis.split("-");
        String teamthuistr = teamthuis[teamthuis.length - 1].trim();
        int stamnrthuis = Integer.parseInt(teamthuistr);
        
        String uit = (String) jListUitteam.getSelectedValue();
        String[] teamuit = uit.split("-");
        String teamuittr = teamuit[teamuit.length - 1].trim();
        int stamnruit = Integer.parseInt(teamuittr);
        
        String scheids = (String) jListScheids.getSelectedValue();
        String[] scheidsa = scheids.split("-");
        String scheidstr = scheidsa[scheidsa.length - 1].trim();
        int lidnr = Integer.parseInt(scheidstr);
        try {
            thuisTeam = DriverManager.getTeam(stamnrthuis);
            uitTeam = DriverManager.getTeam(stamnruit);
            scheidsrechter = DriverManager.getScheids(lidnr);
            sp = new Speeldag(competitie, seizoenInt, speeldagnr);
            
        } catch (DBException ex) {
            Logger.getLogger(AddWedstrijd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Wedstrijd wed = new Wedstrijd(thuisTeam, uitTeam, arena, this.getjTextScoreThuis(), this.getjTextScoreUit(), scheidsrechter, this.getjTextDatum(), sp);
        try {
            DriverManager.addWedstrijd(wed);
            DriverManager.updateScore(wed);
            jTextScoreUit.setText("");
            jTextScoreThuis.setText("");
            jTextDatum.setText("");
            jTextArena.setText("");
            
            JOptionPane.showMessageDialog(null, "Wedstrijdgegevens opgeslagen!");
        } catch (DBException ex) {
            Logger.getLogger(AddWedstrijd.class.getName()).log(Level.SEVERE, null, ex);
        }
        

     }//GEN-LAST:event_StoreActionPerformed

    private void MouseClickedEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MouseClickedEvent
        String thuis = (String) jListThuisteam.getSelectedValue();
        String[] teamthuis = thuis.split("-");
        String teamthuistr = teamthuis[1].trim();
        int stamnrthuis = Integer.parseInt(teamthuistr);
        
        try {
            Team thuisTeam = DriverManager.getTeam(stamnrthuis);
            jTextArena.setText(thuisTeam.getThuisArena());
            
        } catch (DBException ex) {
            Logger.getLogger(AddNieuweCompetitie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_MouseClickedEvent

    private void HighlightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HighlightButtonActionPerformed
        // TODO add your handling code here:
        AddHighlight updateForm = new AddHighlight(dManager);
        updateForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_HighlightButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AddWedstrijd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddWedstrijd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddWedstrijd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddWedstrijd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddWedstrijd().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton HighlightButton;
    private javax.swing.JButton OpstellingToevoegenButton;
    private javax.swing.JButton Store;
    private javax.swing.JButton jButtonaddSpeeldag;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelTop;
    private javax.swing.JList jListScheids;
    private javax.swing.JList jListSpeeldag;
    private javax.swing.JList jListThuisteam;
    private javax.swing.JList jListUitteam;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextArena;
    private javax.swing.JTextField jTextDatum;
    private javax.swing.JTextField jTextScoreThuis;
    private javax.swing.JTextField jTextScoreUit;
    private javax.swing.JTextField jTextaddSpeeldag;
    // End of variables declaration//GEN-END:variables

    public String getjTextArena() {
        return jTextArena.getText();
    }
    
    public String getjTextDatum() {
        return jTextDatum.getText();
    }
    
    public void setjTextArena(String arena) {
        this.jTextArena.setText(arena);
    }
    
    public int getjTextScoreThuis() {
        return Integer.parseInt(jTextScoreThuis.getText());
    }
    
    public int getjTextScoreUit() {
        return Integer.parseInt(jTextScoreUit.getText());
    }
    
    public int getjTextaddSpeeldag() {
        return Integer.parseInt(jTextaddSpeeldag.getText());
    }
    
    public void setjLabelTop(String string) {
        this.jLabelTop.setText(string);
        
    }
    
}
