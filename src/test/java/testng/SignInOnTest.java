package testng;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import pages.IntegriVideoChatLoginPageFactory;
import pages.IntegriVideoChatSignInPage;

public class SignInOnTest {
    ChromeDriver driver;
    IntegriVideoChatLoginPageFactory pageFactory;
    IntegriVideoChatSignInPage signInPage;

    @BeforeClass
    public void openDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void signUpOnCheck() {
        IntegriVideoChatLoginPageFactory pageFactory = new IntegriVideoChatLoginPageFactory(driver);
        IntegriVideoChatSignInPage signInPage = new IntegriVideoChatSignInPage(driver);
        pageFactory
                .openPage()
                .signUp();
        signInPage.verifySignInPage();
    }

    @Test
    public void signUpNewAcc() {
        IntegriVideoChatLoginPageFactory pageFactory = new IntegriVideoChatLoginPageFactory(driver);
        IntegriVideoChatSignInPage signInPage = new IntegriVideoChatSignInPage(driver);
        pageFactory
                .openPage()
                .login("tms2@mailinator.com", "Password01")
                .loginBtnClick();
        signInPage.loginAcces();


    }
    @AfterClass
    public void closeDriver() {
        driver.quit();
    }

}
