/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.presentation;

import delfinen.logic.CompetitionResult;
import delfinen.logic.ControllerMember;
import delfinen.logic.Disciplin;
import delfinen.logic.Member;
import delfinen.logic.TrainingResult;
import java.util.ArrayList;

/**
 *
 * @author sofieamalielandt
 */
public class GUIShowSwimmer extends javax.swing.JFrame
{

    private ControllerMember c;
    private Member s;

    public GUIShowSwimmer(Member s)
    {
        initComponents();

        c = new ControllerMember();
        this.s = s;

        name.setText(s.getName());
        phone.setText("phone number: " + s.getPhone());

        ttraining.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("Disciplin");
        ttraining.getTableHeader().getColumnModel().getColumn(1).setHeaderValue("Date");
        ttraining.getTableHeader().getColumnModel().getColumn(2).setHeaderValue("Time");

        ArrayList<TrainingResult> result = c.getTrainingResult(s, Disciplin.CRAWL);
        ArrayList<TrainingResult> backcrawl = c.getTrainingResult(s, Disciplin.BACKCRAWL);
        ArrayList<TrainingResult> butterfly = c.getTrainingResult(s, Disciplin.BUTTERFLY);
        ArrayList<TrainingResult> breaststroke = c.getTrainingResult(s, Disciplin.BREASTSTROKE);

        for (int i = 0; i < backcrawl.size(); i++)
        {

            result.add(backcrawl.get(i));
        }

        for (int i = 0; i < butterfly.size(); i++)
        {

            result.add(butterfly.get(i));
        }

        for (int i = 0; i < breaststroke.size(); i++)
        {

            result.add(breaststroke.get(i));
        }

        for (int i = 0; i < result.size(); i++)
        {
            ttraining.getModel().setValueAt(result.get(i).getDisciplin(), i, 0);
            ttraining.getModel().setValueAt(result.get(i).getDate(), i, 1);
            ttraining.getModel().setValueAt(result.get(i).getTime(), i, 2);

        }

        tcomp.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("Competition");
        tcomp.getTableHeader().getColumnModel().getColumn(1).setHeaderValue("Disciplin");
        tcomp.getTableHeader().getColumnModel().getColumn(2).setHeaderValue("Rank");
        tcomp.getTableHeader().getColumnModel().getColumn(3).setHeaderValue("Time");

        ArrayList<CompetitionResult> competition = c.getCompetitionResult(s);

        for (int i = 0; i < competition.size(); i++)
        {
            tcomp.getModel().setValueAt(competition.get(i).getCompetition(), i, 0);
            tcomp.getModel().setValueAt(competition.get(i).getDisciplin(), i, 1);
            tcomp.getModel().setValueAt(competition.get(i).getRank(), i, 2);
            tcomp.getModel().setValueAt(competition.get(i).getTime(), i, 3);

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        name = new javax.swing.JLabel();
        phone = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ttraining = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tcomp = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        goback = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        name.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        name.setText("jLabel1");

        phone.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        phone.setText("jLabel2");

        ttraining.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(ttraining);

        tcomp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tcomp);

        jLabel3.setText("Competitions");

        jLabel4.setText("Training results");

        goback.setText("Go back");
        goback.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                gobackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(goback)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 27, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(72, 72, 72)
                                        .addComponent(jLabel4)
                                        .addGap(312, 312, 312)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(261, 261, 261)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(name)
                                            .addComponent(phone))))
                                .addGap(81, 81, 81))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(phone)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(goback)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gobackActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_gobackActionPerformed
    {//GEN-HEADEREND:event_gobackActionPerformed
        this.setVisible(false);
        new GUITeams().setVisible(true);
    }//GEN-LAST:event_gobackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(GUIShowSwimmer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(GUIShowSwimmer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(GUIShowSwimmer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(GUIShowSwimmer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton goback;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel name;
    private javax.swing.JLabel phone;
    private javax.swing.JTable tcomp;
    private javax.swing.JTable ttraining;
    // End of variables declaration//GEN-END:variables
}
