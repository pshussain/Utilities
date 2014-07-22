package org.hussain.workspace.builders.facebook.targeting;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class InterestedIn {
	private List<Integer> interests;

	public void addInterest(Integer interest) {

		interests.add(interest);
	}

	public JsonArray getInterests() {
		JsonElement element = new Gson().toJsonTree(interests,
				new TypeToken<List<Integer>>() {
				}.getType());
		if (interests.size() > 0) {
			return element.getAsJsonArray();
		} else {
			return new JsonArray();
		}
	}
}
