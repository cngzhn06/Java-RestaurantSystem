package org.example.gui;

import org.example.model.Customer;
import org.example.service.CustomerDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static org.example.gui.NavigationManager.hideAllForms;

public class ListCustomer extends Base {
    private JPanel panel1;

    private JTable table1;
    private JButton backButton;
    private JButton removeButton;
    private JButton updateButton;
    private JScrollPane scrollPane;

    public ListCustomer() {
        super("Restoran Sistemi");
        add(scrollPane);

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new Object[]{ "Ad", "Soyad", "Telefon", "Email","TC"});
        table1.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Ad", "Soyad", "Telefon", "Email", "TC"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        });

        table1.setPreferredScrollableViewportSize(new Dimension(450,63));



        try {
            CustomerDAO customerDAO = new CustomerDAO();
            List<Customer> customers = customerDAO.getAllCustomers();
            for (Customer customer : customers) {
                tableModel.addRow(new Object[]{
                        customer.getFirstName(),
                        customer.getLastName(),
                        customer.getPhone(),
                        customer.getEmail(),
                        customer.getTC()
                });
            }
        } catch (Exception e) {
            System.err.println("Veri yükleme hatası: " + e.getMessage());
        }

        table1.setModel(tableModel);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NavigationManager.showHomeAdminForm();
            }
        });
    }
}
