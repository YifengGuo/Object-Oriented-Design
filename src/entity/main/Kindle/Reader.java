package entity.main.Kindle;

import java.io.File;

/**
 * Created by guoyifeng on 5/1/18.
 */
public abstract class Reader {
    protected Book book;

    public Reader(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return this.book;
    }

    abstract File toUTF8(Book book);

    abstract void separatePages(File file);

    abstract void display(File file);
}
