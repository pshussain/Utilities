package org.hussain.workspace.builders.facebook;

import java.util.Map;

import com.google.gson.JsonObject;

public interface AdgroupBuilder {
	public void addAdgroup(String accountId, String name, String adgroupStatus,
			String bidType, String bidInfo, JsonObject conversionSpecs,
			String campaignId, JsonObject creative, String objective,
			JsonObject targeting, JsonObject trackingSpecs,
			JsonObject viewTags, JsonObject socialPrefs);

	public void fetch(String adgroupId);

	public void fetch(String adgroupId, String fields);

	public void update(String adgroupId, String key, String value);

	public void update(String adgroupId, Map<String, String> keyVal);
}
