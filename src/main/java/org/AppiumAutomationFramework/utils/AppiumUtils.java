package org.AppiumAutomationFramework.utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import javax.imageio.ImageIO;


public class AppiumUtils {
    public AppiumDriverLocalService service;
    AppiumDriver driver;
//    public  AppiumUtils (AppiumDriver driver){
//        this.driver = driver;
//    }


    public AppiumDriverLocalService StartAppiumServer(String ipaddress ,int port){
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C://Users//Eslam.Lotfy//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
                .withIPAddress(ipaddress).usingPort(port).build();
        service.start();
        return service;
    }


    public Double getFormatAmmount(String amount){
        Double price= Double.parseDouble(amount.substring(1));
        return price;
    }



    public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {
//System.getProperty("user.dir")+"//src//test//java//org//rahulshettyacademy//testData//eCommerce.json"

        // conver json file content to json string
        String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);

        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent,
                new TypeReference<List<HashMap<String, String>>>() {
                });
        return data;

    }

        public  void waitForElementToApper(WebElement element , AppiumDriver driver){
          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains((element), "text", "Cart"));

    }

//    public  void getScreenShot(String testcaseName,AppiumDriver driver){
//      File source = driver.getScreenshotAs(OutputType.FILE);
//      String destinationFile =System.getProperty("user.dir")+"//reports"+testcaseName+".png";
//      FileUtils.copyFile(source,destinationFile);
//      return destinationFile;
//    }


//    public String getScreenshotPath(String testCaseName, AppiumDriver driver) throws IOException
//    {
//        File source = driver.getScreenshotAs(OutputType.FILE);
//        String destinationFile = System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
//        FileUtils.copyFile(source, new File(destinationFile));
//        return destinationFile;
//        //1. capture and place in folder //2. extent report pick file and attach to report
//    }


    public static String getScreenshotPath(String testCaseName,AppiumDriver driver) throws IOException {

        TakesScreenshot screen = (TakesScreenshot) driver;
        File src = screen.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir")+"/reports/"+testCaseName+".png";
        File target = new File(dest);
        String filpath = target.getAbsolutePath();
        System.out.println("filepath"+filpath);
        FileUtils.copyFile(src, target);
        System.out.println("Screenshot captured.");
        return dest;
    }


//    public static String getScreenshotPath(String testCaseName,AppiumDriver driver) throws IOException {
//
//
//        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        File target = new File(System.getProperty("user.dir")+"/reports/"+testCaseName+".png");
//        String filpath = target.getAbsolutePath();
//        System.out.println("--------------------------------------"+filpath);
//        FileUtils.copyFile(src, target);
//        return filpath;
//    }










}
