package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

public class IntegriVideoChatSignInPage {
    WebDriver driver;
    WebDriverWait wait;

    By nameOfSignInButton = By.xpath("//*[@class='btn btn-primary']");

    public IntegriVideoChatSignInPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void verifySignInPage() {
        String verifyText = driver.findElement(nameOfSignInButton).getText();
        assertEquals(verifyText, "Sign up");
    }
}
