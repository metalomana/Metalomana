package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialTestJUnit {

    @Test
    void testFactorialFive() {
        assertEquals(120, FactorialProgram.factorial(5));
    }

    @Test
    void testFactorialZero() {
        assertEquals(1, FactorialProgram.factorial(0));
    }
}
