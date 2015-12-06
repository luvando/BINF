/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import static GUIPackage.AddWedstrijd.dManager;
import ijshockey.DBException;
import ijshockey.DriverManager;
import static ijshockey.DriverManager.getSpeler;
import static ijshockey.DriverManager.getWedstrijd;
import ijshockey.Opstelling;
import ijshockey.Team;
import ijshockey.Wedstrijd;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ekmaes
 */
public class AddOpstelling extends javax.swing.JFrame {

    /**
     * Creates new form AddOpstelling
     */
    public static DriverManager dManager;

    public Wedstrijd wedstrijd;

    DefaultListModel DLM;

    public AddOpstelling() {
        initComponents();
    }

    AddOpstelling(DriverManager dManager, Wedstrijd wed) throws SQLException {
        this.dManager = dManager;
        this.wedstrijd = wed;

        initComponents();
        this.setjLabelTop("Opstelling wedstrijd :" + wed.getWedstrijdNr() + " : F" + wed.getThuisTeam().getNaam() + " versus " + wed.getUitTeam().getNaam());

        FillLijstSpelertjesThuis(DriverManager.FillLijstSpelers(DLM, wed.getThuisTeam().getStamNr()));

        FillLijstSpelertjesUit(DriverManager.FillLijstSpelers(DLM, wed.getUitTeam().getStamNr()));

        setLocationRelativeTo(null);
    }

    private void FillLijstSpelertjesThuis(DefaultListModel DLM) {
        try {

            jListSpelersThuis.setModel(DLM);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void FillLijstSpelertjesUit(DefaultListModel DLM) {
        try {

            jListSpelersUit.setModel(DLM);

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

        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jComboBox7 = new javax.swing.JComboBox();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox5 = new javax.swing.JComboBox();
        jComboBox6 = new javax.swing.JComboBox();
        jComboBox10 = new javax.swing.JComboBox();
        jComboBox12 = new javax.swing.JComboBox();
        jComboBox11 = new javax.swing.JComboBox();
        jComboBox9 = new javax.swing.JComboBox();
        jComboBox8 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Done = new javax.swing.JButton();
        VorigeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListSpelersThuis = new javax.swing.JList();
        jTextSpelerThuis = new javax.swing.JTextField();
        jComboBoxPositie = new javax.swing.JComboBox<String>();
        jLabel2 = new javax.swing.JLabel();
        jTextTijdstipInthuis = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextTijdstipUitThuis = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jComboxPositie2 = new javax.swing.JComboBox<String>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextTijdstipInUit = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jListSpelersUit = new javax.swing.JList();
        jTextTijdstipUitUit = new javax.swing.JTextField();
        jTextSpelerUit = new javax.swing.JTextField();
        Store = new javax.swing.JButton();
        jButtonStore2 = new javax.swing.JButton();
        jLabelTop = new javax.swing.JLabel();

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox12.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Central");

        jLabel5.setText("Left wing");

        jLabel6.setText("Right wing");

        jLabel7.setText("Left");

        jLabel8.setText("Right");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Opstelling thuisteam");

        Done.setText("Done");
        Done.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoneActionPerformed(evt);
            }
        });

        VorigeButton.setText("Vorige");
        VorigeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VorigeButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Speler:");

        jLabel9.setText("Thuisteam");

        jListSpelersThuis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListSpelersThuisMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jListSpelersThuis);

