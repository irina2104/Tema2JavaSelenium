import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultsPage {

    private WebDriver webDriver;

    public ResultsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @FindBy(xpath = ".//*[@id='main_col']/div/ul[1]/li[7]/a")
    private WebElement phonesCategory;

    public PhoneResultsPage goToMobilePhones() {
        phonesCategory.click();
        return PageFactory.initElements(webDriver, PhoneResultsPage.class);

    }

}
