package ru.netology.methodService;

import ru.netology.Account;

import java.util.Scanner;

public class CreateAccount {

    public static Account creatingAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите Ваше имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите Вашу фамилию: ");
        String surName = scanner.nextLine();
        System.out.print("Введите Ваш возраст: ");
        int age = 0;
        try {
            age = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод возраста. Повторите попытку.");
            return creatingAccount();
        }
        return new BuilderAccount().setName(name).setSurname(surName).setAge(age).build();
    }
}
