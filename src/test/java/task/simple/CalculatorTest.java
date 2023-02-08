package task.simple;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void shouldPerformAddition() {
        // given
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime now = LocalDateTime.now();
        String format = dtf.format(now);
        int a = 2;
        int b = 4;
        // when
        Calculator calc = new Calculator();
        int result = calc.add(a, b);
        // then
        assertEquals(6, result);
    }

}
