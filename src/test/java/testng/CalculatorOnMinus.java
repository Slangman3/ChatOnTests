package testng;

import calc.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorOnMinus {

    @Test(description="this statement", priority = 2)
    public void minus() {
        double newMinus = new Calculator().minus(9,3);
        Assert.assertEquals(newMinus,6.0);
    }

}
