package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Smartphone extends Product {
    // Smarphone, caratterizzati anche dal codice IMEI e dalla quantità di memoria
    private String imeiCode;
    private int gbMemory;

    // getter and setter
    public String getImeiCode() {
        return imeiCode;
    }

    // public void setImeiCode(String imeiCode) {
    // this.imeiCode = imeiCode;
    // }

    public int getGbMemory() {
        return gbMemory;
    }

    public void setGbMemory(int gbMemory) {
        if (gbMemory <= 0) {
            throw new IllegalArgumentException("GB memory non valida");
        }
        this.gbMemory = gbMemory;
    }

    // costruttore
    public Smartphone(String name, String brand, String description, BigDecimal price, String imeiCode,
            int gbMemory) {

        super(name, brand, description, price);

        // if (imeiCode == null || imeiCode.length() != 15) {
        // throw new IllegalArgumentException("IMEI deve essere di 15 caratteri");
        // }

        if (gbMemory <= 0) {
            throw new IllegalArgumentException("GB memory non valida");
        }

        this.imeiCode = imeiCode;
        this.gbMemory = gbMemory;
    }

    @Override
    public String toString() {
        return super.toString() + "\nIMEI code: " + getImeiCode() + "\nGB di memoria: " + getGbMemory();
    }

    // Per gli Smartphone, lo sconto è del 5% se la quantità di memoria è inferiore
    // a 32GB, altrimenti rimane del 2%..
    @Override
    public BigDecimal getFinalPrice(boolean loyaltyCard) {

        if (loyaltyCard) {

            // BigDecimal discount = new BigDecimal("0.02");

            BigDecimal discount;
            if (getGbMemory() < 32) {
                discount = new BigDecimal("0.05");
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
