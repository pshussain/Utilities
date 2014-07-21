package org.hussain.workspace.builders.facebook.targeting;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Zipcode {

	JsonArray zips;

	public Zipcode() {
		this.zips = new JsonArray();
	}

	public String getZipcode() {
		return new Gson().toJson(zips);
	}

	public void addRegions(String zipsName, String zipsCode) {
		JsonObject region = new JsonObject();
		region.addProperty("key", new String(zipsName + ":" + zipsCode));
		this.zips.add(region);
	}
}
