package org.example.model;

import java.util.List;

public class Restaurant {
    private int id;
    private String name;
    private int townId;
    private int postalCode;
    private String openTime;
    private String closeTime;
    private List<Integer> mealIds;

    private String townName;

    public Restaurant(int id, String name, int townId, int postalCode,String openTime,String closeTime, String townName) {
        this.id = id;
        this.name = name;
        this.townId = townId;
        this.postalCode = postalCode;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.townName = townName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTownId() {
        return townId;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getOpenTime() {
        return openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public String getTownName() {
        return townName;
    }

    public List<Integer> getMealIds() {
        return mealIds;
    }
}