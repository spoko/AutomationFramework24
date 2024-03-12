package baseTC;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestUtil extends DataProviders {
    public WebDriver driver;
    private String browser, targetURL;
    private int implicitWait;

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @BeforeMethod
    public void setupDriverAndOpenTargetURL(){
        readConfig("src/test/resources/config.properties");
        setupDriver();
        //implicit wait:
        //driver.manage().timeouts().implicitlyWait(Duration.from(Duration.ofSeconds(implicitWait)));
        driver.get(targetURL);
    }

    private void readConfig(String pathToFile){
        try {
            FileInputStream fileInputStream = new FileInputStream(pathToFile);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            targetURL = properties.getProperty("url");
            browser = properties.getProperty("browser");
            implicitWait = Integer.parseInt(properties.getProperty("implicitWait"));
        }catch (IOException e){
            System.out.println(e);
        }
    }

    private void setupDriver(){
        switch (browser){
            case "safari":
                driver = setupSafariDriver();
                break;
            case "firefox":
                driver = setupFirefoxDriver();
                break;
            default:
                driver = setupChromeDriver();
        }
    }

    private WebDriver setupSafariDriver(){
        WebDriverManager.safaridriver().setup();
        return new SafariDriver();
    }

    private WebDriver setupFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private WebDriver setupChromeDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}