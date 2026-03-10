import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import contact1.getDriver;

public class LoginTest {

    getDriver driver;
    WebDriver webdriver;

@BeforeEach
public void setup()
{
    driver=new getDriver();
    webdriver=driver.chromeWebDriver();

}
@AfterEach
public void tearDown()
{
    if(webdriver!=null)
    {
        webdriver.quit();
    }
}

@ParameterizedTest
@CsvSource(
    {
        "student, Password123",
        "student, Password123"
        
    })
    public void testValidateMessageLength(String username,String password)
    {
        webdriver.get("https://practicetestautomation.com/practice-test-login/");

        webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

       WebElement usernameBox=webdriver.findElement(By.id("username"));
       usernameBox.sendKeys(username);

       WebElement pass=webdriver.findElement(By.id("password"));
       pass.sendKeys(password);


       WebElement submitbutton=webdriver.findElement(By.id("submit"));
       submitbutton.click();

       String url=webdriver.getCurrentUrl().toString();
       assertTrue(url.contains("https://practicetestautomation.com/logged-in-successfully/"));
    }
    

    
}

