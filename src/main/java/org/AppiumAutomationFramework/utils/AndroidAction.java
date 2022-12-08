package org.AppiumAutomationFramework.utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.io.File;

public class AndroidAction extends AppiumUtils{

     AndroidDriver driver;

    public AndroidAction (AndroidDriver driver){
        //super(driver);
        this.driver = driver;
    }





    public void LongpressAction(WebElement element){
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId",((RemoteWebElement) element).getId(),
                        "duration",2000));
    }



    public void scrollToEndAction()
    {
        boolean canScrollMore=true;
        do
        {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0

            ));
        }while(canScrollMore);
    }



    public void scrollIntoView_Selecting(String Text){

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())." +
                "scrollIntoView(text(\"" +Text+ "\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='"+Text+"']")).click();
    }


    public void scrollIntoView(String Text){
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())." +
                "scrollIntoView(text(\"" +Text+ "\"));"));
    }



    public void SwipAction(WebElement element, String direction ) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "percent", 0.75
        ));
    }


    public  void  DrapandDropAction(WebElement element){
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", 619,
                "endY", 560
        ));
    }




}
