package tests;

import com.google.gson.Gson;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.IntegriVideoChatPage;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.*;

public class ChatInputIsEmpty {

    ChromeDriver driver;

    @BeforeClass
    public void openDriver(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void inputEnter() {
        IntegriVideoChatPage chat = new IntegriVideoChatPage(driver);
        chat.openPage();
        chat.writeText("Test");
        chat.sendMessage();
        chat.verifyText("Test");
    }

    @Test
    public void inputByEnter(){
        IntegriVideoChatPage chat = new IntegriVideoChatPage(driver);
        chat.openPage();
        chat.writeText("Test");
        chat.sendMessageByEnter();
        chat.verifyText("Test");
    }

    @Test
    public void checkInvite() {
        IntegriVideoChatPage chat = new IntegriVideoChatPage(driver);
        chat.openPage();
        String clipBoardContent = chat.inviteClick();
        assertEquals(clipBoardContent, driver.getCurrentUrl());
    }

    @AfterClass
    public void closeDriver(){
        driver.quit();
    }

}
