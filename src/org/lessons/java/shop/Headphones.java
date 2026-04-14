package org.lessons.java.shop;

import java.math.BigDecimal;

public class Headphones extends Product {
    private String color;
    private boolean isWirless;

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // public void setIsWirless(boolean isWirless) {
    // this.isWirless = isWirless;
    // }

    public void setWirless(boolean isWirless) {
        this.isWirless = isWirless;
    }

    public boolean isWirless() {
        return isWirless;
    }

    // public boolean getIsWirless() {
    // return this.isWirless;
    // }

    public Headphones(String name, String brand, String description, BigDecimal price, String color,
            boolean isWirless) {
        super(name, brand, description, price);
        this.color = color;
        this.isWirless = isWirless;
    }

    @Override
    public String toString() {
        return super.toString() + "\nisWirless: " + isWirless() + "\ncolor: " + getColor();
    }

}
