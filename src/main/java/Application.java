import simple.Calculator;

public class Application {

    public static void main(String[] args) {

        Calculator calc = new Calculator();
        int result = calc.add(2, 3);
        System.out.println(result);
    }
}
