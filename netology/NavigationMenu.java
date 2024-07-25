package ru.netology;

import ru.netology.interfaceService.AddToCar;
import ru.netology.interfaceService.RemovalFromCart;
import ru.netology.methodService.Filter;
import ru.netology.methodService.ListProducts;

import java.util.Random;
import java.util.Scanner;

class NavigationMenu implements AddToCar, RemovalFromCart {
    private Filter filter = new Filter();
    private Scanner scanner = new Scanner(System.in);
    private ListProducts products = new ListProducts();

    public NavigationMenu() {
    }

    public void itemSelection(Shop shop, Account account, String nextLine) {
        int count = 1;
        switch (Integer.parseInt(nextLine)) {
            case 1:
                System.out.println("Список продуктов:");
                products.displayListProducts();               // вывод списка продуктов
                break;
            case 2:
                System.out.println("Фильтрация: ");
                for (String str : filter.outputFilterType()) {
                    System.out.println(count++ + ". " + str);
                }

                nextLine = scanner.nextLine();
                switch (Integer.parseInt(nextLine)) {
                    case 1 -> filter.setFilteredProducts(filter.filterByName());
                    case 2 -> filter.setFilteredProducts(filter.filterByPrice());
                    case 3 -> filter.setFilteredProducts(filter.filterByCategory());
                }
                displayFilteredProducts();
                break;
            case 3:
                System.out.println("Введите ID товара для добавления в корзину:");
                int productIdToAdd = scanner.nextInt();
                scanner.nextLine();
                Product productToAdd = products.getProducts().stream()
                        .filter(product -> product.getId() == productIdToAdd)
                        .findFirst()
                        .orElse(null);
                if (productToAdd != null) {
                    AddToCar(account, productToAdd, shop);
                } else {
                    System.out.println("Товар не найден.");
                }
                break;
            case 4:
                shop.showBasket(account);
                break;
            case 5:
                System.out.println("Введите ID товара для удаления из корзины:");
                int productIdToRemove = scanner.nextInt();
                scanner.nextLine();
                Product productToRemove = account.getAccountBasket().stream()
                        .filter(product -> product.getId() == productIdToRemove)
                        .findFirst()
                        .orElse(null);
                if (productToRemove != null) {
                    RemovalFromCart(account, productToRemove, shop);
                } else {
                    System.out.println("Товар не найден в корзине.");
                }
                break;
            case 6:
                System.out.println("Создание заказа...");
                Order order = shop.createOrder(account);
                System.out.println("Заказ создан: " + order);
                break;
            case 7:
                System.out.println("Введите ID заказа для трекинга:");
                int orderId = scanner.nextInt();
                scanner.nextLine();
                shop.trackOrder(orderId).ifPresentOrElse(
                        orderTracked -> System.out.println("Заказ найден: " + orderTracked),
                        () -> System.out.println("Заказ не найден.")
                );
                break;
            case 8:
                System.out.println("Введите ID заказа для возврата:");
                int returnOrderId = scanner.nextInt();
                scanner.nextLine();
                if (shop.returnOrder(returnOrderId)) {
                    System.out.println("Заказ возвращен.");
                } else {
                    System.out.println("Не удалось вернуть заказ.");
                }
                break;
            case 9:
                System.out.println("Введите ID заказа для повторения:");
                int repeatOrderId = scanner.nextInt();
                scanner.nextLine();
                Order newOrder = shop.repeatOrder(repeatOrderId);
                if (newOrder != null) {
                    System.out.println("Заказ повторен: " + newOrder);
                } else {
                    System.out.println("Не удалось повторить заказ.");
                }
                break;
            case 10:
                System.out.println("Рекомендации:");
                System.out.println("ID | Название | Категория | Цена | Вес ");
                Random rand = new Random();
                for (int i = 0; i < 5; i++) {
                    Product randomProduct = products.getProducts().get(rand.nextInt(products.getProducts().size()));
                    System.out.printf("%d | %s | %s | %d | %d \n", randomProduct.getId()
                            , randomProduct.getProductName(), randomProduct.getCategory().getDisplayName()
                            , randomProduct.getPrice(), randomProduct.getWeight());
                }
                break;
            case 11:
                System.out.println("До свидания, спасибо, что посетили наш магазин!");
                System.exit(0);
                break;
            default:
                System.out.println("Неверный выбор.");
        }
    }

    private void displayFilteredProducts() {
        if (!filter.getFilteredProducts().isEmpty()) {
            System.out.println("ID | Название | Категория | Цена | Вес ");
            for (Product product : filter.getFilteredProducts()) {
                System.out.printf("%d | %s | %s | %d | %d \n", product.getId()
                        , product.getProductName(), product.getCategory().getDisplayName()
                        , product.getPrice(), product.getWeight());
            }
        } else {
            System.out.println("Фильтр не дал результатов.");
        }
    }

    @Override
    public void RemovalFromCart(Account account, Product product, Shop shop) {
        shop.removeFromBasket(account, product);
        System.out.println("Товар удален из корзины.");
    }

    @Override
    public void AddToCar(Account account, Product product, Shop shop) {
        shop.addToBasket(account, product);
        System.out.println("Товар добавлен в корзину.");
    }
}
