package org.example.model;

public class Town {
    private int id;
    private int cityId;
    private String name;
    private int code;
    private String cityName;

    public Town(int id, int cityId, String name, int code, String cityName) {
        this.id = id;
        this.cityId = cityId;
        this.name = name;
        this.code = code;
        this.cityName = cityName;
    }

    public Town(int id, int cityId, String name,String cityName) {
        this.id = id;
        this.cityId = cityId;
        this.name = name;
        this.cityName = cityName;
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
    public String getCityName() {
        return cityName;
    }

    public int getCode() {
        return code;
    }

}
