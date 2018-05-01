package entity.main.Kindle;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guoyifeng on 4/30/18.
 */

/**
 * Core Object Kindle which implements several basic use cases
 */
public class Kindle {
    private List<Book> library;
    private ReaderFactory factory;

    public Kindle() {
        library = new ArrayList<>();
        factory = new ReaderFactory();
    }

    public void downloadBook(Book book) {
        this.library.add(book);
    }

    public void uploadBook(Book book) {
        System.out.println("Successfully upload book " + book.getName() + " to Kindle cloud.");
    }

    public boolean removeBook(Book book) {
        return this.library.remove(book);
    }

    public void readBook(Book book) throws Exception {
        Reader bookReader = factory.createReader(book);

        if (bookReader == null) {
            throw new BookReaderException("Cannot find proper book reader.");
        } else {
            File file = bookReader.toUTF8(book);
            bookReader.display(file);
        }
    }

    public void showAllBooks() {
        for (Book book : library) {
            System.out.println(book.getName() + " " + book.getFormat());
        }
    }
}
