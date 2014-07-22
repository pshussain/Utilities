package org.hussain.workspace.builders.facebook.targeting;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class AdvancedDemographics {
	private List<Integer> relationshipStatus;
	private List<JsonObject> lifeEvents;
	private List<JsonObject> politics;
	private List<JsonObject> markets;
	private List<JsonObject> industries;
	private List<JsonObject> income;
	private List<JsonObject> netWorth;
	private List<JsonObject> homeType;
	private List<JsonObject> homeOwnership;
	private List<JsonObject> homeValue;
	private List<JsonObject> ethnicAffinity;
	private List<JsonObject> generation;
	private List<JsonObject> householdComposition;
	private List<JsonObject> moms;
	private List<JsonObject> officeType;
	private List<JsonObject> educationMajors;
	private List<JsonObject> employers;
	private List<JsonObject> positions;
	private List<JsonObject> conjunctiveUserCluster;
	private List<JsonObject> userCluster;
	private List<JsonObject> excludedUserCluster;

	public AdvancedDemographics() {
		relationshipStatus = new ArrayList<Integer>();
		lifeEvents = new ArrayList<JsonObject>();
		politics = new ArrayList<JsonObject>();
		markets = new ArrayList<JsonObject>();
		industries = new ArrayList<JsonObject>();
		income = new ArrayList<JsonObject>();
		netWorth = new ArrayList<JsonObject>();
		homeType = new ArrayList<JsonObject>();
		homeOwnership = new ArrayList<JsonObject>();
		homeValue = new ArrayList<JsonObject>();
		ethnicAffinity = new ArrayList<JsonObject>();
		generation = new ArrayList<JsonObject>();
		householdComposition = new ArrayList<JsonObject>();
		moms = new ArrayList<JsonObject>();
		officeType = new ArrayList<JsonObject>();
		educationMajors = new ArrayList<JsonObject>();
		employers = new ArrayList<JsonObject>();
		positions = new ArrayList<JsonObject>();
		conjunctiveUserCluster = new ArrayList<JsonObject>();
		userCluster = new ArrayList<JsonObject>();
		excludedUserCluster = new ArrayList<JsonObject>();

	}

	public void addRelationshipStatus(Integer status) {
		relationshipStatus.add(status);
	}

	public JsonArray getRelationshipStatus() {
		JsonElement element = new Gson().toJsonTree(relationshipStatus,
				new TypeToken<List<Integer>>() {
				}.getType());
		if (relationshipStatus.size() > 0) {
			return element.getAsJsonArray();
		} else {
			return new JsonArray();
		}
	}

	public void addLifeEvent(String id, String name) {

		final JsonObject event = new JsonObject();
		event.addProperty("id", id);
		event.addProperty("name", name);
		lifeEvents.add(event);
	}

	public JsonArray getLifeEvent() {
		JsonElement element = new Gson().toJsonTree(lifeEvents,
				new TypeToken<List<JsonObject>>() {
				}.getType());
		if (lifeEvents.size() > 0) {
			return element.getAsJsonArray();
		} else {
			return new JsonArray();
		}
	}

	public void addPolitics(String id, String name) {

		final JsonObject event = new JsonObject();
		event.addProperty("id", id);
		event.addProperty("name", name);
		politics.add(event);
	}

	public JsonArray getPolitics() {
		JsonElement element = new Gson().toJsonTree(politics,
				new TypeToken<List<JsonObject>>() {
				}.getType());
		if (politics.size() > 0) {
			return element.getAsJsonArray();
		} else {
			return new JsonArray();
		}
	}

	public void addMarket(String id, String name) {

		final JsonObject event = new JsonObject();
		event.addProperty("id", id);
		event.addProperty("name", name);
		markets.add(event);
	}

	public JsonArray getMarkets() {
		JsonElement element = new Gson().toJsonTree(markets,
				new TypeToken<List<JsonObject>>() {
				}.getType());
		if (markets.size() > 0) {
			return element.getAsJsonArray();
		} else {
			return new JsonArray();
		}
	}

	public void addIndustry(String id, String name) {

		final JsonObject event = new JsonObject();
		event.addProperty("id", id);
		event.addProperty("name", name);
		industries.add(event);
	}

	public JsonArray getIndustries() {
		JsonElement element = new Gson().toJsonTree(industries,
				new TypeToken<List<JsonObject>>() {
				}.getType());
		if (industries.size() > 0) {
			return element.getAsJsonArray();
		} else {
			return new JsonArray();
		}
	}

	public void addIncome(String id, String name) {

		final JsonObject event = new JsonObject();
		event.addProperty("id", id);
		event.addProperty("name", name);
		income.add(event);
	}

	public JsonArray getIncomes() {
		JsonElement element = new Gson().toJsonTree(income,
				new TypeToken<List<JsonObject>>() {
				}.getType());
		if (income.size() > 0) {
			return element.getAsJsonArray();
		} else {
			return new JsonArray();
		}
	}

	public void addNetWorth(String id, String name) {

		final JsonObject event = new JsonObject();
		event.addProperty("id", id);
		event.addProperty("name", name);
		netWorth.add(event);
	}

	public JsonArray getNetWorth() {
		JsonElement element = new Gson().toJsonTree(netWorth,
				new TypeToken<List<JsonObject>>() {
				}.getType());
		if (netWorth.size() > 0) {
			return element.getAsJsonArray();
		} else {
			return new JsonArray();
		}
	}

	public void addHomeType(String id, String name) {

		final JsonObject event = new JsonObject();
		event.addProperty("id", id);
		event.addProperty("name", name);
		homeType.add(event);
	}

	public JsonArray getHomeType() {
		JsonElement element = new Gson().toJsonTree(homeType,
				new TypeToken<List<JsonObject>>() {
				}.getType());
		if (homeType.size() > 0) {
			return element.getAsJsonArray();
		} else {
			return new JsonArray();
		}
	}

	public void addHomeOwnership(String id, String name) {

		final JsonObject event = new JsonObject();
		event.addProperty("id", id);
		event.addProperty("name", name);
		homeOwnership.add(event);
	}

	public JsonArray getHomeOwnership() {
		JsonElement element = new Gson().toJsonTree(homeOwnership,
				new TypeToken<List<JsonObject>>() {
				}.getType());
		if (homeOwnership.size() > 0) {
			return element.getAsJsonArray();
		} else {
			return new JsonArray();
		}
	}

	public void addHomeValue(String id, String name) {

		final JsonObject event = new JsonObject();
		event.addProperty("id", id);
		event.addProperty("name", name);
		homeValue.add(event);
	}

	public JsonArray getHomeValue() {
		JsonElement element = new Gson().toJsonTree(homeValue,
				new TypeToken<List<JsonObject>>() {
				}.getType());
		if (homeValue.size() > 0) {
			return element.getAsJsonArray();
		} else {
			return new JsonArray();
		}
	}

	public void addEthnicAffinity(String id, String name) {

		final JsonObject event = new JsonObject();
		event.addProperty("id", id);
		event.addProperty("name", name);
		ethnicAffinity.add(event);
	}

	public JsonArray getEhtnicAffinity() {
		JsonElement element = new Gson().toJsonTree(ethnicAffinity,
				new TypeToken<List<JsonObject>>() {
				}.getType());
		if (ethnicAffinity.size() > 0) {
			return element.getAsJsonArray();
		} else {
			return new JsonArray();
		}
	}

	public void addGeneration(String id, String name) {

		final JsonObject event = new JsonObject();
		event.addProperty("id", id);
		event.addProperty("name", name);
		generation.add(event);
	}

	public JsonArray getGeneration() {
		JsonElement element = new Gson().toJsonTree(generation,
				new TypeToken<List<JsonObject>>() {
				}.getType());
		if (generation.size() > 0) {
			return element.getAsJsonArray();
		} else {
			return new JsonArray();
		}
	}

	public void addHouseholdComposition(String id, String name) {

		final JsonObject event = new JsonObject();
		event.addProperty("id", id);
		event.addProperty("name", name);
		householdComposition.add(event);
	}

	public JsonArray getHouseholdComposition() {
		JsonElement element = new Gson().toJsonTree(householdComposition,
				new TypeToken<List<JsonObject>>() {
				}.getType());
		if (householdComposition.size() > 0) {
			return element.getAsJsonArray();
		} else {
			return new JsonArray();
		}
	}

	public void addMoms(String id, String name) {

		final JsonObject event = new JsonObject();
		event.addProperty("id", id);
		event.addProperty("name", name);
		moms.add(event);
	}

	public JsonArray getMoms() {
		JsonElement element = new Gson().toJsonTree(moms,
				new TypeToken<List<JsonObject>>() {
				}.getType());
		if (moms.size() > 0) {
			return element.getAsJsonArray();
		} else {
			return new JsonArray();
		}
	}

	public void addOfficeType(String id, String name) {

		final JsonObject event = new JsonObject();
		event.addProperty("id", id);
		event.addProperty("name", name);
		officeType.add(event);
	}

	public JsonArray getOfficeType() {
		JsonElement element = new Gson().toJsonTree(officeType,
				new TypeToken<List<JsonObject>>() {
				}.getType());
		if (officeType.size() > 0) {
			return element.getAsJsonArray();
		} else {
			return new JsonArray();
		}
	}

	public void addEducationMajor(String id, String name) {

		final JsonObject event = new JsonObject();
		event.addProperty("id", id);
		event.addProperty("name", name);
		educationMajors.add(event);
	}

	public JsonArray getEducationMajor() {
		JsonElement element = new Gson().toJsonTree(educationMajors,
				new TypeToken<List<JsonObject>>() {
				}.getType());
		if (educationMajors.size() > 0) {
			return element.getAsJsonArray();
		} else {
			return new JsonArray();
		}
	}

	public void addEmployer(String id, String name) {

		final JsonObject event = new JsonObject();
		event.addProperty("id", id);
		event.addProperty("name", name);
		employers.add(event);
	}

	public JsonArray getEmployer() {
		JsonElement element = new Gson().toJsonTree(employers,
				new TypeToken<List<JsonObject>>() {
				}.getType());
		if (employers.size() > 0) {
			return element.getAsJsonArray();
		} else {
			return new JsonArray();
		}
	}

	public void addPostion(String id, String name) {

		final JsonObject event = new JsonObject();
		event.addProperty("id", id);
		event.addProperty("name", name);
		positions.add(event);
	}

	public JsonArray getPostions() {
		JsonElement element = new Gson().toJsonTree(positions,
				new TypeToken<List<JsonObject>>() {
				}.getType());
		if (positions.size() > 0) {
			return element.getAsJsonArray();
		} else {
			return new JsonArray();
		}
	}

	public void addConjunctiveUser(String id, String name) {

		final JsonObject event = new JsonObject();
		event.addProperty("id", id);
		event.addProperty("name", name);
		conjunctiveUserCluster.add(event);
	}

	public JsonArray getConjunctiveUserCluster() {
		JsonElement element = new Gson().toJsonTree(conjunctiveUserCluster,
				new TypeToken<List<JsonObject>>() {
				}.getType());
		if (conjunctiveUserCluster.size() > 0) {
			return element.getAsJsonArray();
		} else {
			return new JsonArray();
		}
	}

	public void addUserToCluster(String id, String name) {

		final JsonObject event = new JsonObject();
		event.addProperty("id", id);
		event.addProperty("name", name);
		userCluster.add(event);
	}

	public JsonArray getUserFromCluster() {
		JsonElement element = new Gson().toJsonTree(userCluster,
				new TypeToken<List<JsonObject>>() {
				}.getType());
		if (userCluster.size() > 0) {
			return element.getAsJsonArray();
		} else {
			return new JsonArray();
		}
	}

	public void addUserToExcludedCluster(String id, String name) {

		final JsonObject event = new JsonObject();
		event.addProperty("id", id);
		event.addProperty("name", name);
		excludedUserCluster.add(event);
	}

	public JsonArray getUserFromExcludedCluster() {
		JsonElement element = new Gson().toJsonTree(excludedUserCluster,
				new TypeToken<List<JsonObject>>() {
				}.getType());
		if (excludedUserCluster.size() > 0) {
			return element.getAsJsonArray();
		} else {
			return new JsonArray();
		}
	}
}
