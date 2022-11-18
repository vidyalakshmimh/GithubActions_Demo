package org.sherwin.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.time.Duration;

@Listeners(ListenersImplementation.class)
public class BaseTest  {
    public static WebDriver driver;

    public BaseTest(){
    }

    @BeforeMethod
    public void initBrowser(){
        try{
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            System.out.println("Browser invoked successfully");
        } catch (Exception e) {
            System.out.println("Failed to invoke browser");
            e.printStackTrace();
        }
    }

    @AfterMethod
    protected void tearDown( ) {
        // Sometimes the driver may be null because there was a problem in creating the driver initially.
        if(driver != null)
            driver.quit();
    }

    public static int getWait() {
        int wait = 3;
        return wait;
    }



    public static void setImplicitWait(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds((long)getWait()));
    }

    public static void setPageLoadTimeOut() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds((long)getWait()));
    }

    protected void setScriptTimeOut() {
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds((long)getWait()));
    }

    protected void setWindowSize(int height, int width) {
        Dimension targetSize = new Dimension(width, height);
        driver.manage().window().setSize(targetSize);
    }

}