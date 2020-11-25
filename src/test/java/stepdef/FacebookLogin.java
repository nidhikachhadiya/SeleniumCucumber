package stepdef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FacebookLogin {

    private WebDriver driver;
    @Given("^Launch Chrome driver and hit Facebook URL$")
    public void launchChrome(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.get("https://www.facebook.com/");
    }
    @When("^Add username and wrong password and click on login button$")
    public void login(){
        driver.findElement(By.id("email")).sendKeys("nidhi3578@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("123");
        driver.findElement(By.id("u_0_b")).submit();
    }
    @Then("^Message should displayed as The password that you've entered is incorrect. Forgotten password$")
    public void validateLoginMessage(){
        String ActualErrorMessage = driver.findElement(By.className("_9ay7")).getText();
        String ExpectedErrorMessage = "The password that you've entered is incorrect. Forgotten password?";
        Assert.assertEquals(ActualErrorMessage,ExpectedErrorMessage);

        driver.quit();
    }
}
