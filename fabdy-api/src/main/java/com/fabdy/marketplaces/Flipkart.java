package com.fabdy.marketplaces;

import com.fabdy.bean.Response;
import com.fabdy.mapping.FlipkartCategoryMapping;
import java.io.IOException;
import java.util.Map;

/**
 * Created by hussain on 21/7/15.
 */
public class Flipkart extends Marketplace {

    @Override
    public Response createListing(Map<String, String> listingValues, long category, long seller) throws IOException {
        //Map the category fields with entered field values
        //Get the sheet number
        final FlipkartCategoryMapping mapping = new FlipkartCategoryMapping(seller, category);

        return null;
    }
}
