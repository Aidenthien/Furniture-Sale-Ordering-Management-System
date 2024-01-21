/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SalesPerson;

import Classes.SalesOrderQuotation;
import Classes.Furniture;
import Classes.loginSession;
import Classes.Salesperson;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author johnp
 */
public class Manage_Sale_Order_Quotation extends javax.swing.JFrame {
    loginSession ls;
    ArrayList<Furniture> furnitures;
    ArrayList<SalesOrderQuotation> quotations;
    Timer time;
    SimpleDateFormat st;
    /**
     * Creates new form Manage_Sale_Order_Quotation
     * @param session
     */
    public Manage_Sale_Order_Quotation(loginSession session) {
        this.ls = session;
        initComponents();
        String id = ls.getId();
       
        ArrayList<Salesperson> salesperson;
        
        salesperson = new Salesperson().Import();
        for(Salesperson s:salesperson){
            String salespersonId= s.getId();
            String username = s.getName();
            if(id.equals(salespersonId)){
                usernameTxt.setText(username);
                salespersonTxt2.setText(salespersonId);
            }
        }   
        //objects
        furnitures = new Furniture().importData();
        quotations = new SalesOrderQuotation().ImportData(id);
        Furniture.setDataToTable(furnitures, furnitureTable);
        SalesOrderQuotation.importDataToTable(quotations, quotationTable);
        filterData(quotationTable,"Pending");
        dateTimeFunction();
        salesIdNo();
     
        
    }
    
    public void setDate(){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
        String dd = sdf.format(d);
        dateTxt2.setText(dd);
    }
    
