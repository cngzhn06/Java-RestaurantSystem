package org.example.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeUser extends Base {

    private JTable table1;
    private JPanel panel1;
    private JButton button1;

    public HomeUser() {
        super("Home User");
        add(panel1);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Field");
        model.addColumn("Value");

        table1.setModel(model);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NavigationManager.showLoginForm();
            }
        });
    }
}
