package entity.main.Kindle;

/**
 * Created by guoyifeng on 4/30/18.
 */
public class Book {
    private Format format;
    private String name;

    public Format getFormat() {
        return format;
    }


    public String getName() {
        return name;
    }

    public Book(String name, Format format) {
        this.name = name;
        this.format = format;
    }
}
