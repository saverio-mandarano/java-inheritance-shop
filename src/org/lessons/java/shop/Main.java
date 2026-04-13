package org.lessons.java.shop;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        String description = "Figurina del cane di Paperino";
        BigDecimal iva = new BigDecimal(0.22);
        BigDecimal price = new BigDecimal(100.015);

        Product pluto = new Product("pluto", "Nike", description, iva, price);
        Product paperino = new Product();

        // getter
        // System.out.println("name = " + pluto.getName());
        // System.out.println("code = " + pluto.getCode());
        // System.out.println("slug = " + pluto.getSlug());
        // System.out.println("description = " + pluto.getDescription());
        // System.out.println("brand = " + pluto.getBrand());
        // System.out.println("iva = " + pluto.getIva());
        // System.out.println("price = " + pluto.getPrice());
        // System.out.println("price with iva = " + pluto.getPricePlusIva());

        // setter
        // pluto.setName("paperino");
        // pluto.setBrand("Adidas");
        // pluto.setDescription("Descrizione disney");
        // pluto.setIva(new BigDecimal(0.11));
        // pluto.setPrice(iva);

        // System.out.println("name = " + pluto.getName());
        // System.out.println("code = " + pluto.getCode());
        // System.out.println("slug = " + pluto.getSlug());
        // System.out.println("description = " + pluto.getDescription());
        // System.out.println("brand = " + pluto.getBrand());
        // System.out.println("iva = " + pluto.getIva());
        // System.out.println("price = " + pluto.getPrice());
        // System.out.println("price with iva = " + pluto.getPricePlusIva());

        // paperino
        // System.out.println("paperino-code= " + paperino.getCode());
        // System.out.println("pluto-code= " + pluto.getCode());

        // inheritance
        Smartphone iphone16 = new Smartphone("iphone", "apple", "ultimo iphone", price, iva, "123456789012345", 32);
        // System.out.println(iphone16.getName());
        // iphone16.setName("iphone16-pro");
        // System.out.println(iphone16.getName());
        // System.out.println(iphone16);

        Television samsungTv = new Television("samsungTV", "samsung", "ultimo modello samsung tv", iva, price, true,
                27);
        System.out.println(samsungTv);
    }

}
