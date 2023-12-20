package ParaBank;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ViewAccountInfoTest {
    WebDriver driver;
    Faker faker = new Faker();

    @Parameters("browser")
    @BeforeClass
    public void setUp(@Optional("chrome") String browser) {
        // Set up WebDriver based on the specified browser
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win64\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\user\\Downloads\\geckodriver-win64\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        // Navigate to Parabank website
        driver.get("https://parabank.parasoft.com/");
    }

    @Test
    public void testViewAccountBalancesAndTransactions() throws InterruptedException {
        // Login with valid credentials
        driver.findElement(By.name("username")).sendKeys("Sam");
        driver.findElement(By.name("password")).sendKeys("Sam@123");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();

        // Navigate to Accounts Overview
        driver.findElement(By.linkText("Accounts Overview")).click();

        // Validate displayed account balances
        WebElement accountBalance = driver.findElement(By.xpath("//table[@id='accountTable']/tbody/tr[1]/td[2]"));
        Assert.assertNotNull(accountBalance.getText());

        // Click on a specific account to view its transaction history
        Thread.sleep(1000);
        driver.findElement(By.xpath("//table[@id='accountTable']/tbody/tr[1]/td[1]/a")).click();

        // Validate transaction history page
        WebElement accountDetails = driver.findElement(By.xpath("//h1[@class='title' and contains(text(), 'Account Details')]"));
        Assert.assertTrue(accountDetails.isDisplayed(), "Account Details");
        Thread.sleep(1000);
        //Transaction Table Validation
        WebElement transactionDetails = driver.findElement(By.xpath("//table[@id='transactionTable']/tbody/tr/td[2]/a"));
        Assert.assertNotNull(transactionDetails.getText());
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}

