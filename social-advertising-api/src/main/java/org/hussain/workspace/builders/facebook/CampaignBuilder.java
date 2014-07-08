package org.hussain.workspace.builders.facebook;

public interface CampaignBuilder {
	public void addCampaign(String accountId, String name, String objective,
			String campaignGroupStatus, String buyingType);

	public void updateName(String name);

	public void updateObjective(String objective);

	public void updateStatus(String status);
}
