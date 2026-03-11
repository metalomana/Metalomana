package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompareNumbersTestJUnit {

    @Test
    void testGreater() {
        assertEquals("Первое число больше второго",
                CompareNumbersProgram.compare(5,3));
    }

    @Test
    void testLess() {
        assertEquals("Первое число меньше второго",
                CompareNumbersProgram.compare(2,7));
    }

    @Test
    void testEqual() {
        assertEquals("Числа равны",
                CompareNumbersProgram.compare(4,4));
    }
}
