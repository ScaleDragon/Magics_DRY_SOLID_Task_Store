package ru.netology.products;

import ru.netology.Category;
import ru.netology.Product;

import java.util.Objects;
import java.util.Random;

import static ru.netology.Category.DAIRY;

public class Dairy extends Product {
    private static int nextId = 1;
    private int id;
    private String productName;
    private Category category;
    private int price;
    private int weight;
    private int rating;

    private Random random = new Random();
    public Dairy(String productName, int price, int weight) {
        this.productName = productName;
        this.category = DAIRY;
        this.price = price;
        this.weight = weight;
        this.rating = random.nextInt(1, 10);
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

    @Override
    public String toString() {
        return String.format("Название \"%s\", Категория (%s), Цена: %d, Вес: %d, Срок годности: %d",
                productName, category.getDisplayName(), price, weight);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Dairy product = (Dairy) object;
        return id == product.id &&
               price == product.price &&
               weight == product.weight &&
               rating == product.rating &&
               Objects.equals(productName, product.productName) &&
               category == product.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, category, price, weight, rating);
    }
}
