package ru.netology.methodService;

import ru.netology.Account;

public class BuilderAccount {

    private String name;
    private String surName;
    private int age;

    public BuilderAccount setName(String name) {
        this.name = name;
        return this;
    }

    public BuilderAccount setSurname(String surName) {
        this.surName = surName;
        return this;
    }

    public BuilderAccount setAge(int age) {
        this.age = age;
        return this;
    }

    public Account build() {
        if (this.name == null || this.surName == null) {
            throw new IllegalStateException("Вы не указали имя или фамилию");
        } else if (this.age < 0) {
            throw new IllegalArgumentException("Некорректный возраст");
        } else {
            return new Account(name, surName, age);
        }
    }
}
