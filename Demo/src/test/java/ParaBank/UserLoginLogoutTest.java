package ParaBank;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class UserLoginLogoutTest {
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
    public void testUserLoginAndLogout() {
        // Login with valid credentials
        driver.findElement(By.name("username")).sendKeys("Vaishu");
        driver.findElement(By.name("password")).sendKeys("Vaishu456@");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();

        // Validate successful login
        WebElement welcomeMessage = driver.findElement(By.xpath("//p[@class='smallText']/b[contains(text(),'Welcome')]"));
        Assert.assertTrue(welcomeMessage.isDisplayed(), "Welcome");

        // Logout
        driver.findElement(By.linkText("Log Out")).click();

        // Validate successful logout
        WebElement loginForm = driver.findElement(By.id("loginPanel"));
        Assert.assertTrue(loginForm.isDisplayed());
        String customerLogin = driver.findElement(By.xpath("//*[@id='leftPanel']/h2[text()='Customer Login']")).getText();
        Assert.assertEquals(customerLogin ,"Customer Login" );
        // Additional assertions and validation checks can be added
    }

    // Same @AfterClass method as in Test Case 1@AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}


