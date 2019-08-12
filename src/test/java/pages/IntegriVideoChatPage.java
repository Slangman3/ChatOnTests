package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.mustache.Value;
import tests.TestData;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.security.Key;
import java.util.EmptyStackException;

import static org.testng.Assert.*;

public class IntegriVideoChatPage extends TestData {
    private static final String URL = "https://dev.integrivideo.com/demo/chat/new";
    WebDriver driver;
    WebDriverWait wait;
    By inviteLink = By.id("invite-users-to-chat");
    By inputArea = By.xpath("//*[@placeholder='Start typing here']");
    By sendMessageButton = By.xpath("//*[@title='Send message']");
    By drugAndDrop = By.cssSelector(".integri-chat-manual-upload");
    By settings = By.cssSelector(".integri-chat-settings");
    By code = By.className("component-code");
    By messageText = By.className("integri-chat-message-text");
    By messageWithLink = By.className("integri-chat-message-attachment-link");
    By editBtn = By.className("integri-chat-edit-message");
    By editArea = By.xpath("//*[@id='integri-component-chat']/div[4]/div[2]/div/div/div[2]/textarea");

    public IntegriVideoChatPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
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

    public void verifyVisibilityJSMessage() {
        String JSCode = driver.findElement(messageText).getAttribute("innerText");
        assertTrue(JSCode.isEmpty());
    }

    public void editClickAndReMessageOn(String text){
        driver.findElement(editBtn).click();
        driver.findElement(editArea).clear();
        driver.findElement(editArea).sendKeys(text);
        driver.findElement(editArea).sendKeys(Keys.ENTER);
    }

    public void verifyEditText(String expectedMessage) {
        wait.until(ExpectedConditions.textToBe(By.className("integri-chat-message-text"), expectedMessage));
        String actual = driver.findElement(messageText).getText();
        assertEquals(actual, expectedMessage);
    }

    public void verifyMessageLinkDimaGoogleDisk(){
        assertFalse(driver.findElements(messageWithLink).isEmpty());
        String text = driver.findElement(By.className("integri-chat-message-attachment-link")).getAttribute("innerText");
        assertEquals(text, "drive.google.com\n" +
                "lesson_7_selenium_advanced.pptx - Google Drive");
    }

    public void verifyMessageLinkTutBy(){
        assertFalse(driver.findElements(messageWithLink).isEmpty());
        String text = driver.findElement(By.className("integri-chat-message-attachment-link")).getAttribute("innerText");
        assertEquals(text, "undefined");
    }
}
