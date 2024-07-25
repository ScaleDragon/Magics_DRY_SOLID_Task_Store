package ru.netology;

public enum Category {
    BAKERY("Хлебобулочные"),
    DAIRY("Молочные"),
    MEAT("Мясные"),
    CHEESE("Сыры"),
    WATER("Вода");

    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
