package org.example.model;

import java.util.List;

public class Cities {
    private int id;
    private String name;
    private int code;

    private List<Integer> townIds;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public Cities(int id, String name, int code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }
}
