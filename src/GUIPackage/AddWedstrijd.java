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
import ijshockey.Seizoen;
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

    private Competitie competitie;
    private Seizoen seizoen;

    private Wedstrijd wedstrijd;

    private Team thuisTeam;
    private Team uitTeam;
    DefaultListModel DLM;

    public AddWedstrijd(DriverManager dManager, Competitie competitie, Seizoen seizoen) throws SQLException {
        AddWedstrijd.dManager = dManager;
        initComponents();
        this.seizoen = seizoen;
        this.competitie = competitie;
        setLocationRelativeTo(null);
        this.setjLabelTop("Team toevoegen aan " + competitie.getCompetitienaam() + " seizoen : " + seizoen.getJaar());
        this.FillLijstSpeeldag(ijshockey.DriverManager.FillLijstSpeeldagen(DLM, competitie, seizoen));
        this.FillLijstScheids(ijshockey.DriverManager.FillLijstScheids(DLM));
        this.FillLijstTeamthuis(ijshockey.DriverManager.FillLijstTeam(DLM, competitie, seizoen));
        this.FillLijstTeamuit(ijshockey.DriverManager.FillLijstTeam(DLM, competitie, seizoen));
    }

    private void FillLijstSpeeldag(DefaultListModel DLM) {
        try {

            jListSpeeldag.setModel(DLM);

        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    private void FillLijstScheids(DefaultListModel DLM) {
        try {

            jListScheids.setModel(DLM);

        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    private void FillLijstTeamthuis(DefaultListModel DLM) {
        try {

            jListThuisteam.setModel(DLM);

        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }

    private void FillLijstTeamuit(DefaultListModel DLM) {
        try {

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

        jPopupMenu1 = new javax.swing.JPopupMenu();
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
        VorigeButton = new javax.swing.JButton();
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
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Voeg speeldag en wedstrijd toe");

        jTextArena.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextArena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextArenaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("*Scheidsrechter:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("*Datum:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Score:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("-");

        jListSpeeldag.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jListSpeeldag.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jListSpeeldag.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", " " };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListSpeeldag.setSelectionBackground(java.awt.SystemColor.activeCaption);
        jListSpeeldag.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListSpeeldagValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jListSpeeldag);

        jTextDatum.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextDatum.setToolTipText("YYYY-MM-DD");

        jTextScoreThuis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("*Speeldag:");

        jTextScoreUit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("*Arena:");

        VorigeButton.setBackground(new java.awt.Color(255, 204, 204));
        VorigeButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        VorigeButton.setText("Vorige");
        VorigeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VorigeButtonActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("*Uitteam:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("*Thuisteam:");

        jTextaddSpeeldag.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextaddSpeeldag.setToolTipText("");

        jButtonaddSpeeldag.setBackground(java.awt.SystemColor.activeCaption);
        jButtonaddSpeeldag.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonaddSpeeldag.setText("Voeg speeldag toe");
        jButtonaddSpeeldag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonaddSpeeldagActionPerformed(evt);
            }
        });

        Store.setBackground(java.awt.SystemColor.activeCaption);
        Store.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Store.setText("Store");
        Store.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StoreActionPerformed(evt);
            }
        });

        jListScheids.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jListScheids.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jListScheids.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jListScheids);

        jListThuisteam.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jListThuisteam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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

        jListUitteam.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jListUitteam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jListUitteam.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(jListUitteam);

        jLabelTop.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTop.setText("jLabel1");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("* = verplicht");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(VorigeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(73, 73, 73)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jTextScoreThuis, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextaddSpeeldag, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonaddSpeeldag, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel6)
                                        .addComponent(jTextScoreUit)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Store, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(73, 73, 73)
                                        .addComponent(jTextArena, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(131, 131, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabelTop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(152, 152, 152))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTop)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextScoreUit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextaddSpeeldag, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonaddSpeeldag, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextScoreThuis, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jTextDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextArena, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Store, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VorigeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        jTextaddSpeeldag.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VorigeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VorigeButtonActionPerformed
        // TODO add your handling code here:

        CompetitieScherm updateForm = null;
        try {
            updateForm = new CompetitieScherm(dManager);
        } catch (DBException ex) {
            Logger.getLogger(AddWedstrijd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddWedstrijd.class.getName()).log(Level.SEVERE, null, ex);
        }
        updateForm.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_VorigeButtonActionPerformed

    private void jButtonaddSpeeldagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonaddSpeeldagActionPerformed

        Speeldag sp = new Speeldag(competitie, DriverManager.getSeizoen(seizoen.getJaar(), competitie.getCompetitienaam()), this.getjTextaddSpeeldag());
        try {
            DriverManager.addSpeeldag(sp);
            FillLijstSpeeldag(ijshockey.DriverManager.FillLijstSpeeldagen(DLM, competitie, seizoen));
        } catch (DBException | SQLException ex) {
            Logger.getLogger(AddWedstrijd.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTextaddSpeeldag.setText("");
    }//GEN-LAST:event_jButtonaddSpeeldagActionPerformed

    private void StoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StoreActionPerformed
        TussenSchermWedOpst updateForm = null;
        Speeldag sp = null;

        Scheidsrechter scheidsrechter = null;

        int speeldagnr = (Integer) jListSpeeldag.getSelectedValue();

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
            this.thuisTeam = DriverManager.getTeam(stamnrthuis);
            this.uitTeam = DriverManager.getTeam(stamnruit);
            scheidsrechter = DriverManager.getScheids(lidnr);
            sp = new Speeldag(competitie, DriverManager.getSeizoen(seizoen.getJaar(), competitie.getCompetitienaam()), speeldagnr);

        } catch (DBException ex) {
            Logger.getLogger(AddWedstrijd.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (jTextScoreThuis.getText().isEmpty() && (!jTextDatum.getText().isEmpty())) {
            Wedstrijd wedntgespeeld = new Wedstrijd(seizoen, thuisTeam, uitTeam, arena, scheidsrechter, this.getjTextDatum(), sp);
            try {
                DriverManager.addNoScoreWedstrijd(wedntgespeeld);

                jTextScoreUit.setText("");
                jTextScoreThuis.setText("");
                jTextDatum.setText("");
                jTextArena.setText("");
                JOptionPane.showMessageDialog(null, "Wedstrijd gepland !!");
            } catch (DBException ex) {
                Logger.getLogger(AddWedstrijd.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            Wedstrijd wed = new Wedstrijd(seizoen, thuisTeam, uitTeam, arena, this.getjTextScoreThuis(), this.getjTextScoreUit(), scheidsrechter, this.getjTextDatum(), sp);
            try {
                DriverManager.addWedstrijd(wed);
                int wedstrijdnr = DriverManager.getRecentWedstrijdNr();
                this.wedstrijd = DriverManager.getWedstrijd(wedstrijdnr);
                jTextScoreUit.setText("");
                jTextScoreThuis.setText("");
                jTextDatum.setText("");
                jTextArena.setText("");
                updateForm = new TussenSchermWedOpst(dManager, wedstrijd, this);
                updateForm.setVisible(true);
            } catch (DBException ex) {
                Logger.getLogger(AddWedstrijd.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

     }//GEN-LAST:event_StoreActionPerformed

    private void MouseClickedEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MouseClickedEvent
        String thuis = (String) jListThuisteam.getSelectedValue();
        String[] teamthuis = thuis.split("-");
        String teamthuistr = teamthuis[teamthuis.length - 1].trim();
        int stamnrthuis = Integer.parseInt(teamthuistr);

        try {
            Team thuisTeam1 = DriverManager.getTeam(stamnrthuis);
            jTextArena.setText(thuisTeam1.getThuisArena());

        } catch (DBException ex) {
            Logger.getLogger(AddWedstrijd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_MouseClickedEvent

    private void jListSpeeldagValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListSpeeldagValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jListSpeeldagValueChanged

    private void jTextArenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextArenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArenaActionPerformed

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
    private javax.swing.JButton Store;
    private javax.swing.JButton VorigeButton;
    private javax.swing.JButton jButtonaddSpeeldag;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPopupMenu jPopupMenu1;
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
