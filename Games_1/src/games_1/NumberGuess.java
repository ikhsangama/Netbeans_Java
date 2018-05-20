/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.DefaultListModel;

/**
 *
 * @author Ikhsan
 */
public class NumberGuess extends javax.swing.JFrame {

    DefaultListModel<String> dlm;
    List<String> list = new ArrayList<>();
    Random r = new Random();
    int randomInt = r.nextInt(100) + 1, nyawa = 7, score = 0;
    
    /**
     * Creates new form NumberGuess
     */
    public NumberGuess() {
        initComponents();
        this.dlm = new DefaultListModel<>();
        this.jList1.setModel(dlm);
        dlm.addElement("Tebak angka 1-100: ");
        lbl_nyawa.setText("nyawa: " + nyawa);
        lbl_score.setText("score: " + score);
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
        jList1 = new javax.swing.JList<>();
        textFld_tebak = new javax.swing.JTextField();
        lbl_nyawa = new javax.swing.JLabel();
        btn_tebak = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        lbl_score = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        textFld_tebak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFld_tebakActionPerformed(evt);
            }
        });

        lbl_nyawa.setText("nyawa");

        btn_tebak.setText("tebak");
        btn_tebak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tebakActionPerformed(evt);
            }
        });

        btn_reset.setBackground(new java.awt.Color(255, 102, 102));
        btn_reset.setForeground(new java.awt.Color(255, 255, 255));
        btn_reset.setText("reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        lbl_score.setText("score: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(textFld_tebak, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_tebak)
                        .addGap(56, 56, 56)
                        .addComponent(lbl_score)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_nyawa)
                        .addGap(40, 40, 40)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_reset)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFld_tebak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_nyawa)
                    .addComponent(btn_tebak)
                    .addComponent(lbl_score))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_reset)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFld_tebakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFld_tebakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFld_tebakActionPerformed

    private void btn_tebakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tebakActionPerformed
        // TODO add your handling code here:
        if (nyawa > 0) {
            try {
                Integer.parseInt(textFld_tebak.getText());
                int i = Integer.parseInt(textFld_tebak.getText());
//                dlm.addElement(textFld_tebak.getText());
                list.add(String.valueOf(i));
                if (i == randomInt) {
                    next();
                } else if (i > randomInt) {
                    dlm.addElement("Coba lebih kecil");
                    nyawa--;
                    lbl_nyawa.setText("nyawa: " + nyawa);
                } else if (i < randomInt) {
                    dlm.addElement("Coba lebih besar");
                    nyawa--;
                    lbl_nyawa.setText("nyawa: " + nyawa);
                }
                    dlm.addElement("percobaan yang dilakukan: "+ list);
            } catch (NumberFormatException e) {
                dlm.addElement("Tebak dengan angka");
            }

        }
        if (nyawa == 0) {
            dlm.addElement("Nyawa habis, jawabannya adalah: " + randomInt);
            dlm.addElement("Percobaan yang dilakukan: "+ list);
        };
        textFld_tebak.setText("");
    }//GEN-LAST:event_btn_tebakActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        // TODO add your handling code here:
        dlm.clear();
        list.clear();
        dlm.addElement("Tebak angka 1-100: ");
        lbl_nyawa.setText("nyawa: " + nyawa);
        randomInt = r.nextInt(100) + 1;
        score = 0;
        nyawa = 5;
        lbl_nyawa.setText("nyawa: " + nyawa);
    }//GEN-LAST:event_btn_resetActionPerformed

    private void next(){
        dlm.clear();
        list.clear();
        dlm.addElement("Selamat anda menang, angka randomnya adalah: "+ randomInt);
        dlm.addElement("Anda mendapat skor dan nyawa tambahan");
        dlm.addElement("Tebak angka 1-100: ");
        randomInt = r.nextInt(100) + 1;
        score = score + nyawa;
        nyawa = nyawa + 5;
        lbl_score.setText("score: " + score);
        lbl_nyawa.setText("nyawa: " + nyawa);
    }
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
            java.util.logging.Logger.getLogger(NumberGuess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NumberGuess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NumberGuess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NumberGuess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NumberGuess().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_tebak;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_nyawa;
    private javax.swing.JLabel lbl_score;
    private javax.swing.JTextField textFld_tebak;
    // End of variables declaration//GEN-END:variables
}