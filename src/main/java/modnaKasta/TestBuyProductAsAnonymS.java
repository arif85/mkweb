package modnaKasta;

import jdk.nashorn.internal.runtime.ECMAException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class TestBuyProductAsAnonymS {

    @FindBy(xpath = ".//div[@class='banner_item banners--big']")
    WebElement bigBanner;
    @FindBy(xpath = ".//div[@class='btn hide_sold']")
    WebElement hideSoldButton;
    @FindBy(xpath = ".//div[@class='btn cta ']")
    WebElement addToBasketButton;
    @FindBy(xpath = ".//div[@class='popup__login-form']")
    WebElement isauthform;

    WebDriver driver;

    public TestBuyProductAsAnonymS(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void startBrowserAndLoadMainPage() throws Exception {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.modnakasta.ua");
        System.out.println("Browser opened and modnaKasta page loaded");

    }

    public boolean isMainPageLoaded() {
        try {
            boolean isBannerDisplayed = bigBanner.isDisplayed();
            return isBannerDisplayed;
        } catch (Exception e) {
            Assert.fail("Main page was not loaded or failed to load big banner");
            return false;
        }
    }


    /**
     * public void clickRandomCampaing() {
     * List<WebElement> listings = driver.findElements(By.xpath(".//div[@class='nav_content']/div"));
     * Random r = new Random();
     * int randomValue = r.nextInt(listings.size()); //Getting a random value that is between 0 and (list's size)-1
     * listings.get(randomValue).click(); //Clicking on the random item in the list.
     * <p>
     * }
     */

    public void clickRandomItem() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@class='b-small']//a")));
        List<WebElement> listings = driver.findElements(By.xpath(".//div[@class='b-small']//a"));
        Random r = new Random();
        int randomValue = r.nextInt(listings.size()); //Getting a random value that is between 0 and (list's size)-1
        listings.get(randomValue).click(); //Clicking on the random item in the list.
        System.out.println("Random campaign clicked");

    }

    public void hideSoldItems() {

        hideSoldButton.click();
        System.out.println("Sold button clicked");
    }

    public void closeBrowserAndDriver() {

        driver.quit();
        System.out.println("Browser and driver were closed");
    }

    public void clickRandomProduct() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@class='product_item_wrap']")));
        List<WebElement> listing = driver
                .findElements(By.xpath(".//div/div[@class='product_item_wrap']"));
        Random r = new Random();
        int randomValue = r.nextInt(listing.size());
        listing.get(randomValue).click();
        System.out.println("Random product opened");
    }

    public void addProductToBasket() {
        addToBasketButton.click();
        System.out.println("Add to basket clicked");

    }

    public boolean isAuthFormDisplayed() {
        try {
            boolean isAuthAppeared = isauthform.isDisplayed();
            return isAuthAppeared;
        } catch (Exception e) {
            Assert.fail("Auth form was not loaded");
            return false;
        }
    }
}
