package org.hussain.workspace.builders.facebook;

import java.util.Map;

public interface CampaignBuilder {
	public void addCampaign(String accountId, String name, String objective,
			String campaignGroupStatus, String buyingType);

	public void updateName(String accountId, String name);

	public void updateObjective(String accountId, String objective);

	public void updateStatus(String accountId, String status);

	public void update(String accountId, String key, String value);

	public void update(String accountId, Map<String, String> keyVal);
}
