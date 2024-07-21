package Pages;

import Base.BaseLibrary;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;


public class LoginPage extends BaseLibrary {
    @Step("E-Posta Alanı Doldurulur")
    public LoginPage emailDoldur(String email) {
        webDriver.findElement(By.name("username")).sendKeys(email);
        return this;
    }

    @Step("Sifre Alanı Doldurulur")
    public LoginPage passwordDoldur(String password) {
        webDriver.findElements(By.name("password")).get(0).sendKeys(password);
        return this;
    }

    public LoginPage loginTikla() {
        webDriver.findElement(By.name("btnLogin")).click();
        return this;
    }

    public LoginPage hataMesajiKontrolu(String text) {
        String value = webDriver.findElement(By.cssSelector("[class='hb-fzpaiS DgEia s31skbo562q']")).getText();
        Assert.assertEquals(text, value);
        return this;
    }

    public LoginPage emailTemizle() {
        webDriver.findElement(By.name("username")).clear();
        return this;
    }

    public LoginPage passwordTemizle() {
        webDriver.findElement(By.name("password")).clear();
        return this;
    }
    public LoginPage  sifreUnuttumButonu() {
        webDriver.findElement(By.cssSelector("class=['_17OD2T5uhxYRT6atZy_yA7 hpa5gnmuOMPuH0E31USHp false']")).click();
        return this;
    }


    public LoginPage emailBoslukKontrolu(String text) {
        String value = webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/div/div/div[2]/div[2]/div/div/div/form/div[1]/div/div[2]")).getText();
        Assert.assertEquals(text, value);
        return this;
    }

    public LoginPage passwordMaskeleme() {
        webDriver.findElements(By.name("password")).get(1).click();
        return this;
    }

    public LoginPage ikonButonKontrol(){
        webDriver.findElement(By.cssSelector("class=['_1ntKM7_0v9t1WleQh1WQmh']")).click();
        return this;
    }
    public LoginPage appleikonButonKontrol(){
        webDriver.findElement(By.id("btnApple")).click();
        return this;
    }
    public LoginPage googleikonButonKontrol(){
        webDriver.findElement(By.id("btnGoogle")).click();
        return this;
    }
    public LoginPage facebookikonButonKontrol(){
        webDriver.findElement(By.id("btnFacebook")).click();
        return this;
    }
}