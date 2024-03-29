/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.isuru.dinemore.view;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lk.isuru.dinemore.controller.ChefController;
import lk.isuru.dinemore.controller.ReceptionController;
import lk.isuru.dinemore.dto.RecepDTO;
import lk.isuru.dinemore.observer.Observer;

/**
 *
 * @author ISURU UMAYANGA
 */
public class ChefForm extends javax.swing.JFrame implements Observer{

    private String orderID;
    private String receptionid;
    private String date;
    private String time;
    private String custName;
    private String tpno;
    private String qty;
    private String status;
    
    public ChefForm() throws RemoteException,Exception {
        initComponents();
        loadAllCustomers();
         getDateAndTime();
        getClock();
        UnicastRemoteObject.exportObject(this, 0);
        ReceptionController.getSubeject().registerObserver(this);
    }
 private DefaultTableModel dtm;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnfinish = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblchef = new javax.swing.JTable();
        btnTake = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lbldate = new javax.swing.JLabel();
        lbltime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/isuru/dinemore/view/image/icons8-chef-90.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, 90));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 48)); // NOI18N
        jLabel2.setText("Chef Window");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 450, 60));

        btnfinish.setBackground(new java.awt.Color(255, 0, 51));
        btnfinish.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnfinish.setText("FINISH");
        btnfinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfinishActionPerformed(evt);
            }
        });
        jPanel1.add(btnfinish, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 460, 140, 40));

        tblchef.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order Id", "Reception ID", "Date", "Time", "Customer Name", "TP", "QTY", "Status"
            }
        ));
        tblchef.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblchefMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblchef);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 850, 280));

        btnTake.setBackground(new java.awt.Color(51, 51, 255));
        btnTake.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTake.setText("TAKE ORDER");
        btnTake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTakeActionPerformed(evt);
            }
        });
        jPanel1.add(btnTake, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 460, 140, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/isuru/dinemore/view/image/blur-bread-buns-1269665.jpg"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 870, 430));

        lbldate.setBackground(new java.awt.Color(102, 102, 102));
        lbldate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbldate.setForeground(new java.awt.Color(102, 102, 102));
        lbldate.setText("Date");
        jPanel1.add(lbldate, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, -1, -1));

        lbltime.setBackground(new java.awt.Color(102, 102, 102));
        lbltime.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbltime.setForeground(new java.awt.Color(102, 102, 102));
        lbltime.setText("Time");
        jPanel1.add(lbltime, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblchefMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblchefMouseClicked
        int selectRow=tblchef.getSelectedRow();
         orderID=dtm.getValueAt(selectRow, 0).toString();
         receptionid=dtm.getValueAt(selectRow, 1).toString();
         date=dtm.getValueAt(selectRow, 2).toString();
         time=dtm.getValueAt(selectRow, 3).toString();
         custName=dtm.getValueAt(selectRow, 4).toString();
         tpno=dtm.getValueAt(selectRow, 5).toString();
        qty=dtm.getValueAt(selectRow, 6).toString();
         status=dtm.getValueAt(selectRow, 7).toString();

     

    }//GEN-LAST:event_tblchefMouseClicked

    private void btnTakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTakeActionPerformed
       try {
            String ststus = "Cooking";
            RecepDTO orderDTO = new RecepDTO(
                    orderID,
                    receptionid,
                    date,
                    time,
                    custName,
                    tpno,
                    Integer.parseInt(qty),
                    ststus
                   
            );
            boolean addorder = ReceptionController.updateCustomer(orderDTO);
            if (addorder) {
                JOptionPane.showMessageDialog(this, "Order Added");
            } else {
                JOptionPane.showMessageDialog(this, "Failed");
            

}
        } catch (Exception ex) {
            Logger.getLogger(ChefForm.class
.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTakeActionPerformed

    private void btnfinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfinishActionPerformed
try {
            String ststus = "Finished";
            RecepDTO orderDTO = new RecepDTO(
                    orderID,
                    receptionid,
                    date,
                    time,
                    custName,
                    tpno,
                    Integer.parseInt(qty),
                    ststus
                   
            );
            boolean addorder = ReceptionController.updateCustomer(orderDTO);
            if (addorder) {
                JOptionPane.showMessageDialog(this, "Finsh Ok");
            } else {
                JOptionPane.showMessageDialog(this, "Failed");
            

}
        } catch (Exception ex) {
            Logger.getLogger(ChefForm.class
.getName()).log(Level.SEVERE, null, ex);
        }
      
    }//GEN-LAST:event_btnfinishActionPerformed

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
            java.util.logging.Logger.getLogger(ChefForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChefForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChefForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChefForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ChefForm().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(ChefForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    @Override
    public void updateObservers() throws Exception {
        loadAllCustomers();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTake;
    private javax.swing.JButton btnfinish;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbldate;
    private javax.swing.JLabel lbltime;
    private javax.swing.JTable tblchef;
    // End of variables declaration//GEN-END:variables

    private void loadAllCustomers() {
         dtm = (DefaultTableModel) tblchef.getModel();
        dtm.setRowCount(0);
        try {
            List<RecepDTO> orders = ReceptionController.getAllCustomers();
            if (orders == null) {
                return;
            }

            for (RecepDTO orderDTO : orders) {
                Object[] rowData = {
                    orderDTO.getOid(),
                    orderDTO.getRid(),
                    orderDTO.getDate(),
                    orderDTO.getTime(),
                    orderDTO.getCid(),
                    orderDTO.getTpNo(),
                    orderDTO.getQty(),
                orderDTO.getStatus()

            };
            dtm.addRow(rowData);
        }

    }
    catch (Exception ex

    
        ) {
            Logger.getLogger(ChefForm.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    private void getDateAndTime() {
        Date date = new Date();
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd");
        String new_DATE = simpledateformat.format(date);
        lbldate.setText(new_DATE);
    }

    private void getClock() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Date curDate = new Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss aa");
                    String currentTime = dateFormat.format(curDate);

                    lbltime.setText(currentTime);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        JOptionPane.showMessageDialog(ChefForm.this, "Database Error...");
                    }
                }
            }
        }).start();
    }
}
