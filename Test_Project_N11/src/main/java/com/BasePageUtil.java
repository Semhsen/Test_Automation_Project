package com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class BasePageUtil {
    protected WebDriver driver;

    public BasePageUtil(WebDriver driver) {
        super();
        this.driver = driver;
    }


    public void click(By by) {
        driver.findElement(by).click();
    }

    public void sendKey(By by, String value) {
        driver.findElement(by).sendKeys(value);
    }

    public void submit(By by) {
        driver.findElement(by).submit();
    }

    public void thread(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebElement find(By by) {
        WebElement x = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", x);
        return x;
    }

    public String getTitle() {
        return driver.getTitle();
    }

}
