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
        NavigationManager.showLoginForm();

    }
}
