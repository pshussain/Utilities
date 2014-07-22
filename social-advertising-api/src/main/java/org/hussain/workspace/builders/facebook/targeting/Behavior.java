package org.hussain.workspace.builders.facebook.targeting;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class Behavior {
	private List<JsonObject> behaviors;

	public void addBehavior(String id, String name) {
		JsonObject behavior = new JsonObject();
		behavior.addProperty("id", id);
		behavior.addProperty("name", name);
		behaviors.add(behavior);
	}

	public JsonArray getBehavior() {
		JsonElement element = new Gson().toJsonTree(behaviors,
				new TypeToken<List<JsonObject>>() {
				}.getType());
		if (behaviors.size() > 0) {
			return element.getAsJsonArray();
		} else {
			return new JsonArray();
		}
	}
}
