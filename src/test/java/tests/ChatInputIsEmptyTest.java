package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.IntegriVideoChatPage;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class ChatInputIsEmptyTest {

    ChromeDriver driver;

    @BeforeClass
    public void openDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void inputEnter() throws InterruptedException {
        IntegriVideoChatPage chat = new IntegriVideoChatPage(driver);
        chat.openPage();
        chat.writeText("Test");
        chat.sendMessage();
        chat.verifyText("Test");
    }

    @Test
    public void inputByEnter() {
        IntegriVideoChatPage chat = new IntegriVideoChatPage(driver);
        chat.openPage();
        chat.writeText("Test");
        chat.sendMessageByEnter();
        chat.verifyText("Test");
    }

    @Test
    public void inputThousandCharsByEnter() {
        IntegriVideoChatPage chat = new IntegriVideoChatPage(driver);
        chat.openPage();
        chat.writeText(TestData.SIMBOLS_1000);
        chat.sendMessageByEnter();
        chat.verifyText(TestData.SIMBOLS_1000);
    }

    @Test
    public void messageWithLinkDimaGoogleDrive() {
        IntegriVideoChatPage chat = new IntegriVideoChatPage(driver);
        chat.openPage();
        chat.writeText("https://drive.google.com/file/d/1WFDNF50ejDthZlyoiFhojP5-1Gz-sKOs/view");
        chat.sendMessageByEnter();
        chat.verifyMessageLinkDimaGoogleDisk();
    }

    @Test
    public void messageWithLinkTutBy() {
        IntegriVideoChatPage chat = new IntegriVideoChatPage(driver);
        chat.openPage();
        chat.writeText("https://www.tut.by/");
        chat.sendMessageByEnter();
        chat.verifyMessageLinkTutBy();
    }

    @Test
    public void messageWithJSCode() {
        IntegriVideoChatPage chat = new IntegriVideoChatPage(driver);
        chat.openPage();
        chat.writeText("<script async=\"true\" src=\"https://dev.integrivideo.com/integri.js?c=5d4b06f5912cd41058eb139d&uid=demo-chat-5d4b06f5912cd41058eb139d\"></script><integri id=\"demo-component-069531\"></integri>");
        chat.sendMessageByEnter();
        chat.verifyVisibilityJSMessage();
    }

    @Test
    public void checkInvite() {
        IntegriVideoChatPage chat = new IntegriVideoChatPage(driver);
        chat.openPage();
        String clipBoardContent = chat.inviteClick();
        assertEquals(clipBoardContent, driver.getCurrentUrl());
    }

    @Test
    public void editMessageCheck() throws InterruptedException {
        IntegriVideoChatPage chat = new IntegriVideoChatPage(driver);
        chat.openPage();
        chat.writeText("Hello bro");
        chat.sendMessage();
        chat.writeText("Hello World");
        chat.sendMessage();
        chat.writeText("Hello dude");
        chat.sendMessage();
        chat.waiterOfMessages(3);
        chat.editMessage(2, "Hello Onliner");
        chat.removeMessage(3);
        chat.setEditAlert(3);
    }

    @Test
    public void editMessageAllDeleteCheck() throws InterruptedException {
        IntegriVideoChatPage chat = new IntegriVideoChatPage(driver);
        chat.openPage();
        chat.writeText("Hello bro");
        chat.sendMessage();
        chat.writeText("Hello World");
        chat.sendMessage();
        chat.writeText("Hello dude");
        chat.sendMessage();
        chat.waiterOfMessages(3);
        chat.editMessageAllDelete(3);
    }

    @Test
    public void manyMessagesCheck() throws InterruptedException {
        IntegriVideoChatPage chat = new IntegriVideoChatPage(driver);
        chat.openPage();
        chat.writeText("Hello bro");
        chat.sendMessage();
        chat.writeText("Hello World");
        chat.sendMessage();
        chat.writeText("Hello dude");
        chat.sendMessage();
        chat.writeText("Hello bro");
        chat.sendMessage();
        chat.writeText("Hello World");
        chat.sendMessage();
        chat.writeText("Hello dude");
        chat.sendMessage();
        chat.writeText("Hello bro");
        chat.sendMessage();
        chat.writeText("Hello World");
        chat.sendMessage();
        chat.writeText("Hello dude");
        chat.sendMessage();
        chat.writeText("Hello bro");
        chat.sendMessage();
        chat.writeText("Hello World");
        chat.sendMessage();
        chat.skipAlertPresent();
        chat.writeText("Oops it is 12th message!");
        chat.sendMessage();
        chat.skipAlertPresent();
    }

    @Test
    public void drugDropCheck(){
        IntegriVideoChatPage chat = new IntegriVideoChatPage(driver);
        chat.openPage();
        chat.clickUpload();
        chat.browseToUpload();

    }

//    @AfterClass
//    public void closeDriver() {
//        driver.quit();
//    }
}
