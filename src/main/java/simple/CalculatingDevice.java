package simple;

public class CalculatingDevice {

    private String name;

    public CalculatingDevice(String name) {
        this.name = name;
    }

    public String calculate(double x, double y) {
        double sum = x + y;
        return String.format("Sum of x = %s and y = %s equals %s", x, y, sum);
//        return "Sum of x = " + x + "y = " + y + "equals " + sum;

    }

}
