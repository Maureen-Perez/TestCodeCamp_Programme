package User;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserManagementTest {
    //import selenium webDriver
    private WebDriver driver;


    @BeforeClass
    public void setUp() throws InterruptedException {
        //fetch the chromeDriver.exe file
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //launch the chromedriver.exe file
        driver = new ChromeDriver();
        //input the website URL
        driver.get("https://web.facebook.com/");
        //wait for the page to load in 5 seconds
        Thread.sleep(5000);
        //Maximize the browser
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void loginTest() throws InterruptedException {
        //click on the username field and input a valid username "maureenupm@gmail.com"
        driver.findElement(By.id("email")).sendKeys("maureenupm@gmail.com");
        //click on the password field and input a valid password "Maumau@222"
        driver.findElement(By.id("pass")).sendKeys("Maumau@222");
        //click on the login/signin button
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/button")).click();
        Thread.sleep(5000);
        if (driver.getCurrentUrl().contains("https://web.facebook.com/")) {
            System.out.println("PASSED - User has successfully logged in");
        } else {
            System.out.println("FAILED - The user was unable to login");
        }
        Thread.sleep(5000);
    }

    @Test
    public void logoutTest() throws InterruptedException {
        //click on user Profile
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div[4]/div[1]/span/div/div[1]/i")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div[4]/div[2]/div/div[3]/div[1]/div[1]/div/div/div/div/div/div/div/div/div[1]/div/div[3]/div/div[4]/div/div[1]/div[2]/div/div/div/div/span")).click();
        if (driver.getCurrentUrl().contains("https://web.facebook.com/?stype=lo&jlou=AffVouhWlFDQ8qnIF5mVZUaqGVcp1lduAnVkEqNy_ud6uB-BhC1aIevBVvxQbnXi2Hl6fBqwWxJG4J2lRAEN7U4h4-U4SOdZ8RinSYyvJAYRCw&smuh=43444&lh=Ac-8WfEWWWSFwbaJe7o")) {
            System.out.println("PASSED - User has successfully logged out");
        } else {
            System.out.println("FAILED - The user is still logged in");
        }
        Thread.sleep(5000);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
