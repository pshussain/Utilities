package com.fabdy.mapping;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * Created by hussain on 20/7/15.
 */
public class SnapdealCatalogueMapping {
    final long category;
    final Properties categoryProp;

    public SnapdealCatalogueMapping(long sellerId, long category) throws IOException {
        this.category = category;
        try {
            System.out.println("In SnapdealCatalogueMapping");
//            InputStream propStream = FlipkartCategoryMapping.class.getClassLoader().getResourceAsStream("/Users/hussain/fabdy/Utilities/fabdy-api/src/main/resources/users/seller.properties");
            final Properties sellerDetail = new Properties();
            InputStream propStream = new FileInputStream("/Users/hussain/fabdy/Utilities/fabdy-api/src/main/resources/users/seller.properties");
            sellerDetail.load(propStream);
            final String seller = sellerDetail.getProperty(String.valueOf(sellerId));
            System.out.println(seller);
            propStream = new FileInputStream("/Users/hussain/fabdy/Utilities/fabdy-api/src/main/resources/category/snapdeal/"+ seller + "/" + this.category + ".properties");
//            FlipkartCategoryMapping.class.getClassLoader().getResourceAsStream(seller + "/" + this.category + ".properties");
            this.categoryProp = new Properties();
            this.categoryProp.load(propStream);
        } catch (NullPointerException npe) {
            throw new NullPointerException("Category file not found.");
        }
    }

    public Map<String, String> getFieldMapping() {
        final Map<String, String> map =
                this.categoryProp.stringPropertyNames().stream()
                        .collect (Collectors.toMap(k -> k, v -> this.categoryProp.getProperty(v)));
        return map;
    }

    public long getSheetMapping() {
        return -1;
    }


}
