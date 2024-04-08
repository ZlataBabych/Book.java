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
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Invalid title");
        }

        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Invalid author");
        }

        if (pageCount <= 0) {
            throw new IllegalArgumentException("Invalid pageCount");
        }

        if (price <= 0) {
            throw new IllegalArgumentException("Invalid price");
        }

        this.title = title;
        this.author = author;
        this.pageCount = pageCount;
        this.price = price;
    }

    /**
     * Конструктор копіювання класу Book.
     * @param another книга, яку копіюємо
     */
    public Book(Book another) {
        if (another == null) {
            throw new IllegalArgumentException("Invalid book");
        }

        this.title = another.title;
        this.author = another.author;
        this.pageCount = another.pageCount;
        this.price = another.price;
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
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Invalid title");
        }

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
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Invalid author");
        }

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
        if (pageCount <= 0) {
            throw new IllegalArgumentException("Page count must be greater than 0");
        }

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
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }

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

    /**
     * Метод для перевірки, чи однакові всі атрибути двох книг.
     * @param book книга для порівняння
     * @return однакові чи ні.
     */
    public boolean equals(Book book) {
        if (this == book) return true;
        if (book == null) return false;

        return pageCount == book.pageCount &&
                Double.compare(book.price, price) == 0 &&
                title.equals(book.title) &&
                author.equals(book.author);
    }
}