        jTextSpelerThuis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextSpelerThuisMouseClicked(evt);
            }
        });
        jTextSpelerThuis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextSpelerThuisActionPerformed(evt);
            }
        });

        jComboBoxPositie.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Goalie", "Defender", "Forward" }));
        jComboBoxPositie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPositieActionPerformed(evt);
            }
        });

        jLabel2.setText("Tijdstip in:");

        jLabel3.setText("Tijdstip uit:");

        jLabel10.setText("Speler:");

        jComboxPositie2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Goalie", "Defender", "Forward" }));
        jComboxPositie2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboxPositie2ActionPerformed(evt);
            }
        });

        jLabel11.setText("Tijdstip in:");

        jLabel12.setText("Uitteam");

        jLabel13.setText("Tijdstip uit:");

        jListSpelersUit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListSpelersUitMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jListSpelersUit);

        jTextSpelerUit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextSpelerUitMouseClicked(evt);
            }
        });
        jTextSpelerUit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextSpelerUitActionPerformed(evt);
            }
        });

        Store.setText("Store");
        Store.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StoreActionPerformed(evt);
            }
        });

        jButtonStore2.setText("Store");
        jButtonStore2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStore2ActionPerformed(evt);
            }
        });

        jLabelTop.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabelTop.setText("jLabel14");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(17, 17, 17)
                        .addComponent(VorigeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Done)
                        .addGap(43, 43, 43))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextSpelerThuis, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jTextTijdstipInthuis))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxPositie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Store)
                                    .addComponent(jTextTijdstipUitThuis, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTop)
                            .addComponent(jLabel12)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextSpelerUit)
                                    .addComponent(jTextTijdstipInUit, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboxPositie2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButtonStore2)
                                            .addComponent(jTextTijdstipUitUit, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 81, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextSpelerThuis, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxPositie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextTijdstipInthuis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jTextTijdstipUitThuis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(Store)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Done)
                            .addComponent(VorigeButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jTextSpelerUit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboxPositie2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jTextTijdstipInUit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(jTextTijdstipUitUit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(jButtonStore2)))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoneActionPerformed
        TussenSchermOpstHighlight updateForm = null;

        updateForm = new TussenSchermOpstHighlight(dManager, wedstrijd, this);
        updateForm.setVisible(true);
    }//GEN-LAST:event_DoneActionPerformed

    private void VorigeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VorigeButtonActionPerformed
        // TODO add your handling code here:
        AddWedstrijd updateForm = null;
        try {
            updateForm = new AddWedstrijd(dManager, wedstrijd.getSp().getCompetitie(), wedstrijd.getSp().getSeizoen());
        } catch (SQLException ex) {
            Logger.getLogger(AddOpstelling.class.getName()).log(Level.SEVERE, null, ex);
        }
        updateForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_VorigeButtonActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextSpelerThuisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextSpelerThuisMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextSpelerThuisMouseClicked

    private void jTextSpelerThuisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextSpelerThuisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextSpelerThuisActionPerformed

    private void jComboBoxPositieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPositieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPositieActionPerformed

    private void jComboxPositie2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboxPositie2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboxPositie2ActionPerformed

    private void jTextSpelerUitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextSpelerUitMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextSpelerUitMouseClicked

    private void jTextSpelerUitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextSpelerUitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextSpelerUitActionPerformed

    private void StoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StoreActionPerformed
        String lidnrThuis = this.jTextSpelerThuis.getText();
        String[] thuis = lidnrThuis.split("-");
        String lidnrthuissp = thuis[thuis.length - 1].trim();
        int lidnrthuis = Integer.parseInt(lidnrthuissp);

        String gekozenpositie = (String) this.jComboBoxPositie.getSelectedItem();

        Opstelling ops = null;
        try {

            ops = new Opstelling(wedstrijd, getSpeler(lidnrthuis), gekozenpositie, this.getjTextTijdstipInthuis(), this.getjTextTijdstipUitThuis());
            DriverManager.addOpstelling(ops);
            JOptionPane.showMessageDialog(null, "Opstelling Opgeslagen");
            jTextSpelerThuis.setText("");
            jTextTijdstipInthuis.setText("");
            jTextTijdstipUitThuis.setText("");
        } catch (DBException ex) {
            Logger.getLogger(AddOpstelling.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_StoreActionPerformed

    private void jButtonStore2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStore2ActionPerformed
        String lidnrUit = this.jTextSpelerUit.getText();
        String[] uit = lidnrUit.split("-");
        String lidnruitstr = uit[uit.length - 1].trim();
        int lidnruit = Integer.parseInt(lidnruitstr);

        String gekozenpositie = (String) this.jComboxPositie2.getSelectedItem();

        Opstelling ops = null;
        try {
            ops = new Opstelling(wedstrijd, getSpeler(lidnruit), gekozenpositie, this.getjTextTijdstipInUit(), this.getjTextTijdstipUitUit());
        } catch (DBException ex) {
            Logger.getLogger(AddOpstelling.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTextSpelerUit.setText("");
        jTextTijdstipInUit.setText("");
        jTextTijdstipUitUit.setText("");

        try {

            DriverManager.addOpstelling(ops);
            JOptionPane.showMessageDialog(null, "Opstelling Opgeslagen");
        } catch (DBException ex) {
            Logger.getLogger(AddNieuweCompetitie.class.getName()).log(Level.SEVERE, null, ex);
        }    }//GEN-LAST:event_jButtonStore2ActionPerformed

    private void jListSpelersThuisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListSpelersThuisMouseClicked
        jTextSpelerThuis.setText((String) jListSpelersThuis.getSelectedValue());
    }//GEN-LAST:event_jListSpelersThuisMouseClicked

    private void jListSpelersUitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListSpelersUitMouseClicked
        jTextSpelerUit.setText((String) jListSpelersUit.getSelectedValue());
    }//GEN-LAST:event_jListSpelersUitMouseClicked

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
            java.util.logging.Logger.getLogger(AddOpstelling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddOpstelling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddOpstelling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddOpstelling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddOpstelling().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Done;
    private javax.swing.JButton Store;
    private javax.swing.JButton VorigeButton;
    private javax.swing.JButton jButtonStore2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox10;
    private javax.swing.JComboBox jComboBox11;
    private javax.swing.JComboBox jComboBox12;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JComboBox jComboBox7;
    private javax.swing.JComboBox jComboBox8;
    private javax.swing.JComboBox jComboBox9;
    private javax.swing.JComboBox<String> jComboBoxPositie;
    private javax.swing.JComboBox<String> jComboxPositie2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelTop;
    private javax.swing.JList jListSpelersThuis;
    private javax.swing.JList jListSpelersUit;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextSpelerThuis;
    private javax.swing.JTextField jTextSpelerUit;
    private javax.swing.JTextField jTextTijdstipInUit;
    private javax.swing.JTextField jTextTijdstipInthuis;
    private javax.swing.JTextField jTextTijdstipUitThuis;
    private javax.swing.JTextField jTextTijdstipUitUit;
    // End of variables declaration//GEN-END:variables

    public String getjTextSpelerThuis() {
        return jTextSpelerThuis.getText();
    }

    public void setjTextSpelerThuis(JTextField jTextSpelerThuis) {
        this.jTextSpelerThuis = jTextSpelerThuis;
    }

    public String getjTextSpelerUit() {
        return jTextSpelerUit.getText();
    }

    public void setjTextSpelerUit(JTextField jTextSpelerUit) {
        this.jTextSpelerUit = jTextSpelerUit;
    }

    public int getjTextTijdstipInthuis() {
        return Integer.parseInt(jTextTijdstipInthuis.getText());
    }

    public int getjTextTijdstipInUit() {
        return Integer.parseInt(jTextTijdstipInUit.getText());
    }

    public void setjTextTijdstipInthuis(JTextField jTextTijdstipInthuis) {
        this.jTextTijdstipInthuis = jTextTijdstipInthuis;
    }

    public int getjTextTijdstipUitThuis() {
        return Integer.parseInt(jTextTijdstipUitThuis.getText());
    }

    public int getjTextTijdstipUitUit() {
        return Integer.parseInt(jTextTijdstipUitUit.getText());
    }

    public void setjTextTijdstipUitThuis(JTextField jTextTijdstipUitThuis) {
        this.jTextTijdstipUitThuis = jTextTijdstipUitThuis;
    }

    private void setjLabelTop(String string) {
        this.jLabelTop.setText(string);
    }

}
