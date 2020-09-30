package stepsDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Steps {

    WebDriver driver;
    String expectedMessage = "My account";
    String currentMessage;

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }


    @Given("a user in a automationpractice.com webstore")
    public void userIsOnAutomationPractice() {
        driver.get("http://automationpractice.com/index.php");
        String currentURL = driver.getCurrentUrl();
        System.out.println("current URL: " + currentURL);
    }

    @When("the user clicks Sign in button")
    public void userClicksOnSignInMainPage()
    {
        driver.findElement(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a")).click();
    }

    @And("the user types {String} on login field")
    public void typesTextOnLoginField(String text1)
    {
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[2]/form/div/div[1]/input"));
        typesTextOnLoginField.sendKeys(text1);

    }

    @And("the user type {String} on password field")
    public void typesTextOnPasswordField(String text2)
    {
        driver.findElement(By.xpath("//*[@id=\"passwd\"]"));
        typesTextOnPasswordField.sendKeys(text2);
    }

    @And("the user clicks on Sign in button"
    public void userClicksOnSignInOnSubPage
    {
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[2]/form/div/p[2]/button/span")).click();
    }

    @Then("the user go to user panel")
    public void assertSignInResult(String text)
    {
        currentMessage = driver.findElement(By.name("My account")).getText();
        assertEquals(expectedMessage, currentMessage);
    }

    @After
    public void tearDown() {
        driver.quit();
        driver = null;
    }

}
