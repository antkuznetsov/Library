package ru.innopolis;

import library.Library;
import library.models.Book;
import library.models.Reader;
import library.utils.DataManager;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();

        //for(Book book : DataManager.deserialize())
            //library.buyBook(book.getTitle(), book.getAuthor(), book.getIsbn(), 1, book.getYear());

        //Создаем 2-х читателей
        //Reader anton = new Reader("Антон", "Александрович", "Кузнецов", 223445);
        //Reader max = new Reader("Максим", "Юрьевич", "Андреев", 431345);

        //Покупаем 2 книги (по несколько экземпляров)
        //library.buyBook("Java. Полное руководство", "Герберт Шилдт", "978-5-8459-1759-1", 1, 2012);
        //library.buyBook("Структуры данных и алгоритмы в Java", "Роберт Лафоре", "978-5-496-00740-5", 1, 2016);

        //Берем книгу
        //library.takeBook("Антон", "Александрович", "Кузнецов", 223445, "Java. Полное руководство");
        //library.takeBook("Максим", "Юрьевич", "Андреев", 431345, "Структуры данных и алгоритмы в Java");

        //Возвращаем книгу
        //library.returnBook("Антон", "Александрович", "Кузнецов", 223445, "Java. Полное руководство");

        //Показываем все данные
        //library.showAllData();

        //Серриализуем
        //DataManager.serializeToFile(library.getCatalog());

        //System.out.println("-----");
        //System.out.println("Десириализуем");

        //DataManager.unSerialize();

        //System.out.println(DataManager.unSerialize());


        for(Book book : DataManager.unSerialize())
            library.buyBook(book.getTitle(), book.getAuthor(), book.getIsbn(), 1, book.getYear());


        //Показываем все данные
        library.showAllData();
    }
}