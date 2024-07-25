package ru.netology.interfaceService;

import ru.netology.Account;
import ru.netology.Product;
import ru.netology.Shop;

public interface AddToCar {

    void AddToCar(Account account, Product product, Shop shop);
}
