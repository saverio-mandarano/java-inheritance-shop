package org.lessons.java.shop;

import java.math.BigDecimal;
import java.util.Scanner;

public class Cart {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Product[] product = new Product[3];

        for (int i = 0; i < product.length; i++) {
            System.out.println("Enter the product name: ");
            String productName = input.nextLine();

            System.out.println("Enter the product description: ");
            String productDescription = input.nextLine();

            System.out.println("Enter the product brand: ");
            String productBrand = input.nextLine();

            System.out.println("Price: ");
            BigDecimal productPrice = new BigDecimal(input.nextLine());

            System.out.println("Which categories does it belong? Smartphone, Headphones, Television");
            String productCategoryString = input.nextLine();
            System.out.println(productCategoryString);

            switch (productCategoryString.toLowerCase()) {
                case "television":
                    System.out.println("Screensize ?");
                    int screenSize = Integer.parseInt(input.nextLine());

                    System.out.println("is Smart ? TRUE or Flase ");
                    boolean isSmart = Boolean.parseBoolean(input.nextLine());

                    Television tv = new Television(productName, productBrand, productDescription, productPrice,
                            isSmart,
                            screenSize);
                    product[i] = tv;

                    break;

                case "smartphone":
                    System.out.println("Gb memory ?");
                    int gbMemory = Integer.parseInt(input.nextLine());

                    System.out.println("IMEI code? ");
                    String imeiCodeString = input.nextLine();

                    Smartphone cellSmartphone = new Smartphone(productName, productBrand, productDescription,
                            productPrice,
                            imeiCodeString,
                            gbMemory);
                    product[i] = cellSmartphone;

                    break;
                case "headphones":
                    System.out.println("color ?");
                    String color = input.nextLine();

                    System.out.println("is Wirless ? TRUE or Flase ");
                    boolean isWirless = Boolean.parseBoolean(input.nextLine());

                    Headphones headphones = new Headphones(productName, productBrand, productDescription,
                            productPrice,
                            color, isWirless);
                    product[i] = headphones;

                    break;

                default:
                    break;
            }
            System.err.println("////////////////");

        }
        System.out.println("Ecco il tuo carrelo: ");

        for (int i = 0; i < product.length; i++) {
            System.out.println(product[i]);
            System.out.println("--------------");
        }

        // Calcolo il prezzo totale del carrello
        System.out.println("Hai un classe fedeltà ? TRUE or False");
        boolean loyaltyCard = Boolean.parseBoolean(input.nextLine());
        input.close();

        BigDecimal total = BigDecimal.ZERO;
        for (int i = 0; i < product.length; i++) {
            total = total.add(product[i].getFinalPrice(loyaltyCard));
        }
        System.out.println("Totale carrello: " + total);

    }

}
