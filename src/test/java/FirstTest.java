import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class FirstTest {

    protected static HomePage homePage;
    private static WebDriver webDriver;

    @BeforeClass
    public static void before() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/amagureanu/Documents/My Received Files/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("http://www.shopmania.ro/");
        homePage = PageFactory.initElements(webDriver, HomePage.class);
    }
}
