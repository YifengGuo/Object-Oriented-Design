package entity.main.Kindle;

/**
 * Created by guoyifeng on 5/1/18.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Test program for Kindle
 */
public class Test {
    public static void main(String[] args) throws Exception {
        List<Book> library = new ArrayList<>();
        Book book1 = new Book("Intro to Algo", Format.PDF);
        Book book2 = new Book("Computer Architecture", Format.EPUB);
        Book book3 = new Book("Design Patterns", Format.MOBI);
        Kindle kindle = new Kindle();
        kindle.downloadBook(book1);
        kindle.downloadBook(book2);
        kindle.downloadBook(book3);
        kindle.readBook(book1);

        // Book book4 = new Book("C++ Prime", null);
        // kindle.readBook(book4);

        Book book5 = new Book("Effective Java", Format.PDF);
        kindle.downloadBook(book5);

        kindle.showAllBooks();
        kindle.removeBook(book1);
        kindle.showAllBooks();
    }
}
