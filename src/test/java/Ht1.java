import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.testng.Assert.assertTrue;


public class Ht1 {

    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(Ht1.class);
    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Initializing Chrome Driver");
    }

    @Test
    public void checkPage() {
        driver.get ("https://otus.ru");
        assertTrue(driver.getTitle().contains("Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям"));
        logger.info("Opening page and checking title");
    }

    @AfterTest
    public void tearDown()  {

        driver.close();
        logger.info("Closing driver");

    }
}
