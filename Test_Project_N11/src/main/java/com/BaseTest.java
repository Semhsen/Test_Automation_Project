package com;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    public WebDriver driver;
    public String driverName = "webdriver.chrome.driver";
    public String driverPath = "C:\\Users\\Semih\\Desktop\\chromedriver.exe";
    public String url = "http://www.n11.com";

    @Before
    public void setup() {
        System.setProperty(driverName, driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);
        System.out.println("BaseTest successful");

    }


    @After
    public void close() {
        driver.quit();
    }
}
