package simple;

public class Book {

    private String author;
    private String title;
    private String body;

    public Book(String author, String title, String body) {
        this.author = author;
        this.title = title;
        this.body = body;
    }


    public String getAuthor() {
        return author;
    }
}
