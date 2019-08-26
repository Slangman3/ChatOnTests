package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorOnMinus {

    @Test
    public void minus() {
        double newMinus = new Calculator().minus(9,3);
        Assert.assertEquals(newMinus,6.0);
    }

}
