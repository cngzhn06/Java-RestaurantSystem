package org.example;

import org.example.service.DataLoader;
import org.example.service.CommandProcessor;

import java.io.IOException;

public class App {

    public static void main(String[] args) {
        try {
            DataLoader.loadCities("src/main/data/cities.txt");
            DataLoader.loadMeals("src/main/data/meals.txt");
            DataLoader.loadRestaurants("src/main/data/restaurants.txt");
            DataLoader.loadTowns("src/main/data/towns.txt");

            CommandProcessor.processCommands();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
