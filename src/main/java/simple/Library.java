package simple;

public class Library {

    private Shelf[] shelves;

    public Library(Shelf[] shelves) {
        this.shelves = shelves;
    }

    /**
     * Returns number of books written by author.
     */
    public int countAuthor(String author) {
        int counter = 0;
        for (Shelf shelf : shelves) {
            for (Book book : shelf.getBooks()) {
                if (book.getAuthor().equals(author)) counter++;
            }
        }
        return counter;
    }
}
