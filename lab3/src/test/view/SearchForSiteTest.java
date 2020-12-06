package test.view;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SearchForSiteTest {
    private static WebDriver driver;

    @BeforeAll
    public static void prepare() {
        System.setProperty("webdriver.chrome.driver", "/opt/webdriver/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://archive.org/");
    }

    @AfterEach
    public void prepareEach() {
        driver.get("https://archive.org/");
    }

    @AfterAll
    public static void finish() {
        driver.quit();
    }

    @Test
    @Order(1)
    public void searchForNotExistedSite() {
        driver.findElement(By.xpath("//input[@name='search']")).click();
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("not-presented-site.com");
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

        WebElement dynamicError = (new WebDriverWait(driver, 5)).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//div[@id='react-wayback-search']/div[@class='error error-border']")));

        assertEquals("Wayback Machine has not archived that URL.",
                dynamicError.findElement(By.xpath("./div/p")).getText());
    }

    @Test
    @Order(2)
    public void searchForExistedButNotArchivedSite() {
        driver.findElement(By.xpath("//input[@name='search']")).click();
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("donaldtrumphairtips.com");
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

        WebElement dynamicError = (new WebDriverWait(driver, 5)).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//div[@id='react-wayback-search']/div[@class='error error-border']")));

        assertEquals("Wayback Machine has not archived that URL.",
                dynamicError.findElement(By.xpath("./div/p")).getText());
    }

    @Test
    @Order(3)
    public void searchForExistedAndPresentedSiteAndLoad() {
        driver.findElement(By.xpath("//input[@name='search']")).click();
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("google.com");
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

        WebElement calendar = (new WebDriverWait(driver, 5)).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//div[@id='react-wayback-search']/div[@class='calendar-layout']/div[@class='calendar-grid']")));
        Actions action = new Actions(driver);

        //WebElement targetDay = (new WebDriverWait(driver, 20))
        //        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("./div[2]/div[2]/div[2]/div[6]/div")));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement targetDay = calendar.findElement(By.xpath("./div[2]/div[2]/div[2]/div[6]/div"));
        action.moveToElement(targetDay).perform();

        driver.findElement(By.xpath("//div[@id='react-wayback-search']/div[4]/div[3]/div/div[2]/ul/div/div/li[6]/a")).click();
    }
}
