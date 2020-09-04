package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    private static ThreadLocal<WebDriver> driverThredLoacal = new ThreadLocal<>();

    private Driver(){

    }
    public static WebDriver getDriver (String browser){
        if(driverThredLoacal.get()== null){
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverThredLoacal.set(new ChromeDriver());
                default:
                    throw new RuntimeException("Unimplemented driver type!");

            }
        }
        return driverThredLoacal.get();
    }
    public void closeDriver(){
        if(driverThredLoacal.get()!=null){
            driverThredLoacal.get().quit();
            driverThredLoacal.remove();
        }
    }
}
