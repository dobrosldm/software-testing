package test.upload;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadFileToArchive {
    private static WebDriver driver;

    @BeforeAll
    public static void prepare() {
        System.setProperty("webdriver.chrome.driver", "/opt/webdriver/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://archive.org/account/login");

        driver.findElement(By.xpath("//input[@class='form-element input-email']")).sendKeys("242419@niuitmo.ru");
        driver.findElement(By.xpath("//input[@class='form-element input-password']")).sendKeys("12345qwerty");
        driver.findElement(By.xpath("//input[@class='btn btn-primary btn-submit input-submit']")).click();
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
    public void uploadFileFromCurrentMachine() {
        WebElement uploadBar = extractShadowRoot(driver.findElement(By.tagName("ia-topnav")));
        uploadBar = extractShadowRoot(uploadBar.findElement(By.tagName("primary-nav")));

        uploadBar.findElement(By.cssSelector(".upload")).click();

        driver.findElement(By.xpath("//a[text()='Upload Files']")).click();
        driver.findElement(By.xpath("//*[@id='file_input_initial']")).sendKeys("/home/dmitry/testing-lab3-testfile.txt");

        driver.findElement(By.xpath("//span[@id='subjects']")).click();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("tag1,tag2");

        driver.findElement(By.xpath("//div[@id='description_row']")).click();
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//html/body")).sendKeys("Adding test description to upload file.");

        driver.switchTo().defaultContent();
        (new WebDriverWait(driver, 10)).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//button[text()='Upload and Create Your Item']"))).click();
    }

    private static WebElement extractShadowRoot(WebElement elem) {
        return (WebElement) ((JavascriptExecutor)driver)
                .executeScript("return arguments[0].shadowRoot", elem);
    }
}