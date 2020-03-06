package main;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Cart {
    private ArrayList<Product> products;
    private ArrayList<Product> availableProducts;
    public Cart(ArrayList<Product> p) {
        availableProducts = p;
        products = new ArrayList<>();
        products.add(new Product("Avira Prime", 75));
        products.add(new Product("Antivirus Pro", 35));
        products.add(new Product("Phantom VPN", 50));
        products.add(new Product("Password Manager", 20));
        products.add(new Product("Optimizer", 10));
        products.add(new Product("System Speedup", 25));
    }
    public boolean buy(int index, int quantity) {
        if (availableProducts.get(index - 1).getQuantity() >= quantity) {
            availableProducts.get(index - 1).setQuantity(availableProducts.get(index - 1).getQuantity() - quantity);
            products.get(index - 1).setQuantity(products.get(index - 1).getQuantity() + quantity);
            return true;
        }
        return false;
    }
    public void showCart() {
        int total = 0;
        for (Product p : products) {
            if (p.getQuantity() > 0) {
                System.out.println(p.getQuantity() + " x " + p.getName());
            }
            total += p.getQuantity() * p.getPrice();
        }
        System.out.println("Total price: " + total + "$.");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
