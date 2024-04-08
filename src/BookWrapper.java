/**
 * Клас-обгортка для класу Book, надаючи доступ лише до гетерів і основних методів
 * для перегляду інформації про книгу.
 */
public class BookWrapper {

    final private Book book; // Посилання на об'єкт класу Book

    /**
     * Конструктор для створення об'єкту BookWrapper з вказаними параметрами книги.
     * @param title Назва книги, не може бути null або порожнім рядком.
     * @param author Автор книги, не може бути null або порожнім рядком.
     * @param pageCount Кількість сторінок у книзі, має бути більше 0.
     * @param price Ціна книги, має бути більше 0.
     * @throws IllegalArgumentException у випадку некоректних вхідних даних.
     */
    public BookWrapper(String title, String author, int pageCount, double price) {
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

        this.book = new Book(title, author, pageCount, price);
    }

    /**
     * Конструктор копіювання для створення об'єкту BookWrapper на основі іншого об'єкта Book.
     * @param another Об'єкт класу Book для копіювання, не може бути null.
     * @throws IllegalArgumentException у випадку якщо переданий об'єкт є null.
     */
    public BookWrapper(Book another) {
        if (another == null) {
            throw new IllegalArgumentException("Invalid book copy");
        }

        this.book = new Book(another);
    }

    /**
     * Гетер для отримання назви книги.
     * @return Назва книги.
     */
    public String getTitle() {
        return book.getTitle();
    }

    /**
     * Гетер для отримання автора книги.
     * @return Автор книги.
     */
    public String getAuthor() {
        return book.getAuthor();
    }

    /**
     * Гетер для отримання кількості сторінок у книзі.
     * @return Кількість сторінок у книзі.
     */
    public int getPageCount() {
        return book.getPageCount();
    }

    /**
     * Гетер для отримання ціни книги.
     * @return Ціна книги.
     */
    public double getPrice() {
        return book.getPrice();
    }

    /**
     * Перевизначений метод toString для виведення інформації про об'єкт BookWrapper.
     * @return Рядок з інформацією про об'єкт BookWrapper.
     */
    @Override
    public String toString() {
        return book.toString();
    }

    /**
     * Метод для порівняння об'єкта BookWrapper з іншим об'єктом.
     * @param obj BookWrapper для порівняння.
     * @return true, якщо об'єкти рівні; false в іншому випадку.
     */
    public boolean equals(BookWrapper obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        return book.equals(obj.book);
    }
}
