package testng;

import calc.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorOnSum {

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("@BeforeMethod starts sum test");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println(" @AfterMethod ended sum test");
    }

    @Test(retryAnalyzer = RetryAnalizer.class)
    public void sum() {
        double newSum = new Calculator().sum(9.0,3.0);
        Assert.assertEquals(newSum,12.0);
    }

}
