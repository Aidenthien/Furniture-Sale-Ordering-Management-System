/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package officer_role;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mahpi
 */
public class UpdateSalesOrderData {
    
    static void saleData(DefaultTableModel model, JTable tableSaleOrder){
        String[] columnNames = {"Sales ID", "Salesperson ID", "Date", "Cus Name",
            "Cus Contact", "Cus Address", "Item Name", "Item Type", 
            "Delivery Fee", "Discount", "Unit Price", "Qty", "Approval Status", "Product Status"};
        model.setColumnIdentifiers(columnNames);
        
        try (BufferedReader reader = new BufferedReader(new FileReader("sales_data.txt"))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] rowData = line.split(", ");
                if(!"Approved".equals(rowData[12])){
                    model.addRow(rowData);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing the data to a file: " + e.toString());
        }
        
        tableSaleOrder.setModel(model);
        tableSaleOrder.setDefaultEditor(Object.class, null); // Make the table non-editable
    }
    
    public static boolean updateSalesData
            (String salesID, 
            String cusName,
            String cusContact, 
            String cusAddress,
            String itemType, 
            String itemName, 
            String qty, 
            String delivery, 
            String discount,
            String price, 
            String changedApprovalStatus,
            String reason) 
    {
        try {
            File inputFile = new File("sales_data.txt");
            File tempFile = new File("tempData.txt");

            BufferedWriter writer;
            boolean found;
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
                writer = new BufferedWriter(new FileWriter(tempFile));
                String line;
                found = false;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(", ");
                    if (parts.length > 1 && parts[0].equals(salesID)) {
                        parts[3] = cusName;
                        parts[4] = cusContact;
                        parts[5] = cusAddress;
                        parts[6] = itemName;
                        parts[7] = itemType;
                        parts[8] = delivery;
                        parts[9] = discount;
                        parts[10] = price;
                        parts[11] = qty;
                        parts[12] = changedApprovalStatus;
                        parts[14] = reason;
                        line = String.join(", ", parts);
                        found = true;
                    }
                    writer.write(line + System.lineSeparator());
                }
            }
            writer.close();

            if (found) {
                if (!inputFile.delete()) {
                    JOptionPane.showMessageDialog(null, "Could not delete the original file.", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                if (!tempFile.renameTo(inputFile)) {
                    JOptionPane.showMessageDialog(null, "Could not rename the temporary file.", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                JOptionPane.showMessageDialog(null, "Sale Order Updated.", salesID, JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Sales ID not found in the data.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
