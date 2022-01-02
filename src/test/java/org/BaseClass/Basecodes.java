package org.BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Basecodes {

    public static WebDriver webdriver;

    public static void initialization(){
        System.setProperty("webdriver.chrome.driver", "C:\\intelli\\FrameworkTesting\\src\\test\\resources1\\Drivers\\chromedriver.exe" );
        webdriver = new ChromeDriver();
        webdriver.manage().window().maximize();
        webdriver.manage().deleteAllCookies();


    }
    public WebDriver getDriver() throws Exception {
        initialization();
        return this.webdriver;

    }
    public static void CloseBrowser(){
        webdriver.quit();
    }
}
