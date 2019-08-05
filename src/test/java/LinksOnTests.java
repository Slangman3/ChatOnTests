import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.awt.datatransfer.*;
import static org.testng.Assert.*;

public class LinksOnTests {
    @Test
    public void linksTest() throws IOException, UnsupportedFlavorException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://dev.integrivideo.com/");
        WebElement startChatBtn = driver.findElementByXPath("/html/body/main/div/div[2]/div/div[3]/div[2]/div/div/a");
        startChatBtn.click();

        WebElement linkWithCode = driver.findElementByXPath("//*[@class='component-code']");
        linkWithCode.click();
        Clipboard c1 = Toolkit.getDefaultToolkit().getSystemClipboard();
        assertNotNull(c1);
        WebElement btnLinkWithCode = driver.findElement(By.xpath("//*[@id='invite-users-to-chat']"));
        btnLinkWithCode.click();
        Clipboard c2 = Toolkit.getDefaultToolkit().getSystemClipboard();
        assertNotNull(c2);
        System.out.println(c2.getData(DataFlavor.stringFlavor));
        assertEquals(c2.getData(DataFlavor.stringFlavor), driver.getCurrentUrl());
        driver.quit();
    }
}
