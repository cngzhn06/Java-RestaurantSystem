package org.example.model;

public class Meal{
    private int id;
    private String name;
    private int price;

    public Meal(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

