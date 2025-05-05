package org.example;

import org.example.gui.NavigationManager;
import org.example.service.CityDAO;
import org.example.service.MealDAO;
import org.example.service.RestaurantDAO;
import org.example.service.TownDAO;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {

        TxtLogger.init();
        CityDAO cdao = new CityDAO();
        cdao.getAllCity();
        NavigationManager.showLoginForm();

    }
}
