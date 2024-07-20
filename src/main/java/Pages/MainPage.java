package Pages;

import Base.BaseLibrary;
import org.openqa.selenium.By;

public class MainPage extends BaseLibrary {
    public MainPage kabulEtButonTıkla() {
        webDriver.findElement(By.id("onetrust-accept-btn-handler")).click();
        return this;
    }
}