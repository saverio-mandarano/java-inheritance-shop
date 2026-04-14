package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Product {
    private String name;
    private String description;
    private String brand;
    private int code;
    private BigDecimal iva;
    private BigDecimal price;

    public Product(String name, String brand, String description, BigDecimal iva, BigDecimal price) {
        // alla creazione nuovo prodotto il codice è valorizzato con un numero random
        Random r = new Random();
        int max = 10000000;
        this.code = r.nextInt(max);

        this.name = name;
        this.description = description;
        this.brand = brand;
        this.price = price;
        this.iva = iva;
    }

    public Product(String name, String brand, String description, BigDecimal price) {
        // alla creazione nuovo prodotto il codice è valorizzato con un numero random
        Random r = new Random();
        int max = 10000000;
        this.code = r.nextInt(max);

        this.name = name;
        this.description = description;
        this.brand = brand;
        this.price = price;
        this.iva = new BigDecimal("0.22");
    }

    public Product() {
        // alla creazione nuovo prodotto il codice è valorizzato con un numero random
        Random r = new Random();
        int max = 10000000;
        this.code = r.nextInt(max);
    }

    // getter
    public String getName() {
        return this.name;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getDescription() {
        return this.description;
    }

    public int getCode() {
        return this.code;
    }

    public BigDecimal getIva() {
        if (iva != null) {
            return this.iva.setScale(2, RoundingMode.DOWN);
        }
        return null;
    }

    // metodo per avere il prezzo base
    BigDecimal getPrice() {
        if (price != null) {
            return this.price.setScale(2, RoundingMode.DOWN);
        }
        return null;
    }

    // metodo per avere il prezzo comprensivo di iva
    public BigDecimal getPricePlusIva() {
        // verificare se sono state inizializzate le varibaili di istanza
        if (price != null && iva != null) {
            return this.price.add(price.multiply(iva)).setScale(2, RoundingMode.DOWN);
        }
        return null;
    }

    // metodo per avere il nome esteso, ottenuto concatenando codice-nome
    public String getSlug() {
        if (code != 0 && name != null) {
            return this.code + "-" + this.name;
        }
        return null;
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return getSlug();
    }

}
