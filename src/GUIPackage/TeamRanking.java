/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import ijshockey.Competitie;
import ijshockey.CustomOutputStream;
import ijshockey.DBException;
import ijshockey.DriverManager;
import ijshockey.Seizoen;
import java.io.PrintStream;
import javax.swing.JTextArea;

/**
 *
 * @author Jasper
 */
public class TeamRanking extends javax.swing.JFrame {

    public static DriverManager dManager;

    private PrintStream standardOut;
    private Competitie competitie;
    private Seizoen seizoen;

    /**
     * Creates new form TeamRanking
     */
    public TeamRanking(DriverManager dManager, Competitie competitie, Seizoen seizoen) throws DBException {
        super("Klassement");
        this.competitie = competitie;
        this.seizoen = seizoen;
        initComponents();
        this.setjLabelTop("Klassement van " + competitie.getCompetitienaam() + " seizoen : " + seizoen.getJaar());
        setLocationRelativeTo(null);
        jTextArea1.setEditable(false);
        PrintStream printStream = new PrintStream(new CustomOutputStream(jTextArea1));

        standardOut = System.out;

        System.setOut(printStream);
        System.setErr(printStream);
        DriverManager.printTeamRanking(competitie, seizoen);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabelTop = new javax.swing.JLabel();
        Vorige = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Klassement");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabelTop.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTop.setText("jLabel1");

        Vorige.setBackground(new java.awt.Color(255, 204, 204));
        Vorige.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Vorige.setText("Vorige");
        Vorige.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VorigeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(294, 294, 294)
                                .addComponent(Vorige, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelTop)))
                        .addGap(0, 300, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Vorige, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VorigeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VorigeActionPerformed
        GegevensOpvragen updateForm = null;
        updateForm = new GegevensOpvragen(dManager, competitie, seizoen);
        updateForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_VorigeActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Vorige;
    private javax.swing.JLabel jLabelTop;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    public JTextArea getjTextArea1() {
        return jTextArea1;
    }

    public void setjTextArea1(String jTextArea1) {
        this.jTextArea1.setText(jTextArea1);
    }

    private void setjLabelTop(String string) {
        this.jLabelTop.setText(string);
    }

}
