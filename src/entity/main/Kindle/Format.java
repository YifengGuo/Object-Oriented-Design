package entity.main.Kindle;

/**
 * Created by guoyifeng on 4/30/18.
 */
public enum Format {
    PDF("PDF"),
    EPUB("EPUB"),
    MOBI("MOBI");

    private String content;

    Format(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
