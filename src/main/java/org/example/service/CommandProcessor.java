package org.example.service;

import org.example.model.*;

import java.io.*;
import java.util.*;

public class CommandProcessor {
    private static final List<Customer> customers = new ArrayList<>();
    private static int lastCustomerId = 0;

    static {
        loadLastCustomerId();
    }

    private static void loadLastCustomerId() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/data/customers.txt"))) {
            String line;
            int maxId = 0;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\t");
                if (data.length == 5) {
                    int id = Integer.parseInt(data[0]);
                    maxId = Math.max(maxId, id);
                }
            }
            lastCustomerId = maxId;
        } catch (IOException e) {
            System.err.println("Error loading last customer ID: " + e.getMessage());
        }
    }


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
            System.out.println("Added " + customer);
        } catch (IOException e) {
            System.err.println("File error: " + e.getMessage());
        }
    }


}
