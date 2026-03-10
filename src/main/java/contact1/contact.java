package contact1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class contact {

     getDriver driver=new getDriver();

     public void waitFor(WebDriver driver,int time)
    {
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
     }

    // //checking length >=10

    // public void  validateMessageLength(String email,String message)
    // {
    //     WebDriver driver=this.driver.chromeWebDriver();
    //    driver.get("http://localhost:3000");

    //    WebElement emailBox=driver.findElement(By.id("ExampleFormControlInput"));
    //    emailBox.sendKeys(message);
    //    this.waitFor(driver,1000);

    //    WebElement messageBox=driver.findElement(By.id("ExampleFormControlTextarea1"));
    //    emailBox.sendKeys(message);
    //    this.waitFor(driver,1000);





    // }
    
}
