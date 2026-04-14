package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Television extends Product {
    // Televisori, caratterizzati dalle dimensioni e dalla proprietà di essere smart
    // oppure no
    private int screenSize;
    private boolean isSmart;

    public Television(String name, String brand, String description, BigDecimal price, boolean isSmart,
            int screenSize) {

        super(name, brand, description, price);

        if (screenSize < 0) {
            throw new IllegalArgumentException("screenSize errata");
        }

        this.isSmart = isSmart;
        this.screenSize = screenSize;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        if (screenSize < 0) {
            throw new IllegalArgumentException("screenSize errata");
        }
        this.screenSize = screenSize;
    }

    public boolean getIsSmart() {
        return this.isSmart;
    }

    public void setIsSmart(boolean isSmart) {
        this.isSmart = isSmart;
    }

    @Override
    public String toString() {
        return super.toString() + "\nisSmart: " + getIsSmart() + "\nScreenSize: " + getScreenSize();
    }

    // Per i Televisori lo sconto è del 10% se la televisione non è smart,
    // altrimenti rimane del 2%.
    @Override
    public BigDecimal getFinalPrice(boolean loyaltyCard) {

        if (loyaltyCard) {

            // BigDecimal discount = new BigDecimal("0.02");

            BigDecimal discount;
            if (!getIsSmart()) {
                discount = new BigDecimal("0.1");
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
