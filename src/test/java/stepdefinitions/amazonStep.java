package stepdefinitions;

import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class amazonStep {

    @Given("amazona gidis")
    public void amazona_gidis() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com");

    WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
        searchBar.sendKeys("Guitar" + Keys.ENTER);

        List<WebElement> elementsWholes = driver.findElements(By.xpath("//span[@data-a-size='l']/span[@aria-hidden='true']/span[@class='a-price-whole']"));
        List<WebElement> elementsFractions = driver.findElements(By.xpath("//span[@data-a-size='l']/span[@aria-hidden='true']/span[@class='a-price-fraction']"));

        double result = 0;

        for (int i = 0; i < elementsWholes.size(); i++) {
            result += Double.valueOf(elementsWholes.get(i).getText())+Double.valueOf(elementsFractions.get(i).getText())/100;
        }

        System.out.println(result);
        double averagePrice = result/elementsWholes.size();

        System.out.println(averagePrice);
    }

    @Given("urun aramasi yap")
    public void urun_aramasi_yap() {

    }
    @Given("urunu dogrula")
    public void urunu_dogrula() {

    }

}
