// Бабич З.А.
// ООП на мові Java
// Лабораторна робота 9
// Кінцевий строк подання: 09 квітня 2024
// Використано часу: 1 година
// Це моя власна робота. Не було використано жодної несанкціонованої допомоги.

// Це драйвер для класу Book. Вын демонструє принцип агрегації для класу Book і Owner.

import java.util.Scanner;

public class BookTest {
    public static void main(String[] args) {
        Owner autor1 = new Owner("Jack Nool", "jack@gmail.com");

        Book book1 = new Book("C++", autor1, 100, 2600);

        Book book2 = new Book(book1);

        Owner autor2 = new Owner("Marina Bobova", "bobva@gmail.com");

        Book book3 = new Book("C++", autor2 , 100, 2600);

        System.out.println("Copy of first book: " + book2.toString());

        System.out.println("Is the first book equal to its copy? "
                + book1.equals(book2));
        System.out.println("Is the second book equal to thirty book? "
                + book2.equals(book3));

        Owner autor3 = new Owner("Zlata Babych", "zlata@gmail.com");

        System.out.println("Thirty book: " + book3.toString());

        book3.setTitle("Java for beginners");
        book3.setAuthor(autor3);
        book3.setPageCount(375793);
        book3.setPrice(12);

        System.out.println("Changed thirty book: " + book3.toString());
    }
}
