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

public class AmazonTest {


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
        "Fossil Watches",
        "women kurtis"
        
    })
    public void testValidateMessageLength(String productname)
    {
        webdriver.get("https://www.amazon.in");

        webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

       WebElement searchBox=webdriver.findElement(By.id("twotabsearchtextbox"));
       searchBox.sendKeys(productname);
       searchBox.submit();


    //    String url = webdriver.getCurrentUrl().toString();
    //    assertTrue(url.toLowerCase().contains(productname.toLowerCase()));

    String url = webdriver.getCurrentUrl();
String expected = productname.toLowerCase().replace(" ", "+");

assertTrue(url.toLowerCase().contains(expected));

    }
       
}

