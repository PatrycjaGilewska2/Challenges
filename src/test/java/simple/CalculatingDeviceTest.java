package simple;

import junit.framework.TestCase;
import org.junit.Test;

public class CalculatingDeviceTest extends TestCase {

    private CalculatingDevice calculator = new CalculatingDevice("dupa dupa");

    @Test
    public void abc() {
        //given
        double x = 4.0;
        double y = 5.0;
        //when
        String real = calculator.calculate(x, y);
        //then
        String expected = "Sum of x = 4.0 and y = 5.0 equals 9.0";
        assertEquals(real, expected);
    }

}