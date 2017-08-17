import org.junit.Assert;
import org.junit.Test;


public class SearchTest extends FirstTest {

    @Test
    public void searchProdTest() {

        ResultsPage resultsPage = homePage.searchProduct("iphone");
        PhoneResultsPage phoneResultsPage = resultsPage.goToMobilePhones();

        System.out.println("Iphone price: " + phoneResultsPage.getThePriceOfFirstPhone());
        Assert.assertEquals("1.442 RON", phoneResultsPage.getThePriceOfFirstPhone());

        IphonePage iphonePage = phoneResultsPage.goToFirstIphonePage();
        System.out.println("Number of available shops: " + iphonePage.noOfAvailableShops());
        System.out.println("Number of shops per page: " + iphonePage.numberOfShops());

        System.out.println("Min price: " + iphonePage.minPrice() + " on shop: " + iphonePage.shopMinPrice());

        System.out.println("Max price: " + iphonePage.maxPrice() + " on shop: " + iphonePage.shopMaxPrice());
        Assert.assertEquals("2399.9", String.valueOf(iphonePage.maxPrice()));


    }

}
