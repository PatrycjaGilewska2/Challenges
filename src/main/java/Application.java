import simple.Book;
import simple.Library;
import simple.Shelf;

public class Application {

    public static void main(String[] args) {
        Shelf shelf1 = new Shelf("Shelf1", new Book[]{
                new Book("Babe1", "Odessa Tales", "babelode"),
                new Book("Joyce", "Ulisses", "joyceuli")
        });
        Shelf shelf2 = new Shelf("Shelf2", new Book[]{
                new Book("Mann", "Dr Faustus", "mannfrau"),
                new Book("Babel", "Red Cavalry", "babelred")
        });
        Library lib = new Library(new Shelf[]{shelf1, shelf2});
        System.out.println("No of books by this author: " + lib.countAuthor("Babel"));
    }
}
