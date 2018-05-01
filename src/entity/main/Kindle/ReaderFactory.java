package entity.main.Kindle;

/**
 * Created by guoyifeng on 4/30/18.
 */

import java.io.File;

/**
 * This is simple factory for Book Reader
 * based on Book format create corresponding book reader
 */
public class ReaderFactory {
    public Reader createReader(Book book) {
        if (book.getFormat() == Format.EPUB) {
            return new EPUBReader(book);
        } else if (book.getFormat() == Format.MOBI) {
            return new MOBIReader(book);
        } else if (book.getFormat() == Format.PDF){
            return new PDFReader(book);
        } else {
            return null;
        }
    }
}
