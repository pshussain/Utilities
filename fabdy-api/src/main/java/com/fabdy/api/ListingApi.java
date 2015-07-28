package com.fabdy.api;

import com.fabdy.bean.Listing;
import com.fabdy.marketplaces.Marketplace;
import com.fabdy.bean.Response;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by hussain on 21/7/15.
 */
public class ListingApi extends Platform {
    @Override
    public Response createListing(Map<String, String> listingValues, List<Marketplace> marketplaces, long category, long seller) throws IOException, InterruptedException {
        for(Marketplace marketplace : marketplaces) {
            marketplace.createListing(listingValues, category, seller);
        }
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
