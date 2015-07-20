package com.fabdy.api;

import com.fabdy.api.bean.Listing;
import com.fabdy.com.fabdy.handler.Response;

import java.util.List;

/**
 * Created by hussain on 20/7/15.
 */
public abstract class Marketplace {

    protected abstract Response createListing();

    protected abstract List<Listing> getListing();

    protected abstract Response updatePrice();

    protected abstract Response updateStock();

    protected abstract Response updateStatus();
}
