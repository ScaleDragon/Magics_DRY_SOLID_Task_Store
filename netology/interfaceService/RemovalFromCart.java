package ru.netology.interfaceService;

import ru.netology.Account;
import ru.netology.Product;
import ru.netology.Shop;

public interface RemovalFromCart {
    void RemovalFromCart(Account account, Product product, Shop shop);
}
