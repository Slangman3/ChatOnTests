package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.SendKeysAction;
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
    By removeBtn = By.className("integri-chat-remove-message");
    By editArea = By.xpath("//*[contains(@class, 'integri-chat-message ')]//textarea");
    By editAlert = By.className("integri-notify-error");
    By skipBtn = By.className("close-demo-screen");

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

    public void sendMessageByEnter() {
        driver.findElement(inputArea).sendKeys(Keys.ENTER);
    }

    public void sendMessage() throws InterruptedException {
        driver.findElement(sendMessageButton).click();
        Thread.sleep(1000);
    }

    public void browseToUpload(){
        driver.findElement(By.className("integri-file-upload-manual-init")).click();

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

    public void waiterOfMessages(int numberOfAllMessages){
        wait.until(ExpectedConditions.numberOfElementsToBe(messageText, numberOfAllMessages));
    }

    public void setEditAlert(int numberOfMessage){
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void editMessage(int numberOfMessage, String newText) {
        driver.findElements(editBtn).get(numberOfMessage - 1).click();
        driver.findElement(editArea).clear();
        driver.findElement(editArea).sendKeys(newText);
        driver.findElement(editArea).sendKeys(Keys.ENTER);
    }

    public void editMessageAllDelete(int numberOfMessage) {
        driver.findElements(editBtn).get(numberOfMessage - 1).click();
        driver.findElement(editArea).clear();
        driver.findElement(editArea).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(editAlert));
        wait.until(ExpectedConditions.textToBe(editAlert, "Message cannot be empty!"));
    }

    public void skipAlertPresent(){
        wait.until(ExpectedConditions.textToBe(skipBtn, "Skip"));
        driver.findElement(skipBtn).click();
    }

    public void removeMessage(int numberOfMessgae) {
        driver.findElements(removeBtn).get(numberOfMessgae - 1).click();
    }

    public void verifyEditText(String expectedMessage) {
        wait.until(ExpectedConditions.textToBe(By.className("integri-chat-message-text"), expectedMessage));
        String actual = driver.findElement(messageText).getText();
        assertEquals(actual, expectedMessage);
    }

    public void verifyMessageLinkDimaGoogleDisk() {
        assertFalse(driver.findElements(messageWithLink).isEmpty());
        String text = driver.findElement(By.className("integri-chat-message-attachment-link")).getAttribute("innerText");
        assertEquals(text, "drive.google.com\n" +
                "lesson_7_selenium_advanced.pptx - Google Drive");
    }

    public void verifyMessageLinkTutBy() {
        assertFalse(driver.findElements(messageWithLink).isEmpty());
        String text = driver.findElement(By.className("integri-chat-message-attachment-link")).getAttribute("innerText");
        assertEquals(text, "undefined");
    }
}
