package com.connectfour;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private String color;
    private List<String> availableColors;

    public Cell() {
        color = null;
        availableColors = new ArrayList<>();
        availableColors.add("red");
        availableColors.add("green");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
    	if(!availableColors.contains(color.toLowerCase()))
    		throw new IllegalArgumentException("Wrong color name");
        this.color = color.toLowerCase();
    }

}
