package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorOnDivide {

    @Test
    public void divide() {
        double newDivide = new Calculator().divide(9,3);
        Assert.assertEquals(newDivide,3.0);
    }

}
