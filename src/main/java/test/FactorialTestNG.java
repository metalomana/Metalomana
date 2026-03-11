package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialTestNG {

    @Test
    public void testFactorialFive() {
        Assert.assertEquals(FactorialProgram.factorial(5), 120);
    }

    @Test
    public void testFactorialZero() {
        Assert.assertEquals(FactorialProgram.factorial(0), 1);
    }
}
