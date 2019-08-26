package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorOnMultiply {

    @Test
    public void multiply() {
        double newMultiply = new Calculator().multiply(9,3);
        Assert.assertEquals(newMultiply,27.0);
    }

}
