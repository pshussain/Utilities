package org.hussain.workspace.builders.facebook;

public interface SetBuilder {
	public void addSet(String accountId, String name, String campaignGroupId,
			String campaignStatus, String startTime, String endTime,
			String updatedTime, String created_time, Integer daily_budget,
			Integer lifetimeBudget);
}
