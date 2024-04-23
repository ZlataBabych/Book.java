/**
 * Клас, що представляє електронну книгу, яка успадковує властивості та методи класу
 Book.
 */
public class EBook extends Book {
    private String fileFormat; // Формат файлу електронної книги
    private double fileSize; // Розмір файлу в мегабайтах
    /**
     * Конструктор класу EBook для створення нової електронної книги з заданими
     атрибутами.
     *
     * @param title назва електронної книги
     * @param author автор електронної книги
     * @param pageCount кількість сторінок в електронній книзі
     * @param price ціна електронної книги
     * @param fileFormat формат файлу електронної книги
     * @param fileSize розмір файлу в мегабайтах
     */
    public EBook(String title, String author, int pageCount, double price,
                 String fileFormat, double fileSize) {
        super(title, author, pageCount, price); // Виклик конструктора базового класу
        if (fileFormat == null || fileFormat.isBlank()) {
            throw new IllegalArgumentException("Invalid file format");
        }
        if (fileSize <= 0) {
            throw new IllegalArgumentException("Invalid file size");
        }
        this.fileFormat = fileFormat;
        this.fileSize = fileSize;
    }
    /**
     * Конструктор копіювання класу EBook.
     *
     * @param another електронна книга, яку копіюємо
     */
    public EBook(EBook another) {
        super(another); // Виклик конструктора копіювання базового класу
        this.fileFormat = another.fileFormat;
        this.fileSize = another.fileSize;
    }
    /**
     * Гетер для отримання формату файлу.
     * @return формат файлу
     */
    public String getFileFormat() {
        return fileFormat;
    }
    /**
     * Сетер для встановлення формату файлу.

     * @param fileFormat новий формат файлу
     */
    public void setFileFormat(String fileFormat) {
        if (fileFormat == null || fileFormat.isBlank()) {
            throw new IllegalArgumentException("Invalid file format");
        }
        this.fileFormat = fileFormat;
    }
    /**
     * Гетер для отримання розміру файлу.
     * @return розмір файлу в мегабайтах
     */
    public double getFileSize() {
        return fileSize;
    }
    /**
     * Сетер для встановлення розміру файлу.
     * @param fileSize новий розмір файлу в мегабайтах
     */
    public void setFileSize(double fileSize) {
        if (fileSize <= 0) {
            throw new IllegalArgumentException("Invalid file size");
        }
        this.fileSize = fileSize;
    }
    /**
     * Метод для виведення всієї інформації про електронну книгу як рядок.
     * @return Рядок з інформацією про електронну книгу.
     */
    @Override
    public String toString() {
        return super.toString() +
                ", File Format: " + fileFormat + ", File Size: " +
                String.format("%.2f", fileSize) + " MB";
    }
    /**
     * Метод для перевірки, чи однакові всі атрибути двох електронних книг.
     * @param ebook об&#39;єкт для порівняння
     * @return однакові чи ні.
     */
    public boolean equals(EBook ebook) {
        if (!super.equals(ebook)) return false;
        if (this == ebook) return true;
        return fileFormat.equals(ebook.fileFormat)
                && Double.compare(fileSize, ebook.fileSize) == 0;
    }
}