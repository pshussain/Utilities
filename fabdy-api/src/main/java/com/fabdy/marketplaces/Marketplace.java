package com.fabdy.marketplaces;

import com.fabdy.bean.Response;
import java.io.IOException;
import java.util.Map;

/**
 * Created by hussain on 21/7/15.
 */
public abstract class Marketplace {
    public abstract Response createListing(Map<String, String> listingValues, long category, long seller) throws IOException;
}
