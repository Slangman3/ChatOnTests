package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.TestData;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.desktop.OpenFilesEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class IntegriVideoChatLoginPageFactory {
    WebDriver driver;

    private static final String URL = "https://dev.integrivideo.com/login";

    @FindBy(name = "email")
    private WebElement userEmail;
    @FindBy(name = "password")
    private WebElement userPassword;
    @FindBy(name = "btn btn-primary")
    private WebElement loginButton;
    @FindBy(xpath = "//*[@href='/signup']")
    private WebElement signButton;

    public IntegriVideoChatLoginPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public IntegriVideoChatLoginPageFactory openPage() {
        this.driver.get(URL);
        return this;
    }

    public IntegriVideoChatLoginPageFactory login(String userName, String userPass) {
        userEmail.sendKeys(userName);
        userPassword.sendKeys(userPass);
        loginButton.click();
        return this;
    }

    public IntegriVideoChatLoginPageFactory signUp() {
        signButton.click();
        return this;
    }

}
