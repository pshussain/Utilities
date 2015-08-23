package com.fabdy.marketplaces;

import com.fabdy.auth.UserAuth;
import com.fabdy.bean.Response;
import com.fabdy.catalogue.Catalogue;
import com.fabdy.catalogue.FlipkartCatalogue;
import com.fabdy.mapping.FlipkartCategoryMapping;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Map;

/**
 * Created by hussain on 21/7/15.
 */
public class Flipkart extends Marketplace {

    @Override
    public Response createListing(Map<String, String> listingValues, long category, long seller) throws IOException, InterruptedException {
        //Map the category fields with entered field values
        //Get the sheet number
        final FlipkartCategoryMapping mapping = new FlipkartCategoryMapping(seller, category);
        Map<String, String> userAuth = UserAuth.login(seller);
        final Catalogue catalogue = new FlipkartCatalogue();
        final String filePath = catalogue.buildCatalogue();
        uploadCatalogue(userAuth.get("user"), userAuth.get("pass"), filePath);
        return null;
    }

    private void uploadCatalogue(String user, String pass, String filePath) throws InterruptedException {
        System.setProperty("webDriver.chrome.driver", "/usr/bin/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://seller.flipkart.com/");

        driver.findElement(By.id("username")).sendKeys(user);
        driver.findElement(By.id("userpass")).sendKeys(pass);
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

        driver.findElement(By.id("listing-file")).sendKeys(filePath);
        Thread.sleep(2000);
        driver.quit();
    }
}
