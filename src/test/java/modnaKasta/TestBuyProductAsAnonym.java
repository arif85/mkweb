package modnaKasta;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class TestBuyProductAsAnonym {

    WebDriver driver = new ChromeDriver();
    TestBuyProductAsAnonymS testBuyProductAsAnonymS = new TestBuyProductAsAnonymS(driver);

    @Before
    public void setUp() throws Exception {
        testBuyProductAsAnonymS.startBrowserAndLoadMainPage();
        Assert.assertTrue("Wrong page loaded", testBuyProductAsAnonymS.isMainPageLoaded());
    }

    @Test

    public void testBuyProductAsAnonym() {
        testBuyProductAsAnonymS.clickRandomItem();
        testBuyProductAsAnonymS.hideSoldItems();
        testBuyProductAsAnonymS.clickRandomProduct();
        testBuyProductAsAnonymS.addProductToBasket();
        Assert.assertTrue("Auth form was not opened", testBuyProductAsAnonymS.isAuthFormDisplayed());

    }

    @After

    public void tearDown() {

        testBuyProductAsAnonymS.closeBrowserAndDriver();
    }
}
