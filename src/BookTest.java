// Бабич З.А.
// ООП на мові Java
// Лабораторна робота 7
// Кінцевий строк подання: 21 березня 2024
// Використано часу: 0.5 години
// Це моя власна робота. Не було використано жодної несанкціонованої допомоги.

// Це драйвер для класу Book для створення масиву об’єктів цього класу.

import java.util.Scanner;

public class BookTest {
    public static void main(String[] args) {
        // Створення об'єкта книги
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of books: ");
        int numberOfBooks = scanner.nextInt();

        while(numberOfBooks <= 0){
            System.out.println("Enter correct number of books!");
            System.out.print("Number of books: ");
            numberOfBooks = scanner.nextInt();
        }

        scanner.nextLine(); // Очистити буфер після читання числа

        Book[] books = new Book[numberOfBooks];

        for (int i = 0; i < numberOfBooks; i++) {
            System.out.println("Enter details for book " + (i + 1) + ":");

            System.out.print("Title: ");
            String title = scanner.nextLine().trim();

            while(title.isEmpty()){
                System.out.println("Enter correct title!");
                System.out.print("Title: ");
                title = scanner.nextLine().trim();
            }

            System.out.print("Author: ");
            String author = scanner.nextLine().trim();

            while(author.isEmpty()){
                System.out.println("Enter correct author!");
                System.out.print("Author: ");
                author = scanner.nextLine().trim();
            }

            System.out.print("Page count: ");
            int pageCount = scanner.nextInt();

            while(pageCount <= 0){
                System.out.println("Enter correct count!");
                System.out.print("Page count: ");
                pageCount = scanner.nextInt();
            }

            System.out.print("Price: ");
            double price = scanner.nextDouble();

            while(price < 0){
                System.out.println("Enter correct Price!");
                System.out.print("Price: ");
                price = scanner.nextDouble();
            }

            scanner.nextLine(); // Очистити буфер

            books[i] = new Book(title, author, pageCount, price);
        }

        System.out.println("\nBooks Information:");
        for (Book book : books) {
            System.out.println(book.toString());
        }

        scanner.close();
    }
}
