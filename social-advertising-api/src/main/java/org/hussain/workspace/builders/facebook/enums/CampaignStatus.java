package org.hussain.workspace.builders.facebook.enums;

public enum CampaignStatus {
	ACTIVE("ACTIVE"), PAUSED("PAUSED"), ARCHIVED("ARCHIVED"), DELETED("DELETED"), CAMPAIGN_GROUP_PAUSED(
			"CAMPAIGN_GROUP_PAUSED");

	private String campaignStatus;

	CampaignStatus(String campaignStatus) {
		this.campaignStatus = campaignStatus;
	}

	public String getCampaignStatus() {
		return campaignStatus;
	}
}
