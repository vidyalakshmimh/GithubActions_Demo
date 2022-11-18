package org.sherwin.utilities;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static org.sherwin.utilities.ListenersImplementation.test;


public class BaseCommands extends BaseTest {
    static WebDriverWait wait;
    public BaseCommands(){
    }

    //This method is used To enter the URL
    public static void getURL(String inputURL){
        try {
            driver.get(inputURL);
            test.pass("Entered application URL successfully");
        }
        catch (Exception var4) {
            String temp = takeScreenshot(driver);
            test.fail("Failed to enter application URL ............. " + var4, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            Assert.fail("test case execution stopped due to failure in entering URL");
        }
    }

    //This method is used To find the element
    public static boolean findElement(By locator) {
        try {
            waitForElement(locator);
            driver.findElement(locator);
            test.pass("Able to find the element");
        } catch (Exception var4) {
            String temp = takeScreenshot(driver);
            test.fail("Finding element failed " + var4, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            Assert.fail();
        }
        return false;
    }
    //This method is used To wait for an element until its located
    public static WebElement waitForElement(By locator) {
        WebElement element = null;
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(50));
            element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            test.pass("Able to wait for an element");
        } catch (Exception var3) {
            String temp = takeScreenshot(driver);
            test.fail("waiting for an element failed " + var3, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            Assert.fail();
        }
        return element;
    }
    //This method is used to wait until an element is clickable
    public static WebElement waitForClickable(By locator) {
        WebElement element=null;
        while (true) {
            try {
                waitForVisibilityOfElement(locator);
                element = wait.until(ExpectedConditions.elementToBeClickable(locator));
                test.pass("Able to wait for an element");
                break;
            } catch (StaleElementReferenceException e) {
                waitForElement(locator);
            } catch (Exception var3) {
                String temp = takeScreenshot(driver);
                test.fail("waiting for clickable element failed " + var3, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
                Assert.fail();
            }
        }
        return element;
    }

    public static String getAttribute(By locator){
        try {
            String element=driver.findElement(locator).getAttribute("title");
            test.pass("Able to get the getAttribute from element");
            return element;
        } catch (Exception var4) {
            String temp = takeScreenshot(driver);
            test.fail("Failed to retrieve the getAttribute from an element" + var4, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            Assert.fail();
        }
        return null;
    }

    //This method is used To clear the field
    public static void clear(By locator){
        try {
            waitForClickable(locator).clear();
            test.pass("Able to clear the input field successfully");
        } catch (Exception var4) {
            String temp = takeScreenshot(driver);
            test.fail("Failed to clear the input field .......... " + var4, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            Assert.fail("test case execution failed due to failure at clicking an element");
        }
    }
    //This method is used To verify that checkbox is checked or not
    public static void checkBoxChecked(By locator){
        try {
            waitForElement(locator).isSelected();
            test.pass("Able to clear the input field successfully");
        } catch (Exception var4) {
            String temp = takeScreenshot(driver);
            test.fail("Failed to clear the input field .......... " + var4, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            Assert.fail("test case execution failed due to failure at clicking an element");
        }
    }
    //This method is used To verify that expected and actual statements
    public static void AssertEquals(String Expected, String Actual){
        try {
            Assert.assertEquals(Expected, Actual);
            test.pass("Assert equals verified successfully");
        } catch (Exception var4) {
            String temp = takeScreenshot(driver);
            test.fail("Failed to verify Assert equals .......... " + var4, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            Assert.fail("test case execution failed due to failure at clicking an element");
        }
    }

    //To provide the value for input field
    public static void sendKeys(By element, String value) {
        try {
            waitForClickable(element).sendKeys(value);
            test.pass("Entered "+ value+" for input field "+driver.findElement(element).getText()+" successfully");
        } catch (Exception var4) {
            String temp = takeScreenshot(driver);
            test.fail("Failed to send the value for input field failed.......... " + var4, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            Assert.fail("test case execution stopped due to failure in providing input value");
        }
    }

    //To click the button or element
    public static boolean click(By locator) {
        try {
            waitForClickable(locator).click();
            test.pass("Able to click the Element successfully");
        } catch(StaleElementReferenceException e){
            waitForClickable(locator).click();
        }
        catch (Exception var4) {
            String temp = takeScreenshot(driver);
            test.fail("Failed to click the Element......... " + var4, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            Assert.fail();
        }
        return false;
    }

    //To capture the screenshot
    public static String takeScreenshot(WebDriver driver) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
        File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
        String destFile = "./screenshots/" + dateName + System.currentTimeMillis() + ".png";
        File Destn = new File(destFile);
        try {
            Files.copy(sourceFile.toPath(), Destn.toPath());
        } catch (IOException e) {
            System.out.println("take screenshot is failed" + e.getMessage());
        }
        return destFile;
    }
    //To add screenshot into the report
    public static void addScreenShotInReport(String Message,String temp)
    {
        temp = BaseCommands.takeScreenshot(driver);
        test.info(Message,MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
    }
    // This method is used to Click on any element by using Actions
    public static void clickUsingActions(By locator)
    {
        try {
            Actions action = new Actions(driver);
            WebElement element = driver.findElement(locator);
            action.moveToElement(element).click();
            test.pass("Able to click on element using actions successfully");
        } catch (Exception e) {
            String temp = takeScreenshot(driver);
            test.fail("Failed to click on element using actions .......... " + e, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            Assert.fail();
        }

    }

    //Clicking on an element using JavaScript
    public static void clickUsingJS(By locator)
    {
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].click();", driver.findElement(locator));
            test.pass("Able to click on element using javascript executor successfully");
        } catch (Exception e) {
            String temp = takeScreenshot(driver);
            test.fail("Failed to click on element using javascript executor .......... " + e, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            Assert.fail();
        }
    }

    //Switching to Frame using locators
    public static void switchToFrame(By locator) {
        try{
            waitForElement(locator);
            WebElement frame = driver.findElement(locator);
            driver.switchTo().frame(frame);
        } catch (Exception var4) {
            String temp = takeScreenshot(driver);
            test.fail("Failed to switching into frame......... " + var4, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            Assert.fail();
        }
    }
    //Switching into the frame using frame number
    public static void switchToFrame(int frameNumber) {
        try {
            driver.switchTo().frame(frameNumber);
            test.pass("Able to switch into the frame successfully");
        } catch (Exception var4) {
            String temp = takeScreenshot(driver);
            test.fail("Failed to switching into frame........ " + var4, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            Assert.fail();
        }
    }
    //Switching into the frame using frame name
    public static void switchToFrame(String frameName) {
        try {
            driver.switchTo().frame(frameName);
            test.pass("Able to switch into the frame successfully");
        } catch (Exception var4) {
            String temp = takeScreenshot(driver);
            test.fail("Failed to switching into frame........ " + var4, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            Assert.fail();
        }
    }

    //Switching back from frame
    public static void switchBackFromFrame() {
        driver.switchTo().defaultContent();
    }
    //Switching into new window
    public static void switchToNewWindow(){
        try {
            for (String childWindow : driver.getWindowHandles())
            {
                driver.switchTo().window(childWindow);
                Thread.sleep(5000);
            }
            test.pass("Switched to new window successfully");
        } catch (Exception var3) {
            String temp = takeScreenshot(driver);
            test.fail("Failed to switch to new window " + var3, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            Assert.fail();
        }
    }

    //scroll to middle with Javascript Executor
    public static void scrollToCenter(By locator) {
        try{
            WebElement element = driver.findElement(locator);
            JavascriptExecutor j = (JavascriptExecutor) driver;
            j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", element);
        }
        catch (Exception var){
            String temp = takeScreenshot(driver);
            test.fail("Failed to scroll........ " + var, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            Assert.fail();
        }
    }
    //scroll into view using javascript executor
    public static void scrollIntoView(By locator) {
        try {
            WebElement element = BaseCommands.waitForVisibilityOfElement(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            test.pass("Able to scrollIntoView to the element");
        } catch (Exception var4) {
            String temp = takeScreenshot(driver);
            test.fail("ScrollIntoView on the element failed " + var4, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            Assert.fail();
        }
    }
    //Wait until the element is visible
    public static WebElement waitForVisibilityOfElement(By locator) {
        WebElement element = null;
        try {
            waitForElement(locator);
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            element = wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfElementLocated(locator));
            test.pass("Able to wait until the element is visible");
        } catch (Exception var) {
            String temp = takeScreenshot(driver);
            test.fail("Failed to find the visible element........ " + var, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            Assert.fail();
        }
        return element;
    }

    //Select value from Dropdown by using visible Text
    public static void dropDownSelectByText(By locator, String visibleText) {
        try {
            waitForClickable(locator);
            Select option = new Select(driver.findElement(locator));
            option.selectByVisibleText(visibleText);
            test.pass("Able to select the value in drop down by visible text");
        } catch (Exception var4) {
            String temp = takeScreenshot(driver);
            test.fail("Selecting value from drop down by visible text failed " + var4,MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            Assert.fail();
        }
    }

    //Select value from Dropdown by using Value
    public static void dropDownSelectByValue(By locator, String value){
        try{
            waitForVisibilityOfElement(locator);
            Select dataAccess = new Select(driver.findElement(locator));
            dataAccess.selectByValue(value);
            test.pass("Able to select the value successfully");
        } catch (Exception var4){
            String temp = takeScreenshot(driver);
            test.fail("Failed to select the value .......... " + var4, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            Assert.fail();
        }
    }

    //Mouse over on a Element
    public static void  mouseHover(By locator) {
        try {
            WebElement hoverTo = driver.findElement(locator);
            Actions action = new Actions(driver);
            action.moveToElement(hoverTo).perform();
            test.pass("Able to mouse hover on the element");
        } catch (Exception var4) {
            String temp = takeScreenshot(driver);
            test.fail("Mouse hovering on the element failed " + var4, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            Assert.fail();
        }

    }

    //Get Text value of an Element
    public static String getText(By locator) {
        String text = null;
        try {
            text = waitForClickable(locator).getText();
            test.pass("Able to get Text successfully");
        } catch (Exception var4) {
            String temp = takeScreenshot(driver);
            test.fail("Failed to get Text......... " + var4, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            Assert.fail();
        }
        return text;
    }

    // Page Refresh
    public static void refresh() {
       try {
           driver.navigate().refresh();
           test.pass("Able to refresh the page successfully");
       }
       catch (Exception var){
           String temp = takeScreenshot(driver);
           test.fail("Failed to refresh the page" + var, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
           Assert.fail();
       }

    }

    // Get element attribute value as String by passing attribute value
    public static String getElementAttribute(By locator,String attributeName) {
        String element = null;
        try {
            element = driver.findElement(locator).getAttribute(attributeName);
            test.pass("Able to get the getAttribute from element");
            // return element;
        } catch (Exception var4) {
            String temp = takeScreenshot(driver);
            test.fail("Failed to retrieve the getAttribute from an element" + var4, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            Assert.fail();
        }
        return element;
    }

    //Assert Element attribute value by passing the expected String value
    public static void assertElementAttribute(By locator, String attributeName, String expected) {
        try {
            String actual = getElementAttribute(locator, attributeName);
            Assert.assertEquals(actual, expected);
            test.pass("Able to Assert element attribute");
        } catch (Exception var5) {
            String temp = takeScreenshot(driver);
            test.fail("AssertElement Failed......... " + var5, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            Assert.fail();
        }
    }


    //Assert Element attribute value by passing the expected String value by using Css
    public static void assertCssAttribute(By locator, String attribute, String expected) {
        try {
            String actual = getCssAttribute(locator, attribute);
            Assert.assertEquals(actual, expected);
            test.pass("Able to assert the CSS attribute successfully");
        } catch (Exception var5) {
            String temp = takeScreenshot(driver);
            test.fail("CSS Assert Attribute Failed......... " + var5, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            Assert.fail();
        }
    }

    // Get element attribute value as String by passing attribute value by using Css
    public static String getCssAttribute(By locator, String attribute) {
        String element = null;
        try {
            element = waitForVisibilityOfElement(locator).getCssValue(attribute);
            test.pass("Able to get CSS attribute successfully");
          //  return element;
        } catch (Exception var4) {
            String temp = takeScreenshot(driver);
            test.fail("Failed to get CSS attribute .......... " + var4, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            Assert.fail();
        }
        return element;
    }
    // To assert the page title
    public static void assertTitle(String expected) {
        try {
            Assert.assertEquals(getPageTitle(), expected);
            test.pass("Assert page title successfully");
        } catch (Exception var4) {
            String temp = takeScreenshot(driver);
            test.fail("Failed to Assert page title .......... " + var4, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            Assert.fail();
        }
    }
    // To get the page title
    public static String getPageTitle() {
        String title = null;
        try {
            title = driver.getTitle();
            test.pass("Able to get the page title successfully");
        } catch (Exception var4) {
            String temp = takeScreenshot(driver);
            test.fail("Failed to get the page title .......... " + var4, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            Assert.fail();
        }
        return title;
    }
    //To wait until ana element is invisible
    public static void waitForElementInvisible(By locator)
    {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        try{
            test.pass("Wait for element invisible was successful");
        }catch(Exception var4){
            String temp = takeScreenshot(driver);
           test.fail("Failed to wait for invisibility of an element ............. " + var4, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            Assert.fail("test case execution stopped due to failure of wait for invisibility of element");
        }
    }
    //Enter using sendkeys
    public static void enter(By locator) {
        try {
            driver.findElement(locator).sendKeys(Keys.ENTER);
            test.pass("Able to enter successfully");
        } catch (Exception var4) {
            String temp = takeScreenshot(driver);
            test.fail("Failed to enter .......... " + var4, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            Assert.fail();
        }
    }
    //To split the String
    public static String[] splitString(String account){
        String[] accountDetails=account.split("[.]");
        return accountDetails;
    }
    public static boolean checkButton(WebElement element)
    {
        if(element.isDisplayed())
            return true;
        else
            return false;

    }
//To accept the alert
    public static void switchToAlertAccept() {
        try {
            driver.switchTo().alert().accept();
            test.pass("Able to switch into alert");

        } catch (Exception var2) {
            String temp = takeScreenshot(driver);
            test.fail("switching into alert failed " + var2, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            Assert.fail();
        }
    }
    //To decline the alert
    public void switchToAlertDecline() {
        try {
            driver.switchTo().alert().dismiss();
            test.pass("Switching into alert rejected");
        } catch (Exception var2) {
            String temp = takeScreenshot(driver);
            test.fail("Failed to reject the alert " + var2, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            Assert.fail();
        }
    }
    //Wait until alert present
    public static void waitForAlert(){
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            test.pass("Able to wait until the alert is present");
        } catch (Exception var) {
            String temp = takeScreenshot(driver);
            test.fail("Failed to find the alert........ " + var, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            Assert.fail();
        }

    }
    //To verify an element is displayed
    public static  boolean isElementDisplayed(By locator) {
        try {
          return driver.findElement(locator).isDisplayed();
//            test.pass("Able to display an element successfully");
//            return true;
        } catch (Exception var4) {
            return false;
        }
    }
    //waits until stale elements visible
    public static void staleWait(By locator){
        try {
            wait.until(ExpectedConditions.stalenessOf(driver.findElement(locator)));
            test.pass("stalewait for element is successful");
        }catch(Exception var4){
            String temp = takeScreenshot(driver);
            test.fail("Failed to stalewait for element ............. " + var4, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            Assert.fail("test case execution stopped due to failure of stalewait for  element");
        }
    }
    //Scroll down using javascript
    public static void scrollDown(){
        try{
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,500)");
        }
        catch (Exception var){
            String temp = takeScreenshot(driver);
            test.fail("Failed to scroll down ............. " + var, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            Assert.fail("test case execution stopped due to failure at scrolling down");
        }


    }
    public static void scrollUp(){
        try{
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,-500)");
        }
        catch (Exception var){
            String temp = takeScreenshot(driver);
            test.fail("Failed to scroll up ............. " + var, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            Assert.fail("test case execution stopped due to failure at scrolling up");
        }


    }

}