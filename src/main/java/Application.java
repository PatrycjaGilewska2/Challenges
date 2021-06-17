import simple.CalculatingDevice;

public class Application {

    public static void main(String[] args) {
        CalculatingDevice calculator = new CalculatingDevice("name");
        String calculate = calculator.calculate(4, 6);
        System.out.println(calculate);
    }
}
