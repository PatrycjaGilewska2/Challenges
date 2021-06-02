package simple;

public class Square {

    private int parameter;
    private double side;

    Square(double side) {
        this.side = side;
    }

    public Double getSide() {
        return this.side;
    }

    public int getParameter() {
        return this.parameter;
    }

    public Double getArea() {
        return Math.sqrt(side);
    }

    public String toString() {
        return String.valueOf(side);
    }
}
