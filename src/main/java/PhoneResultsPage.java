import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PhoneResultsPage {
    private WebDriver webDriver;

    public PhoneResultsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @FindBy(xpath = ".//*[@id='main_products_container']/ul/li[1]/div[2]/div[2]/div[2]/a")
    private WebElement priceOfTheFirstPhone;

    @FindBy(xpath = ".//*[@id='main_products_container']/ul/li[1]/div[3]/p[1]/a")
    private WebElement firstIphonePhone;

    public String getThePriceOfFirstPhone() {
        return String.valueOf(priceOfTheFirstPhone.getText());
    }


    public IphonePage goToFirstIphonePage() {

        firstIphonePhone.click();
        return PageFactory.initElements(webDriver, IphonePage.class);

    }
}
