package testng;

import org.testng.Assert;
import org.testng.annotations.*;

public class CalculatorOnSum {

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("@BeforeMethod starts sum test");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println(" @AfterMEthod ended sum test");
    }

    @Test(dataProvider = "getNumbers")
    public void sum(int n1, int n2, int n3) {
        double newSum = new Calculator().sum(n1,n2);
        Assert.assertEquals(newSum, n3);
    }

    @DataProvider(name = "setNumbers"){

    }
}
