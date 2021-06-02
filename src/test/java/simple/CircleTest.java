package simple;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
        assertEquals(12.566, squareArea, 0.001);
    }

    @Test
    public void shouldReturnCircle_withTheSameAreaAsSquare_whenSquareWithSideIsCreated() {
        //given
        double side = 2d;
        Square square = new Square(side);
        double squareArea = square.getArea();
        //when
        Circle circle = new Circle(square);
        double circleArea = circle.getArea();
        //then
        assertEquals(squareArea, circleArea, 0.00001);
    }

    @Test
    public void shouldReturnSquare_whichIsInscribedInCircle_whenThisCircleIsCreated() {
        //given
        double radius = 2d;
        Circle circle = new Circle(radius);
        //when
        Square inscribedSquare = circle.getInscribedSquare();
        //then
        assertNotNull(inscribedSquare);
        double squareSide = inscribedSquare.getSide();
        assertEquals(3d, Math.round(squareSide), 0.01);
    }

    @Test
    public void shouldReturnSquare_whichIsCircumscribedAboutCircle_whenThisCircleIsCreated() {
        //given
        double radius = 2d;
        Circle circle = new Circle(radius);
        //when
        Square circumscribedSquare = circle.getCircumscribedSquare();
        //then
        assertNotNull(circumscribedSquare);
        double squareSide = circumscribedSquare.getSide();
        assertEquals(4d, squareSide, 0.01);
    }
}
