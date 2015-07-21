package com.fabdy.api;

import com.fabdy.bean.Listing;
import com.fabdy.marketplaces.Marketplace;
import com.fabdy.bean.Response;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by hussain on 20/7/15.
 */
public abstract class Platform {

    protected abstract Response createListing(Map<String, String> listingValues, List<Marketplace> marketplaces, long category, long seller) throws IOException;

    protected abstract List<Listing> getListing();

    protected abstract Response updatePrice();

    protected abstract Response updateStock();

    protected abstract Response updateStatus();
}
