package ru.netology;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Account {

    private String name;
    private String surName;
    private int age;
    private List<Product> accountBasket;

    public Account(String name, String surName, int age) {
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.accountBasket = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addToAccountBasket(Product product) {
        accountBasket.add(product);
    }

    public List<Product> getAccountBasket() {
        return accountBasket;
    }

    public void removeFromAccountBasket(Product product) {
        accountBasket.remove(product);
    }

    public void clearAccountBasket() {
        accountBasket.clear();
    }

    @Override
    public String toString() {
        return "Account{" +
               "name='" + name + '\'' +
               ", surname='" + surName + '\'' +
               ", age=" + age +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return age == account.age && Objects.equals(name, account.name) && Objects.equals(surName, account.surName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surName, age);
    }
}
