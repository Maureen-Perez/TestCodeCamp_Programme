package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

import java.util.concurrent.TimeUnit;

public class LoginTests {
    private WebDriver driver;

    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        //Automate Konga URL
        driver.get("https://www.konga.com/");
        Thread.sleep(5000);

        // maximize the page of your browser while page loads
        driver.manage().window().maximize();

        // get the page title
        System.out.println(driver.getTitle());

        // make page wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Actions actions = new Actions(driver);

        //click on login/signup button
        driver.findElement(By.linkText("Login / Signup")).click();

        //Enter your username
        driver.findElement(By.id("username")).sendKeys("maureenupm@gmail.com");

        //Enter your password
        driver.findElement(By.id("password")).sendKeys("welcome22");

        //Click on Login button
        driver.findElement(By.xpath("//button[text() = 'Login']")).click();

        //Make page wait
        Thread.sleep(5000);

        //click on Computers and Accessories
        WebElement computersAndAccessories = driver.findElement(By.linkText("Computers and Accessories"));
        actions.moveToElement(computersAndAccessories).perform();

        //click laptops
        WebElement Laptops = driver.findElement(By.linkText("Laptops"));
        actions.click(Laptops).perform();
        Thread.sleep(5000);

        //Click on the Laptops subcategory
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[2]/section/div/section/div[2]/div[2]/ul/li[5]/a/label/span")).click();
        Thread.sleep(5000);

        //Click on the Apple MacBooks
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/section[2]/section/div/section/div[2]/div[2]/ul/li[4]/a/ul/li[1]/a/label/span")).click();
        Thread.sleep(5000);

        //Click on the Add to cart button
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/section[2]/section/section/section/section/ul/li[10]/div/div/div[2]/form/div[4]/button")).click();

        //Click on My Cart
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/nav/div[2]/div/div/a[2]/span[1]")).click();

        //Click on Checkout
        driver.findElement(By.xpath("//button[@class='_0a08a_3czMG' and text() = 'Checkout']")).click();
        Thread.sleep(5000);

        //Click on Use this Address
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
        Thread.sleep(5000);

        //Select Payment Method
        driver.findElement(By.xpath("//button[@_0a08a_3czMG _4a291_2cOtr' and @name = 'selectPaymentMethod']")).click();

        //Continue to make Payment
        driver.findElement(By.xpath("//button[@class = '_0a08a_3czMG' and @name='placeOrder']")).click();

        //Select iframe that comes up for payment
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='kpg-frame-component']"));
        driver.switchTo().frame(iframe);
        Thread.sleep(5000);

        //Click on the card option
        driver.findElement(By.xpath("//button[@class = 'dashboard-card__button Card']")).click();

        //input invalid card details
        driver.findElement(By.xpath("//input[@class = 'card-number input_class' and @id = 'card-number']")).sendKeys("231456677789734");

        //Enter Expiry Date
        driver.findElement(By.xpath("//input[@class = 'date input_class' and @id = 'expiry']")).sendKeys("0623");

        //Enter CVV number
        driver.findElement(By.xpath("//input[@class = 'cvv input_class' and @id = 'cvv']")).sendKeys("432");

        //Click on the Pin input box
        driver.findElement(By.xpath("//input[@class = 'card-pin' and @id = 'card-pin-new']")).click();

        //Enter Pin
        driver.findElement(By.xpath("//button[@class='keypadbutton pin-keypad__button' and text() = '3']")).click();
        driver.findElement(By.xpath("//button[@class='keypadbutton pin-keypad__button' and text() = '2']")).click();
        driver.findElement(By.xpath("//button[@class='keypadbutton pin-keypad__button' and text() = '1']")).click();
        driver.findElement(By.xpath("//button[@class='keypadbutton pin-keypad__button' and text() = '5']")).click();

        //Validate card form
        driver.findElement(By.id("validateCardForm")).click();

        //Print error message of card number field
        WebElement error = driver.findElement(By.xpath("//label[@id='card-number_unhappy' and text() = 'Invalid card number']"));
        String errorPrint = error.getText();
        System.out.println(errorPrint);

        Thread.sleep(5000);

        //Close iframe for input card modal
        driver.findElement(By.className("data-card__close")).click();

    }
    public static void main (String args[]) throws InterruptedException {
        LoginTests test = new LoginTests();
        test.setUp();

    }
    @AfterTest

    public void QuitBrowser() {driver.quit(); }
    {
    }

}

