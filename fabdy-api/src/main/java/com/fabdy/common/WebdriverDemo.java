package com.fabdy.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by hussain on 23/7/15.
 */
public class WebdriverDemo {
    public static void main(String[] args) throws InterruptedException, MalformedURLException {

        WebdriverDemo demo = new WebdriverDemo();
//        demo.flipkartDemo();
        demo.snapdealDemo();
    }

    public void flipkartDemo() throws InterruptedException {
        System.setProperty("webDriver.chrome.driver", "/usr/bin/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://seller.flipkart.com/");

        driver.findElement(By.id("username")).sendKeys("aseemabdul@hotmail.com");
        driver.findElement(By.id("userpass")).sendKeys("Veiji8101");
        driver.findElement(By.id("edit-submit")).submit();

        Thread.sleep(5000);
        driver.findElement(By.partialLinkText("Skip")).click();
        driver.switchTo().defaultContent();

        Thread.sleep(5000);
        driver.findElement(By.className("ads-modal-btn")).click();
        driver.switchTo().defaultContent();

        driver.findElement(By.id("listings")).click();
        driver.findElement(By.partialLinkText("My listings")).click();
        Thread.sleep(5000);
        driver.findElement(By.partialLinkText("Skip")).click();
        driver.switchTo().defaultContent();

        driver.findElement(By.id("listing-file")).sendKeys("/Users/hussain/thread-dump.hprof");

        Thread.sleep(2000);
        driver.quit();
    }

    public void snapdealDemo() throws InterruptedException {
        System.setProperty("webDriver.chrome.driver", "/usr/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://sellers.snapdeal.com/");
        driver.findElement(By.id("pgLogin:navbar:txtUserName")).sendKeys("fabdyfashion@gmail.com");
        driver.findElement(By.id("pgLogin:navbar:txtPassword")).sendKeys("Jainii12345");
        driver.findElement(By.name("pgLogin:navbar:j_id12")).click();
        Thread.sleep(20000);
        driver.findElement(By.xpath("//*[@id=\"skipAction\"]/span")).click();
        Thread.sleep(1500);
        driver.findElement(By.id("notInterested")).click();
        driver.switchTo().defaultContent();
        driver.get("http://sellercontent.snapdeal.com/admin/sellerUploadAdmin");
        Thread.sleep(1000);
        driver.findElement(By.className("upld_data")).click();
        Thread.sleep(1000);
        List<WebElement> sellerUploadType= driver.findElements(By.name("sellerUploadType"));
        sellerUploadType.get(0).click();
        driver.findElement(By.id("file1")).sendKeys("/Users/hussain/thread-dump.hprof");
        driver.findElement(By.id("file2")).sendKeys("/Users/hussain/thread-dump.hprof");
        driver.findElement(By.id("popupUploadButton")).click();

    }
}