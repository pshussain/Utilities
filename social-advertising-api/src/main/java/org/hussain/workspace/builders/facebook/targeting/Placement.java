package org.hussain.workspace.builders.facebook.targeting;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

public class Placement {
	private List<String> placement;

	public Placement() {
		this.placement = new ArrayList<String>();
	}

	public void addPlacement(String placement) {
		this.placement.add(placement);
	}

	public JsonArray getPlacement() {
		JsonElement element = new Gson().toJsonTree(placement,
				new TypeToken<List<String>>() {
				}.getType());
		if (placement.size() > 0) {
			return element.getAsJsonArray();
		} else {
			return new JsonArray();
		}
	}
}
