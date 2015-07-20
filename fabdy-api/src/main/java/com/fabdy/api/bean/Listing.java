package com.fabdy.api.bean;

import java.math.BigDecimal;

/**
 * Created by hussain on 20/7/15.
 */
public class Listing {
    String name;
    String sku;
    long units;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public long getUnits() {
        return units;
    }

    public void setUnits(long units) {
        this.units = units;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    BigDecimal price;
}
