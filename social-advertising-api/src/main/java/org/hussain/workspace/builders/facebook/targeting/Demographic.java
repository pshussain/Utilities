package org.hussain.workspace.builders.facebook.targeting;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

public class Demographic {
	private String minAge;
	private String maxAge;
	private List<Integer> genders;
	private List<String> keywords;

	public Demographic() {
		minAge = "-1";
		maxAge = "-1";
		genders = new ArrayList<Integer>();
		keywords = new ArrayList<String>();
	}

	public void setMinAge(String minAge) {
		this.minAge = minAge;
	}

	public void setMaxAge(String maxAge) {
		this.maxAge = maxAge;
	}

	public String getMinAge() {
		if (!minAge.equals("-1"))
			return minAge;
		else
			return "";
	}

	public String getMaxAge() {
		if (!maxAge.equals("-1"))
			return maxAge;
		else
			return "";
	}

	public void addGender(int gender) {
		genders.add(gender);
	}

	public void addKeyword(String keyword) {
		keywords.add(keyword);
	}

	public JsonArray getGender() {
		final StringBuilder sb = new StringBuilder(200);

		if (genders.size() > 0) {
			JsonElement element = new Gson().toJsonTree(genders,
					new TypeToken<List<Integer>>() {
					}.getType());
			return element.getAsJsonArray();
		} else
			return new JsonArray();

	}

	public JsonArray getKeywords() {
		final StringBuilder sb = new StringBuilder(200);

		if (keywords.size() > 0) {
			JsonElement element = new Gson().toJsonTree(keywords,
					new TypeToken<List<String>>() {
					}.getType());
			return element.getAsJsonArray();
		} else {
			return new JsonArray();

		}

	}
}
