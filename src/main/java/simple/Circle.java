package simple;

public class Circle {

    private int parameter;
    private double radius;

    Circle(double radius) {
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
        return String.valueOf(radius);
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
}
