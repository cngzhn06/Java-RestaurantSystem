package org.example.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends Base{
    private JButton addCustomerButton;
    private JButton listCustomerButton;
    private JPanel panel1;

    public Home(){
        super("Restoran Sistemi");
        add(panel1);
        addCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NavigationManager.showAddCustomerForm();
            }
        });
        listCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NavigationManager.showListCustomerForm();
            }
        });
    }
}
