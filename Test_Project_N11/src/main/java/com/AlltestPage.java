package com;
import org.junit.Assert;
import org.openqa.selenium.*;
import java.util.List;
import java.util.Random;

public class AlltestPage extends BasePageUtil implements General {
    public AlltestPage(WebDriver driver) {
        super(driver);
    }

    public void n11test(String email, String password) {
        //login islemi
        thread(2000);
        click(SIGNIN_BUTTON);
        thread(3000);
        sendKey(EMAIL_TEXTBOX, email);
        thread(2000);
        sendKey(PASSWORD_TEXTBOX, password);
        thread(3000);
        click(LOGIN_BUTTON);
        thread(2000);

        Assert.assertTrue(getTitle().contains("n11.com - Alışverişin Uğurlu Adresi"));
        thread(2000);

            //Arama yap
            sendKey(SEARCH_TEXTBOX,"Bilgisayar");
            thread(2000);
            click(SEARCH_BUTTON);
            //2. sayfaya gecis yap
            JavascriptExecutor scroll = (JavascriptExecutor) driver;

            int offset = 0;
            while(true) {
                try {
                    scroll.executeScript("window.scrollTo(0, document.body.scrollHeight - " + offset + ")");
                    thread(2000);
                    click(SECOND_PAGE);
                    break;
                } catch (ElementClickInterceptedException e) {
                    offset += 500;
                }
            }

        thread(2000);
            Assert.assertTrue(getTitle().contains("Bilgisayar - n11.com"));
            System.out.println("Page 2 opened ...");
            //Rastgele urun secimi
            List<WebElement> links = driver.findElements(By.cssSelector("a.plink"));

            links.subList(0, 10).clear();

            Random rand = new Random();
            int randIndex = rand.nextInt(links.size());

            offset = 0;
            while(true) {
                try {
                    scroll.executeScript("window.scrollTo(0, " + offset + ")");
                    thread(2000);
                    links.get(randIndex).click();
                    break;
                } catch (ElementClickInterceptedException e) {
                    offset += 500;
                }
            }


        thread(2000);

            // urun fiyati
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        String productPrice = find(PRODUCT_PRICE).getAttribute("content");

            // sepete ekle
            links = driver.findElements(ADDBASKET_BUTTON);
            links.get(0).click();

        thread(2000);

            // sepete git
            //driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[2]/div[2]/div[4]/a")).click();
            click(MYBASKET);
        thread(2000);

            // fiyat karsilastir
        links = driver.findElements(NEW_PRICE);
        String otherPrice = links.get(0).getText();

        thread(2000);

        StringBuilder sb = new StringBuilder(otherPrice);
        sb.deleteCharAt(sb.indexOf("."));
        String newPrice = sb.substring(0, sb.indexOf(" ")).replace(',', '.');

        System.out.println("Product price: " +productPrice + " - "+"New Price: " + newPrice);
        Assert.assertEquals(productPrice,newPrice);
        System.out.println("Same Price");

            // urun sayisi arttir
            links = driver.findElements(SPINNERUP);
            links.get(0).click();

        thread(2000);
            //sepetteki urunu sil
            click(REMOVE_PROD);
        thread(5000);
            System.out.println("successful");



    }

}
