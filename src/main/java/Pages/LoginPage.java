package Pages;

import Base.BaseLibrary;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


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

}
