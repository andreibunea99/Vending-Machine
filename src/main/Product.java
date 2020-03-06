package main;

public class Product {
    private String name;
    private int price;
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product(String n, int p) {
        name = n;
        price = p;
        quantity = 0;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
