package test.upload;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArchiveWebPageByUrl {
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
    public void archiveExistedSite() {
        driver.findElement(By.xpath("//span[@class='iconochive-web']")).click();
        driver.findElement(By.xpath("//input[@id='web_save_url']")).sendKeys("vk-friends-randomizer.herokuapp.com");
        driver.findElement(By.xpath("(//button[@id='web_save_button'])")).click();
    }

    @Test
    public void archiveNotExistedSite() {
        driver.findElement(By.xpath("//span[@class='iconochive-web']")).click();
        driver.findElement(By.xpath("//input[@id='web_save_url']")).sendKeys("im-not-existing.com");
        driver.findElement(By.xpath("(//button[@id='web_save_button'])")).click();

        assertEquals("failed to archive the URL. specifics of failure is unknown",
                driver.findElement(By.xpath("//p")).getText());
    }
}
