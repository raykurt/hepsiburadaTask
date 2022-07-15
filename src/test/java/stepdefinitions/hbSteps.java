package stepdefinitions;

import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class hbSteps {

    @Given("user enter site")
    public void user_enter_site() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.build.com/");

        WebElement notXxx = driver.findElement(By.xpath("//span[@class='close-icon']"));
        notXxx.click();

        WebElement notYet = driver.findElement(By.xpath("(//div[@class='btn_wrapper']/button)[1]"));
        notYet.click();

                WebElement searchBar = driver.findElement(By.id("search_txt"));
        searchBar.sendKeys("Bath" + Keys.ENTER);

    }
}
