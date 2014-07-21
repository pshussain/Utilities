package org.hussain.workspace.builders.facebook.targeting;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Region {
	JsonArray regions;

	public Region() {
		this.regions = new JsonArray();
	}

	public String getRegions() {
		return new Gson().toJson(regions);
	}

	public void addRegions(String regionName, String regionCode) {
		JsonObject region = new JsonObject();
		region.addProperty("key", new String(regionName + ":" + regionCode));
		this.regions.add(region);
	}
}
