package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.security.Key;

import static org.testng.Assert.assertEquals;

public class IntegriVideoChatPage {
    private static final String URL = "https://dev.integrivideo.com/demo/chat/new";
    WebDriver driver;
    By inviteLink = By.id("invite-users-to-chat");
    By inputArea = By.xpath("//*[@placeholder='Start typing here']");
    By sendMessageButton = By.xpath("//*[@title='Send message']");
    By drugAndDrop = By.cssSelector(".integri-chat-manual-upload");
    By settings = By.cssSelector(".integri-chat-settings");
    By code = By.className("component-code");
    By messageText = By.className("integri-chat-message-text");


    public IntegriVideoChatPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(URL);
    }

    public void writeText(String text) {
        driver.findElement(inputArea).clear();
        driver.findElement(inputArea).sendKeys(text);
    }

    public void sendMessageByEnter(){
        driver.findElement(inputArea).sendKeys(Keys.ENTER);
    }

    public void sendMessage() {
        driver.findElement(sendMessageButton).click();
    }

    public String inviteClick() {
        driver.findElement(inviteLink).click();
        try {
            return (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void clickUpload() {
        driver.findElement(drugAndDrop).click();
    }

    public void clickSettings() {
        driver.findElement(settings).click();
    }

    public String clickCode() {
        driver.findElement(code).click();
        try {
            return (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void verifyText(String expectedMessage) {
        String actual = driver.findElement(messageText).getText();
        assertEquals(actual, expectedMessage);
    }

}
