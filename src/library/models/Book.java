package library.models;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created by Kuznetsov on 05/04/2017.
 */
public class Book implements Externalizable {
    private String author;
    private String title;
    private String isbn;
    private int year;
    private static long serialVersionUID = 5L;

    public void print(){
        //System.out.println(Book.class.getCanonicalName());
        for (Method met:this.getClass().getMethods()) {

            System.out.println(met.getName());
            System.out.println(met.getReturnType().getName());

            for (Parameter param:met.getParameters()){
                System.out.println(param.getName() + " "+ param.getType().getName());
            }

            System.out.println(met.getModifiers());
        }

        try {
            for(Field field: Class.forName("library.models.Book").getFields()){
                System.out.println(field.getName());
                System.out.println(field.getType().getName());
                System.out.println(field.isAccessible());
            }
            System.out.println();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public void getInfoAboutClass () {

        //System.out.println(Book.class.getCanonicalName());

        //System.out.println(Book.class.getCanonicalName());

        /*
        for (Method met:this.getClass().getMethods()) {
            System.out.println(met.getName());
        }
        */
        //System.out.println(this.getClass());

        System.out.println("About class");

        Class clazz = Book.class;

        // выводим поля класса
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("\t" + field.getModifiers()
                    + field.getType() + " " + field.getName() + ";");
        }

    }


    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public Book() {
        author = null;
        title = null;
        isbn = null;
        year = 0;
    }

    public Book(String author, String title, int year, String isbn) {
        this.author = author;
        this.title = title;
        this.year = year;
        this.isbn = isbn;
    }

    @Override
    public int hashCode() {
        return isbn.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (!(obj instanceof Book))
            return false;

        if (!isbn.equals(((Book) obj).isbn))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(author);
        out.writeObject(title);
        out.writeObject(year);
        out.writeObject(isbn);
        out.writeUTF("by @antkuznetsov");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.author = (String) in.readObject();
        this.title = (String) in.readObject();
        this.year = (int) in.readObject();
        this.isbn = (String) in.readObject();
        in.readUTF();
    }
}