package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.IntegriVideoChatSettings;

import java.util.concurrent.TimeUnit;

public class ChatSettingsConfirm {
    ChromeDriver driver;

    @BeforeClass
    public void openDriver(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void inputSettingsAndExit(){
        IntegriVideoChatSettings set = new IntegriVideoChatSettings(driver);
        set.openPage();
        set.clickSettingsBtn();
        set.setUserName("Belochkin");
        set.setUserEmail("slangman@inbox.ru");
        set.setUserPhoto("https://pp.userapi.com/c854320/v854320003/8abf8/7uanbdoK7AE.jpg?ava=1");
        set.exitFromSettings();
    }

    @Test
    public void inputSettingsAndCancel(){
        IntegriVideoChatSettings set = new IntegriVideoChatSettings(driver);
        set.openPage();
        set.clickSettingsBtn();
        set.setUserName("Belochkin");
        set.setUserEmail("slangman@inbox.ru");
        set.setUserPhoto("https://pp.userapi.com/c854320/v854320003/8abf8/7uanbdoK7AE.jpg?ava=1");
        set.pushCanselSettings();
    }

    @Test
    public void inputSettingsAndSave(){
        IntegriVideoChatSettings set = new IntegriVideoChatSettings(driver);
        set.openPage();
        set.clickSettingsBtn();
        set.setUserName("Belochkin");
        set.setUserEmail("slangman@inbox.ru");
        set.setUserPhoto("https://pp.userapi.com/c854320/v854320003/8abf8/7uanbdoK7AE.jpg?ava=1");
        set.saveSettings();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        set.verifyName("Belochkin");
    }

    @AfterClass
    public void closeDriver(){
        driver.quit();
    }
}
