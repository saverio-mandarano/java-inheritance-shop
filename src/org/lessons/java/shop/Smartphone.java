package org.lessons.java.shop;

import java.math.BigDecimal;

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
    public Smartphone(String name, String brand, String description, BigDecimal price, BigDecimal iva, String imeiCode,
            int gbMemory) {

        super(name, brand, description, iva, price);

        if (imeiCode == null || imeiCode.length() != 15) {
            throw new IllegalArgumentException("IMEI deve essere di 15 caratteri");
        }

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
}
