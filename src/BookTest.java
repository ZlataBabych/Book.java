// Бабич З.А.
// ООП на мові Java
// Лабораторна робота 11
// Кінцевий строк подання: 15 квітня 2024
// Використано часу: 1 година
// Це моя власна робота. Не було використано жодної несанкціонованої допомоги.

// Це драйвер для класу Book. Він демонструє конструктор, конструктор копіювання,
// гетери, сетери, метод equals та метод toString()
// для успадкованого від класу Book класу SchoolTextbook

import java.util.Scanner;

public class BookTest {
    public static void main(String[] args) {

        // Створення нового об'єкту шкільного підручника
        SchoolTextbook textbook1 = new SchoolTextbook
                ("Mathematics for Grade 7", "John Doe", 200, 29.99, "Mathematics", 7);

        // Виведення інформації про підручник
        System.out.println("Textbook 1 details: " + textbook1);

        // Створення копії підручника за допомогою конструктора копіювання
        SchoolTextbook textbook2 = new SchoolTextbook(textbook1);
        System.out.println("Textbook 2 (copy of Textbook 1) details: " + textbook2);

        // Перевірка на рівність двох підручників
        System.out.println("Are Textbook 1 and Textbook 2 equal? " + textbook1.equals(textbook2));

        // Зміна деяких властивостей textbook2
        textbook2.setTitle("Advanced Mathematics for Grade 7");
        textbook2.setPrice(34.99);

        // Використання гетерів і сетерів
        System.out.println("Updated Textbook 2 title: " + textbook2.getTitle());
        System.out.println("Updated Textbook 2 price: " + textbook2.getPrice());

        // Перевірка на рівність двох підручників
        System.out.println("Are Textbook 1 and Textbook 2 equal? " + textbook1.equals(textbook2));

        // Створення ще одного підручника для порівняння
        SchoolTextbook textbook3 = new SchoolTextbook(
                "Biology for Grade 10", "Jane Smith", 150, 25.50, "Biology", 10);
        System.out.println("Textbook 3 details: " + textbook3);

        // Перевірка на рівність textbook2 та textbook3
        System.out.println("Are Textbook 2 and Textbook 3 equal? " + textbook2.equals(textbook3));

        
    }
}




