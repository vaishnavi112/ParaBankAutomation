package ParaBank;


import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class NewCustomerRegistrationTest {
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
    public void testNewCustomerRegistration() throws InterruptedException {
        // Click on the "Register" link
        driver.findElement(By.linkText("Register")).click();
        //Generate unique names & password
        String uniqueFirstName = faker.name().firstName();
        String uniqueLastName = faker.name().lastName();
        String uniqueUserName = faker.name().username();
        String uniquePassword = faker.internet().password();

        driver.findElement(By.name("customer.firstName")).sendKeys(uniqueFirstName);
        driver.findElement(By.name("customer.lastName")).sendKeys(uniqueLastName);
        driver.findElement(By.name("customer.address.street")).sendKeys("XYZ Street");
        driver.findElement(By.name("customer.address.city")).sendKeys("Hyd");
        driver.findElement(By.name("customer.address.state")).sendKeys("TN");
        driver.findElement(By.name("customer.address.zipCode")).sendKeys("4409");
        driver.findElement(By.name("customer.phoneNumber")).sendKeys("0000012345");
        driver.findElement(By.name("customer.ssn")).sendKeys("980");
        driver.findElement(By.name("customer.username")).sendKeys(uniqueUserName);
        driver.findElement(By.name("customer.password")).sendKeys(uniquePassword);
        driver.findElement(By.name("repeatedPassword")).sendKeys(uniquePassword);

        // Submit registration form
        driver.findElement(By.xpath("//input[@value='Register']")).click();

        // Validate registration success
        WebElement successMessage = driver.findElement(By.xpath("//h1[@class='title' and contains(text(), 'Welcome')]"));
        Assert.assertTrue(successMessage.isDisplayed(), "Welcome" + uniqueUserName);
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
