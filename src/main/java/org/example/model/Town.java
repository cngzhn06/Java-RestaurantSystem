package org.example.model;

public class Town {
    private int id;
    private int cityId;
    private String name;
    private int code;

    public Town(int id, int cityId, String name, int code) {
        this.id = id;
        this.cityId = cityId;
        this.name = name;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public int getCityId() {
        return cityId;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }
}
