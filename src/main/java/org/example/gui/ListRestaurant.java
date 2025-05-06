package org.example.gui;

import org.example.model.Restaurant;
import org.example.service.RestaurantDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ListRestaurant extends Base{
    private JPanel panel1;
    private JTable table1;
    private JScrollPane scrollPane1;
    private JButton button1;


    public ListRestaurant(){
        super("Restoran Sistemi");
        add(scrollPane1);

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new Object[]{"Name", "Open Time", "Close Time", "Town Name", "Postal Code"});
        table1.setModel(tableModel);

        table1.setPreferredScrollableViewportSize(new Dimension(450,63));


        try {
            RestaurantDAO restaurantDAO = new RestaurantDAO();
            List<Restaurant> restaurants = restaurantDAO.getAllRestaurant();
            for (Restaurant restaurant : restaurants) {
                tableModel.addRow(new Object[]{
                        restaurant.getName(),
                        restaurant.getOpenTime(),
                        restaurant.getCloseTime(),
                        restaurant.getTownName(),
                        restaurant.getPostalCode()
                });
            }
        } catch (Exception e) {
            System.err.println("Veri yükleme hatası: " + e.getMessage());
        }

        table1.setModel(tableModel);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NavigationManager.showHomeAdminForm();
            }
        });
    }
}