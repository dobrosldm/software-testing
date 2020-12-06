package test.account;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuthorizationFlowTest {
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
    public void viewTermsOfUseAndEmailToWrite() {
        driver.findElement(By.xpath("//a[@class='stealth']")).click();
        assertEquals("Internet Archive's Terms of Use, Privacy Policy, and Copyright Policy",
                driver.findElement(By.xpath("//div[@class='container container-ia']/h1")).getText());
    }

    @Test
    @Order(2)
    public void tryToUploadFileWhenNotLogined() {
        WebElement uploadBar = extractShadowRoot(driver.findElement(By.tagName("ia-topnav")));
        uploadBar = extractShadowRoot(uploadBar.findElement(By.tagName("primary-nav")));

        uploadBar.findElement(By.cssSelector(".upload")).click();

        String answer = driver.findElement(By.xpath("//div[@class='container container-ia']/p")).getText();
        assertTrue(answer.contains("you will need to log in to our website"));
    }

    @Test
    @Order(3)
    public void loginViaEmailWithRememberMeCheckBoxNotChecked() {
        WebElement accountBar = extractShadowRoot(driver.findElement(By.tagName("ia-topnav")));
        accountBar = extractShadowRoot(accountBar.findElement(By.tagName("primary-nav")));
        accountBar = extractShadowRoot(accountBar.findElement(By.tagName("login-button")));

        accountBar.findElement(By.cssSelector(".logged-out-toolbar > span:nth-child(2) > a:nth-child(2)")).click();

        driver.findElement(By.xpath("//input[@class='form-element input-email']")).sendKeys("242419@niuitmo.ru");
        driver.findElement(By.xpath("//input[@class='form-element input-password']")).sendKeys("12345qwerty");
        driver.findElement(By.xpath("//input[@class='input-checkbox']")).click();
        driver.findElement(By.xpath("//input[@class='btn btn-primary btn-submit input-submit']")).click();
    }

    @Test
    @Order(4)
    public void tryToUploadFileWhenLogined() {
        WebElement uploadBar = extractShadowRoot(driver.findElement(By.tagName("ia-topnav")));
        uploadBar = extractShadowRoot(uploadBar.findElement(By.tagName("primary-nav")));

        uploadBar.findElement(By.cssSelector(".upload")).click();

        driver.findElement(By.xpath("//a[text()='Upload Files']")).click();
        assertEquals("Drag & Drop files here or",
                driver.findElement(By.xpath("//div[@id='file_drop_contents']/div/b")).getText());
    }

    @Test
    @Order(5)
    public void logOutAfterSession() {
        WebElement accountBar = extractShadowRoot(driver.findElement(By.tagName("ia-topnav")));
        accountBar = extractShadowRoot(accountBar.findElement(By.tagName("primary-nav")));
        accountBar.findElement(By.cssSelector(".user-menu")).click();
        driver.navigate().to("https://archive.org/account/logout");
    }

    private WebElement extractShadowRoot(WebElement elem) {
        return (WebElement) ((JavascriptExecutor)driver)
                .executeScript("return arguments[0].shadowRoot", elem);
    }
}
