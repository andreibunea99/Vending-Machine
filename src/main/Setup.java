package main;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Setup {
    public static void initialiseDefaultInventory(ArrayList<Product> products) {
        try {
            Scanner scanner = new Scanner(new File("dailyInventory"));
            for (Product p : products) {
                int i = scanner.nextInt();
                p.setQuantity(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void initialiseCustomInventory(ArrayList<Product> products, Scanner scanner) {
        for (Product p : products) {
            System.out.println("Input number of " + p.getName());
            int i = scanner.nextInt();
            p.setQuantity(i);
        }
    }
}
