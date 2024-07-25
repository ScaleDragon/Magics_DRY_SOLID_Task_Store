package ru.netology;

import java.util.Objects;
import java.util.Random;

public abstract class Product {
    private static int nextId = 1;
    private int id;
    private String productName;
    private Category category;
    private int price;
    private int weight;

    public Product() {
        this.id = nextId++;
    }

    public int getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public String getProductName() {
        return productName;
    }
}
