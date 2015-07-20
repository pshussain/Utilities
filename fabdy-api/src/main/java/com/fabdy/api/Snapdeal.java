package com.fabdy.api;

import com.fabdy.api.bean.Listing;
import com.fabdy.com.fabdy.handler.Response;

import java.util.List;

/**
 * Created by hussain on 20/7/15.
 */
public class Snapdeal extends Marketplace {
    @Override
    protected Response createListing() {
        return null;
    }

    @Override
    protected List<Listing> getListing() {
        return null;
    }

    @Override
    protected Response updatePrice() {
        return null;
    }

    @Override
    protected Response updateStock() {
        return null;
    }

    @Override
    protected Response updateStatus() {
        return null;
    }
}
