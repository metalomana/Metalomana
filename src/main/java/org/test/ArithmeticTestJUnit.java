package test;

import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArithmeticTestJUnit {

    @Test
    void testAddition() {
        assertEquals(7, ArithmeticProgram.add(3,4));
    }

    @Test
    void testSubtraction() {
        assertEquals(1, ArithmeticProgram.subtract(5,4));
    }

    @Test
    void testMultiplication() {
        assertEquals(20, ArithmeticProgram.multiply(4,5));
    }

    @Test
    void testDivision() {
        assertEquals(2.0, ArithmeticProgram.divide(6,3));
    }

    @Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class,
                () -> ArithmeticProgram.divide(5,0));
    }
}
