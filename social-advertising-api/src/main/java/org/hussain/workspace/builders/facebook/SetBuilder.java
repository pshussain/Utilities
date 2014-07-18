package org.hussain.workspace.builders.facebook;

import java.util.Map;

public interface SetBuilder {
	public void addSet(String accountId, String name, String campaignGroupId,
			String campaignStatus, long startTime, long endTime,
			String updatedTime, String created_time, Integer daily_budget,
			Integer lifetimeBudget);

	public void update(String adsetId, String key, String value);

	public void update(String adsetId, Map<String, String> keyVal);

	public void fetch(String accountId);

	public void fetch(String accountId, String fields);
}
