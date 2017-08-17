import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class IphonePage {

    private WebDriver webDriver;

    public IphonePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @FindBy(xpath = ".//*[@id='product_offers_container']/ul/li/div[2]/div[2]/p[1]/a")
    private List<WebElement> iphoneShops;

    @FindBy(xpath = ".//*[@id='product_offers_container']/ul/li/div[2]/div[3]/p[1]/a")
    private List<WebElement> iphonePrices;

    @FindBy(xpath = ".//*[@id='product_offers_container']//ul[contains(@class,'do-hover')]")
    private List<WebElement> iphoneList;

    @FindBy(xpath =".//*[@id='prod_row_166766615']/div[1]/div/div[1]/div/p[1]/span[3]/b/span")
    private WebElement availableShops;

    public Integer numberOfShops() {
        return iphoneShops.size();
    }

    List<String> prices = new ArrayList<String>();
    List<String> pricesInt = new ArrayList<String>();
    List<String> pricesNum = new ArrayList<String>();
    List<Double> pricesDouble = new ArrayList<Double>();

    int poz = 0;

    public Double minPrice() {
        for (WebElement price : iphonePrices) {
            prices.add(price.getText());
        }
        for (String price : prices) {
            pricesInt.add(price.replace(" RON", ""));
        }
        for (String price : pricesInt) {
            pricesNum.add(price.replace(".", ""));
        }
        for (String price : pricesNum) {
            pricesDouble.add(Double.parseDouble(price.replace(",", ".")));
        }
        Double min = pricesDouble.get(0);
        for (int i = 1; i < pricesDouble.size(); i++) {
            if (min > pricesDouble.get(i)) {
                min = pricesDouble.get(i);
                poz = i;
            }
        }
        return min;
    }

    public String shopMinPrice() {
        return iphoneShops.get(poz).getAttribute("title");
    }

    int index = 0;

    public Double maxPrice() {

        Double max = pricesDouble.get(0);
        for (int i = 1; i < pricesDouble.size(); i++) {
            if (max < pricesDouble.get(i)) {
                max = pricesDouble.get(i);
                index = i;
            }
        }
        return max;
    }

    public String shopMaxPrice() {
        return iphoneShops.get(index).getAttribute("title");
    }

    public String noOfAvailableShops(){
        return availableShops.getText();
    }

}
