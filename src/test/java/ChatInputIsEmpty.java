import com.google.gson.Gson;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class ChatInputIsEmpty {

    @Test
    public void inputEnter() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://dev.integrivideo.com/");
        WebElement startChatBtn = driver.findElementByXPath("/html/body/main/div/div[2]/div/div[3]/div[2]/div/div/a");
        startChatBtn.click();
        driver.findElement(By.xpath("//*[@placeholder='Start typing here']")).sendKeys("Hello World");
        WebElement btnEnter = driver.findElement(By.xpath("//*[@class='integri-chat-send-message integri-chat-action-button']"));
        btnEnter.click();
        driver.quit();
    }
}
