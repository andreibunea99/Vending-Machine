package main;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Avira Prime", 75));
        products.add(new Product("Antivirus Pro", 35));
        products.add(new Product("Phantom VPN", 50));
        products.add(new Product("Password Manager", 20));
        products.add(new Product("Optimizer", 10));
        products.add(new Product("System Speedup", 25));
        System.out.println("Initialise inventory:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to use the default daily inventory? (y/n)");
        String s = scanner.next();
        if (s.equals("y") || s.equals("Y")) {
            Setup.initialiseDefaultInventory(products);
        } else {
            Setup.initialiseCustomInventory(products, scanner);
        }
        for (Product p : products) {
            System.out.println("We have " + p.getQuantity() + " of item \"" + p.getName() + "\"");
        }
        while (true) {
            System.out.print("Choose operating mode:");
            System.out.println("1. Buy");
            System.out.println("2. Update Inventory");
            System.out.println("3. Quit");
            int i = scanner.nextInt();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 3) {
                break;
            }
            if (i == 2) {
                Setup.initialiseCustomInventory(products, scanner);
            }
            Vendor.driver(products, scanner);
        }
    }
}
