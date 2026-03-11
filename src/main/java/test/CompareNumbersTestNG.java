package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CompareNumbersTestNG {

    @Test
    public void testGreater() {
        Assert.assertEquals(
                CompareNumbersProgram.compare(6,2),
                "Первое число больше второго");
    }

    @Test
    public void testLess() {
        Assert.assertEquals(
                CompareNumbersProgram.compare(2,6),
                "Первое число меньше второго");
    }

    @Test
    public void testEqual() {
        Assert.assertEquals(
                CompareNumbersProgram.compare(5,5),
                "Числа равны");
    }
}
