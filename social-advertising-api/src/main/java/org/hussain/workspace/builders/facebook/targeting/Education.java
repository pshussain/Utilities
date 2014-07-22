package org.hussain.workspace.builders.facebook.targeting;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class Education {
	private List<JsonObject> schools;
	private List<Integer> years;

	public void addSchool(String id, String name) {
		JsonObject school = new JsonObject();
		school.addProperty("id", id);
		school.addProperty("name", name);
		schools.add(school);
	}

	public void addYear(Integer year) {
		years.add(year);
	}

	public JsonArray getSchool() {
		JsonElement element = new Gson().toJsonTree(schools,
				new TypeToken<List<JsonObject>>() {
				}.getType());
		if (schools.size() > 0) {
			return element.getAsJsonArray();
		} else {
			return new JsonArray();
		}
	}

	public JsonArray getYear() {
		JsonElement element = new Gson().toJsonTree(years,
				new TypeToken<List<Integer>>() {
				}.getType());
		if (years.size() > 0) {
			return element.getAsJsonArray();
		} else {
			return new JsonArray();
		}
	}

}
