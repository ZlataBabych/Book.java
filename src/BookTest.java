// Бабич З.А.
// ООП на мові Java
// Лабораторна робота 16
// Кінцевий строк подання: 13 травня 2024
// Використано часу: 2 години
// Це моя власна робота. Не було використано жодної несанкціонованої допомоги.

// Повний опис драйверу: програма читає інформацію про книги з файлу books.txt та виводить їх на екран.
// Книги сортуються за ціною у порядку зростання.
// Якщо виникає помилка при зчитуванні даних про книгу, програма виводить повідомлення про помилку та продовжує роботу.
// Власні винятки використовуються для обробки помилок при зчитуванні даних про книгу.


import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class BookTest {
    /**
     * Точка входу в програму.
     *
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {
        String filePath = "books.txt";
        ArrayList<Book> books = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader
                (new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue; // Пропускаємо пусті рядки

                try {
                    if ("SchoolTextbook".equals(line)) {
                        books.add(readSchoolTextbook(reader));
                    } else if ("EBook".equals(line)) {
                        books.add(readEBook(reader));
                    } else if ("Book".equals(line)) {
                        books.add(readBook(reader));}
                } catch (IllegalArgumentException | IOException e) {
                    System.err.println("Error creating book: "
                            + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: "
                    + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading file: "
                    + e.getMessage());
        }

        System.out.println("Unsorted books:");
        for (Book book : books) {
            System.out.println(book);
        }

        // Використання Comparator для сортування книг за ціною
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                return Double.compare(book1.getPrice(), book2.getPrice());
            }
        });

        System.out.println("\nSorted books by price:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    /**
     * Читає з файлу інформацію про книгу та повертає об'єкт Book.
     *
     * @param reader об'єкт для зчитування файлу
     * @return об'єкт Book
     * @throws IOException якщо виникла помилка при зчитуванні файлу
     */
    private static Book readBook(BufferedReader reader) throws IOException {
        String title = reader.readLine();
        String author = reader.readLine();
        int pageCount = Integer.parseInt(reader.readLine());
        double price = Double.parseDouble(reader.readLine());

        return new Book(title, author, pageCount, price);
    }

    /**
     * Читає з файлу інформацію про підручник та повертає об'єкт SchoolTextbook.
     *
     * @param reader об'єкт для зчитування файлу
     * @return об'єкт SchoolTextbook
     * @throws IOException якщо виникла помилка при зчитуванні файлу
     */
    private static SchoolTextbook readSchoolTextbook(BufferedReader reader) throws IOException {
        try {
            String title = readNonNullString(reader, "title");
            String author = readNonNullString(reader, "author");
            int pageCount = readPositiveInt(reader, "page count");
            double price = readPositiveDouble(reader, "price");
            String subject = readNonNullString(reader, "subject");
            int grade = readPositiveInt(reader, "grade");

            return new SchoolTextbook(title, author, pageCount, price, subject, grade);
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to read SchoolTextbook: " + e.getMessage(), e);
        }
    }

    /**
     * Читає з файлу інформацію про електронну книгу та повертає об'єкт EBook.
     *
     * @param reader об'єкт для зчитування файлу
     * @return об'єкт EBook
     * @throws IOException якщо виникла помилка при зчитуванні файлу
     */
    private static EBook readEBook(BufferedReader reader) throws IOException {
        try {
            String title = readNonNullString(reader, "title");
            String author = readNonNullString(reader, "author");
            int pageCount = readPositiveInt(reader, "page count");
            double price = readPositiveDouble(reader, "price");
            String fileFormat = readNonNullString(reader, "file format");
            double fileSize = readPositiveDouble(reader, "file size");

            return new EBook(title, author, pageCount, price, fileFormat, fileSize);
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to read EBook: " + e.getMessage(), e);
        }
    }

    /**
     * Читає з файлу непорожній рядок та повертає його.
     *
     * @param reader    об'єкт для зчитування файлу
     * @param attribute назва атрибута, який зчитується
     * @return рядок
     * @throws IOException якщо виникла помилка при зчитуванні файлу
     */
    private static String readNonNullString(BufferedReader reader, String attribute) throws IOException {
        String value = reader.readLine();
        if (value == null || value.trim().isEmpty()) {
            switch (attribute) {
                case "title":
                    throw new InvalidTitleException("Title cannot be null or empty.");
                case "author":
                    throw new InvalidAuthorException("Author cannot be null or empty.");
                case "subject":
                    throw new InvalidSubjectException("Subject cannot be null or empty.");
                case "file format":
                    throw new InvalidFileFormatException("File format cannot be null or empty.");
                default:
                    throw new IllegalArgumentException(attribute + " cannot be null or empty.");
            }
        }
        return value.trim();
    }

    /**
     * Читає з файлу додатне ціле число та повертає його.
     *
     * @param reader    об'єкт для зчитування файлу
     * @param attribute назва атрибута, який зчитується
     * @return ціле число
     * @throws IOException якщо виникла помилка при зчитуванні файлу
     */
    private static int readPositiveInt(BufferedReader reader, String attribute) throws IOException {
        String value = reader.readLine();
        try {
            int intValue = Integer.parseInt(value.trim());
            if (intValue <= 0) {
                throw new InvalidPageCountException(attribute + " must be positive and greater than zero.");
            }
            return intValue;
        } catch (NumberFormatException e) {
            throw new InvalidPageCountException("Expected a positive integer for " + attribute + ", but got: " + value);
        }
    }

    /**
     * Читає з файлу додатне дійсне число та повертає його.
     *
     * @param reader    об'єкт для зчитування файлу
     * @param attribute назва атрибута, який зчитується
     * @return дійсне число
     * @throws IOException якщо виникла помилка при зчитуванні файлу
     */
    private static double readPositiveDouble(BufferedReader reader, String attribute) throws IOException {
        String value = reader.readLine();
        try {
            double doubleValue = Double.parseDouble(value.trim());
            if (doubleValue <= 0) {
                throw new InvalidPriceException(attribute + " must be positive and greater than zero.");
            }
            return doubleValue;
        } catch (NumberFormatException e) {
            throw new InvalidPriceException("Expected a positive double for " + attribute + ", but got: " + value);
        }
    }

}
