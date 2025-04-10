package org.example.service;

import org.example.model.*;

import java.io.*;
import java.util.*;

public class DataLoader {
    private static final Map<Integer, Cities> cities = new HashMap<>();
    private static final Map<Integer, Meal> meals = new HashMap<>();
    private static final Map<Integer, Restaurant> restaurants = new HashMap<>();
    private static final Map<Integer, Town> towns = new HashMap<>();


    public static void loadCities(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\s+", 3);
            int id = Integer.parseInt(parts[0]);
            String name = parts[1];
            int code = Integer.parseInt(parts[2]);
            cities.put(id, new Cities(id, name, code));
        }
        reader.close();
    }


    public static void loadMeals(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\t");
            int id = Integer.parseInt(parts[0]);
            String name = parts[1];
            int price = Integer.parseInt(parts[2]);
            meals.put(id, new Meal(id, name, price));
        }
        reader.close();
    }

    public static void loadRestaurants(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\t");
            int id = Integer.parseInt(parts[0]);
            String name = parts[1];
            int townId = Integer.parseInt(parts[2]);
            int postalCode = Integer.parseInt(parts[3]);
            String openTime = parts[4];
            String closeTime = parts[5];

            List<Integer> mealIds = new ArrayList<>();
            for (int i = 6; i < parts.length; i++) {
                if (!parts[i].isEmpty()) {
                    mealIds.add(Integer.parseInt(parts[i]));
                }
            }

            restaurants.put(id, new Restaurant(id, name, townId, postalCode, openTime, closeTime, mealIds));
        }
        reader.close();
    }

    public static void loadTowns(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\t");
            int id = Integer.parseInt(parts[0]);
            int cityId = Integer.parseInt(parts[1]);
            String name = parts[2];
            int code = Integer.parseInt(parts[3]);
            towns.put(id, new Town(id, cityId, name, code));
        }
        reader.close();
    }

    public static Map<Integer, Cities> getCities() {
        return cities;
    }

    public static Map<Integer, Meal> getMeals() {
        return meals;
    }

    public static Map<Integer, Restaurant> getRestaurants() {
        return restaurants;
    }

    public static Map<Integer, Town> getTowns() {
        return towns;
    }
}
