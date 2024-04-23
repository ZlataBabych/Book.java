// Бабич З.А.
// ООП на мові Java
// Лабораторна робота 15
// Кінцевий строк подання: 06 травня 2024
// Використано часу: 2 години
// Це моя власна робота. Не було використано жодної несанкціонованої допомоги.

// Повний опис драйверу: програма читає з файлу інформацію
// про книги (підручники та електронні книги) та виводить її на екран.
// Винятки обробляються відповідним чином.
// Якщо виникає помилка при зчитуванні файлу,
// виводиться повідомлення про помилку.


import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class BookTest {
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

        for (Book book : books) {
            System.out.println(book);
        }
    }

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
     * @throws IllegalArgumentException якщо виникла помилка при створенні об'єкту
     */
    private static SchoolTextbook readSchoolTextbook(BufferedReader reader)
            throws IOException, IllegalArgumentException {
        String title = readNonNullString(reader);
        String author = readNonNullString(reader);
        int pageCount = readPositiveInt(reader);
        double price = readPositiveDouble(reader);
        String subject = readNonNullString(reader);
        int grade = readPositiveInt(reader);

        return new SchoolTextbook(title, author,
                pageCount, price, subject, grade);
    }

    /**
     * Читає з файлу інформацію про електронну книгу та повертає об'єкт EBook.
     *
     * @param reader об'єкт для зчитування файлу
     * @return об'єкт EBook
     * @throws IOException якщо виникла помилка при зчитуванні файлу
     * @throws IllegalArgumentException якщо виникла помилка при створенні об'єкту
     */
    private static EBook readEBook(BufferedReader reader)
            throws IOException, IllegalArgumentException {
        String title = readNonNullString(reader);
        String author = readNonNullString(reader);
        int pageCount = readPositiveInt(reader);
        double price = readPositiveDouble(reader);
        String fileFormat = readNonNullString(reader);
        double fileSize = readPositiveDouble(reader);

        return new EBook(title, author, pageCount,
                price, fileFormat, fileSize);
    }

    /**
     * Читає з файлу рядок та перевіряє, що він не є пустим або null.
     *
     * @param reader об'єкт для зчитування файлу
     * @return рядок, який не є пустим або null
     * @throws IOException якщо виникла помилка при зчитуванні файлу
     * @throws IllegalArgumentException якщо рядок є пустим або null
     */
    private static String readNonNullString(BufferedReader reader)
            throws IOException {
        String value = reader.readLine();
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException
                    ("Expected non-null, non-empty string value");
        }
        return value.trim();
    }

    /**
     * Читає з файлу ціле число та перевіряє, що воно є додатнім.
     *
     * @param reader об'єкт для зчитування файлу
     * @return додатнє ціле число
     * @throws IOException якщо виникла помилка при зчитуванні файлу
     * @throws IllegalArgumentException якщо число не є додатнім
     */
    private static int readPositiveInt(BufferedReader reader)
            throws IOException {
        String value = reader.readLine();
        try {
            int intValue = Integer.parseInt(value.trim());
            if (intValue <= 0) {
                throw new IllegalArgumentException("Value must be positive");
            }
            return intValue;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException
                    ("Expected an integer value, but got: " + value);
        }
    }

    /**
     * Читає з файлу дійсне число та перевіряє, що воно є додатнім.
     *
     * @param reader об'єкт для зчитування файлу
     * @return додатнє дійсне число
     * @throws IOException якщо виникла помилка при зчитуванні файлу
     * @throws IllegalArgumentException якщо число не є додатнім
     */
    private static double readPositiveDouble(BufferedReader reader)
            throws IOException {
        String value = reader.readLine();
        try {
            double doubleValue = Double.parseDouble(value.trim());
            if (doubleValue <= 0) {
                throw new IllegalArgumentException("Value must be positive");
            }
            return doubleValue;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException
                    ("Expected a double value, but got: " + value);
        }
    }
}




