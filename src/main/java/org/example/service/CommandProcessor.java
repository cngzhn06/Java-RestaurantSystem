package org.example.service;

import org.example.model.*;

import java.io.*;
import java.util.*;

public class CommandProcessor {
    private static final List<Customer> customers = new ArrayList<>();

    private static int lastCustomerId = 0;

//    public static void processCommands() {
//        loadExistingCustomers();
//        Scanner scanner = new Scanner(System.in);

//        System.out.println("Komutlar: \n");
//        System.out.println("1 - Müşteri ekle");
//        System.out.println("2 - Müşterileri listele");
//        System.out.println("3 - Tüm seçimleri listele");
//        System.out.println("4 - Çıkış");

//        while (true) {
//            System.out.print("\nSEÇİM: ");
//            int selection = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (selection) {
//                case 1:
//                    addCustomerWithDetails(scanner);
//                    break;
//                case 2:
//                    listCustomers();
//                    break;
//                case 3:
//                    listAllChoices();
//                    break;
//                case 4:
//                    System.out.println("exit");
//                    scanner.close();
//                    return;
//                default:
//                    System.out.println("invalid choice: " + selection);
//                    break;
//            }
//        }
//    }
//
//
//    private static void loadExistingCustomers() {
//        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/data/customers.txt"))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split("\\t");
//                int id = Integer.parseInt(parts[0]);
//                String firstName = parts[1];
//                String lastName = parts[2];
//                String phone = parts[3];
//                String email = parts[4];
//
//                customers.add(new Customer(id, firstName, lastName, phone, email));
//                lastCustomerId = Math.max(lastCustomerId, id);
//            }
//        } catch (IOException e) {
//            System.out.println("customer.txt okunmadı: " + e.getMessage());
//        }
//    }
//
//    private static void addCustomerWithDetails(Scanner scanner) {
//        try {
//            System.out.print("Adı: ");
//            String firstName = scanner.nextLine();
//            System.out.print("Soyadı: ");
//            String lastName = scanner.nextLine();
//            System.out.print("Telefon: ");
//            String phone = scanner.nextLine();
//            System.out.print("Email: ");
//            String email = scanner.nextLine();
//
//            int customerId = ++lastCustomerId;
//            Customer customer = new Customer(customerId, firstName, lastName, phone, email);
//            customers.add(customer);
//
//
//            try (FileWriter writer = new FileWriter("src/main/data/customers.txt", true)) {
//                writer.write(customer.getId() + "\t"
//                        + customer.getFirstName() + "\t"
//                        + customer.getLastName() + "\t"
//                        + customer.getPhone() + "\t"
//                        + customer.getEmail() + "\n");
//            }
//
//            System.out.println("eklend");
//        } catch (IOException e) {
//            System.out.println("file error: " + e.getMessage());
//        }
//    }

    public static void addCustomer(String firstName, String lastName, String phone, String email) {
        try {
            int customerId = ++lastCustomerId;
            Customer customer = new Customer(customerId, firstName, lastName, phone, email);
            customers.add(customer);

            try (FileWriter writer = new FileWriter("src/main/data/customers.txt", true)) {
                writer.write(customer.getId() + "\t"
                        + customer.getFirstName() + "\t"
                        + customer.getLastName() + "\t"
                        + customer.getPhone() + "\t"
                        + customer.getEmail() + "\n");
            }
            System.out.println("eklendi " + customer);
        } catch (IOException e) {
            System.out.println("file error " + e.getMessage());
        }
    }

//    private static void listCustomers() {
//        System.out.println("müsteriler:");
//        for (Customer customer : customers) {
//            System.out.println(customer);
//        }
//    }
//
//    private static void listAllChoices() {
//        for (Restaurant restaurant : DataLoader.getRestaurants().values()) {
//            Town town = DataLoader.getTowns().get(restaurant.getTownId());
//            Cities cities = DataLoader.getCities().get(town.getCityId());
//
//            System.out.println(restaurant.getName() + " ( " + cities.getName() + "," + town.getName() + ")");
//            for (int mealId : restaurant.getMealIds()) {
//                Meal meal = DataLoader.getMeals().get(mealId);
//                if (meal != null) {
//                    System.out.println("ID:" + meal.getId() + " : " + meal.getName() + " - " + meal.getPrice());
//                }
//            }
//        }
//    }
}
