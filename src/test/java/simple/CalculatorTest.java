package simple;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void shouldPerformAddition() {
        //given
        int a = 2;
        int b = 4;
        //when
        Calculator calc = new Calculator();
        int result = calc.add(a, b);
        //then
        assertEquals(6, result);
    }
}