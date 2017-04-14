package ru.innopolis;

import library.Library;
import library.models.Book;
import library.models.DatabaseManager;
import library.models.Reader;
import library.utils.DataManager;
import library.utils.SendMailTLS;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {

    /*
    static {
        //PropertyConfigurator.configure("log4g.properties");
    }
    */

    //private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        //SendMailTLS mail = new SendMailTLS();
        //mail.sendMyMail("Тестовое письмо");

        //logger.debug("Hello!");


        //DatabaseManager manager = new DatabaseManager();
        //manager.select();


        //Book book = new Book("Александр Пушкин", "Медный всадник", 1800, "123mofe2");

        //book.print();

        //book.getInfoAboutClass();

        //DataManager.createXML();

        Library library = new Library();

        //for(Book book : DataManager.deserialize())
            //library.buyBook(book.getTitle(), book.getAuthor(), book.getIsbn(), 1, book.getYear());

        //Создаем 2-х читателей
        //Reader anton = new Reader("Антон", "Александрович", "Кузнецов", 223445);
        //Reader max = new Reader("Максим", "Юрьевич", "Андреев", 431345);

        //Покупаем 2 книги (по несколько экземпляров)
        //library.buyBook("Java. Полное руководство", "Герберт Шилдт", "978-5-8459-1759-1", 3, 2012);
        //library.buyBook("Структуры данных и алгоритмы в Java", "Роберт Лафоре", "978-5-496-00740-5", 2, 2016);

        //Берем книгу
        //library.takeBook("Антон", "Александрович", "Кузнецов", 223445, "Java. Полное руководство");
        //library.takeBook("Максим", "Юрьевич", "Андреев", 431345, "Структуры данных и алгоритмы в Java");

        //Возвращаем книгу
        //library.returnBook("Антон", "Александрович", "Кузнецов", 223445, "Java. Полное руководство");

        //Показываем все данные
        //library.showAllData();

        //Серриализуем
        //DataManager.mySerialize(library.getCatalog());

        //System.out.println("-----");
        //System.out.println("Десириализуем");

        //DataManager.myUnserialize();

        //System.out.println(DataManager.unSerialize());

        //library.setCatalog(DataManager.myUnserialize());

        for(Book book : DataManager.myUnserialize())
            library.buyBook(book.getTitle(), book.getAuthor(), book.getIsbn(), 1, book.getYear());

        //Показываем все данные
        library.showAllData();
    }
}