package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;

public class Form {


    WebDriver driver;
    WebDriver wait;
    @Given("the website Toolsqa is available")
    public void the_website_toolsqa_is_available() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/text-box");
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }
    @When("register my data")
    public void register_my_data() throws InterruptedException {
        driver.findElement(By.id("userName")).sendKeys("Daniel Gonzalez");
        Thread.sleep(2000);
        driver.findElement(By.id("userEmail")).sendKeys("daniggcia@hotmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("currentAddress")).sendKeys("C/ Nuñez de Balboa, 32");
        Thread.sleep(2000);
        driver.findElement(By.id("permanentAddress")).sendKeys("C/ Real Betis, 2");
    }
    @When("click button submit")
    public void click_button_submit() throws InterruptedException {
        //No funciona con las etiquetas id ni class
        //driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",driver.findElement(By.id("submit")));
    }
    @Then("the recorded data is displayed")
    public void the_recorded_data_is_displayed() throws InterruptedException {
        System.out.println(driver.findElement(By.id("name")).getText());
        System.out.println(driver.findElement(By.id("email")).getText());
        driver.findElement(By.id("currentAddress")).isDisplayed();
        driver.findElement(By.id("permanentAddress")).isDisplayed();
        Thread.sleep(10000);
    }
    @Then("we close the browser")
    public void we_close_the_browser() {
        //Limpiamos las cookies y cerramos ventana
        driver.manage().deleteAllCookies();
        driver.quit();
    }


}
