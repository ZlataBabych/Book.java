// Бабич З.А.
// ООП на мові Java
// Лабораторна робота 12
// Кінцевий строк подання: 23 квітня 2024
// Використано часу: 1 година
// Це моя власна робота. Не було використано жодної несанкціонованої допомоги.

// Це драйвер для класу Book. Він створює ArrayList елементів типу Book, додає до нього об'єкти класів Book,
// SchoolTextbook та Newspaper, а потім виводить інформацію про кожен об'єкт за допомогою циклу for-each.
// Також використовується метод display для виведення інформації про кожен об'єкт.

import java.util.Scanner;
import java.util.ArrayList;

public class BookTest {
    /**
     * Приватний метод для виводу інформації про книгу.
     * @param book об'єкт класу Book для виводу.
     */
    private static void display(Book book) {
        System.out.println(book);
    }
    public static void main(String[] args) {

        // Створення ArrayList елементів типу Book
        ArrayList<Book> books = new ArrayList<>();

        // Book
        books.add(new Book(
                "The Great Gatsby", "F. Scott Fitzgerald", 180, 10.00));
        books.add(new Book(
                "1984", "George Orwell", 328, 12.50));
        books.add(new Book(
                "To Kill a Mockingbird", "Harper Lee", 281, 8.99));

        // SchoolTextbook
        books.add(new SchoolTextbook(
                "Math Essentials", "Jane Matherson", 250, 20.00,
                "Mathematics", 7));
        books.add(new SchoolTextbook(
                "Biology Basics", "Dr. Green", 300, 25.00,
                "Biology", 10));
        books.add(new SchoolTextbook(
                "World History", "H. Wells", 350, 22.00,
                "History", 9));

        // Newspaper
        books.add(new Newspaper(
                "Daily News", "Editorial Team", 40, 1.50,
                "2021-05-01", "Daily"));
        books.add(new Newspaper(
                "Community Voice", "Local Writers", 30, 0.99,
                "2021-05-02", "Weekly"));
        books.add(new Newspaper(
                "The Science Monitor", "Global Science Forum", 45, 2.00,
                "2021-05-01", "Monthly"));

        // Виведення інформації про кожен об'єкт
        System.out.println("Looping through the list of books:");
        for (Book book : books) {
            System.out.println(book);
        }

        System.out.println("\n\nLooping through the list of books using display method:");
        for (Book book : books) {
            display(book);
        }
    }
}




