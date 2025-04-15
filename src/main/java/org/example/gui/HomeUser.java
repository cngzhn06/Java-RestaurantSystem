package org.example.gui;

import org.example.model.Customer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class HomeUser extends Base {

    private JComboBox<String> comboBox1; // Example for other interactions
    private JTable table1;
    private JPanel panel1;

    public HomeUser(Customer customer) {
        super("Home User");
        add(panel1);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Field");
        model.addColumn("Value");

        if (customer != null) {
            model.addRow(new Object[]{"ID", customer.getId()});
            model.addRow(new Object[]{"First Name", customer.getFirstName()});
            model.addRow(new Object[]{"Last Name", customer.getLastName()});
            model.addRow(new Object[]{"Phone", customer.getPhone()});
            model.addRow(new Object[]{"Email", customer.getEmail()});
            model.addRow(new Object[]{"Type", customer.type});
            model.addRow(new Object[]{"TC", customer.getTC()});
        }

        table1.setModel(model);
    }
}
