package org.AppiumAutomationFramework.PagesObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.AppiumAutomationFramework.utils.AndroidAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AndroidAction {
    AndroidDriver driver;

    public  CartPage(AndroidDriver driver){ //Driver come from base

        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "android:id/button1")
    private WebElement acceptbutton;

    @AndroidFindBy(className = "android.widget.CheckBox")
    private WebElement checkBox;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
    private WebElement proceedbutton;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    private WebElement  totalAmount;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    private List<WebElement> productList;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
    private WebElement termsbutton;

    public Double getTotalAmountDisplay(){
        return  getFormatAmmount(totalAmount.getText());
    }



    public List<WebElement> getProductList()
    {
        return productList;
    }


    public  double getProductSum(){
        int count = productList.size();
        double  totalsum = 0;
        for (int i = 0; i < count; i++) {
            String ammountstring =productList.get(i).getText();
            Double price= getFormatAmmount(ammountstring);
            totalsum = totalsum + price;
        }
        return totalsum;
    }


    public  void accpetTermConditions(){
        LongpressAction(termsbutton);
        acceptbutton.click();
    }


    public void submitOrder(){
        checkBox.click();
        proceedbutton.click();
    }


}
