//  Number of items verification test. 
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test1_HowManyItem
{
    private WebDriver driver;
    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rafal\\Desktop\\ChromeDriver\\ChromeDriver89\\chromedriver.exe");
        driver = new ChromeDriver();
    //    driver.manage().window().maximize();
        driver.navigate().to("http://automationpractice.com/index.php");
    }
    @Test
    public void test()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a")));
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"categories_block_left\"]/div/ul/li[1]/a")));
        driver.findElement(By.xpath("//*[@id=\"categories_block_left\"]/div/ul/li[1]/a")).click();
    //    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
    //    driver.findElement(By.cssSelector("[data-atat='close']")).click();    rozwiązanie na wyskakujące reklamy
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"center_column\"]/ul")));
    //    Assert.assertThat("Liczba elementów na stronie nie równa się 2", driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul")).getSize().);//
    //    Assert.assertEquals(true, verifyElementPresent(driver, By.xpath("//*[@id=\\\"center_column\\\"]/ul\"")));
        Assert.assertEquals(true, verifyElementPresent(driver, By.xpath("//*[@id=\"center_column\"]/ul/li[1]")));
        Assert.assertEquals(true, verifyElementPresent(driver, By.xpath("//*[@id=\"center_column\"]/ul/li[2]")));
    }

    public static boolean verifyElementPresent(WebDriver driver, By by)
    {
        try{
            driver.findElement(by);
            System.out.println("Element found");
            return true;
        }
        catch (NoSuchElementException e){
            System.out.println("Element not found");
            return false;
        }
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

}
