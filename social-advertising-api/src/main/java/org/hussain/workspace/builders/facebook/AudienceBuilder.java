package org.hussain.workspace.builders.facebook;

import java.util.List;
import java.util.Map;

import com.google.gson.JsonObject;

public interface AudienceBuilder {

	public void addEmailToAudience(String audienceId, String schema,
			List<String> emailAddresses);

	public void addFacebookIdToAudience(String audienceId, String schema,
			List<String> facebookIds);

	public void addPhoneToAudience(String audienceId, String schema,
			List<String> phoneNumbers);

	public void addAdvertiserIdToAudience(String audienceId, String schema,
			List<String> advertiserIds);

	public void addWebAudience(String accountId, String name, String subtype,
			int retentionDays, JsonObject rule);

	public void addCustomAudience(String accountId, String name,
			String description, String optOutLink);

	public void updateAudience(String audienceId, String key, String value);

	public void update(String audienceId, Map<String, String> keyVal);

	public void read(String accountId);

	public void read(String accountId, String fields);

	public void readPixel(String pixelId);

	public void createPixel(String accountId);

	public void fetch(String accountId);

	public void fetch(String accountId, String fields);
}