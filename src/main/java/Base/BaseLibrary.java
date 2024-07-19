package Base;

import org.openqa.selenium.WebDriver;

public class BaseLibrary {
    public static WebDriver webDriver;

    public void sleep(int time) throws InterruptedException {
        Thread.sleep(time);
    }
}