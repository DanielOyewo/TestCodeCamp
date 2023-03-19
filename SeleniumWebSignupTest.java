import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebSignupTest {
    //import the selenium WebDriver
    private WebDriver driver;

    @BeforeTest
    public void begin() throws InterruptedException {
        //locate the WebDriver
        System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");
        //1. open edge browser
        driver = new EdgeDriver();
        //2. input the selenium demo page url (https://selenium-blog.herokuapp.com)
        driver.get("https://selenium-blog.herokuapp.com");
        Thread.sleep(5000);
        //3. maximize the browser
        driver.manage().window().maximize();
        //4. click on signup button to open signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
    }
    @Test (priority = 0)
    public void negativeSignup() throws InterruptedException{
        //5. enter less than 3 characters username in the username field
        driver.findElement(By.xpath("//*[@id=\"user_username\"]")).sendKeys("mo");
        //6. enter email address in the email field
        driver.findElement(By.xpath("//*[@id=\"user_email\"]")).sendKeys("moyo31@mailnator.com");
        //7. enter password in the password field
        driver.findElement(By.xpath("//*[@id=\"user_password\"]")).sendKeys("admin");
        //8.  click on signup button
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        Thread.sleep(5000);

    }

    @Test (priority = 1)
    public void positiveSignup() throws InterruptedException{
        //9. clear the username field
        driver.findElement(By.xpath("//*[@id=\"user_username\"]")).clear();
        //10. clear the email field
        driver.findElement(By.xpath("//*[@id=\"user_email\"]")).clear();
        Thread.sleep(5000);
        //11. enter username in the username field
        driver.findElement(By.id("user_username")).sendKeys("moyo34");
        //12. enter email address in the email field
        driver.findElement(By.id("user_email")).sendKeys("moyo34@mailnator.com");
        //13. enter password in the password field
        driver.findElement(By.id("user_password")).sendKeys("admin");
        //14 click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);

    }
    @Test (priority = 2)
    public void clickuser1Item() throws InterruptedException{
        //15. click on the user1 on the listpage
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        Thread.sleep(5000);

    }
    @Test (priority = 3)
    public void verifyItem() throws InterruptedException{
        //16. search for an item (using python with selenium) and confirm it is present
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/a")).click();
        Thread.sleep(5000);
        //17. click on logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        Thread.sleep(5000);

    }

    @Test (priority = 4)
    public void positivelogin() throws InterruptedException{
        //18. click on login button
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[1]/a")).click();
        //19. enter the email address in the email field
        driver.findElement(By.xpath("//*[@id=\"session_email\"]")).sendKeys("moyo34@mailnator");
        //20. enter the password in the password field
        driver.findElement(By.xpath("//*[@id=\"session_password\"]")).sendKeys("admin");
        //21. click on the login button
        driver.findElement(By.xpath("/html/body/div[2]/form/div[3]/div/input")).click();
        Thread.sleep(5000);

    }

    @AfterTest
    public void closebrowser(){
        //Quit the browser
        driver.quit();
    }

}