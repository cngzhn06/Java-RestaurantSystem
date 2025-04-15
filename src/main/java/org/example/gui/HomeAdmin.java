package org.example.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeAdmin extends Base{
    private JButton listCustomerButton;
    private JPanel panel1;
    private JButton listRestaurantButton;
    private JButton searchRestaurantButton;
    private JButton addMealButton;

    public HomeAdmin(){
        super("Restoran Sistemi");
        add(panel1);

        listCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NavigationManager.showListCustomerForm();
            }
        });
        listRestaurantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NavigationManager.showListRestaurantForm();
            }
        });
        searchRestaurantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NavigationManager.showSearchRestaurantForm();
            }
        });
    }
}
