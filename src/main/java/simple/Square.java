package simple;

public class Square {

    private int parameter;
    private double side;

    public Square(double side) {
        this.side = side;
    }

    /**
     * Creates Square with the same area as Circle
     */
    Square(Circle circle) {
        this.side = Math.sqrt(circle.getArea());
    }

    public Double getSide() {
        return this.side;
    }

    public int getParameter() {
        return this.parameter;
    }

    public double getArea() {
        return Math.pow(side, 2);
    }

    public String toString() {
        String sideToPrint = String.valueOf(this.side);
        String square = "Square[%s]";
        return String.format(square, sideToPrint);
    }

    /**
     * Returns circle inscribed in this square
     */
    public Circle getInscribedCircle() {
        double circleRadius = this.side / 2;
        return new Circle(circleRadius);
    }

    /**
     * Returns circle circumscribed about this square
     */
    public Circle getCircumscribedCircle() {
        double circleRadius = this.side * Math.sqrt(2d) / 2;
        return new Circle(circleRadius);
    }

    /**
     * Creates and returns an array of {@link Circle}
     * which have the same area as the corresponding {@link Square}
     */
    public static Circle[] getCircles(Square[] squares) {
        Circle[] circles = new Circle[squares.length];
        for (int i = 0; i < squares.length; i++) {
            circles[i] = new Circle(squares[i]);
        }
        return circles;
    }
}
