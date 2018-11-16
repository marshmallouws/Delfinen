/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.presentation;

import delfinen.data.DBConnector;
import delfinen.data.DataAccessor;
import delfinen.data.DataAccessorDataBase;
import delfinen.logic.ControllerMember;
import delfinen.logic.Disciplin;
import delfinen.logic.Member;
import delfinen.logic.TrainingResult;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author aamandajuhl
 */
public class GUITrainingResults extends javax.swing.JFrame
{

    private ControllerMember c;
    private final Member s;

    public GUITrainingResults(Member s)
    {
        initComponents();

        this.s = s;
        try
        {
            DataAccessor data = new DataAccessorDataBase(new DBConnector());

            c = new ControllerMember(data);

        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }

        Tcrawl.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("Date");
        Tcrawl.getTableHeader().getColumnModel().getColumn(1).setHeaderValue("Time");

        ArrayList<TrainingResult> crawl = c.getTrainingResult(s, Disciplin.CRAWL);

        for (int i = 0; i < crawl.size(); i++)
        {
            Tcrawl.getModel().setValueAt(crawl.get(i).getDate(), i, 0);
            Tcrawl.getModel().setValueAt(crawl.get(i).getTime(), i, 1);
        }

        Tbackcrawl.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("Date");
        Tbackcrawl.getTableHeader().getColumnModel().getColumn(1).setHeaderValue("Time");

        ArrayList<TrainingResult> backcrawl = c.getTrainingResult(s, Disciplin.BACKCRAWL);

        for (int i = 0; i < backcrawl.size(); i++)
        {
            Tbackcrawl.getModel().setValueAt(backcrawl.get(i).getDate(), i, 0);
            Tbackcrawl.getModel().setValueAt(backcrawl.get(i).getTime(), i, 1);
        }

        Tbreaststroke.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("Date");
        Tbreaststroke.getTableHeader().getColumnModel().getColumn(1).setHeaderValue("Time");

        ArrayList<TrainingResult> breaststroke = c.getTrainingResult(s, Disciplin.BREASTSTROKE);

        for (int i = 0; i < breaststroke.size(); i++)
        {
            Tbreaststroke.getModel().setValueAt(breaststroke.get(i).getDate(), i, 0);
            Tbreaststroke.getModel().setValueAt(breaststroke.get(i).getTime(), i, 1);
        }

        Tbutterfly.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("Date");
        Tbutterfly.getTableHeader().getColumnModel().getColumn(1).setHeaderValue("Time");

        ArrayList<TrainingResult> butterfly = c.getTrainingResult(s, Disciplin.BUTTERFLY);

        for (int i = 0; i < butterfly.size(); i++)
        {
            Tbutterfly.getModel().setValueAt(butterfly.get(i).getDate(), i, 0);
            Tbutterfly.getModel().setValueAt(butterfly.get(i).getTime(), i, 1);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tcrawl = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tbutterfly = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        Tbackcrawl = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        Tbreaststroke = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setText("Training results");

        Tcrawl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String []
            {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(Tcrawl);

        Tbutterfly.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String []
            {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane3.setViewportView(Tbutterfly);

        Tbackcrawl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String []
            {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane4.setViewportView(Tbackcrawl);

        Tbreaststroke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String []
            {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane5.setViewportView(Tbreaststroke);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setText("Butterfly");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel3.setText("Crawl");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel4.setText("Back crawl");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel5.setText("Breatstroke");

        jButton1.setText("Go back");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(106, 106, 106))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1)
                                .addGap(170, 170, 170))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(30, 30, 30))))
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(117, 117, 117))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addComponent(jButton1)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        this.setVisible(false);
        new GUICompetitiveMenu(s).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(GUITrainingResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(GUITrainingResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(GUITrainingResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(GUITrainingResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JTable Tbackcrawl;
    private javax.swing.JTable Tbreaststroke;
    private javax.swing.JTable Tbutterfly;
    private javax.swing.JTable Tcrawl;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables
}