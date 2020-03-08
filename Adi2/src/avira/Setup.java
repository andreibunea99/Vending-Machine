package avira;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Setup {
    static boolean initialised = false;
    static ArrayList<Product> productsCopy;
    public static void initialiseDefaultInventory(ArrayList<Product> products) {
        try {
            Scanner scanner = new Scanner(new File("dailyInventory"));
            for (Product p : products) {
                int i = scanner.nextInt();
                p.setQuantity(i);
            }
            productsCopy = products;
            initialised = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void initialiseCustomInventory(ArrayList<Product> products, int[] n) {
        for (int i = 0; i < 6; ++i) {
            products.get(i).setQuantity(n[i]);
        }
        productsCopy = products;
        initialised = true;
    }
}

