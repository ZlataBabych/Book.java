// Бабич З.А.
// ООП на мові Java
// Лабораторна робота 8
// Кінцевий строк подання: 28 березня 2024
// Використано часу: 0.5 години
// Це моя власна робота. Не було використано жодної несанкціонованої допомоги.

// Це драйвер для класу Book

import java.util.Scanner;

public class BookTest {
    public static void main(String[] args) {
        Book book1 = new Book("C++", "Jack", 100, 2600);

        Book book2 = new Book(book1);

        Book book3 = new Book("C++", "Marina Bobova", 100, 2600);


        System.out.println("Copy of first book: " + book2.toString());

        System.out.println("Is the first book equal to its copy? "
                + book1.equals(book2));

        System.out.println("Is the second book equal to thirt book? "
                + book2.equals(book3));

        System.out.println("Total number of books created: "
                + Book.getBookCount());

    }
}
