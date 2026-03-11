package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleAreaTestJUnit {

    @Test
    void testTriangleArea() {

        double area = TriangleAreaProgram.calculateArea(3,4,5);

        assertEquals(6.0, area, 0.001);
    }
}
