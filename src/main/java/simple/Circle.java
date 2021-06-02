package simple;

public class Circle {

    private int parameter;
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Creates Circle with the same area as Square
     */
    Circle(Square square) {
        this.radius = Math.sqrt(square.getArea() / Math.PI);
    }

    public double getRadius() {
        return this.radius;
    }

    public int getParameter() {
        return this.parameter;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public String toString() {
        String radiusToPrint = String.valueOf(this.radius);
        String square = "Circle[%s]";
        return String.format(square, radiusToPrint);
    }

    /**
     * Returns square inscribed in this circle
     */
    public Square getInscribedSquare() {
        double squareSide = this.radius * 2 / Math.sqrt(2);
        return new Square(squareSide);
    }

    /**
     * Returns square circumscribed about this circle
     */
    public Square getCircumscribedSquare() {
        double squareSide = this.radius * 2;
        return new Square(squareSide);
    }

    /**
     * Creates and returns an array of {@link Square}
     * which have the same area as the corresponding {@link Circle}
     */
    public static Square[] getSquares(Circle[] circles) {
        Square[] squares = new Square[circles.length];
        for (int i = 0; i < circles.length; i++) {
            squares[i] = new Square(circles[i]);
        }
        return squares;
    }
}