    public void dateTimeFunction(){
        // Date
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        String dd = sdf.format(d);
        dateTF.setText(dd);
        dateTxt2.setText(dd);
        // Time
        time = new Timer (0, new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
            
                Date dt = new Date();
                st = new SimpleDateFormat("hh:mm:ss a");
                
                String tt = st.format(dt);
                timeTF.setText(tt);
            }
        }); 
           time.start();   
    }
    
    public void salesIdNo() {
        // Read the sales IDs from the file and store them in a list
        ArrayList<Integer> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("sales_data.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length > 0) {
                    String salesId = parts[0].substring(1);
                    if (salesId.matches("\\d+")) {
                        list.add(Integer.valueOf(salesId));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Calculate the new sales ID (+1)
        if (!list.isEmpty()) {
            int max = Collections.max(list);
            int newID = max + 1;
            salesIdTxt2.setText(String.format("S%04d", newID));
        } else {
            salesIdTxt2.setText("S0001");
        }
    }
   
    public void filldata(String Id){
        ArrayList<String> data;
        data = SalesOrderQuotation.ReadFile("sales_data.txt");
        for(String str:data){
            String[] list = str.split(", ");
            if(Id.equals(list[0])){
                salesIdTxt3.setText(list[0]);
                salespersonTxt3.setText(list[1]);
                dateTxt3.setText(list[2]);
                customerNameTxt3.setText(list[3]);
                customerContactNoTxt3.setText(list[4]);
                customerAddressTxt3.setText(list[5]);      
                itemNameTxt3.setText(list[6]);        
                itemTypeTxt3.setText(list[7]);       
                deliveryFeeTxt3.setText(list[8]);
                discountTxt3.setText(list[9]);
                priceTxt3.setText(list[10]); 
                quantityTxt1.setSelectedItem(list[11]);
            }
        }
    }  
    
    public void filterData(JTable table, String query) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
        RowFilter<Object, Object> rowFilter = RowFilter.regexFilter(query);
        sorter.setRowFilter(rowFilter);
        table.setRowSorter(sorter);
    }

    public void searchQuotationTable(String str) {
        DefaultTableModel tbl = (DefaultTableModel) quotationTable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(tbl);
        quotationTable.setRowSorter(trs);
        // Pass the status filter to the regexFilter
        RowFilter<DefaultTableModel, Object> statusFilter = RowFilter.regexFilter("(?i)Pending", 12); 
        // Combine status filter and search
        RowFilter<DefaultTableModel, Object> combinedFilter = RowFilter.andFilter(Arrays.asList(statusFilter, RowFilter.regexFilter("(?i)" + str)));
        // Set the combined filter to the TableRowSorter
        trs.setRowFilter(combinedFilter);
    }

    
    public void searchFurnitureTable(String str) {
        DefaultTableModel tbl = (DefaultTableModel) furnitureTable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(tbl);
        furnitureTable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter("(?i)" + str));
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        quotationTable = new javax.swing.JTable();
        searchBar1 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        modifyBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        clearSearchBtn1 = new javax.swing.JButton();
        dltBtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        salesIdTxt3 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        customerContactNoTxt3 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        customerNameTxt3 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        salespersonTxt3 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        dateTxt3 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        deliveryFeeTxt3 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        discountTxt3 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        priceTxt3 = new javax.swing.JTextField();
        clearBtn1 = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        jLabel50 = new javax.swing.JLabel();
        quantityTxt1 = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        customerAddressTxt3 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        itemTypeTxt3 = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        itemNameTxt3 = new javax.swing.JTextArea();
        generateBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        furnitureTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        salesIdTxt2 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        customerContactNoTxt2 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        customerNameTxt2 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        salespersonTxt2 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        dateTxt2 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        deliveryFeeTxt2 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        discountTxt2 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        priceTxt2 = new javax.swing.JTextField();
        clearBtn2 = new javax.swing.JButton();
        addBtn2 = new javax.swing.JButton();
        jLabel49 = new javax.swing.JLabel();
        quantityTxt2 = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        customerAddressTxt2 = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        itemTypeTxt2 = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        itemNameTxt2 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        searchBar2 = new javax.swing.JTextField();
        clearSearchBtn2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        addfidTF2 = new javax.swing.JTextField();
        usernameTxt = new javax.swing.JLabel();
        dateTF = new javax.swing.JLabel();
        timeTF = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 36)); // NOI18N
        jLabel2.setText("Sale Order Quotation Management");
        jLabel2.setPreferredSize(new java.awt.Dimension(200, 100));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 370, 50));

        jPanel1.setPreferredSize(new java.awt.Dimension(1063, 580));

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1018, 800));

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        quotationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sales ID", "SP ID", "Date", "Customer Name", "Contact No", "Address", "Item Name", "Item Type", "Delivery", "Discount", "Unit Price", "Qty", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        quotationTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quotationTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(quotationTable);
        if (quotationTable.getColumnModel().getColumnCount() > 0) {
            quotationTable.getColumnModel().getColumn(0).setMaxWidth(55);
            quotationTable.getColumnModel().getColumn(1).setMaxWidth(50);
            quotationTable.getColumnModel().getColumn(2).setMaxWidth(70);
            quotationTable.getColumnModel().getColumn(8).setMaxWidth(70);
            quotationTable.getColumnModel().getColumn(9).setMaxWidth(60);
            quotationTable.getColumnModel().getColumn(10).setMaxWidth(70);
            quotationTable.getColumnModel().getColumn(11).setMaxWidth(30);
        }

        jPanel6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 35, 1018, 202));

        searchBar1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchBar1FocusGained(evt);
            }
        });
        searchBar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBar1ActionPerformed(evt);
            }
        });
        searchBar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchBar1KeyReleased(evt);
            }
        });
        jPanel6.add(searchBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 6, 298, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel6.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 272, 1018, 10));

        jLabel3.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        jLabel3.setText("Modify Tab");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 284, -1, -1));

        modifyBtn.setText("Modify");
        modifyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyBtnActionPerformed(evt);
            }
        });
        jPanel6.add(modifyBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 90, -1));

        jLabel4.setText("Search:");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 9, -1, -1));

        clearSearchBtn1.setText("Clear");
        clearSearchBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearSearchBtn1ActionPerformed(evt);
            }
        });
        jPanel6.add(clearSearchBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(656, 6, -1, -1));

        dltBtn.setText("Delete");
        dltBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dltBtnActionPerformed(evt);
            }
        });
        jPanel6.add(dltBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 240, 90, -1));

        salesIdTxt3.setEditable(false);
        salesIdTxt3.setBackground(new java.awt.Color(204, 204, 204));
        salesIdTxt3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        salesIdTxt3.setText("Sales ID");
        salesIdTxt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesIdTxt3ActionPerformed(evt);
            }
        });

        jLabel26.setText("Sales ID:");

        customerContactNoTxt3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        customerContactNoTxt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerContactNoTxt3ActionPerformed(evt);
            }
        });

        jLabel33.setText("Salesperson ID:");

        customerNameTxt3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        customerNameTxt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerNameTxt3ActionPerformed(evt);
            }
        });

        jLabel38.setText("Customer Name:");

        jLabel39.setText("Customer");

        jLabel40.setText("Address:");

        salespersonTxt3.setEditable(false);
        salespersonTxt3.setBackground(new java.awt.Color(204, 204, 204));
        salespersonTxt3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        salespersonTxt3.setText("Salesperson ID");

        jLabel41.setText("Contact No :");

        jLabel42.setText("Customer");

        jLabel43.setText("Date:");

        dateTxt3.setEditable(false);
        dateTxt3.setBackground(new java.awt.Color(204, 204, 204));
        dateTxt3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dateTxt3.setText("Date");
        dateTxt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateTxt3ActionPerformed(evt);
            }
        });

        jLabel44.setText("Item Name:");

        jLabel45.setText("Item Type:");

        jLabel46.setText("Delivery Fee:");

        deliveryFeeTxt3.setEditable(false);
        deliveryFeeTxt3.setBackground(new java.awt.Color(204, 204, 204));
        deliveryFeeTxt3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        deliveryFeeTxt3.setText("Delivery Fee");

        jLabel47.setText("Discount:");

        discountTxt3.setEditable(false);
        discountTxt3.setBackground(new java.awt.Color(204, 204, 204));
        discountTxt3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        discountTxt3.setText("Discount");

        jLabel48.setText("Price:");

        priceTxt3.setEditable(false);
        priceTxt3.setBackground(new java.awt.Color(204, 204, 204));
        priceTxt3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        priceTxt3.setText("Price");

        clearBtn1.setText("Clear");
        clearBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtn1ActionPerformed(evt);
            }
        });

        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        jLabel50.setText("Quantity:");

        quantityTxt1.setBackground(new java.awt.Color(204, 204, 204));
        quantityTxt1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        customerAddressTxt3.setColumns(20);
        customerAddressTxt3.setRows(5);
        customerAddressTxt3.setMaximumSize(new java.awt.Dimension(223, 80));
        customerAddressTxt3.setMinimumSize(new java.awt.Dimension(80, 223));
        customerAddressTxt3.setName(""); // NOI18N
        jScrollPane3.setViewportView(customerAddressTxt3);

        itemTypeTxt3.setEditable(false);
        itemTypeTxt3.setBackground(new java.awt.Color(204, 204, 204));
        itemTypeTxt3.setColumns(20);
        itemTypeTxt3.setRows(5);
        itemTypeTxt3.setText("             Item Type");
        itemTypeTxt3.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        jScrollPane5.setViewportView(itemTypeTxt3);

        itemNameTxt3.setEditable(false);
        itemNameTxt3.setBackground(new java.awt.Color(204, 204, 204));
        itemNameTxt3.setColumns(20);
        itemNameTxt3.setRows(5);
        itemNameTxt3.setText("             Item Name ");
        itemNameTxt3.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        jScrollPane7.setViewportView(itemNameTxt3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(discountTxt3))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel42, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(salesIdTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customerContactNoTxt3)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(55, 68, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33)
                    .addComponent(jLabel40)
                    .addComponent(jLabel46)
                    .addComponent(jLabel48))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(clearBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(salespersonTxt3)
                            .addComponent(deliveryFeeTxt3)
                            .addComponent(priceTxt3)
                            .addComponent(jScrollPane3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(dateTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(81, 81, 81)
                                        .addComponent(quantityTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(customerNameTxt3)))
                        .addContainerGap(85, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salesIdTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33)
                    .addComponent(salespersonTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38)
                    .addComponent(customerNameTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addGap(74, 74, 74)
                        .addComponent(jLabel45)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46)
                            .addComponent(deliveryFeeTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43)
                            .addComponent(dateTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel39)
                                    .addComponent(jLabel42))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(customerContactNoTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(discountTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48)
                    .addComponent(jLabel50)
                    .addComponent(quantityTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearBtn1)
                    .addComponent(updateBtn))
                .addGap(80, 80, 80))
        );

        jPanel6.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, -1, -1));

        generateBtn.setText("Generate Quotation");
        generateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateBtnActionPerformed(evt);
            }
        });
        jPanel6.add(generateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 240, -1, -1));

        jTabbedPane1.addTab("Manage Quotations", jPanel6);

        furnitureTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name", "Item Type", "Delivery Fee", "Discount", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        furnitureTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                furnitureTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(furnitureTable);

        salesIdTxt2.setEditable(false);
        salesIdTxt2.setBackground(new java.awt.Color(204, 204, 204));
        salesIdTxt2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        salesIdTxt2.setText("Sales ID");
        salesIdTxt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesIdTxt2ActionPerformed(evt);
            }
        });

        jLabel18.setText("Sales ID:");

        customerContactNoTxt2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        customerContactNoTxt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerContactNoTxt2ActionPerformed(evt);
            }
        });

        jLabel19.setText("Salesperson ID:");

        customerNameTxt2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        customerNameTxt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerNameTxt2ActionPerformed(evt);
            }
        });

        jLabel21.setText("Customer Name:");

        jLabel22.setText("Customer");

        jLabel23.setText("Address:");

        salespersonTxt2.setEditable(false);
        salespersonTxt2.setBackground(new java.awt.Color(204, 204, 204));
        salespersonTxt2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        salespersonTxt2.setText("Salesperson ID");
        salespersonTxt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salespersonTxt2ActionPerformed(evt);
            }
        });

        jLabel28.setText("Contact No :");

        jLabel29.setText("Customer");

        jLabel20.setText("Date:");

        dateTxt2.setEditable(false);
        dateTxt2.setBackground(new java.awt.Color(204, 204, 204));
        dateTxt2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dateTxt2.setText("Date");

        jLabel31.setText("Item Name:");

        jLabel34.setText("Item Type:");

        jLabel35.setText("Delivery Fee:");

        deliveryFeeTxt2.setEditable(false);
        deliveryFeeTxt2.setBackground(new java.awt.Color(204, 204, 204));
        deliveryFeeTxt2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        deliveryFeeTxt2.setText("Delivery Fee");

        jLabel36.setText("Discount:");

        discountTxt2.setEditable(false);
        discountTxt2.setBackground(new java.awt.Color(204, 204, 204));
        discountTxt2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        discountTxt2.setText("Discount");

        jLabel37.setText("Price:");

        priceTxt2.setEditable(false);
        priceTxt2.setBackground(new java.awt.Color(204, 204, 204));
        priceTxt2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        priceTxt2.setText("Price");

        clearBtn2.setText("Clear");
        clearBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtn2ActionPerformed(evt);
            }
        });

        addBtn2.setText("Add");
        addBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtn2ActionPerformed(evt);
            }
        });

        jLabel49.setText("Quantity:");

        quantityTxt2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        quantityTxt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityTxt2ActionPerformed(evt);
            }
        });

        customerAddressTxt2.setColumns(20);
        customerAddressTxt2.setRows(5);
        customerAddressTxt2.setMaximumSize(new java.awt.Dimension(232, 84));
        jScrollPane4.setViewportView(customerAddressTxt2);

        itemTypeTxt2.setEditable(false);
        itemTypeTxt2.setBackground(new java.awt.Color(204, 204, 204));
        itemTypeTxt2.setColumns(20);
        itemTypeTxt2.setRows(5);
        itemTypeTxt2.setText("           Item Type");
        itemTypeTxt2.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        jScrollPane6.setViewportView(itemTypeTxt2);

        itemNameTxt2.setEditable(false);
        itemNameTxt2.setBackground(new java.awt.Color(204, 204, 204));
        itemNameTxt2.setColumns(20);
        itemNameTxt2.setRows(5);
        itemNameTxt2.setText("          Item Name ");
        itemNameTxt2.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        jScrollPane8.setViewportView(itemNameTxt2);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabel1.setText("eg. +XX XXXXX or XXXXXX");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(salesIdTxt2, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(customerContactNoTxt2)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(jLabel1))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(66, 100, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(clearBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(124, 124, 124)
                                .addComponent(addBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel37))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(salespersonTxt2)
                                    .addComponent(deliveryFeeTxt2)
                                    .addComponent(jScrollPane4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel49))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addComponent(quantityTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(36, 36, 36))
                                            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addGap(18, 18, 18)
                                        .addComponent(customerNameTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(dateTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(discountTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(194, 194, 194)
                        .addComponent(priceTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(salesIdTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(salespersonTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel35)
                                    .addComponent(deliveryFeeTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(customerContactNoTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel34)
                                        .addGap(13, 13, 13)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(discountTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(priceTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(customerNameTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(dateTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49)
                            .addComponent(quantityTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearBtn2)
                    .addComponent(addBtn2))
                .addGap(82, 82, 82))
        );

        jLabel5.setText("Search:");

        searchBar2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchBar2FocusGained(evt);
            }
        });
        searchBar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBar2ActionPerformed(evt);
            }
        });
        searchBar2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchBar2KeyReleased(evt);
            }
        });

        clearSearchBtn2.setText("Clear");
        clearSearchBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearSearchBtn2ActionPerformed(evt);
            }
        });

        jLabel6.setText("Click on a table row to select furniture.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(307, 307, 307)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(clearSearchBtn2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(clearSearchBtn2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Add Quotations", jPanel2);

        addfidTF2.setEditable(false);
        addfidTF2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        addfidTF2.setText("Date");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(228, 228, 228)
                .addComponent(addfidTF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(288, 288, 288))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(482, 482, 482)
                .addComponent(addfidTF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 1030, 650));

        usernameTxt.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        usernameTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernameTxt.setText("Username");
        getContentPane().add(usernameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 10, 110, 38));

        dateTF.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        dateTF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateTF.setText("date");
        getContentPane().add(dateTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 50, 90, 20));

        timeTF.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        timeTF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeTF.setText("time");
        getContentPane().add(timeTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 50, 80, 20));

        backBtn.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        getContentPane().add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchBar1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchBar1FocusGained
        // TODO add your handling code here:
        searchBar1.setText("");
    }//GEN-LAST:event_searchBar1FocusGained

    private void searchBar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBar1KeyReleased
        String searchStr = searchBar1.getText();
        searchQuotationTable(searchStr);
    }//GEN-LAST:event_searchBar1KeyReleased
    
   
    
    private void modifyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyBtnActionPerformed
     // TODO add your handling code here:
        DefaultTableModel tableModel = (DefaultTableModel) quotationTable.getModel();
        if(quotationTable.getSelectedRowCount() == 1){     
            int column = 0;
            int row = quotationTable.getSelectedRow();
            String value = quotationTable.getModel().getValueAt(row, column).toString();
            String Id = quotationTable.getModel().getValueAt(quotationTable.convertRowIndexToModel(row), column).toString();
            //transfer data to modify field
            filldata(Id);
        JOptionPane.showMessageDialog(null,"Move to Modify Tab to make changes! Only customer details and item quantity are editable");
        }
        else {
            if(quotationTable.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null,"The Table is Empty!");
            } 
            else {
                JOptionPane.showMessageDialog(null,"Please Select A Single Row of Data!");
            }
        }        
    }//GEN-LAST:event_modifyBtnActionPerformed

    private void clearSearchBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearSearchBtn1ActionPerformed
        searchBar1.setText("");
        String searchStr = searchBar1.getText();
        searchQuotationTable(searchStr);
        DefaultTableModel tableModel = (DefaultTableModel) quotationTable.getModel();
        tableModel.setRowCount(0);
        SalesOrderQuotation.importDataToTable(quotations, quotationTable); 
        filterData(quotationTable,"Pending");
    }//GEN-LAST:event_clearSearchBtn1ActionPerformed

    private void dltBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dltBtnActionPerformed
        if(quotationTable.getSelectionModel().isSelectionEmpty()==false){
            int column = 0;
            int row = quotationTable.getSelectedRow();
            String salesId = quotationTable.getModel().getValueAt(quotationTable.convertRowIndexToModel(row), column).toString();

            quotations = SalesOrderQuotation.DeleteData(quotations, salesId);
            SalesOrderQuotation.importDataToTable(quotations, quotationTable);
            JOptionPane.showMessageDialog(null,"Selected Row has Been Deleted!");
        } 
        else {
        JOptionPane.showMessageDialog(null,"Please select a row!");
        }
               
    }//GEN-LAST:event_dltBtnActionPerformed

    private void customerNameTxt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerNameTxt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerNameTxt2ActionPerformed

    private void customerContactNoTxt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerContactNoTxt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerContactNoTxt2ActionPerformed
  
    private void furnitureTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_furnitureTableMouseClicked
    
        DefaultTableModel model = (DefaultTableModel) furnitureTable.getModel();
        int selectedRow = furnitureTable.getSelectedRow();
        // get selected row data
        if (selectedRow != -1) {
            String itemName = model.getValueAt(selectedRow, 0).toString();
            String itemType = model.getValueAt(selectedRow, 1).toString();
            String deliveryFee = model.getValueAt(selectedRow, 2).toString();
            String discount = model.getValueAt(selectedRow, 3).toString();
            String price = model.getValueAt(selectedRow, 4).toString();
            // set data to text
            itemNameTxt2.setText(itemName);
            itemTypeTxt2.setText(itemType);
            deliveryFeeTxt2.setText(deliveryFee);
            discountTxt2.setText(discount);
            priceTxt2.setText(price);
        }
    
    
    
    
   
    }//GEN-LAST:event_furnitureTableMouseClicked
  
    private void salesIdTxt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesIdTxt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salesIdTxt2ActionPerformed

    private void searchBar2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchBar2FocusGained
        searchBar2.setText("");
    }//GEN-LAST:event_searchBar2FocusGained

    private void searchBar2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBar2KeyReleased

        String searchStr = searchBar2.getText();
        searchFurnitureTable(searchStr);
    }//GEN-LAST:event_searchBar2KeyReleased

    private void clearSearchBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearSearchBtn2ActionPerformed
        searchBar2.setText("");
        String searchStr = searchBar2.getText();
        searchFurnitureTable(searchStr);
        DefaultTableModel tableModel = (DefaultTableModel) furnitureTable.getModel();
        tableModel.setRowCount(0);
        Furniture.setDataToTable(furnitures, furnitureTable); 
        
        
    }//GEN-LAST:event_clearSearchBtn2ActionPerformed

    private void searchBar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBar2ActionPerformed

    private void salesIdTxt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesIdTxt3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salesIdTxt3ActionPerformed

    private void customerContactNoTxt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerContactNoTxt3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerContactNoTxt3ActionPerformed

    private void customerNameTxt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerNameTxt3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerNameTxt3ActionPerformed

    private void clearBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtn2ActionPerformed
        customerNameTxt2.setText("");
        customerContactNoTxt2.setText("");
        customerAddressTxt2.setText("");
        itemNameTxt2.setText("");
        itemTypeTxt2.setText("");
        deliveryFeeTxt2.setText("");
        discountTxt2.setText("");
        priceTxt2.setText("");
    }//GEN-LAST:event_clearBtn2ActionPerformed

    private void addBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtn2ActionPerformed
    // Check if row is selected
    if (furnitureTable.getSelectedRow() == -1) {
        JOptionPane.showMessageDialog(null, "Please select furniture to add to quotation!");
        return;
    }
    //data validation
    if (customerNameTxt2.getText().equals("") || customerContactNoTxt2.getText().equals("") || 
            customerAddressTxt2.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Please Enter Required Data!");
    } else if (!SalesOrderQuotation.isValidCustomerName(customerNameTxt2.getText())) {
        JOptionPane.showMessageDialog(null, "Please enter a valid customer name (alphabets only)!");
    } else if (!SalesOrderQuotation.isValidCustomerPhoneNumber(customerContactNoTxt2.getText())) {
        JOptionPane.showMessageDialog(null, "Please enter a valid phone number!");
    } else if (!SalesOrderQuotation.isValidCustomerAddress(customerAddressTxt2.getText())) {
        JOptionPane.showMessageDialog(null, "Please enter a valid customer address!");
    } else {
        String salesId = salesIdTxt2.getText();
        String salesPersonId = salespersonTxt2.getText();
        String date = dateTxt2.getText();
        String customerName = customerNameTxt2.getText();
        String customerContactNo = customerContactNoTxt2.getText();
        String customerAddress = customerAddressTxt2.getText().replace("\n", " ");
        String itemName = itemNameTxt2.getText();
        String itemType = itemTypeTxt2.getText();
        String deliveryFee = deliveryFeeTxt2.getText();
        String discount = discountTxt2.getText();
        String price = priceTxt2.getText();
        String quantity =  quantityTxt2.getSelectedItem().toString();
        String status = "Pending";

        quotations.add(new SalesOrderQuotation(salesId, salesPersonId, date, customerName, customerContactNo, 
                customerAddress, itemName, itemType, deliveryFee, discount, price, quantity, status));

        try {
            SalesOrderQuotation.WriteNewData(quotations);
            SalesOrderQuotation.importDataToTable(quotations, quotationTable);
            filterData(quotationTable,"Pending");         
            JOptionPane.showMessageDialog(null, "The Data has been successfully Added!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: Unable to save data. Please try again later.");
            e.printStackTrace();
        }

        // reset txt field
        salesIdTxt2.setText("");
        salespersonTxt2.setText(salesPersonId);
        dateTxt2.setText("");
        customerNameTxt2.setText("");
        customerContactNoTxt2.setText("");
        customerAddressTxt2.setText("");
        itemTypeTxt2.setText("");
        itemNameTxt2.setText("");
        deliveryFeeTxt2.setText("");
        discountTxt2.setText("");
        priceTxt2.setText("");
        quantityTxt2.setSelectedItem("");
        // New id fills in
        salesIdNo();
        setDate();
    }  
    }//GEN-LAST:event_addBtn2ActionPerformed

    private void dateTxt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateTxt3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateTxt3ActionPerformed

    private void clearBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtn1ActionPerformed
        salesIdTxt3.setText("");
        salespersonTxt3.setText("");
        customerNameTxt3.setText("");
        customerContactNoTxt3.setText("");
        customerAddressTxt3.setText("");
        itemTypeTxt3.setText("");
        itemNameTxt3.setText("");
        deliveryFeeTxt3.setText("");
        discountTxt3.setText("");
        priceTxt3.setText("");
        dateTxt3.setText("");
    }//GEN-LAST:event_clearBtn1ActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
         
        String salesId = salesIdTxt3.getText();
        String salesPersonId = salespersonTxt3.getText();
        String date = dateTxt3.getText();
        String customerName = customerNameTxt3.getText();
        String customerContactNo = customerContactNoTxt3.getText();
        String customerAddress = customerAddressTxt3.getText().replace("\n", " ");
        String itemName = itemNameTxt3.getText();
        String itemType = itemTypeTxt3.getText();
        String deliveryFee = deliveryFeeTxt3.getText();
        String discount = discountTxt3.getText();
        String price = priceTxt3.getText();
        String quantity =  quantityTxt1.getSelectedItem().toString();
        String status = "Pending";
        
        try {
            quotations = new SalesOrderQuotation(salesId, salesPersonId, date, customerName, customerContactNo, 
            customerAddress, itemName, itemType, deliveryFee, discount, price, quantity, status).UpdateData(quotations, salesId);
            JOptionPane.showMessageDialog(null, "Quotation Detail Has Been Successfully Modified!");
            SalesOrderQuotation.importDataToTable(quotations, quotationTable);
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: Unable to modify data");
            e.printStackTrace(); 
        }
        
        //reset txt field
        salesIdTxt3.setText("");
        salespersonTxt3.setText("");
        dateTxt3.setText("");
        customerNameTxt3.setText("");
        customerContactNoTxt3.setText("");
        customerAddressTxt3.setText("");
        itemTypeTxt3.setText("");
        itemNameTxt3.setText("");
        deliveryFeeTxt3.setText("");
        discountTxt3.setText("");
        priceTxt3.setText("");
        quantityTxt1.setSelectedItem("");
    }//GEN-LAST:event_updateBtnActionPerformed

    private void quantityTxt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityTxt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityTxt2ActionPerformed

    private void quotationTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quotationTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_quotationTableMouseClicked

    private void generateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateBtnActionPerformed
        int selectedRow = quotationTable.getSelectedRow();
    
        // Check if row selected
        if (selectedRow != -1) {
            // Convert the displayed row index to the model row index so that easy transfer
            int modelRow = quotationTable.convertRowIndexToModel(selectedRow);
            // Get data from the filtered table
            String[] rowData = new String[quotationTable.getModel().getColumnCount()];
            for (int i = 0; i < quotationTable.getModel().getColumnCount(); i++) {
                rowData[i] = (String) quotationTable.getModel().getValueAt(modelRow, i);
            }

            //quotation screen
            quotation quotationScreen = new quotation(rowData);
            quotationScreen.setVisible(true);
        }
    }//GEN-LAST:event_generateBtnActionPerformed

    private void salespersonTxt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salespersonTxt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salespersonTxt2ActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        salespersonMainpage mainpage = new salespersonMainpage(ls);
        mainpage.show();
        dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void searchBar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBar1ActionPerformed
    
  
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
//            java.util.logging.Logger.getLogger(Manage_Sale_Order_Quotation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Manage_Sale_Order_Quotation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Manage_Sale_Order_Quotation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Manage_Sale_Order_Quotation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Manage_Sale_Order_Quotation(ls).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn2;
    private javax.swing.JTextField addfidTF2;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton clearBtn1;
    private javax.swing.JButton clearBtn2;
    private javax.swing.JButton clearSearchBtn1;
    private javax.swing.JButton clearSearchBtn2;
    private javax.swing.JTextArea customerAddressTxt2;
    private javax.swing.JTextArea customerAddressTxt3;
    private javax.swing.JTextField customerContactNoTxt2;
    private javax.swing.JTextField customerContactNoTxt3;
    private javax.swing.JTextField customerNameTxt2;
    private javax.swing.JTextField customerNameTxt3;
    private javax.swing.JLabel dateTF;
    private javax.swing.JTextField dateTxt2;
    private javax.swing.JTextField dateTxt3;
    private javax.swing.JTextField deliveryFeeTxt2;
    private javax.swing.JTextField deliveryFeeTxt3;
    private javax.swing.JTextField discountTxt2;
    private javax.swing.JTextField discountTxt3;
    private javax.swing.JButton dltBtn;
    private javax.swing.JTable furnitureTable;
    private javax.swing.JButton generateBtn;
    private javax.swing.JTextArea itemNameTxt2;
    private javax.swing.JTextArea itemNameTxt3;
    private javax.swing.JTextArea itemTypeTxt2;
    private javax.swing.JTextArea itemTypeTxt3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton modifyBtn;
    private javax.swing.JTextField priceTxt2;
    private javax.swing.JTextField priceTxt3;
    private javax.swing.JComboBox<String> quantityTxt1;
    private javax.swing.JComboBox<String> quantityTxt2;
    private javax.swing.JTable quotationTable;
    private javax.swing.JTextField salesIdTxt2;
    private javax.swing.JTextField salesIdTxt3;
    private javax.swing.JTextField salespersonTxt2;
    private javax.swing.JTextField salespersonTxt3;
    private javax.swing.JTextField searchBar1;
    private javax.swing.JTextField searchBar2;
    private javax.swing.JLabel timeTF;
    private javax.swing.JButton updateBtn;
    private javax.swing.JLabel usernameTxt;
    // End of variables declaration//GEN-END:variables
}
