package simple;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CircleTest {

    @Test
    public void shouldReturnRadius_whenCircleCreated() {
        //given
        double radius = 2d;
        //when
        Circle circle = new Circle(radius);
        double squareSide = circle.getRadius();
        //then
        assertEquals(2d, squareSide, 0d);
    }

    @Test
    public void shouldReturnArea_whenCircleCreated() {
        //given
        double radius = 2d;
        //when
        Circle circle = new Circle(radius);
        double squareArea = circle.getArea();
        //then
        assertEquals(12.566, squareArea, 0.01);
    }
}