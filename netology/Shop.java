package ru.netology;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Shop {

    private List<Order> orders;
    private List<Product> products;

    public Shop() {
        this.orders = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    public void addToBasket(Account account, Product product) {
        account.addToAccountBasket(product);
    }

    public void removeFromBasket(Account account, Product product) {
        account.removeFromAccountBasket(product);
    }

    public void showBasket(Account account) {
        List<Product> basket = account.getAccountBasket();
        if (basket.isEmpty()) {
            System.out.println("Корзина пуста.");
        } else {
            System.out.println("Содержимое корзины:");
            System.out.println("ID | Название | Категория | Цена | Вес");
            for (Product product : basket) {
                System.out.printf("%d | %s | %s | %d | %d \n", product.getId(), product.getProductName()
                        , product.getCategory().getDisplayName(), product.getPrice(), product.getWeight());
            }
        }
    }

    public Order createOrder(Account account) {
        Order order = new Order(account, new ArrayList<>(account.getAccountBasket()));
        orders.add(order);
        account.clearAccountBasket();
        return order;
    }

    public Optional<Order> trackOrder(int orderId) {
        return orders.stream().filter(order -> order.getId() == orderId).findFirst();
    }

    public boolean returnOrder(int orderId) {
        return orders.removeIf(order -> order.getId() == orderId);
    }

    public Order repeatOrder(int orderId) {
        Optional<Order> order = trackOrder(orderId);
        if (order.isPresent()) {
            Order newOrder = new Order(order.get().getUser(), order.get().getProducts());
            orders.add(newOrder);
            return newOrder;
        }
        return null;
    }
}
