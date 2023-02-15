import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LessonFiveTest {


    WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void Setup() {
        System.out.println("test start");
    }


    @AfterTest
    public void Finish() {
        System.out.println("test finish");
        driver.quit();
    }

    @Test
    void test1() {
        try {
            driver.get("https://crossbrowsertesting.github.io/drag-and-drop");
            Thread.sleep(2000);
            WebElement element = driver.findElement(By.id("draggable"));
            WebElement element2 = driver.findElement(By.id("droppable"));
            Actions actions = new Actions(driver);
            actions.moveToElement(element).clickAndHold().moveToElement(element2).release().build().perform();


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    @Test
    void test2() throws InterruptedException {
        driver.get("https://lenta.ru/");
        driver.findElement(By.xpath("//*[@id=\"body\"]/div[3]/div[3]/div[2]/header/div[1]/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"body\"]/div[3]/div[2]/div/div[2]/nav/ul/li[15]/a")).click();
        Thread.sleep(1000);
        WebElement webElement3 = driver.findElement(By.cssSelector("[class=\"rubric-header__link\"]"));
        webElement3.click();
        Thread.sleep(1000);
    }


}



