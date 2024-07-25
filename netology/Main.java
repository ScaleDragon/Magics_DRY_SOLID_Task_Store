package ru.netology;

import ru.netology.methodService.CreateAccount;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Shop shop = new Shop();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в онлайн магазин!");
        Account account = CreateAccount.creatingAccount();
        System.out.println("Добро пожаловать, " + account.getName() + "!");

        NavigationMenu navigationMenu = new NavigationMenu();
        Menu.menu();

        String answer;
        do {
            System.out.println("Выберите один из пунктов меню:");
            answer = scanner.nextLine();
            navigationMenu.itemSelection(shop, account, answer);
            Menu.menu();
        } while (true);
    }
}
