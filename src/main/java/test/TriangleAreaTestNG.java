package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleAreaTestNG {

    @Test
    public void testTriangleArea() {

        double area = TriangleAreaProgram.calculateArea(3,4,5);

        Assert.assertEquals(area, 6.0, 0.001);
    }
}
