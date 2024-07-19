import Base.BaseTest;

import Pages.LoginPage;
import Pages.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class UserLoginTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
aaaa
    @Test
    public void loginSuccessful() throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.hepsiburada.com");
        webDriver.manage().window().maximize();
        webDriver.findElement(By.id("myAccount")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.id("login")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.name("username")).sendKeys(email);
        webDriver.findElements(By.name("password")).get(0).sendKeys(password);
        Thread.sleep(3000);
        webDriver.findElement(By.name("btnLogin")).click();

    }

      @Test(description = "Başarılı kullanıcı login kontrolü")
        public void loginUserSuccesfull() throws InterruptedException {
        sleep(3000);
            loginPage
                    .emailDoldur(email)
                    .passwordDoldur(password)
                    .loginTikla();
          sleep(5000);
        }


}