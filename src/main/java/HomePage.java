import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(id = "autocomplete_prod")
    private WebElement searchBox;

    @FindBy(xpath = ".//*[@id='main_search']/div/span[2]/button")
    private WebElement searchButton;

    private WebDriver webDriver;

    public HomePage(WebDriver driver) {
        this.webDriver = driver;
    }

    public ResultsPage searchProduct(String productName) {
        searchBox.sendKeys(productName);
        searchButton.click();


        ResultsPage resultsPage = PageFactory.initElements(webDriver, ResultsPage.class);
        //resultsPage.waitUntilCOmpleteLog();
        return resultsPage;
    }
}
