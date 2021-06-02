package simple;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SquareTest {

    @Test
    public void shouldReturnSide_whenSquareCreated() {
        //given
        double side = 2d;
        //when
        Square square = new Square(side);
        double squareSide = square.getSide();
        //then
        assertEquals(2d, squareSide, 0d);
    }

    @Test
    public void shouldReturnArea_whenSquareCreated() {
        //given
        double side = 2d;
        //when
        Square square = new Square(side);
        double squareArea = square.getArea();
        //then
        assertEquals(4d, squareArea, 0d);
    }
}