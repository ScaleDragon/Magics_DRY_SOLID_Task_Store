package ru.netology;

import java.util.ArrayList;

public class Menu {
    private static ArrayList<String> paragraphMenu = new ArrayList<>();

    static {
        paragraphMenu.add("Список продуктов");
        paragraphMenu.add("Фильтрация товаров");
        paragraphMenu.add("Добавить товар в корзину");
        paragraphMenu.add("Показать содержимое корзины");
        paragraphMenu.add("Удалить товар из корзины");
        paragraphMenu.add("Создать заказ");
        paragraphMenu.add("Трекинг заказа");
        paragraphMenu.add("Возврат заказа");
        paragraphMenu.add("Повторение заказа");
        paragraphMenu.add("Рекомендации");
        paragraphMenu.add("Выход");
    }

    public static void menu() {
        String horizontal = "-";
        String vertical = " | ";
        String space = " ";
        System.out.println(" " + horizontal.repeat(39));
        System.out.println(vertical + space.repeat(1) + "Выберите один из пунктов меню:" + space.repeat(4) + vertical);
        System.out.println(" " + horizontal.repeat(39));
        for (int i = 0; i < paragraphMenu.size(); i++) {
            if (i < 9) {
                System.out.println(vertical + (i + 1) + ". " + paragraphMenu.get(i) +
                                   space.repeat(32 - paragraphMenu.get(i).length()) + vertical);
            } else {
                System.out.println(vertical + (i + 1) + ". " + paragraphMenu.get(i) +
                                   space.repeat(32 - paragraphMenu.get(i).length() - 1) + vertical);
            }
        }
        System.out.println(" " + horizontal.repeat(39));
    }
}
