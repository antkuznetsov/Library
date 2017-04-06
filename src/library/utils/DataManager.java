package library.utils;

import library.models.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kuznetsov on 05/04/2017.
 */
public class DataManager {

    /*
    public static void serializeToFile(Set<Book> books) {
        try (FileOutputStream fos = new FileOutputStream("books.txt"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for (Book book : books)
                oos.writeObject(book);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Set<Book> unSerialize() {

        Set<Book> books = new HashSet<>();

        try (FileInputStream fis = new FileInputStream("books.txt");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            Book book = null;
            while ((book = (Book) ois.readObject()) != null) {
                books.add(book);
            }

            for (int i = 0; i < 2; i++) {
                books.add(book);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            return books;
        }

    }
    */
    public static void serializeToFile(Set<Book> books) {

        try (FileOutputStream fos = new FileOutputStream("books.txt"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            for (Book book : books)
                oos.writeObject(book);

        } catch (Exception ex) {

            System.out.println(ex.getMessage());

        }

    }

    public static Set<Book> unSerialize() {

        Set<Book> books = new HashSet<>();

        try (FileInputStream fis = new FileInputStream("books.txt"); ObjectInputStream ois = new ObjectInputStream(fis)) {

            while(fis.available() > 0) {

                Book book = (Book) ois.readObject();

                books.add(book);

                //System.out.printf("Название: %s \t Автор: %s \n", book.getTitle(), book.getAuthor());
            }

        } catch (Exception ex) {

            System.out.println(ex.getMessage());

        }

        return books;

    }
}