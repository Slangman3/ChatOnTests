package testng;

import calc.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorOnMultiply {

    @DataProvider(name="for multiplicity")
    public Object[][] createData2() {
        return new Object[][] {
                { 8.0, 4.0, 32.0 },
                { 18.0, 0.0, 0.0 },
                { 0.0, 13.0, 0.0 },
        };
    }

    @Test(dataProvider = "for multiplicity")
    public void multiply(double a, double b, double c) {
        double newMultiply = new Calculator().multiply(a,b);
        Assert.assertEquals(newMultiply,c);
    }

}
