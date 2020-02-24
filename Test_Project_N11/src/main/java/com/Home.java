package com;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home extends BasePageUtil{

    public Home(WebDriver driver) {
        super(driver);
    }
    public AlltestPage callLoginPage() {

        thread(2);
        find(By.className("btnSignIn"));
        thread(3);
        return new AlltestPage(driver);
    }

}
