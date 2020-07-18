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

    @When("the user types {string} in input search")
    public void typeTextInput(String text) {
        input.sendKeys(text);
        driver.findElement(By.id("search")).click();
    }

    @And("the user clicks on search button")
    public void userClickOnSearch()
    {
        List<WebElement> searchButtons = driver.findElements(By.name("btnK"));
        for(WebElement searchButton : searchButtons)
        {
            if(searchButton.isDisplayed())
            {
                searchButton.click();
                break;
            }
        }

    }

    @Then("the user should see {string} on search results")
    public void assertSearchResult(String text)
    {

    }

    @After
    public void tearDown() {
        driver.quit();
        driver = null;
    }

}
