package simple;

public class Square {

    private int parameter;
    private double side;

    Square(double side) {
        this.side = side;
    }

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
        return String.valueOf(side);
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
}
