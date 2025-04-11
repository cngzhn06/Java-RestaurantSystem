package org.example.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import static org.example.gui.NavigationManager.hideAllForms;

public class ListCustomer extends Base{
    private JPanel panel1;
    private JTable table1;
    private JButton backButton;
    private JButton deleteButton;
    private JButton addButton;

    public ListCustomer() {
        super("Restoran Sistemi");
        add(panel1);

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new Object[]{"ID", "Ad", "Soyad", "Telefon", "Email"});

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/data/customers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\t");
                if (data.length == 5) {
                    tableModel.addRow(data);
                } else {
                    System.err.println("hatalı veri formati: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("yuklenme hatasi: " + e.getMessage());
        }
        table1.setModel(tableModel);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backButton();
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideAllForms();
                NavigationManager.showAddCustomerForm();
            }
        });
    }
}
