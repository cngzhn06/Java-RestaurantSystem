package org.example;

import org.example.gui.NavigationManager;
import org.example.service.CityDAO;
import org.example.service.MealDAO;
import org.example.service.RestaurantDAO;
import org.example.service.TownDAO;

import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {

        TxtLogger.init();
//        TownDAO townDAO = new TownDAO();
//        townDAO.getTownsByCityId(6);


//        RestaurantDAO restaurantDAO = new RestaurantDAO();
//        restaurantDAO.getAllRestaurant();
//        List<String> meals = restaurantDAO.getMealsByRestaurantId(1);
//        System.out.println("Restoranın yemekleri: " + meals);

        NavigationManager.showHomeAdminForm();

    }
}
