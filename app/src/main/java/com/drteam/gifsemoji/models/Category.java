package com.drteam.gifsemoji.models;

import java.util.List;

/**
 * Created by truongpq on 06/04/2017.
 */

public class Category {
    private String name;
    private List<String> sub;

    public Category() {
    }

    public Category(String name, List<String> sub) {
        this.name = name;
        this.sub = sub;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSub() {
        return sub;
    }

    public void setSub(List<String> sub) {
        this.sub = sub;
    }
}
