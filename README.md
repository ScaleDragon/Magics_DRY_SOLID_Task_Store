# Домашнее задание к занятию «Magics, DRY, SOLID»
### Задача Магазин
Описание
Это финальная задача! В этом задании попрактикуемся с правилами чистого кода и принципами SOLID.

Нужно написать программу-магазин, в которой пользователи заказывают товары. Вам предоставляется свобода в продумывании функциональности вашей программы, как и в проектировании её структуры. В процессе реализации вы должны применить принцип избегания магических чисел, DRY и как минимум 4 из 5 принципов SOLID, причём явно комментариями в коде или при отправке решения указать по одному примеру применения каждого принципа в вашем решении со ссылками на конкретные места кода на гитхабе.

Примеры возможностей программы:

- Вывод доступных для покупки товаров
- Фильтрация товаров по ключевым словам, ценам, производителям
- Составление продуктовой корзины пользователя
- Трекинг заказа в системе доставки
- Возврат заказа, повтороение заказа
- Система рейтинга для товаров
- Простая рекомендательная система для покупок

___Реализация___

Продумайте и зафиксируйте список возможностей вашей программы.
Продумайте консольный интерфейс взаимодействия пользователя с вашей программой.
Продумайте систему классов, которые вам понадобятся для реализации вашей программы.

Напишите вашу программу, явно применив вышеперечисленные принципы хорошего кода.
При отправке решения укажите, в чём именно было применение каждого этого принципа (по одному примеру) со ссылками на конкретные места кода на гитхабе.

Протестируйте работу программы. Не забывайте про правила форматирования кода (для автоформата можете выделить код в идее и нажать Ctrl+Alt+L).

# Решение

- Принцип избегания магических чисел

В классе Order для генерации уникальных идентификаторов используется статическая переменная nextId.
```java
private static int nextID = 1;
```
[Class Order, строка № 7](https://github.com/ScaleDragon/Magics_DRY_SOLID_Task_Store/blob/c279b0e3140d818cce8b773c74829a8a81c31b00/netology/Order.java#L7)
- Принцип DRY (Don't Repeat Yourself)

В методе filterProducts класса NavigationMenu применяется фильтрация с использованием Stream API,
 что позволяет избежать повторяющегося кода.
```java
 switch (Integer.parseInt(nextLine)) {
    case 1 -> filter.setFilteredProducts(filter.filterByName());
    case 2 -> filter.setFilteredProducts(filter.filterByPrice());
    case 3 -> filter.setFilteredProducts(filter.filterByCategory());
     }
 ```
[class NavigationMenu, строки № 34-36](https://github.com/ScaleDragon/Magics_DRY_SOLID_Task_Store/blob/300cb3b1fca376fad4122017b84cc9feda8e6588/netology/NavigationMenu.java#L34C20-L36C27)

-  Принцип единственной ответственности (Single Responsibility Principle, SRP)

Программа разделена на классы.
Например класс Account отвечает только за представление пользователя и его свойств.

[Classs Account](https://github.com/ScaleDragon/Magics_DRY_SOLID_Task_Store/blob/300cb3b1fca376fad4122017b84cc9feda8e6588/netology/Account.java#L8C1-L21C1)

   - Принцип открытости/закрытости (Open/Closed Principle, OCP)

 Класс NavigationMenu открыт для расширения (можно добавить новые методы фильтрации), но закрыт для модификации.

 [Class NavigationMenu](https://github.com/ScaleDragon/Magics_DRY_SOLID_Task_Store/blob/300cb3b1fca376fad4122017b84cc9feda8e6588/netology/NavigationMenu.java#L11)

  - Принцип подстановки Барбары Лисков (Liskov Substitution Principle, LSP)

 Продукты из папки products наследуются от общего предка класса Product, но у каждого класса имеется своя категория.

 [Class Product родитель](https://github.com/ScaleDragon/Magics_DRY_SOLID_Task_Store/blob/300cb3b1fca376fad4122017b84cc9feda8e6588/netology/Product.java#L6)

[Class Dairy дочерний](https://github.com/ScaleDragon/Magics_DRY_SOLID_Task_Store/blob/300cb3b1fca376fad4122017b84cc9feda8e6588/netology/products/Dairy.java#L11)

- Dependency inversion principle 
  
разделив интерфейсы AddToCar и RemovalFromCart мы не зависим от общего
функционала одного интерфейса, а каждый может выполнить самостоятельную функцию.

```java
 if (productToAdd != null) {
    AddToCar(account, productToAdd, shop);
}
```

[interfaceService/AddToCar ](https://github.com/ScaleDragon/Magics_DRY_SOLID_Task_Store/blob/300cb3b1fca376fad4122017b84cc9feda8e6588/netology/NavigationMenu.java#L49)

```java
if (productToRemove != null) {
    RemovalFromCart(account, productToRemove, shop);
}
```
[interfaceService/RemovalFromCart](https://github.com/ScaleDragon/Magics_DRY_SOLID_Task_Store/blob/300cb3b1fca376fad4122017b84cc9feda8e6588/netology/NavigationMenu.java#L66)