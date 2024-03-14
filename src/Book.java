// Бабич З.А.
// ООП на мові Java
// Лабораторна робота 7
// Кінцевий строк подання: 21 березня 2024
// Використано часу: 0.5 години
// Це моя власна робота. Не було використано жодної несанкціонованої допомоги.

// Ця програма описує клас Book з основними атрибутами та методами

/**
 * Клас, що представляє книгу з відповідними атрибутами та методами
 */
public class Book {
    private String title; // Назва книги
    private String author; // Автор книги
    private int pageCount; // Кількість сторінок у книзі
    private double price; // Ціна книги

    /**
     * Конструктор класу Book для створення нової книги з заданими атрибутами.
     * @param title назва книги
     * @param author автор книги
     * @param pageCount кількість сторінок у книзі
     * @param price ціна книги
     */
    public Book(String title, String author, int pageCount, double price) {
        this.title = title;
        this.author = author;
        this.pageCount = pageCount;
        this.price = price;
    }

    /**
     * Гетер для отримання назви книги.
     * @return назва книги
     */
    public String getTitle() {
        return title;
    }

    /**
     * Сетер для встановлення назви книги.
     * @param title нова назва книги
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Гетер для отримання автора книги.
     * @return автор книги
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Сетер для встановлення автора книги.
     * @param author новий автор книги
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Гетер для отримання кількості сторінок у книзі.
     * @return кількість сторінок у книзі
     */
    public int getPageCount() {
        return pageCount;
    }

    /**
     * Сетер для встановлення кількості сторінок у книзі.
     * @param pageCount нова кількість сторінок у книзі
     */
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * Гетер для отримання ціни книги.
     * @return ціна книги
     */
    public double getPrice() {
        return price;
    }

    /**
     * Сетер для встановлення ціни книги.
     * @param price нова ціна книги
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Метод для виведення всієї інформації про книгу як рядок.
     * @return Рядок з інформацією про книгу.
     */
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author +
                ", Page count: " + pageCount + ", Price: $" + price;
    }
}
