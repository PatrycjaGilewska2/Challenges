import simple.Circle;
import simple.Square;

public class Application {

    public static void main(String[] args) {
        Square[] sqs = {new Square(2), new Square(1),
                new Square(3), new Square(4)};
        for (Square s : sqs) System.out.print(s + " ");
        System.out.print("\nAreas: ");
        for (Square s : sqs) System.out.print(s.getArea() + " ");
        System.out.print("\nPerimeters: ");
        for (Square s : sqs) System.out.print(s.getParameter() + " ");
        Circle[] crs = {new Circle(2), new Circle(1),
                new Circle(3), new Circle(4)};
        Square[] squares = Circle.getSquares(crs);
        System.out.println("\nAreas of squares from circles: ");
        for (Square s : squares) System.out.printf("%.2f ", s.getArea());
        System.out.println();
    }
}
