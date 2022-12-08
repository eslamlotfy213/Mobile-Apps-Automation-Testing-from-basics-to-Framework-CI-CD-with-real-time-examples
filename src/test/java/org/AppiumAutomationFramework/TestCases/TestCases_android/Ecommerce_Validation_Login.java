package org.AppiumAutomationFramework.TestCases.TestCases_android;

import org.AppiumAutomationFramework.PagesObjects.android.ProductCatalogepage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ecommerce_Validation_Login  extends  BaseTest{


//   @BeforeMethod
//    public  void prehome(){
//       pageFormpageobj.setActivity();
//
//    }

    @Test(priority = 1,groups = {"Regression"})
    public void FllFormByInValidDate() throws InterruptedException {
        //newpage   Newobj  =  oldobj.methodAction();
        // pageFormpageobj.setNameField();
        pageFormpageobj.setGender("Female");
        pageFormpageobj.setSelectCountry("Argentina");
        ProductCatalogepage productCatalogepageObj = pageFormpageobj.SubmitForm();
        String toastMessage= driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
        Assert.assertEquals(toastMessage,"Please enter your name1");
    }


    @Test(priority = 2,groups = {"Regression"})
    public void FllFormByValidDate() throws InterruptedException {

        //newpage   Newobj  =  oldobj.methodAction();
        pageFormpageobj.setNameField("eslam lotfy");
        pageFormpageobj.setGender("male");
        pageFormpageobj.setSelectCountry("Argentina");
        ProductCatalogepage productCatalogepageObj = pageFormpageobj.SubmitForm();
       Assert.assertTrue(driver.findElements(By.xpath("(//android.widget.Toast)[1]")).size()<1);
    }


}
