package library.utils;

import library.models.Book;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import sun.misc.IOUtils;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
    public static void mySerialize(Set<Book> books) {

        try (FileOutputStream fos = new FileOutputStream("books.txt"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            for (Book book : books)
                book.writeExternal(oos);

        } catch (Exception ex) {

            System.out.println(ex.getMessage());

        }

    }

    public static Set<Book> myUnserialize() {

        Set<Book> books = new HashSet<>();


        try (FileInputStream fis = new FileInputStream("books.txt"); ObjectInputStream ois = new ObjectInputStream(fis)) {

            while(fis.available() > 0) {

                Book auxBook = new Book();

                auxBook.readExternal(ois);

                books.add(auxBook);

                //System.out.printf("Название: %s \t Автор: %s \n", auxBook.getTitle(), auxBook.getAuthor());
            }

        } catch (Exception ex) {

            System.out.println(ex.getMessage());

        }

        return books;
    }

    public static void createXML () {

        Book b = new Book();

        try {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // create books
            Element books = doc.createElement("books");
            doc.appendChild(books);

            //  create book
            Element book = doc.createElement("book");
            books.appendChild(book);

            // create fields
            Element fields = doc.createElement("fields");
            book.appendChild(fields);

            for (Field fie : b.getClass().getDeclaredFields()) {

                Element field = doc.createElement("field");
                field.appendChild(doc.createTextNode(fie.getName()));
                fields.appendChild(field);

                System.out.println(fie.getName());
            }

            // create methods
            Element methods = doc.createElement("methods");
            book.appendChild(methods);

            for (Method met : b.getClass().getMethods()) {

                Element method = doc.createElement("method");
                method.appendChild(doc.createTextNode(met.getName()));
                methods.appendChild(method);

                //System.out.println(met.getName());
            }

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("books.xml"));
            transformer.transform(source, result);

            // Output to console for testing
            //StreamResult consoleResult = new StreamResult(System.out);
            //transformer.transform(source, consoleResult);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}