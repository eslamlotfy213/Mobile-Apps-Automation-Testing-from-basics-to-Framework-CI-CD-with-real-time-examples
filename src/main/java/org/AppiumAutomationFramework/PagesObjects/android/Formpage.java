package org.AppiumAutomationFramework.PagesObjects.android;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.AppiumAutomationFramework.utils.AndroidAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Formpage extends AndroidAction {

    AndroidDriver driver;
    public Formpage(AndroidDriver driver){ //Driver come from base

        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement nameField;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Female']")
    private WebElement FemaleOption;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Male']")
    private WebElement MaleOption;
    @AndroidFindBy(id = "android:id/text1")
    private WebElement CountrySelecton;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement Shopbutton;


    public void setActivity(){
        Activity activity = new Activity("com.androidsample.generalstore","com.androidsample.generalstore.MainActivity");
        driver.startActivity(activity);
    }


    public void setNameField(String name ){
        nameField.sendKeys(name);
        driver.hideKeyboard();
    }



    public  void  setGender(String geneder){
            if (geneder.equalsIgnoreCase("Female")){
                FemaleOption.click();
            }else {
                MaleOption.click();
            }

    }


    public void  setSelectCountry(String country){
           CountrySelecton.click();
           scrollIntoView_Selecting(country);
    }



    ///--------------methed 1----------//
    public ProductCatalogepage SubmitForm(){
        Shopbutton.click();
        return new ProductCatalogepage(driver);
    }



}
