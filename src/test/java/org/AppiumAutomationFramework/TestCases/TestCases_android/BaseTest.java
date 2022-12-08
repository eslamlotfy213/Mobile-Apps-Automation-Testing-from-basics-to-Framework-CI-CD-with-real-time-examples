package org.AppiumAutomationFramework.TestCases.TestCases_android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.AppiumAutomationFramework.PagesObjects.android.Formpage;
import org.AppiumAutomationFramework.utils.AppiumUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest extends AppiumUtils {

   public AppiumDriverLocalService service;
   public UiAutomator2Options options;
   public AndroidDriver driver;
    Formpage pageFormpageobj;

   @BeforeClass(alwaysRun = true)
    public  void configuration() throws IOException {

       Properties prop = new Properties();
       System.out.println(System.getProperty("user.dir"));
       FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/org/AppiumAutomationFramework/resources/data.properties");
       prop.load(fs);

       String _ipaddress= System.getProperty("ipaddress")!=null? System.getProperty("ipaddress") : prop.getProperty("ipaddress") ;

       String _port= prop.getProperty("port");
       service=  StartAppiumServer(_ipaddress,Integer.parseInt(_port));

        options = new UiAutomator2Options();
        options.setDeviceName(prop.getProperty("AndroidDeviceName"));
        options.setChromedriverExecutable("D://[LATEST VERSION 2.0] Master on Mobile Apps Automation Testing from basics to Framework CICD with real time examples//83.0.4103//chromedriver.exe");
        options.setApp(System.getProperty("user.dir")+"/src/test/java/org/AppiumAutomationFramework/TestCases/resources/General-Store.apk");
        driver = new AndroidDriver(service.getUrl(),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        pageFormpageobj = new Formpage(driver);
    }


    @AfterClass(alwaysRun = true)
    public  void TearDown()
    {
        driver.quit();
        service.stop();
    }


}
