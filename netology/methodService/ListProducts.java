package ru.netology.methodService;

import ru.netology.interfaceService.DisplayListProducts;
import ru.netology.products.*;
import ru.netology.Product;

import java.util.ArrayList;
import java.util.List;

public class ListProducts implements DisplayListProducts {

    private final static List<Product> listProducts = new ArrayList<>();

    static {
        addProducts();
    }

    public static List<Product> getProducts() {
        return listProducts;
    }

    private static void addProducts() {
        listProducts.add(new Dairy("Молоко \"Агуша\"", 120, 1000));
        listProducts.add(new Dairy("Молоко", 120, 1000));
        listProducts.add(new Dairy("Творог 5% \"Как творог\"", 170, 500));
        listProducts.add(new Dairy("Кефир \"Доброе утро\"", 90, 900));
        listProducts.add(new Dairy("Йогурт \"Гуд\"", 85, 300));
        listProducts.add(new Bakery("Батон домашний \"Уголек\"", 76, 450));
        listProducts.add(new Bakery("Слойка с яблоком", 56, 140));
        listProducts.add(new Bakery("Крендель", 160, 400));
        listProducts.add(new Bakery("Сухарики \"Березовая кора\"", 120, 120));
        listProducts.add(new Meat("Говядина \"Только что\"", 2300, 1000));
        listProducts.add(new Meat("Колбаса докторская \"Диссертация\"", 450, 500));
        listProducts.add(new Meat("Свиная рулька \"Пяточок\"", 370, 400));
        listProducts.add(new Meat("Курица охлажденная", 370, 800));
        listProducts.add(new Cheese("Партизан", 670, 300));
        listProducts.add(new Cheese("Дары блю", 250, 240));
        listProducts.add(new Cheese("Решето", 245, 200));
        listProducts.add(new Cheese("Сливочный рай", 389, 250));
        listProducts.add(new Water("Березовый сок \"Дракула\"", 460, 1000));
        listProducts.add(new Water("Вода б/г \"Волга\"", 80, 500));
        listProducts.add(new Water("Лимонад ассорти", 90, 450));
    }

    @Override
    public void displayListProducts() {
        System.out.println("ID | Название | Категория | Цена | Вес \n");
        for (Product product : listProducts) {
            System.out.printf("%d | %s | %s | %d | %d \n", product.getId(), product.getProductName(),
                    product.getCategory().getDisplayName(), product.getPrice(), product.getWeight());
        }
    }
}
