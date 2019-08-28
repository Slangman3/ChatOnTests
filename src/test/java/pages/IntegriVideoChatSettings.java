package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.security.Key;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class IntegriVideoChatSettings {
    private static final String URL = "https://dev.integrivideo.com/demo/chat/new";
    WebDriver driver;
    By btnSettings = By.className("integri-chat-settings");
    By inptName = By.name("userName");
    By inptEmail = By.name("userEmail");
    By inptPhotoURL = By.name("userPic");
    By crossIcon = By.className("close-integri-modal");
    By btnSave = By.className("integri-user-settings-save");
    By btnCansel = By.className("integri-button-blue-inverse");
    By validateUserName = By.xpath("//*[@class='integri-session-user-name']");

    public IntegriVideoChatSettings(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(URL);
    }

    public void clickSettingsBtn(){
        driver.findElement(btnSettings).click();
    }

    public void setUserName(String userName){
        driver.findElement(inptName).clear();
        driver.findElement(inptName).sendKeys(userName);
    }

    public void setUserEmail(String userEmail){
        driver.findElement(inptEmail).clear();
        driver.findElement(inptEmail).sendKeys(userEmail);
    }

    public void setUserPhoto(String userPhoto){
        driver.findElement(inptPhotoURL).clear();
        driver.findElement(inptPhotoURL).sendKeys(userPhoto);
    }

    public void exitFromSettings(){
        driver.findElements(crossIcon).get(1).click();
    }

    public void saveSettings(){
        driver.findElement(btnSave).click();
    }

    public void pushCanselSettings(){
        driver.findElements(btnCansel).get(1).click();
    }

    public void verifyName(String expectedName) {
        String actual1 = driver.findElements(validateUserName).get(0).getText();
        assertEquals(actual1, expectedName);
        String actual2 = driver.findElements(validateUserName).get(1).getText();
        assertEquals(actual2, expectedName);
        String actual3 = driver.findElements(validateUserName).get(2).getText();
        assertEquals(actual3, expectedName);
    }
}
