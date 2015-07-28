package com.fabdy.marketplaces;

import com.fabdy.auth.UserAuth;
import com.fabdy.bean.Response;
import com.fabdy.catalogue.Catalogue;
import com.fabdy.catalogue.FlipkartCatalogue;
import com.fabdy.catalogue.SnapdealCatalogue;
import com.fabdy.mapping.FlipkartCategoryMapping;
import com.fabdy.mapping.SnapdealCatalogueMapping;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by hussain on 21/7/15.
 */
public class Snapdeal extends Marketplace {

    @Override
    public Response createListing(Map<String, String> listingValues, long category, long seller) throws IOException, InterruptedException {

        //Map the category fields with entered field values
        //Get the sheet number
        final SnapdealCatalogueMapping mapping = new SnapdealCatalogueMapping(seller, category);
        Map<String, String> userAuth = UserAuth.login(seller);
        final Catalogue catalogue = new SnapdealCatalogue();
        final String filePath = catalogue.buildCatalogue();
        uploadCatalogue(userAuth.get("user"), userAuth.get("pass"), filePath);
        return null;
    }

    private void uploadCatalogue(String user, String pass, String filePath) throws InterruptedException {
        System.setProperty("webDriver.chrome.driver", "/usr/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://sellers.snapdeal.com/sdMobileLogin");
        driver.findElement(By.id("pageId:j_id6:txtMobileUserName")).sendKeys("fabdyfashion@gmail.com");
        driver.findElement(By.id("pageId:j_id6:txtMobilePassword")).sendKeys("Jainii12345");
        driver.findElement(By.name("pageId:j_id6:j_id11")).click();
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
