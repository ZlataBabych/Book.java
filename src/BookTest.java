// Бабич З.А.
// ООП на мові Java
// Лабораторна робота 10
// Кінцевий строк подання: 15 квітня 2024
// Використано часу: 1 година
// Це моя власна робота. Не було використано жодної несанкціонованої допомоги.

// Це драйвер для класу Book. Він демонструє конструктор, конструктор копіювання,
// гетери, метод equals та метод toString() для класу обгортки BookWrapper

import java.util.Scanner;

public class BookTest {
    public static void main(String[] args) {
        // Створення об'єкта BookWrapper через конструктор з параметрами
        BookWrapper bookWrapper1 = new BookWrapper("Щоденник", "Антоніо Павло", 320, 250.50);

        // Виведення інформації про книгу через перевизначений метод toString()
        System.out.println("Книга 1:\n" + bookWrapper1);

        // Створення копії об'єкта Book через конструктор копіювання
        Book bookForCopy = new Book("Научна література", "Марія Галушка", 1450, 7850.50);
        BookWrapper bookWrapper2 = new BookWrapper(bookForCopy);

        // Використання гетерів
        System.out.println("\nІнформація про книгу 2 з гетерів:");
        System.out.println("Назва: " + bookWrapper2.getTitle());
        System.out.println("Автор: " + bookWrapper2.getAuthor());
        System.out.println("Кількість сторінок: " + bookWrapper2.getPageCount());
        System.out.println("Ціна: " + bookWrapper2.getPrice());

        // Порівняння двох об'єктів BookWrapper
        System.out.println("\nКнига 1 еквівалентна Книзі 2? " + bookWrapper1.equals(bookWrapper2));

        // Створення копії об'єкта Book через конструктор копіювання
        Book bookForCopy2 = new Book("Щоденник", "Антоніо Павло", 320, 250.50);
        BookWrapper bookWrapper3 = new BookWrapper(bookForCopy2);

        // Використання гетерів
        System.out.println("\nІнформація про книгу 3 з гетерів:");
        System.out.println("Назва: " + bookWrapper3.getTitle());
        System.out.println("Автор: " + bookWrapper3.getAuthor());
        System.out.println("Кількість сторінок: " + bookWrapper3.getPageCount());
        System.out.println("Ціна: " + bookWrapper3.getPrice());

        // Порівняння двох об'єктів BookWrapper
        System.out.println("\nКнига 1 еквівалентна Книзі 3? " + bookWrapper1.equals(bookWrapper3));
    }
}
