package com.mycompany.gui;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

        import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
/**
 *
 * @author Sfiso
 */


public class GUI extends JFrame{


    
    // Declare GUI components
    private JTextField txtCustomerName, txtPrice;
    private JComboBox<String> cmbProducts;
    private JButton btnProcess;

    public GUI() {
        // Set up basic frame properties
        setTitle("Product App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Q2.4: Create Menu Bar (File -> Exit, Tools -> Process, Clear)
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenuItem itemExit = new JMenuItem("Exit");
        menuFile.add(itemExit);

        JMenu menuTools = new JMenu("Edit");
        JMenuItem itemProcess = new JMenuItem("Process");
        JMenuItem itemClear = new JMenuItem("Clear");
        menuTools.add(itemProcess);
        menuTools.add(itemClear);

        menuBar.add(menuFile);
        menuBar.add(menuTools);
        setJMenuBar(menuBar);

        // Customer Name Label & Text Field
        JLabel lblName = new JLabel("Customer Name:");
        lblName.setBounds(30, 30, 120, 25);
        add(lblName);

        txtCustomerName = new JTextField();
        txtCustomerName.setBounds(160, 30, 180, 25);
        add(txtCustomerName);

        // Product Selection ComboBox
        JLabel lblProduct = new JLabel("Select Product:");
        lblProduct.setBounds(30, 70, 120, 25);
        add(lblProduct);

        String[] products = {
            "Cozy Nights Monarch", 
            "Restonic Barbados", 
            "Sealy Phuket"
        };
        cmbProducts = new JComboBox<>(products);
        cmbProducts.setBounds(160, 70, 180, 25);
        add(cmbProducts);

        // Price Label & Text Field
        JLabel lblPrice = new JLabel("Enter Price:");
        lblPrice.setBounds(30, 110, 120, 25);
        add(lblPrice);

        txtPrice = new JTextField();
        txtPrice.setBounds(160, 110, 180, 25);
        add(txtPrice);

        // Process Button
        btnProcess = new JButton("PROCESS");
        btnProcess.setBounds(30, 160, 310, 30);
        add(btnProcess);

        // --- EVENT HANDLERS ---

        // When Process button is clicked
        btnProcess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processSalesData();
            }
        });

        // Menu Item Listeners (Q2.4)
        itemExit.addActionListener(e -> System.exit(0)); // Close app
        itemProcess.addActionListener(e -> processSalesData()); // Call same logic
        itemClear.addActionListener(e -> clearFields()); // Clear textboxes and reset combo box
    }

    // Core processing logic for button and menu
    private void processSalesData() {
        try {
            // Read input fields
            String customerName = txtCustomerName.getText();
            String selectedProduct = (String) cmbProducts.getSelectedItem();
            double price = Double.parseDouble(txtPrice.getText());

            // Instantiate calculations class
            ProductCalculations calc = new ProductCalculations(price);
            double vat = calc.GetVAT();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

            // Q2.1 / Q2.3: Display message dialog matching the sample output
            String message = "Customer Name: " + customerName + "\n" +
                             "Product: " + selectedProduct + "\n" +
                             "VAT: R " + vat + "\n" +
                             "COMMISSION: R " + commission + "\n" +
                             "TOTAL: R " + total;
            
            JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);

            // Q2.3: Save details to data.txt file
            saveToFile(customerName, selectedProduct, vat, commission, total);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric price!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Helper method to clear the form
    private void clearFields() {
        txtCustomerName.setText("");
        txtPrice.setText("");
        cmbProducts.setSelectedIndex(0); // Set combo box index back to 0
    }

    // Helper method to write log data into data.txt
    private void saveToFile(String name, String product, double vat, double commission, double total) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("data.txt", true))) {
            writer.println("DATA LOG");
            writer.println("**************************************************");
            writer.println("Customer Name: " + name);
            writer.println("Product: " + product);
            writer.println("VAT: R " + vat);
            writer.println("COMMISSION: R " + commission);
            writer.println("TOTAL: R " + total);
            writer.println("**************************************************");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving file!", "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }



   public static void main(String[] args) {
       
       // Launch GUI Window
      new GUI().setVisible(true);
    }
    
}
