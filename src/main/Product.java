package main;

public class Product {
    private String name;
    private int price;
    public Product(String n, int p) {
        name = n;
        price = p;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
