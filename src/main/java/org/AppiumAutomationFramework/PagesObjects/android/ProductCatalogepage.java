package org.AppiumAutomationFramework.PagesObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.AppiumAutomationFramework.utils.AndroidAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalogepage extends AndroidAction {
    AndroidDriver driver;

    public ProductCatalogepage(AndroidDriver driver) { //Driver come from base

        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
    private List<WebElement> addToCart;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement CartButton;


    public void addItemToCartByIndex(int index) {

        addToCart.get(index).click();
    }




    ///--------------methed 2----------//
    public CartPage goToCartPage() throws InterruptedException {

        CartButton.click();
        Thread.sleep(2000);

        return new  CartPage(driver);
    }

}
