/**
 * Клас, що представляє газету, яка успадковує властивості та методи класу Book.
 */
public class Newspaper extends Book {
    private String publicationDate; // Дата публікації
    private String frequency; // Періодичність випусків

    /**
     * Конструктор класу Newspaper для створення нової газети з заданими атрибутами.
     *
     * @param title          назва газети
     * @param author         автор газети (або видавець)
     * @param pageCount      кількість сторінок у газеті
     * @param price          ціна газети
     * @param publicationDate дата публікації газети
     * @param frequency      періодичність випусків газети
     */
    public Newspaper(String title, String author, int pageCount, double price,
                     String publicationDate, String frequency) {
        super(title, author, pageCount, price); // Виклик конструктора базового класу

        if (publicationDate == null || publicationDate.isBlank()) {
            throw new IllegalArgumentException("Invalid publication date");
        }

        if (frequency == null || frequency.isBlank()) {
            throw new IllegalArgumentException("Invalid frequency");
        }

        this.publicationDate = publicationDate;
        this.frequency = frequency;
    }

    /**
     * Конструктор копіювання класу Newspaper.
     *
     * @param another газета, яку копіюємо
     */
    public Newspaper(Newspaper another) {
        super(another); // Виклик конструктора копіювання базового класу

        this.publicationDate = another.publicationDate;
        this.frequency = another.frequency;
    }

    /**
     * Гетер для отримання дати публікації.
     * @return дата публікації
     */
    public String getPublicationDate() {
        return publicationDate;
    }

    /**
     * Сетер для встановлення дати публікації.
     * @param publicationDate нова дата публікації
     */
    public void setPublicationDate(String publicationDate) {
        if (publicationDate == null || publicationDate.isBlank()) {
            throw new IllegalArgumentException("Invalid publication date");
        }

        this.publicationDate = publicationDate;
    }

    /**
     * Гетер для отримання періодичності випусків.
     * @return періодичність випусків
     */
    public String getFrequency() {
        return frequency;
    }

    /**
     * Сетер для встановлення періодичності випусків.
     * @param frequency нова періодичність випусків
     */
    public void setFrequency(String frequency) {
        if (frequency == null || frequency.isBlank()) {
            throw new IllegalArgumentException("Invalid frequency");
        }

        this.frequency = frequency;
    }

    /**
     * Метод для виведення всієї інформації про газету як рядок.
     * @return Рядок з інформацією про газету.
     */
    @Override
    public String toString() {
        return super.toString() +
                ", Publication Date: " + publicationDate + ", Frequency: " + frequency;
    }

    /**
     * Метод для перевірки, чи однакові всі атрибути двох газет.
     * @param newspaper об'єкт для порівняння
     * @return однакові чи ні.
     */
    public boolean equals(Newspaper newspaper) {
        if (!super.equals(newspaper)) return false;
        if (this == newspaper) return true;

        return publicationDate.equals(newspaper.publicationDate) &&
                frequency.equals(newspaper.frequency);
    }
}
