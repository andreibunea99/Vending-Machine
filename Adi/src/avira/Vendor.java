package main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Vendor {
    public static void payment() {
        System.out.println("TODO");
    }
    public static void driver(ArrayList<Product> products, Scanner scanner) {
        Cart cart = new Cart(products);
        System.out.println("Your cart is empty");
        while (true) {
            System.out.println("Choose product:");
            for (int i = 1; i <= products.size(); ++i) {
                System.out.println("" + i + ". " + products.get(i - 1).getName());
            }
            System.out.println("\n7. View Cart");
            System.out.println("8. End Shopping");
            int i = scanner.nextInt();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 7) {
                cart.showCart();
                continue;
            }
            if (i == 8) {
                payment();
                break;
            }
            System.out.println("You have chose to buy " + products.get(i - 1).getName());
            System.out.println("(" + products.get(i - 1).getPrice() + "$ each)");
            System.out.println("How many would you like?");
            int q = scanner.nextInt();
            if (cart.buy(i, q)) {
                System.out.println("Added to cart");
                continue;
            }
            System.out.println("Not enough of the selected item (" + products.get(i - 1).getQuantity() + " remaining)");
        }
    }
}
