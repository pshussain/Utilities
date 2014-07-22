package org.hussain.workspace.builders.facebook.targeting;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class Location {
	List<String> countries;
	List<JsonObject> cities;
	List<JsonObject> regions;
	List<JsonObject> zips;

	public Location() {
		countries = new ArrayList<String>();
		cities = new ArrayList<JsonObject>();
		regions = new ArrayList<JsonObject>();
		zips = new ArrayList<JsonObject>();
	}

	public void addCountry(String country) {
		countries.add(country);
	}

	public void addCity(String key, double radius, String distanceUnit) {
		final JsonObject city = new JsonObject();
		city.addProperty("key", key);
		city.addProperty("radius", radius);
		city.addProperty("distance_unit", distanceUnit);
		cities.add(city);

	}

	public void addRegion(String value) {
		final JsonObject region = new JsonObject();
		region.addProperty("key", value);
		regions.add(region);
	}

	public void addZipcode(String country, String code) {
		final JsonObject zip = new JsonObject();
		zip.addProperty("key", country + ":" + code);
		zips.add(zip);
	}

	public JsonArray getCountries() {
		JsonElement element = new Gson().toJsonTree(countries,
				new TypeToken<List<String>>() {
				}.getType());
		if (countries.size() > 0) {
			return element.getAsJsonArray();
		} else {
			return new JsonArray();
		}
	}

	public JsonArray getCities() {
		JsonElement element = new Gson().toJsonTree(cities,
				new TypeToken<List<JsonObject>>() {
				}.getType());
		if (cities.size() > 0) {
			return element.getAsJsonArray();
		} else {
			return new JsonArray();
		}
	}

	public JsonArray getRegions() {
		JsonElement element = new Gson().toJsonTree(regions,
				new TypeToken<List<JsonObject>>() {
				}.getType());
		if (regions.size() > 0) {
			return element.getAsJsonArray();
		} else {
			return new JsonArray();
		}
	}

	public JsonArray getZipcode() {
		JsonElement element = new Gson().toJsonTree(zips,
				new TypeToken<List<String>>() {
				}.getType());
		if (zips.size() > 0) {
			return element.getAsJsonArray();
		} else {
			return new JsonArray();
		}
	}

	/*
	 * public String makeLocation() { final StringBuilder sb = new
	 * StringBuilder(200); if (countries.size() > 0) { JsonElement element = new
	 * Gson().toJsonTree(keywords, new TypeToken<List<String>>() { }.getType());
	 * sb.append("'countries':").append(countries.toString()); } if
	 * (regions.size() > 0) {
	 * sb.append(",'regions':").append(regions.toString());
	 * 
	 * } if (cities.size() > 0) {
	 * sb.append(",'cities':").append(cities.toString()); }
	 * 
	 * if (zips.size() > 0) { sb.append(",'zips':").append(zips.toString()); }
	 * // StringBuilder finalLocaltion = new StringBuilder(); // if (sb.length()
	 * > 0) { // finalLocaltion.append(sb.toString()); // } return
	 * sb.toString();
	 * 
	 * }
	 */
}
