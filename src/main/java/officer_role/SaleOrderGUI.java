package officer_role;

import Classes.UpdateSalesOrderData;
import Classes.loginSession;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class SaleOrderGUI extends javax.swing.JFrame {
    loginSession ls;
    public SaleOrderGUI(loginSession session) {
        initComponents();
        this.ls = session;
    
        this.setLocationRelativeTo(null);
        DefaultTableModel model = (DefaultTableModel) tableSaleOrder.getModel();
        UpdateSalesOrderData.saleData(model, tableSaleOrder);
        String[] approvalStatus = {"<Select>", "Approved", "Unapproved", "Pending"};
        String[] reason = {"<Select>", "Insufficient Information", "Out of Stock", "Production Constraint", "Quality Concern"};
        cmbApprovalStatus.setModel(new DefaultComboBoxModel(approvalStatus));
        cmbReason.setModel(new DefaultComboBoxModel(reason));
        cmbReason.setVisible(false);
        lblReason.setVisible(false); 
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSaleOrder = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSalespersonID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSalesID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        lblReason = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtCusName = new javax.swing.JTextField();
        txtCusContact = new javax.swing.JTextField();
        txtCusAddress = new javax.swing.JTextField();
        txtItemType = new javax.swing.JTextField();
        txtItemName = new javax.swing.JTextField();
        txtDeliveryFee = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtDiscount = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        cmbApprovalStatus = new javax.swing.JComboBox<>();
        btnReset = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtQty = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtProductStatus = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        cmbReason = new javax.swing.JComboBox<>();
        btnBack = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(730, 350));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Stencil", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(212, 229, 239));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sale Order");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, 50));

        txtSearch.setBackground(new java.awt.Color(182, 203, 222));
        txtSearch.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 20, 160, -1));

        tableSaleOrder.setBackground(new java.awt.Color(182, 203, 222));
        tableSaleOrder.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tableSaleOrder.setForeground(new java.awt.Color(50, 113, 174));
        tableSaleOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableSaleOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableSaleOrder.setDragEnabled(true);
        tableSaleOrder.setSelectionBackground(new java.awt.Color(115, 211, 250));
        tableSaleOrder.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableSaleOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSaleOrderMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableSaleOrder);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 940, 170));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(212, 229, 239));
        jLabel2.setText("Search:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(212, 229, 239));
        jLabel3.setText("Salesperson ID:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 270, -1, -1));

        txtSalespersonID.setEditable(false);
        txtSalespersonID.setBackground(new java.awt.Color(182, 203, 222));
        txtSalespersonID.setFont(new java.awt.Font("SimSun", 0, 12)); // NOI18N
        txtSalespersonID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSalespersonID.setDisabledTextColor(new java.awt.Color(73, 73, 73));
        txtSalespersonID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalespersonIDActionPerformed(evt);
            }
        });
        getContentPane().add(txtSalespersonID, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, 140, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(212, 229, 239));
        jLabel4.setText("Sales ID:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, -1, -1));

        txtSalesID.setEditable(false);
        txtSalesID.setBackground(new java.awt.Color(182, 203, 222));
        txtSalesID.setFont(new java.awt.Font("SimSun", 0, 12)); // NOI18N
        txtSalesID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSalesID.setDisabledTextColor(new java.awt.Color(73, 73, 73));
        txtSalesID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalesIDActionPerformed(evt);
            }
        });
        getContentPane().add(txtSalesID, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 150, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(212, 229, 239));
        jLabel5.setText(" Date:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 270, -1, -1));

        txtDate.setEditable(false);
        txtDate.setBackground(new java.awt.Color(182, 203, 222));
        txtDate.setFont(new java.awt.Font("SimSun", 0, 12)); // NOI18N
        txtDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDate.setDisabledTextColor(new java.awt.Color(73, 73, 73));
        txtDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateActionPerformed(evt);
            }
        });
        getContentPane().add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 270, 140, -1));

        lblReason.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblReason.setForeground(new java.awt.Color(212, 229, 239));
        lblReason.setText("Unapproved Reason:");
        getContentPane().add(lblReason, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 470, -1, -1));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(212, 229, 239));
        jLabel7.setText("Customer Name:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(212, 229, 239));
        jLabel8.setText("Customer Contact No.:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, -1, -1));

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(212, 229, 239));
        jLabel9.setText("Customer Address:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 320, -1, -1));

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(212, 229, 239));
        jLabel10.setText("Quantity:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 370, -1, -1));

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(212, 229, 239));
        jLabel11.setText("Item Type:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, -1, -1));

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(212, 229, 239));
        jLabel12.setText("Delivery Fee:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, -1, -1));

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(212, 229, 239));
        jLabel13.setText("Discount:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, -1, -1));

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(212, 229, 239));
        jLabel14.setText(" Price:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 420, -1, -1));

        txtCusName.setBackground(new java.awt.Color(182, 203, 222));
        txtCusName.setFont(new java.awt.Font("SimSun", 0, 12)); // NOI18N
        txtCusName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCusName.setDisabledTextColor(new java.awt.Color(73, 73, 73));
        txtCusName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCusNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtCusName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 150, -1));

        txtCusContact.setBackground(new java.awt.Color(182, 203, 222));
        txtCusContact.setFont(new java.awt.Font("SimSun", 0, 12)); // NOI18N
        txtCusContact.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCusContact.setDisabledTextColor(new java.awt.Color(73, 73, 73));
        txtCusContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCusContactActionPerformed(evt);
            }
        });
        getContentPane().add(txtCusContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, 140, -1));

        txtCusAddress.setBackground(new java.awt.Color(182, 203, 222));
        txtCusAddress.setFont(new java.awt.Font("SimSun", 0, 12)); // NOI18N
        txtCusAddress.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCusAddress.setDisabledTextColor(new java.awt.Color(73, 73, 73));
        txtCusAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCusAddressActionPerformed(evt);
            }
        });
        getContentPane().add(txtCusAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 320, 140, -1));

        txtItemType.setBackground(new java.awt.Color(182, 203, 222));
        txtItemType.setFont(new java.awt.Font("SimSun", 0, 12)); // NOI18N
        txtItemType.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtItemType.setDisabledTextColor(new java.awt.Color(73, 73, 73));
        txtItemType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemTypeActionPerformed(evt);
            }
        });
        getContentPane().add(txtItemType, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 150, -1));

        txtItemName.setBackground(new java.awt.Color(182, 203, 222));
        txtItemName.setFont(new java.awt.Font("SimSun", 0, 12)); // NOI18N
        txtItemName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtItemName.setDisabledTextColor(new java.awt.Color(73, 73, 73));
        txtItemName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtItemName, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 370, 140, -1));

        txtDeliveryFee.setBackground(new java.awt.Color(182, 203, 222));
        txtDeliveryFee.setFont(new java.awt.Font("SimSun", 0, 12)); // NOI18N
        txtDeliveryFee.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDeliveryFee.setDisabledTextColor(new java.awt.Color(73, 73, 73));
        txtDeliveryFee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDeliveryFeeActionPerformed(evt);
            }
        });
        getContentPane().add(txtDeliveryFee, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 150, -1));

        txtPrice.setBackground(new java.awt.Color(182, 203, 222));
        txtPrice.setFont(new java.awt.Font("SimSun", 0, 12)); // NOI18N
        txtPrice.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrice.setDisabledTextColor(new java.awt.Color(73, 73, 73));
        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });
        getContentPane().add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 420, 140, -1));

        txtDiscount.setBackground(new java.awt.Color(182, 203, 222));
        txtDiscount.setFont(new java.awt.Font("SimSun", 0, 12)); // NOI18N
        txtDiscount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDiscount.setDisabledTextColor(new java.awt.Color(73, 73, 73));
        txtDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiscountActionPerformed(evt);
            }
        });
        getContentPane().add(txtDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 420, 140, -1));

        btnUpdate.setBackground(new java.awt.Color(212, 229, 239));
        btnUpdate.setFont(new java.awt.Font("Bauhaus 93", 0, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(50, 113, 174));
        btnUpdate.setText("Update");
        btnUpdate.setMargin(new java.awt.Insets(2, 14, 2, 14));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 530, -1, -1));

        cmbApprovalStatus.setBackground(new java.awt.Color(182, 203, 222));
        cmbApprovalStatus.setFont(new java.awt.Font("SimSun", 0, 12)); // NOI18N
        cmbApprovalStatus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbApprovalStatusItemStateChanged(evt);
            }
        });
        cmbApprovalStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbApprovalStatusActionPerformed(evt);
            }
        });
        getContentPane().add(cmbApprovalStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, 150, -1));

        btnReset.setBackground(new java.awt.Color(212, 229, 239));
        btnReset.setFont(new java.awt.Font("Bauhaus 93", 0, 14)); // NOI18N
        btnReset.setForeground(new java.awt.Color(50, 113, 174));
        btnReset.setText("Reset");
        btnReset.setMargin(new java.awt.Insets(2, 14, 2, 14));
        btnReset.setMaximumSize(new java.awt.Dimension(75, 27));
        btnReset.setMinimumSize(new java.awt.Dimension(75, 27));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        getContentPane().add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 530, -1, -1));

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(212, 229, 239));
        jLabel15.setText("Approval Status:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, -1, -1));

        txtQty.setBackground(new java.awt.Color(182, 203, 222));
        txtQty.setFont(new java.awt.Font("SimSun", 0, 12)); // NOI18N
        txtQty.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtQty.setDisabledTextColor(new java.awt.Color(73, 73, 73));
        txtQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtyActionPerformed(evt);
            }
        });
        getContentPane().add(txtQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 370, 140, -1));

        jLabel16.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(212, 229, 239));
        jLabel16.setText("Item Name:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 370, -1, -1));

        txtProductStatus.setEditable(false);
        txtProductStatus.setBackground(new java.awt.Color(182, 203, 222));
        txtProductStatus.setFont(new java.awt.Font("SimSun", 0, 12)); // NOI18N
        txtProductStatus.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtProductStatus.setDisabledTextColor(new java.awt.Color(73, 73, 73));
        txtProductStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductStatusActionPerformed(evt);
            }
        });
        getContentPane().add(txtProductStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 470, 140, -1));

        jLabel17.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(212, 229, 239));
        jLabel17.setText("Product Status:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 470, -1, -1));

        cmbReason.setBackground(new java.awt.Color(182, 203, 222));
        cmbReason.setFont(new java.awt.Font("SimSun", 0, 12)); // NOI18N
        getContentPane().add(cmbReason, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 470, 140, -1));

        btnBack.setBackground(new java.awt.Color(212, 229, 239));
        btnBack.setFont(new java.awt.Font("Bauhaus 93", 0, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(50, 113, 174));
        btnBack.setText("Back");
        btnBack.setMargin(new java.awt.Insets(2, 14, 2, 14));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel1.setBackground(new java.awt.Color(50, 113, 174));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String search = txtSearch.getText();
        DefaultTableModel table = (DefaultTableModel)tableSaleOrder.getModel();
        TableRowSorter<DefaultTableModel> tData = new TableRowSorter<>(table);
        tableSaleOrder.setRowSorter(tData);
        tData.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSalespersonIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalespersonIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalespersonIDActionPerformed

    private void txtSalesIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalesIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalesIDActionPerformed

    private void txtDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateActionPerformed

    private void txtCusNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCusNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCusNameActionPerformed

    private void txtCusContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCusContactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCusContactActionPerformed

    private void txtCusAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCusAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCusAddressActionPerformed

    private void txtItemTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtItemTypeActionPerformed

    private void txtItemNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtItemNameActionPerformed

    private void txtDeliveryFeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDeliveryFeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDeliveryFeeActionPerformed

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed

    private void txtDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiscountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiscountActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String salesID = txtSalesID.getText();
        String cusName = txtCusName.getText();
        String cusContact = txtCusContact.getText();
        String cusAddress = txtCusAddress.getText();
        String itemType = txtItemType.getText();
        String itemName = txtItemName.getText();
        String qty = txtQty.getText();
        String delivery = txtDeliveryFee.getText();
        String discount = txtDiscount.getText();
        String price = txtPrice.getText();
        String changedApprovalStatus = cmbApprovalStatus.getSelectedItem().toString();
        String reason = cmbReason.getSelectedItem().toString();

        // Check if the approval status is changing from unapproved to approved
        boolean fromUnapprovedToApproved = !reason.equals("-") && changedApprovalStatus.equals("Approved");

        // If the status is changing from unapproved to approved, reset the reason
        if (fromUnapprovedToApproved) {
            reason = "-";
        }

        boolean update = UpdateSalesOrderData.updateSalesData(salesID, cusName, cusContact, cusAddress, itemType, itemName, qty, delivery, discount, price, changedApprovalStatus, reason);
        if (update) {
            // reset row count for auto-fill in textfield function works after search 
            DefaultTableModel model = (DefaultTableModel) tableSaleOrder.getModel();
            model.setRowCount(0);
            UpdateSalesOrderData.saleData(model, tableSaleOrder);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tableSaleOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSaleOrderMouseClicked
        int selectedRow = tableSaleOrder.getSelectedRow();
        int i = tableSaleOrder.convertRowIndexToModel(selectedRow);
        TableModel tableModel = tableSaleOrder.getModel();
        txtSalesID.setText(tableModel.getValueAt(i, 0).toString());
        txtSalespersonID.setText(tableModel.getValueAt(i, 1).toString());
        txtDate.setText(tableModel.getValueAt(i, 2).toString());
        txtCusName.setText(tableModel.getValueAt(i, 3).toString());
        txtCusContact.setText(tableModel.getValueAt(i, 4).toString());
        txtCusAddress.setText(tableModel.getValueAt(i, 5).toString());
        txtItemName.setText(tableModel.getValueAt(i, 6).toString());
        txtItemType.setText(tableModel.getValueAt(i, 7).toString());
        txtDeliveryFee.setText(tableModel.getValueAt(i, 8).toString());
        txtDiscount.setText(tableModel.getValueAt(i, 9).toString());
        txtPrice.setText(tableModel.getValueAt(i, 10).toString());
        txtQty.setText(tableModel.getValueAt(i, 11).toString());
        txtProductStatus.setText(tableModel.getValueAt(i, 13).toString());
        String approvalStatus = tableModel.getValueAt(i, 12).toString();
        switch(approvalStatus){
            case "Approved" -> cmbApprovalStatus.setSelectedIndex(1);
            case "Unapproved" -> cmbApprovalStatus.setSelectedIndex(2);
            case "Pending" -> cmbApprovalStatus.setSelectedIndex(3);
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader("sales_data.txt"))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] rowData = line.split(", ");
                if (tableModel.getValueAt(i, 0).toString().equals(rowData[0])) {
                    if("Unapproved".equals(rowData[12])){
                        String reason = rowData[14];
                        switch(reason){
                            case "Insufficient Information" -> cmbReason.setSelectedIndex(1);
                            case "Out of Stock" -> cmbReason.setSelectedIndex(2);
                            case "Production Constraint" -> cmbReason.setSelectedIndex(3);
                            case "Quality Concern" -> cmbReason.setSelectedIndex(4);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing the data to a file: " + e.toString());
        }
    }//GEN-LAST:event_tableSaleOrderMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtSalesID.setText("");
        txtSalespersonID.setText("");
        txtDate.setText("");
        txtCusName.setText("");
        txtCusContact.setText("");
        txtCusAddress.setText("");
        txtItemName.setText("");
        txtItemType.setText("");
        txtDeliveryFee.setText("");
        txtDiscount.setText("");
        txtPrice.setText("");
        txtProductStatus.setText("");
        txtQty.setText("");
        cmbApprovalStatus.setSelectedIndex(0);
        cmbReason.setSelectedIndex(0);
        cmbReason.setVisible(false);
        lblReason.setVisible(false); 
    }//GEN-LAST:event_btnResetActionPerformed

    private void txtQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtyActionPerformed

    private void txtProductStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductStatusActionPerformed

    private void cmbApprovalStatusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbApprovalStatusItemStateChanged
        String approvalStatus = (String) cmbApprovalStatus.getSelectedItem();
        if ("Unapproved".equals(approvalStatus)){
            lblReason.setVisible(true); 
            cmbReason.setVisible(true); 
        }else{
            lblReason.setVisible(false); 
            cmbReason.setVisible(false); 
        }
        
    }//GEN-LAST:event_cmbApprovalStatusItemStateChanged

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        OfficerMainMenu a = new OfficerMainMenu(ls);
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void cmbApprovalStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbApprovalStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbApprovalStatusActionPerformed

    /**
     * @param args the command line arguments
     */
//    ss

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbApprovalStatus;
    private javax.swing.JComboBox<String> cmbReason;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblReason;
    private javax.swing.JTable tableSaleOrder;
    private javax.swing.JTextField txtCusAddress;
    private javax.swing.JTextField txtCusContact;
    private javax.swing.JTextField txtCusName;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtDeliveryFee;
    private javax.swing.JTextField txtDiscount;
    private javax.swing.JTextField txtItemName;
    private javax.swing.JTextField txtItemType;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtProductStatus;
    private javax.swing.JTextField txtQty;
    private javax.swing.JTextField txtSalesID;
    private javax.swing.JTextField txtSalespersonID;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}