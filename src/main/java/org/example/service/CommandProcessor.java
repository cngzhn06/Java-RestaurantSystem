package org.example.service;

import org.example.model.*;

import java.util.*;


public class CommandProcessor {
    private static final List<Customer> customers = new ArrayList<>();

    public static void processCommands() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("örnek komutlar \n\n");
        System.out.println("ADDCUSTOMER 1 Cengizhan Caliskan 5554443322 cq@gmail.com");
        System.out.println("LISTCUSTOMERS");
        System.out.println("LISTALLCHOICES");
        System.out.println("EXIT");

        while (true) {
            System.out.print("\nKOMUT: ");
            String line = scanner.nextLine();

            if (line.equalsIgnoreCase("EXIT")) {
                System.out.println("cikis yapiliyor...");
                break;
            }

            String[] parts = line.trim().split("\\s+");
            String command = parts[0];

            switch (command) {
                case "ADDCUSTOMER":
                    addCustomer(parts);
                    break;
                case "LISTCUSTOMERS":
                    listCustomers();
                    break;
                case "LISTALLCHOICES":
                    listAllChoices();
                    break;
                default:
                    System.out.println("belirsiz komut: " + command);
                    break;
            }
        }
        scanner.close();
    }

    public static void addCustomer(String[] parts) {
        int customerId = Integer.parseInt(parts[1]);
        String firstName = parts[2];
        String lastName = parts[3];
        String phone = parts[4];
        String email = parts[5];
        customers.add(new Customer(customerId, firstName, lastName, phone, email));
        System.out.println("BASARILI");
    }

    private static void listCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
    }

    private static void listAllChoices() {
        for (Restaurant restaurant : DataLoader.getRestaurants().values()) {
            Town town = DataLoader.getTowns().get(restaurant.getTownId());
            Cities cities = DataLoader.getCities().get(town.getCityId());

            System.out.println("Restoran: " + restaurant.getName() + " (Şehir: " + cities.getName() + ", İlçe: " + town.getName() + ")");
            for (int mealId : restaurant.getMealIds()) {
                Meal meal = DataLoader.getMeals().get(mealId);
                if (meal != null) {
                    System.out.println("ID: " + meal.getId() + " Meal: " + meal.getName() + " - " + meal.getPrice() + " TL");
                }
            }
        }

    }
}
