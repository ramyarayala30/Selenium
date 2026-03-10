import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import contact1.contact;
import contact1.getDriver;

public class ContactTest {

    contact c;
    getDriver driver;
    WebDriver webdriver;

@BeforeEach
public void setup()
{
    c=new contact();
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
        "ramyarayala70@gmail.com, ramya12345",
        "ramyarayala12@gmail.com,rayala12345"
    })
    public void testValidateMessageLength(String email,String message)
    {
        webdriver.get("http://localhost:3000");

        webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

       WebElement emailBox=webdriver.findElement(By.id("exampleFormControlInput1"));
       emailBox.sendKeys(email);

       
       WebElement messageBox=webdriver.findElement(By.id("exampleFormControlTextarea1"));
       messageBox.sendKeys(message);


       WebElement submitbutton=webdriver.findElement(By.className("btn-primary"));
       submitbutton.click();


       Alert alert=webdriver.switchTo().alert();
       String alertText=alert.getText();
       alert.accept();

       assertEquals("Thank you for contacting us! We will get back to you soon.",alertText);
       
    }   
}
