/**
 * Клас, що представляє автора книги з відповідними атрибутами та методами.
 */

public class Owner {
    private String name; // Ім'я автора
    private String contactInfo; // Контактна інформація автора


    /**
     * Конструктор для створення об'єкту Owner з вказаними параметрами.
     * @param name        ім'я власника
     * @param contactInfo контактна інформація власника
     */
    public Owner(String name, String contactInfo) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid owner");
        }

        if (contactInfo == null || contactInfo.isBlank()) {
            throw new IllegalArgumentException("Invalid contact");
        }

        this.name = name;
        ;
        this.contactInfo = contactInfo;
        ;
    }

    /**
     * Конструктор копіювання.
     *
     * @param another інший об'єкт Owner, з якого буде скопійовано дані
     */
    public Owner(Owner another) {
        if (another == null) {
            throw new IllegalArgumentException("Invalid owner copy");
        }

        this.name = another.name;
        this.contactInfo = another.contactInfo;
    }

    /**
     * Гетер для отримання імені власника.
     *
     * @return ім'я власника
     */
    public String getName() {
        return name;
    }

    /**
     * Сетер для встановлення імені власника.
     *
     * @param name нове ім'я власника
     */
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid owner name");
        }

        this.name = name;
    }

    /**
     * Гетер для отримання контактної інформації власника.
     *
     * @return контактна інформація власника
     */
    public String getContactInfo() {
        return contactInfo;
    }

    /**
     * Сетер для встановлення контактної інформації власника.
     *
     * @param contactInfo нова контактна інформація власника
     */
    public void setContactInfo(String contactInfo) {
        if (contactInfo == null || contactInfo.isBlank()) {
            throw new IllegalArgumentException("Invalid owner contact");
        }

        this.contactInfo = contactInfo;
    }

    /**
     * Перевизначений метод toString для виведення інформації про автора.
     *
     * @return рядок з інформацією про власника книги
     */
    @Override
    public String toString() {
        return "Name: " + name + ", Contact Info: " + contactInfo;
    }

    /**
     * Перевіряє, чи об'єкт Owner рівний іншому об'єкту Owner.
     *
     * @param owner об'єкт Owner для порівняння
     * @return true, якщо об'єкти рівні;
     * false, якщо не рівні або переданий об'єкт є null чи є тим самим об'єктом
     */
    public boolean equals(Owner owner) {
        if (this == owner) return true;
        if (owner == null) return false;

        return name.equals(owner.name) &&
                contactInfo.equals(owner.contactInfo);
    }
}
