package TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public class TestBase1
{
    public WebDriver driver;
    public  Properties p;
    public Logger logger;
    @BeforeClass

    @Parameters("browser")
    public WebDriver setup(String browser) throws IOException
    {

        switch (browser.toLowerCase())
        {
            case "chrome" :WebDriverManager.chromedriver().setup();
                /*ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");*/

                           driver = new ChromeDriver();
                break;

            case "edge" :WebDriverManager.edgedriver().setup();
               /* EdgeOptions optionsEdge = new EdgeOptions();
                optionsEdge.addArguments("--headless");*/
               driver=new EdgeDriver();
               break;

            case "firefox" :WebDriverManager.firefoxdriver().setup();
               /* FirefoxOptions optionsFire = new FirefoxOptions();
                optionsFire.addArguments("--headless");*/
            driver=new FirefoxDriver();
            break;

            case "default" :
                System.out.println("invalid browser");
                break;

        }


        //System.setProperty("webdriver.chromedriver.driver","//Users//aditilokhande//Downloads//chromedriver-mac-x64//chromedriver");
        //ChromeDriver driver =new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

        logger = (Logger) LogManager.getLogger(this.getClass());

        FileReader file = new FileReader("./src/test/java/config.properties");
        p = new Properties();
        p.load(file);


        return driver;
    }

    @AfterClass(groups="Sanity")
    public void close()
    {
        driver.quit();
    }
}
