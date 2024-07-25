package ru.netology.methodService;

import ru.netology.Category;
import ru.netology.Product;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Filter {
    private List<Product> filteredProducts;
    private Scanner scanner = new Scanner(System.in);

    public List<String> outputFilterType() {
        return List.of("по ключевому слову", "по цене", "по категории");
    }

    public List<Product> filterByName() {
        System.out.println("Введите название продукта");
        String answer = scanner.nextLine().toLowerCase();
        return ListProducts.getProducts().stream()
                .filter(product -> product.getProductName().toLowerCase().contains(answer))
                .collect(Collectors.toList());
    }

    public List<Product> filterByPrice() {
        System.out.println("Введите min цену для продукта");
        int min = scanner.nextInt();
        System.out.println("Введите max цену для продукта");
        int max = scanner.nextInt();
        scanner.nextLine();
        return ListProducts.getProducts().stream()
                .filter(product -> product.getPrice() >= min && product.getPrice() <= max)
                .collect(Collectors.toList());
    }

    public List<Product> filterByCategory() {
        System.out.println("Выберите категорию продукта");
        for (Category category : Category.values()) {
            System.out.println(category.getDisplayName());
        }
        String answer = scanner.nextLine().toLowerCase();
        return ListProducts.getProducts().stream()
                .filter(product -> product.getCategory().getDisplayName().toLowerCase().contains(answer))
                .collect(Collectors.toList());
    }

    public void setFilteredProducts(List<Product> filteredProducts) {
        this.filteredProducts = filteredProducts;
    }

    public List<Product> getFilteredProducts() {
        return filteredProducts;
    }
}
