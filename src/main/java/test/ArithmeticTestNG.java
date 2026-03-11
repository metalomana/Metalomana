package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ArithmeticTestNG {

    @Test
    public void testAdd() {
        Assert.assertEquals(ArithmeticProgram.add(2,3),5);
    }

    @Test
    public void testSubtract() {
        Assert.assertEquals(ArithmeticProgram.subtract(5,3),2);
    }

    @Test
    public void testMultiply() {
        Assert.assertEquals(ArithmeticProgram.multiply(4,3),12);
    }

    @Test
    public void testDivide() {
        Assert.assertEquals(ArithmeticProgram.divide(6,3),2.0);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivideByZero() {
        ArithmeticProgram.divide(5,0);
    }
}
