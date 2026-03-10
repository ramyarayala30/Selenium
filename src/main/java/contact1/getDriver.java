package contact1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getDriver {

     public WebDriver chromeWebDriver()
    {
        ChromeOptions chromeoptions=new ChromeOptions();
        chromeoptions.addArguments("--disable-blink-features=AutomationControlled");
        //this is used because
        /*Chrome has a rendering engine called Blink.
        When Selenium automates Chrome, Chrome exposes some internal flags
         that indicate the browser is controlled by automation.
        Some websites, especially Google, Facebook, and banking sites, 
        can detect automated browsers and sometimes block them.
        --disable-blink-features=AutomationControlled
        Tells Chrome to hide that it’s being automated by Selenium.
        Specifically, it disables the internal navigator.webdriver property, 
        which normally returns true when automation is detected.
        */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver(chromeoptions);
        return driver;    
    }
    public WebDriver edgeWebDriver()
    {
        WebDriverManager.edgedriver().setup();
        WebDriver driver=new EdgeDriver();
        return driver;   
    }
    public WebDriver firefoxWebDriver()
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();
        return driver;   
    }    
    
}
