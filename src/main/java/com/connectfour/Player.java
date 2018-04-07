package com.connectfour;

public class Player {
	private String name;
    private String color;
    
    public Player(){
        this.name = null;
        color = "None";
    }

    public Player(String name){
        this.name = name;
        color = "None";
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
    	if(!color.equals("red") && !color.equals("green"))
    		throw new IllegalArgumentException("Wrong color name");
    	
        this.color = color;
    }
}
