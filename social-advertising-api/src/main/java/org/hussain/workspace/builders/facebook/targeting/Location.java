package org.hussain.workspace.builders.facebook.targeting;

import java.util.List;

import com.google.gson.JsonObject;

public class Location {
	Country countries;
	City cities;
	Region regions;
	Zipcode zips;

	public Location() {
		countries = new Country();
		regions = new Region();
		zips = new Zipcode();
	}

	public static JsonObject makeLocation(List<String> countries,
			List<String> excludedCcountries, List<City> cities, Region regions,
			Zipcode zips) {
		if (countries.size() > 0) {

		}
		if (!regions.getRegions().isEmpty()) {

		}
		if (cities.size() > 0) {
		}

		if (!zips.getZipcode().isEmpty()) {
		}
		return null;

	}

}
