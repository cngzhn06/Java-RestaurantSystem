package org.example;

import org.example.gui.NavigationManager;
import org.example.service.MealDAO;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {

        TxtLogger.init();
        MealDAO meal = new MealDAO();
        meal.getAllMeals();
        NavigationManager.showLoginForm();

    }
}
