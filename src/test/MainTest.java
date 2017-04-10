package test;

import library.Library;
import library.models.Book;
import library.models.BookInstance;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Kuznetsov on 10/04/2017.
 */
public class MainTest {

    private static Library library;

    @BeforeClass
    public static void init() {
        library = new Library();
    }

    @Test
    public void buyBookTestCatalog() {

        library.buyBook("Java. Полное руководство", "Герберт Шилдт", "978-5-8459-1759-1", 1, 2012);

        assertEquals(1, library.getCatalog().size()); // Проверяем, что книга куплена и что она одна

        Book book = new Book("Герберт Шилдт", "Java. Полное руководство", 2012, "978-5-8459-1759-1");

        assertTrue(library.getCatalog().contains(book));

        Book bookFromCatalog = library.getCatalog().iterator().next();

        assertTrue(book.getTitle().equals(bookFromCatalog.getTitle()));

        assertTrue(book.getAuthor().equals(bookFromCatalog.getAuthor()));

        assertTrue(book.getIsbn().equals(bookFromCatalog.getIsbn()));

        assertTrue(book.getYear() == bookFromCatalog.getYear());

    }

    @Test
    public void buyBookTestStore() {

        library.buyBook("Java. Полное руководство", "Герберт Шилдт", "978-5-8459-1759-1", 5, 2012);

        assertEquals(5, library.getStore().size());

        Book book = new Book("Герберт Шилдт", "Java. Полное руководство", 2012, "978-5-8459-1759-1");

        assertTrue(5 == library.getStore().size());

        for (BookInstance bookInstance : library.getStore()) {
            Book bookFromStore = bookInstance.getBook();
            assertTrue(book.getTitle().equals(bookFromStore.getTitle()));
            assertTrue(book.getIsbn().equals(bookFromStore.getIsbn()));
            assertTrue(book.getAuthor().equals(bookFromStore.getAuthor()));
            assertTrue(book.getYear() == bookFromStore.getYear());
        }

    }

    @Test
    public void takeBookTest() {

        library.buyBook("Java. Полное руководство", "Герберт Шилдт", "978-5-8459-1759-1", 5, 2012);

        library.takeBook("Антон", "Александрович", "Кузнецов", 223445, "Java. Полное руководство");

        assertEquals(4, library.getStore().size()); //Книжек стало меньше

        assertEquals(1, library.getBookings().size()); //Бронирование увеличивается
    }

    @Test
    public void returnBookTest() {
        library.buyBook("Java. Полное руководство", "Герберт Шилдт", "978-5-8459-1759-1", 5, 2012);

        library.takeBook("Антон", "Александрович", "Кузнецов", 223445, "Java. Полное руководство");

        assertEquals(4, library.getStore().size()); // Взяли книгу, количество уменьшилось

        library.returnBook("Антон", "Александрович", "Кузнецов", 223445, "Java. Полное руководство");

        assertEquals(5, library.getStore().size()); // Вернули, количество увеличилось

        Book book = new Book("Герберт Шилдт", "Java. Полное руководство", 2012, "978-5-8459-1759-1");

        assertTrue(library.getCatalog().contains(book));

        assertEquals(0, library.getBookings().size()); //Бронирование уменьшается
    }

    @After //ДБ AfterEach
    public void clearAll() {

        library = new Library();

    }

}