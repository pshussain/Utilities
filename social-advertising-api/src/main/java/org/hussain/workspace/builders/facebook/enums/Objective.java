package org.hussain.workspace.builders.facebook.enums;

public enum Objective {
	NONE("NONE"), CANVAS_APP_INSTALLS("CANVAS_APP_INSTALLS"), CANVAS_APP_ENGAGEMENT(
			"CANVAS_APP_ENGAGEMENT"), EVENT_RESPONSES("EVENT_RESPONSES"), MOBILE_APP_ENGAGEMENT(
			"MOBILE_APP_ENGAGEMENT"), MOBILE_APP_INSTALLS("MOBILE_APP_INSTALLS"), OFFER_CLAIMS(
			"OFFER_CLAIMS"), PAGE_LIKES("PAGE_LIKES"), POST_ENGAGEMENT(
			"POST_ENGAGEMENT"), WEBSITE_CLICKS("WEBSITE_CLICKS"), WEBSITE_CONVERSIONS(
			"WEBSITE_CONVERSIONS");

	private String objective;

	Objective(String objective) {
		this.objective = objective;
	}

	public String getObjective() {
		return objective;
	}
}
