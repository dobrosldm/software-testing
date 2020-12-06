package test.view;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SearchForBookTest {
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
    public void openPublicLibraryOfIndiaMostPopularBook() {
        driver.findElement(By.xpath("//a[@href='/details/texts']")).click();
        driver.findElement(By.xpath("//a[@href='/details/digitallibraryindia']")).click();
        driver.findElement(By.xpath("//a[@href='/details/in.ernet.dli.2015.61523']")).click();
        assertEquals("The Indian Year Book Volume. Xxix",
                driver.findElement(By.xpath("//h1[@class='item-title']/span")).getText());
    }

    @Test
    @Order(2)
    public void openPublicLibraryOfIndiaOldestBook() {
        driver.findElement(By.xpath("//a[@href='/details/texts']")).click();
        driver.findElement(By.xpath("//a[@href='/details/digitallibraryindia']")).click();
        driver.findElement(By.xpath("//a[@id='date_switcher']")).click();

        List<WebElement> elements =  driver.findElements(By.xpath("//div[@class='results']/*"));
        elements.get(1).click();

        assertEquals("Dhammapala;s Paramattha-Dipani",
                driver.findElement(By.xpath("//h1[@class='item-title']/span")).getText());
    }

    @Test
    @Order(3)
    public void openProjectGutenbergAtYear2003() {
        driver.findElement(By.xpath("//a[@href='/details/texts']")).click();
        driver.findElement(By.xpath("//a[@href='/details/gutenberg']")).click();

        (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@class='farow']")));

        List<WebElement> yearFilter =  driver.findElements(By.xpath("//div[@class='fatable facet-year']/*"));
        yearFilter.get(0).findElement(By.xpath("./div/input")).click();

        List<WebElement> texts =  driver.findElements(By.xpath("//div[@class='results']/*"));
        texts.get(9).click();

        assertEquals("2003",
                driver.findElement(By.xpath("//span[@itemprop='datePublished']")).getText());
    }

    @Test
    @Order(4)
    public void openProjectGutenbergWithSpanishLanguage() {
        driver.findElement(By.xpath("//a[@href='/details/texts']")).click();
        driver.findElement(By.xpath("//a[@href='/details/gutenberg']")).click();

        (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@class='farow']")));

        List<WebElement> languageFilter =  driver.findElements(By.xpath("//div[@class='fatable facet-languageSorter']/*"));
        languageFilter.get(4).findElement(By.xpath("./div/input")).click();

        List<WebElement> texts =  driver.findElements(By.xpath("//div[@class='results']/*"));
        texts.get(13).click();

        assertEquals("Spanish",
                driver.findElement(By.linkText("Spanish")).getText());
    }
}