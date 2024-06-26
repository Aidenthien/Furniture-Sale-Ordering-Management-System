/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Admin;

import Classes.GeneratePDF;
import Classes.ReportCalculation;
import Classes.loginSession;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class GenerateReport extends javax.swing.JFrame {
    loginSession ls;
    
    /**
     * Creates new form GenerateReport
     */
    public GenerateReport(loginSession session) {
        initComponents(); 
        this.ls = session;
        String userId = ls.getId();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableWorkdone = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtWorkdone = new javax.swing.JTextField();
        txtTotalSales = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAvgSales = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtHighestSales = new javax.swing.JTextField();
        txtHighestSalesID = new javax.swing.JTextField();
        btnWDPDF = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableACSale = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPercentApproved = new javax.swing.JTextField();
        txtPercentClosed = new javax.swing.JTextField();
        txtApproved = new javax.swing.JTextField();
        txtClosed = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnACPDF = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cmbMonth = new javax.swing.JComboBox<>();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableWorkdone.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableWorkdone);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 23, 951, 252));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("New Work Done Sale Order:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("Total Monthly Sales (RM):");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        txtWorkdone.setEditable(false);
        txtWorkdone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWorkdoneActionPerformed(evt);
            }
        });
        jPanel1.add(txtWorkdone, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 90, -1));

        txtTotalSales.setEditable(false);
        jPanel1.add(txtTotalSales, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 90, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Average Monthly Sales (RM):");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        txtAvgSales.setEditable(false);
        jPanel1.add(txtAvgSales, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 90, -1));

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel9.setText("Highest Sales Price:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, -1, -1));

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel10.setText("Highest Sales Order ID:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 300, -1, -1));

        txtHighestSales.setEditable(false);
        txtHighestSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHighestSalesActionPerformed(evt);
            }
        });
        jPanel1.add(txtHighestSales, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, 90, -1));

        txtHighestSalesID.setEditable(false);
        txtHighestSalesID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHighestSalesIDActionPerformed(evt);
            }
        });
        jPanel1.add(txtHighestSalesID, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 300, 90, -1));

        btnWDPDF.setText("Generate PDF");
        btnWDPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWDPDFActionPerformed(evt);
            }
        });
        jPanel1.add(btnWDPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 450, -1, -1));

        jTabbedPane1.addTab("Work Done Report", jPanel1);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableACSale.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tableACSale);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 23, 951, 252));

        jLabel5.setText("Percentage of Closed Sale Order (%):");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 350, -1, -1));

        jLabel6.setText("Total Sale Order:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        jLabel7.setText("Closed Sale Order:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        jLabel8.setText("Percentage of Approved Sale Order (%):");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, -1, -1));

        txtPercentApproved.setEditable(false);
        txtPercentApproved.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPercentApprovedActionPerformed(evt);
            }
        });
        jPanel2.add(txtPercentApproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, 110, -1));

        txtPercentClosed.setEditable(false);
        jPanel2.add(txtPercentClosed, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, 110, -1));

        txtApproved.setEditable(false);
        txtApproved.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApprovedActionPerformed(evt);
            }
        });
        jPanel2.add(txtApproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 110, -1));

        txtClosed.setEditable(false);
        txtClosed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClosedActionPerformed(evt);
            }
        });
        jPanel2.add(txtClosed, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 110, -1));

        jLabel11.setText("Approved Sale Order:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        txtTotal.setEditable(false);
        jPanel2.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, 110, -1));

        btnACPDF.setText("Generate PDF");
        btnACPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnACPDFActionPerformed(evt);
            }
        });
        jPanel2.add(btnACPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 450, -1, -1));

        jTabbedPane1.addTab("Approved/ Closed Sale Report", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1000, 540));

        jLabel1.setFont(new java.awt.Font("Stencil", 0, 36)); // NOI18N
        jLabel1.setText("MONTHLY Furniture Sale Report");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        cmbMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Select a month>", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        cmbMonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMonthItemStateChanged(evt);
            }
        });
        cmbMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMonthActionPerformed(evt);
            }
        });
        getContentPane().add(cmbMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 30, 140, -1));

        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBack.setText("Back");
        btnBack.setMaximumSize(new java.awt.Dimension(1000, 600));
        btnBack.setMinimumSize(new java.awt.Dimension(1000, 600));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 16, 100, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtWorkdoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWorkdoneActionPerformed
        
    }//GEN-LAST:event_txtWorkdoneActionPerformed

    private void txtApprovedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApprovedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApprovedActionPerformed

    private void txtPercentApprovedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPercentApprovedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPercentApprovedActionPerformed

    private void txtClosedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClosedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClosedActionPerformed

    private void cmbMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMonthItemStateChanged
        
    }//GEN-LAST:event_cmbMonthItemStateChanged

    private void cmbMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMonthActionPerformed
        int selectedMonth = cmbMonth.getSelectedIndex();        
        
        // Workdone Sale Order data
        double totalSalesOrder;
        double approvedSales;
        double closedSales;
        
        DefaultTableModel ACModel = (DefaultTableModel)tableACSale.getModel();
        ACModel.setColumnIdentifiers(new String[] {"Sales ID", "Salesperson ID", "Date", "Customer Name",
            "Customer Contact No.", "Customer Address", "Item Name", "Item Type", 
            "Delivery Fee", "Discount", "Unit Price", "Qty", "Approval Status", "Product Status"});
        ReportCalculation ACReport = new ReportCalculation();
        ACReport.ACdata(ACModel, tableACSale,selectedMonth);
        approvedSales = ACReport.getApproved();
        closedSales = ACReport.getClosed();
        totalSalesOrder = ACReport.getTotalSalesCount();
        
        double pctApproved = (approvedSales / totalSalesOrder)* 100;
        double pctClosed = (closedSales / totalSalesOrder) * 100;
        
        txtTotal.setText(String.format("%.0f", totalSalesOrder));
        txtApproved.setText(String.format("%.0f", approvedSales));
        txtClosed.setText(String.format("%.0f", closedSales));
        txtPercentApproved.setText(String.format("%.2f", pctApproved));
        txtPercentClosed.setText(String.format("%.2f", pctClosed));
        
        // Approved / Closed Sale Order data
        double WDSales;
        double monthlySales;
        double avgSales;
        double highestSales;
        String highestSOID;
        
        DefaultTableModel WDModel = (DefaultTableModel)tableWorkdone.getModel();
        WDModel.setColumnIdentifiers(new String[] {"Sales ID", "Salesperson ID", "Date", "Customer Name",
            "Customer Contact No.", "Customer Address", "Item Name", "Item Type", 
            "Delivery Fee", "Discount", "Unit Price", "Qty", "Approval Status", "Product Status"});
        ReportCalculation WDReport = new ReportCalculation();
        WDReport.Workdonedata(WDModel, tableWorkdone,selectedMonth);
        
        WDSales = WDReport.getWorkdoneSalesCount();
        monthlySales = WDReport.getMonthlySales();
        avgSales = WDReport.getAvgMonthlySales();
        highestSOID = WDReport.getHighestSalesID();
        highestSales = WDReport.getHighestSales();
        
        txtWorkdone.setText(String.format("%.0f", WDSales));
        txtTotalSales.setText(String.format("%.2f", monthlySales));
        txtAvgSales.setText(String.format("%.2f", avgSales));
        txtHighestSalesID.setText(highestSOID);
        txtHighestSales.setText(String.format("%.2f", highestSales));
        
    }//GEN-LAST:event_cmbMonthActionPerformed

    private void txtHighestSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHighestSalesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHighestSalesActionPerformed

    private void txtHighestSalesIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHighestSalesIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHighestSalesIDActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        AdminMainMenu a =new AdminMainMenu(ls);
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnWDPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWDPDFActionPerformed
        String month = (String) cmbMonth.getSelectedItem();

        if (!"<Select a month>".equals(month)) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save Work Done Report PDF");
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.setCurrentDirectory(new java.io.File(System.getProperty("user.home")));
            FileNameExtensionFilter pdfFilter = new FileNameExtensionFilter("PDF Documents", "pdf");
            fileChooser.addChoosableFileFilter(pdfFilter);
            fileChooser.setFileFilter(pdfFilter);

            int userSelection = fileChooser.showSaveDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                java.io.File fileToSave = fileChooser.getSelectedFile();
                String filePath = fileToSave.getAbsolutePath();
                if (!filePath.toLowerCase().endsWith(".pdf")) {
                    filePath += ".pdf";
                }

                String workDoneData = "Work Done Sales: " + txtWorkdone.getText() + "\n" +
                        "Monthly Sales: RM " + txtTotalSales.getText() + "\n" +
                        "Average Monthly Sales: RM " + txtAvgSales.getText() + "\n" +
                        "Highest Sales ID: " + txtHighestSalesID.getText() + "\n" +
                        "Highest Sales: RM " + txtHighestSales.getText() + "\n";

                GeneratePDF pdf = new GeneratePDF();
                try {
                    pdf.WDReportPDF(tableWorkdone, filePath, month + " Workdone Sales Report", workDoneData);
                    JOptionPane.showMessageDialog(null, "PDF Report Generated and saved to: " + filePath, "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Failed to generate PDF.", "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a month.", "Validation Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnWDPDFActionPerformed

    private void btnACPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnACPDFActionPerformed
       String month = (String) cmbMonth.getSelectedItem();

       if (!"<Select a month>".equals(month)) {
           JFileChooser fileChooser = new JFileChooser();
           fileChooser.setDialogTitle("Save Approved/Closed Sales Report PDF");
           fileChooser.setAcceptAllFileFilterUsed(false);
           fileChooser.setCurrentDirectory(new java.io.File(System.getProperty("user.home")));
           FileNameExtensionFilter pdfFilter = new FileNameExtensionFilter("PDF Documents", "pdf");
           fileChooser.addChoosableFileFilter(pdfFilter);
           fileChooser.setFileFilter(pdfFilter);

           int userSelection = fileChooser.showSaveDialog(null);

           if (userSelection == JFileChooser.APPROVE_OPTION) {
               java.io.File fileToSave = fileChooser.getSelectedFile();
               String filePath = fileToSave.getAbsolutePath();
               if (!filePath.toLowerCase().endsWith(".pdf")) {
                   filePath += ".pdf";
               }

               String salesOrderData = "Total Sales Orders: " + txtTotal.getText() + "\n" +
                                       "Approved Sales: " + txtApproved.getText() + "\n" +
                                       "Closed Sales: " + txtClosed.getText() + "\n" +
                                       "Percent Approved: " + txtPercentApproved.getText() + "%\n" +
                                       "Percent Closed: " + txtPercentClosed.getText() + "%\n";

               GeneratePDF pdf = new GeneratePDF();
               try {
                   pdf.ACReportPDF(tableACSale, filePath, month + " Approved/Closed Sales Report", salesOrderData);
                   JOptionPane.showMessageDialog(null, "PDF Report Generated and saved to: " + filePath, "Success", JOptionPane.INFORMATION_MESSAGE);
               } catch (FileNotFoundException ex) {
                   JOptionPane.showMessageDialog(null, "Failed to generate PDF.", "Error", JOptionPane.ERROR_MESSAGE);
                   ex.printStackTrace();
               }
           }
       } else {
           JOptionPane.showMessageDialog(this, "Please select a month.", "Validation Error", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_btnACPDFActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(GenerateReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GenerateReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GenerateReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GenerateReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new GenerateReport().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnACPDF;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnWDPDF;
    private javax.swing.JComboBox<String> cmbMonth;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tableACSale;
    private javax.swing.JTable tableWorkdone;
    private javax.swing.JTextField txtApproved;
    private javax.swing.JTextField txtAvgSales;
    private javax.swing.JTextField txtClosed;
    private javax.swing.JTextField txtHighestSales;
    private javax.swing.JTextField txtHighestSalesID;
    private javax.swing.JTextField txtPercentApproved;
    private javax.swing.JTextField txtPercentClosed;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotalSales;
    private javax.swing.JTextField txtWorkdone;
    // End of variables declaration//GEN-END:variables
}
