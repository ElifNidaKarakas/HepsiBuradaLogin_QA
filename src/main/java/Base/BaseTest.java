package Base;

import Pages.MainPage;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Data {

    MainPage mainPage=new MainPage();
    @BeforeMethod
    public void setUp() throws InterruptedException {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://giris.hepsiburada.com/");
        sleep(3000);
        mainPage.kabulEtButonTıkla();
    }

    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }
}