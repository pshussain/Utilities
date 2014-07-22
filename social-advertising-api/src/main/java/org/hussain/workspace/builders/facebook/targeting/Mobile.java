package org.hussain.workspace.builders.facebook.targeting;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

public class Mobile {
	private List<String> userDevice;
	private List<String> userOs;
	private List<String> wirelessCarrier;
	private List<String> siteCategory;

	public Mobile() {
		userDevice = new ArrayList<String>();
		userOs = new ArrayList<String>();
		wirelessCarrier = new ArrayList<String>();
		siteCategory = new ArrayList<String>();
	}

	public void addDevice(String deviceName) {
		userDevice.add(deviceName);
	}

	public void addOS(String osName) {
		userOs.add(osName);
	}

	public void addCarrier(String carrierName) {
		wirelessCarrier.add(carrierName);
	}

	public void addCategory(String category) {
		siteCategory.add(category);
	}

	public JsonArray getOS() {
		JsonElement element = new Gson().toJsonTree(userOs,
				new TypeToken<List<String>>() {
				}.getType());
		if (userOs.size() > 0) {
			return element.getAsJsonArray();
		} else {
			return new JsonArray();
		}
	}

	public JsonArray getCarrier() {
		JsonElement element = new Gson().toJsonTree(wirelessCarrier,
				new TypeToken<List<String>>() {
				}.getType());
		if (wirelessCarrier.size() > 0) {
			return element.getAsJsonArray();
		} else {
			return new JsonArray();
		}
	}

	public JsonArray getDevice() {
		JsonElement element = new Gson().toJsonTree(userDevice,
				new TypeToken<List<String>>() {
				}.getType());
		if (userDevice.size() > 0) {
			return element.getAsJsonArray();
		} else {
			return new JsonArray();
		}
	}

	public JsonArray getCategory() {
		JsonElement element = new Gson().toJsonTree(siteCategory,
				new TypeToken<List<String>>() {
				}.getType());
		if (siteCategory.size() > 0) {
			return element.getAsJsonArray();
		} else {
			return new JsonArray();
		}
	}

	public String makeMobile() {
		final StringBuilder sb = new StringBuilder(200);
		if (userDevice.size() > 0) {
			sb.append("'user_device':").append(new Gson().toJson(userDevice));
		}
		if (userOs.size() > 0) {
			sb.append(",'user_os':").append(new Gson().toJson(userOs));

		}
		if (wirelessCarrier.size() > 0) {
			sb.append(",'wireless_carrier':").append(
					new Gson().toJson(wirelessCarrier));
		}

		if (siteCategory.size() > 0) {
			sb.append(",'site_category':").append(
					new Gson().toJson(siteCategory));
		}

		return sb.toString();
	}

}
