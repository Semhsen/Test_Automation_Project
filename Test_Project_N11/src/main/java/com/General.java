package com;
import org.openqa.selenium.By;

public interface General {
    By EMAIL_TEXTBOX = By.id("email");
    By PASSWORD_TEXTBOX = By.id("password");
    By SEARCH_TEXTBOX =By.id("searchData");
    By SEARCH_BUTTON =By.className("searchBtn");
    By LOGIN_BUTTON =By.id("loginButton");
    By SIGNIN_BUTTON =By.className("btnSignIn");
    By SECOND_PAGE =By.xpath("//*[@id=\"contentListing\"]/div/div/div[2]/div[4]/a[2]");
    By PRODUCT_PRICE =By.cssSelector("div.newPrice > ins ");
    By ADDBASKET_BUTTON=By.cssSelector("a.btn.btnGrey.btnAddBasket");
    By MYBASKET=By.className("myBasket");
    By NEW_PRICE=By.cssSelector("div.priceArea > span");
    By SPINNERUP=By.cssSelector("span.spinnerUp");
    By REMOVE_PROD=By.cssSelector("span.removeProd.svgIcon.svgIcon_trash");
}
