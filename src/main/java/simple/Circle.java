package simple;

public class Circle {

    private int parameter;
    private double radius;

    Circle(double radius) {
        this.radius = radius;
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
}
