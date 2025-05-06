package org.example.gui;

import org.example.model.Cities;
import org.example.model.Town;
import org.example.model.Restaurant;
import org.example.service.CityDAO;
import org.example.service.TownDAO;
import org.example.service.RestaurantDAO;
import org.example.service.MealDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchRestaurant extends Base {
    private JPanel panel1;
    private JComboBox comboBox1; // Şehir
    private JComboBox comboBox2; // İlçe
    private JComboBox comboBox3; // Restoran
    private JComboBox comboBox4; // Yemek
    private JButton backButton;
    private JButton button1;

    private CityDAO cityDAO = new CityDAO();
    private TownDAO townDAO = new TownDAO();
    private RestaurantDAO restaurantDAO = new RestaurantDAO();
    private MealDAO mealDAO = new MealDAO();

    public SearchRestaurant() {
        super("Search Restaurant");
        add(panel1);

        // Şehirleri combobox1 içine ekleyelim
        for (Cities city : cityDAO.getAllCity()) {
            comboBox1.addItem(city.getName());
        }

        // Şehir seçildiğinde ilçeleri ekle
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBox2.removeAllItems();

                String selectedCityName = (String) comboBox1.getSelectedItem();
                Cities selectedCity = cityDAO.getAllCity().stream()
                        .filter(city -> city.getName().equals(selectedCityName))
                        .findFirst()
                        .orElse(null);

                if (selectedCity != null) {
                    for (Town town : townDAO.getTownsByCityId(selectedCity.getId())) {
                        comboBox2.addItem(town.getName());
                    }
                }
            }
        });

        // İlçe seçildiğinde restoranları ekle
        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBox3.removeAllItems();

                String selectedTownName = (String) comboBox2.getSelectedItem();
                Town selectedTown = townDAO.getAllTown().stream()
                        .filter(town -> town.getName().equals(selectedTownName))
                        .findFirst()
                        .orElse(null);

                if (selectedTown != null) {
                    for (Restaurant restaurant : restaurantDAO.getAllRestaurant()) {
                        if (restaurant.getTownId() == selectedTown.getId()) {
                            comboBox3.addItem(restaurant.getName());
                        }
                    }
                }
            }
        });

        // Restoran seçildiğinde yemekleri ekle
        comboBox3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBox4.removeAllItems();

                String selectedRestaurantName = (String) comboBox3.getSelectedItem();
                Restaurant selectedRestaurant = restaurantDAO.getAllRestaurant().stream()
                        .filter(restaurant -> restaurant.getName().equals(selectedRestaurantName))
                        .findFirst()
                        .orElse(null);

                if (selectedRestaurant != null) {
                    for (String meal : restaurantDAO.getMealsByRestaurantId(selectedRestaurant.getId())) {
                        comboBox4.addItem(meal);
                    }
                }
            }
        });

        // Geri düğmesi
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NavigationManager.showHomeAdminForm();
            }
        });

    }
}
