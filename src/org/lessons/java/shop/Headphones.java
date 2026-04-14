package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

    // Per le Cuffie lo sconto è del 7% se sono cablate, altrimenti rimane del 2%.
    @Override
    public BigDecimal getFinalPrice(boolean loyaltyCard) {

        if (loyaltyCard) {

            // BigDecimal discount = new BigDecimal("0.02");

            BigDecimal discount;
            if (!isWirless()) {
                discount = new BigDecimal("0.07");
            } else {

                discount = new BigDecimal("0.02");
            }

            return getPricePlusIva()
                    .subtract(getPricePlusIva().multiply(discount))
                    .setScale(2, RoundingMode.DOWN);
        }
        return getPricePlusIva();

    }

}
