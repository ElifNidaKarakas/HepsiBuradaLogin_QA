import Base.BaseTest;

import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class UserLoginTest extends BaseTest {

    LoginPage loginPage = new LoginPage();

    /*
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

    }*/

    @Test(description = "Başarılı kullanıcı login kontrolü")
    public void loginUserSuccesfull() throws InterruptedException {
        sleep(3000);
        loginPage
                .emailDoldur(email)
                .passwordDoldur(password)
                .loginTikla();
        sleep(5000);
    }

    @Test(description = "Hatalı Login Kullanıcı Giriş Kontrol")
    public void notValidLogin() throws InterruptedException {
        loginPage
                .emailDoldur(email)
                .passwordDoldur("aaaaaaaaa")
                .loginTikla();

        sleep(3000);
        loginPage.hataMesajiKontrolu(message);
    }

    @Test(description = "Şifre Alanı Maskeleme Butonu Kontrolü")
    public void passwordMaskingControl() throws InterruptedException {
        loginPage
                .emailDoldur(email)
                .passwordDoldur(password)
                .passwordMaskeleme()
                .loginTikla();
        sleep(2000);
    }


    @Test(description = "Sistemde Kayıtlı Olmayan Email Kullanıcı Girişi")
    public void notValidWithEmail() throws InterruptedException {
        loginPage.emailDoldur("aaaaaaaaaaa@mail.com")
                .passwordDoldur(password)
                .loginTikla();
        sleep(3000);
         loginPage.hataMesajiKontrolu(message);
    }


    @Test(description = "Bos Karakter Kontrolu")
    public void requiredBlankControl() throws InterruptedException {
        loginPage.emailDoldur("")
                .passwordDoldur("")
                .loginTikla();
        sleep(3000);
        loginPage.emailBoslukKontrolu(EmailMessage);
        loginPage.emailDoldur(email)
                .loginTikla();
        sleep(3000);
        loginPage
                //.hataMesajiKontrolu("Lütfen şifrenizi giriniz.")
                .passwordDoldur(password)
                .loginTikla();
        sleep(3000);

    }

    @Test(description = "Minumum Karakter Kontrolü")
    public void minControl() throws InterruptedException {
        loginPage.emailDoldur("1")
                .passwordDoldur("2")
                .loginTikla();
        sleep(3000);
        loginPage.emailBoslukKontrolu(EmailMessage);
        loginPage.emailTemizle();
        sleep(2000);
        loginPage.emailDoldur(email)
                .passwordDoldur("2")
                .loginTikla();
        sleep(3000);
        ;
        loginPage.hataMesajiKontrolu(message);
    }

    @Test(description = "Maximum Karakter Kontrolü")
    public void maxControl() throws InterruptedException {
        loginPage.emailDoldur("111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111")
                .passwordDoldur(password);
        sleep(3000);
        loginPage.loginTikla();
        Thread.sleep(3000);
        loginPage.emailBoslukKontrolu(EmailMessage);
        sleep(3000);
        loginPage.emailTemizle()
                .passwordTemizle()
                .emailDoldur(email)
                .loginTikla();
        sleep(3000);
    }

    @Test(description = "Hepsi Burada Login Buton Kontrolü")
    public void hepsiBuradaButonKontrol() {
        loginPage.ikonButonKontrol();

    }

    @Test(description = "Apple Login Buton Kontrolü")
    public void appleLoginButonKontrol() {
        loginPage.appleikonButonKontrol();

    }

    @Test(description = "Google Login Buton Kontrolü")
    public void googleLoginButonKontrol() {
        loginPage.googleikonButonKontrol();

    }

    @Test(description = "Facebook Login Buton Kontrolü")
    public void facebookLoginButonKontrol() {
        loginPage.facebookikonButonKontrol();
    }

    @Test(description = "Şifre Unuttum Butonu Kontrolü")
    public void sifreUnuttumButonKontrol() {
        loginPage.sifreUnuttumButonu();
    }
}