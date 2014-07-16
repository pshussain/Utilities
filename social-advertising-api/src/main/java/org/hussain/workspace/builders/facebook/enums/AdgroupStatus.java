package org.hussain.workspace.builders.facebook.enums;

public enum AdgroupStatus {
	ACTIVE("ACTIVE"), PAUSED("PAUSED"), CAMPAIGN_PAUSED("CAMPAIGN_PAUSED"), CAMPAIGN_GROUP_PAUSED(
			"CAMPAIGN_GROUP_PAUSED"), PENDING_REVIEW("PENDING_REVIEW"), PREAPPROVED(
			"PREAPPROVED"), DISAPPROVED("DISAPPROVED"), PENDING_BILLING_INFO(
			"PENDING_BILLING_INFO"), ARCHIVED("ARCHIVED"), DELETED("DELETED");

	private String adgroupStatus;

	AdgroupStatus(String adgroupStatus) {
		this.adgroupStatus = adgroupStatus;
	}

	public String getAdgroupStatus() {
		return adgroupStatus;
	}
}
