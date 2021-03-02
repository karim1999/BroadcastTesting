package com.karim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import java.io.IOException;

public class Broadcasting {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "C:/projects/chromeDriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--headless");
        options.addArguments("--use-fake-device-for-media-stream");
        options.addArguments("--use-fake-ui-for-media-stream");
        int num= 100;
        WebDriver[] drivers= new WebDriver[num];
        for (int i=0;i < num; i++){
            WebDriver driver = new ChromeDriver(options);
            driver.get("https://cloudgear.dev");
            WebElement username= driver.findElement(By.id("email"));
            username.sendKeys("karim.elbadry2@gmail.com");
            WebElement password= driver.findElement(By.id("password"));
            password.sendKeys("karim2010");
            password.submit();
            WebElement startBtn = driver.findElement(By.cssSelector("#app button"));
            startBtn.click();
            drivers[i]= driver;
        }
        Thread.sleep(1000 * 60 * 15);
        for (int i=0;i < num; i++) {
            drivers[i].quit();
        }
    }
}
