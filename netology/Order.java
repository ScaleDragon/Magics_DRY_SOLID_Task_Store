package ru.netology;

import java.util.List;

public class Order {

    private static int nextID = 1;
    private Account account;
    private int id;
    private List<Product> products;

    public Order(Account account, List<Product> products) {
        this.id = nextID++;
        this.account = account;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public Account getUser() {
        return account;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Order{" +
               "account=" + account +
               ", id=" + id +
               ", products=" + products +
               '}';
    }
}
