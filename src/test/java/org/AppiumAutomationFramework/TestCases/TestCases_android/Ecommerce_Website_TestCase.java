package org.AppiumAutomationFramework.TestCases.TestCases_android;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.AppiumAutomationFramework.PagesObjects.android.CartPage;
import org.AppiumAutomationFramework.PagesObjects.android.ProductCatalogepage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Ecommerce_Website_TestCase extends BaseTest {



    @Test(dataProvider = "getData",groups = {"Smoke"})
    public void FllForm(HashMap<String,String> input) throws InterruptedException {

        //newpage   Newobj  =  oldobj.methodAction();
        pageFormpageobj.setNameField(input.get("name"));
        pageFormpageobj.setGender(input.get("gender"));
        pageFormpageobj.setSelectCountry(input.get("country"));
        ProductCatalogepage productCatalogepageObj = pageFormpageobj.SubmitForm();
        productCatalogepageObj.addItemToCartByIndex(0);
        productCatalogepageObj.addItemToCartByIndex(0);
        CartPage cartPageObj = productCatalogepageObj.goToCartPage();

        double totalsum=  cartPageObj.getProductSum();
        double AmountDisplayed = cartPageObj.getTotalAmountDisplay();
        Assert.assertEquals(totalsum,AmountDisplayed);

        cartPageObj.accpetTermConditions();
        cartPageObj.submitOrder();


        Thread.sleep(4000);
        Set<String> contexts = driver.getContextHandles();
        for ( String contextName :contexts) {
            System.out.println(contextName);
        }
       // NATIVE_APP
       // WEBVIEW_com.androidsample.generalstore
        driver.context("WEBVIEW_com.androidsample.generalstore");
        driver.findElement(By.name("q")).sendKeys("Welcome");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context("NATIVE_APP");
    }


//    @BeforeMethod
//    public  void prehome(){
//        pageFormpageobj.setActivity();
//
//    }


    @DataProvider
    public Object [][] getData() throws IOException {
        List<HashMap<String, String>> mydata = getJsonData(System.getProperty("user.dir") + "/src/test/java/org/AppiumAutomationFramework/TestCases/Testdata/eCommerce.json");
        //return new Object [][]{ {mydata.get(0), mydata.get(1), mydata.get(2)}, {"eslam lotfy1", "Male", "Argentina"} };
        return new Object[][]{{mydata.get(0)},{ mydata.get(1)}};
    }

}