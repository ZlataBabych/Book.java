/**
 * Клас, що представляє шкільний підручник, який успадковує властивості та методи класу Book.
 */
public class SchoolTextbook extends Book {
    private String subject; // Предмет, до якого належить підручник
    private int grade; // Клас, для якого призначений підручник

    /**
     * Конструктор класу SchoolTextbook для створення нового шкільного підручника з заданими атрибутами.
     *
     * @param title     назва підручника
     * @param author    автор підручника
     * @param pageCount кількість сторінок у підручнику
     * @param price     ціна підручника
     * @param subject   предмет підручника
     * @param grade     клас, для якого призначений підручник
     */
    public SchoolTextbook(String title, String author, int pageCount, double price, String subject, int grade) {
        super(title, author, pageCount, price); // Виклик конструктора базового класу

        if (subject == null || subject.isBlank()) {
            throw new IllegalArgumentException("Invalid subject");
        }

        if (grade <= 0) {
            throw new IllegalArgumentException("Invalid grade");
        }

        this.subject = subject;
        this.grade = grade;
    }

    /**
     * Конструктор копіювання класу SchoolTextbook.
     *
     * @param another підручник, який копіюємо
     */
    public SchoolTextbook(SchoolTextbook another) {
        super(another); // Виклик конструктора копіювання базового класу

        this.subject = another.subject;
        this.grade = another.grade;
    }

    /**
     * Гетер для отримання назви предмету.
     * @return назва предмету
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Сетер для встановлення назви предмету.
     * @param subject нова назва предмету книги
     */
    public void setSubject(String subject) {
        if (subject == null || subject.isBlank()) {
            throw new IllegalArgumentException("Invalid subject");
        }

        this.subject = subject;
    }

    /**
     * Гетер для отримання класу.
     * @return клас
     */
    public int getGrade() {
        return grade;
    }

    /**
     * Сетер для встановлення класу.
     * @param grade новий клас
     */
    public void setGrade(int grade) {
        if (grade <= 0) {
            throw new IllegalArgumentException("Invalid grade");
        }

        this.grade = grade;
    }

    /**
     * Метод для виведення всієї інформації про книгу як рядок.
     * @return Рядок з інформацією про книгу.
     */
    @Override
    public String toString() {
        return super.toString() +
                ", Subject: " + subject + ", Grade: " + grade;
    }

    /**
     * Метод для перевірки, чи однакові всі атрибути двох книг.
     * @param book книга для порівняння
     * @return однакові чи ні.
     */
    public boolean equals(SchoolTextbook book) {
        if (book == null) return false;
        if (this == book) return true;

        return getAuthor().equals(book.getAuthor())
                && getTitle().equals(book.getTitle())
                && Double.compare(getPrice(), book.getPrice()) == 0
                && getPageCount() == book.getPageCount()
                && subject.equals(book.subject)
                && grade == book.grade;
    }
}
