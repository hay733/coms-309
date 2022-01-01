package com.example.springboottests.Apples;

public class Apple {

    private String color;
    private String type;

    public Apple() {

    }

    public Apple(String color, String type) {
        this.color = color;
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Color: " + color + "\n" +
                "Type: " + type;
    }
}
