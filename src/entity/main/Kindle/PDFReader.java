package entity.main.Kindle;

import java.io.File;

/**
 * Created by guoyifeng on 4/30/18.
 */
public class PDFReader extends Reader {


    public PDFReader(Book book) {
        super(book);
    }

    @Override
    public File toUTF8(Book book) {
        return new File("src/entity/main/Kindle/File_PDF.txt");
    }

    @Override
    public void separatePages(File file) {
        System.out.println("Separating " + file.getName() + " pages...");
    }

    @Override
    public void display(File file) {
        System.out.println("Now displaying " + file.getName() + " in PDF format.");
    }
}
