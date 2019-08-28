package testng;

import calc.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorOnDivide {

    //This method will provide data to any test method that declares that its Data Provider
//is named "test1"
    @DataProvider(name = "for division")
    public Object[][] createData1() {
        return new Object[][] {
                { 9.0, 3.0, 3.0 },
                { 14.30, 2, 7.15 },
                { 0.0, 13.0, 0.0 },
        };
    }

    @Test(dataProvider = "for division")
    public void divide(double a, double b, double c) {
        double newDivide = new Calculator().divide(a, b);
        Assert.assertEquals(newDivide, c);
    }

    @Test(invocationCount = 2, threadPoolSize = 3)
    public void divideOnNull() {
        double newDivide = new Calculator().divide(9, 0);
        Assert.assertTrue(Double.isInfinite(newDivide));
    }

}
