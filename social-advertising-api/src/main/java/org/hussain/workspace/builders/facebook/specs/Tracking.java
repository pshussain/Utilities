package org.hussain.workspace.builders.facebook.specs;

import org.hussain.workspace.builders.facebook.enums.TrackingSpec;

public class Tracking {
	public String canvasAppEngagement(String applicationId) {
		String trackingSpec = "[{'action.type':'app_engagement','application':"
				+ applicationId + "}]";
		return trackingSpec;
	}

	public String canvasPostEngagement(String postId, String pageId) {
		String trackingSpec = "[{'action.type':'post_engagement','post':"
				+ postId + "'page':" + pageId + "}]";
		return trackingSpec;
	}

	public String canvasAppInstall(String applicationId) {
		String trackingSpec = "[{'action.type':'app_engagement','application':"
				+ applicationId + "}]";
		return trackingSpec;
	}

	public String canvasPostInstall(String postId, String pageId) {
		String trackingSpec = "[{'action.type':'post_engagement','post':"
				+ postId + "'page':" + pageId + "}]";
		return trackingSpec;
	}

	public String eventResponse(String eventId, String pageId) {
		String trackingSpec = "[{'action.type':'rsvp' ,"
				+ "'response':'yes', 'event':" + eventId + "},"
				+ "{'action.type':'rsvp' ," + "'response':'maybe', 'event':"
				+ eventId + "}," + "[{'action.type':'rsvp' ,"
				+ "'response':'no', 'event':" + eventId + "}]";
		return trackingSpec;
	}

	public String mobileAppInstall(String applicationId) {
		String trackingSpec = "[{'action.type':" + "'app_custom_event',"
				+ "'application':" + applicationId + "}"
				+ "{'action.type': 'mobile_app_install', 'application': "
				+ applicationId + "}]";
		return trackingSpec;
	}

	public String mobileAppEngagement(String postId, String pageId) {
		String trackingSpec = "[{'action.type':'post_engagement','post':"
				+ postId + "'page':" + pageId + "}]";
		return trackingSpec;
	}

	public String offerClaims(String postId, String pageId) {
		String trackingSpec = "[{'action.type':'post_engagement','post':"
				+ postId + "'page':" + pageId + "}]";
		return trackingSpec;
	}

	public String offerClaims(String postId, String pageId, String offerId) {
		String trackingSpec = "[{'action.type':" + "'post_engagement',"
				+ "'post':" + postId + ", 'page':" + pageId
				+ "}, {'action.type':" + "'receive_offer',\n" + "'offer':"
				+ offerId + "}]";
		return trackingSpec;
	}

	public String pageLikes(String postId, String pageId) {
		String trackingSpec = "[{'action.type':'page_engagement','page':"
				+ pageId + "}]";
		return trackingSpec;
	}

	public String postEngagement(String postId, String pageId) {
		String trackingSpec = "[{'action.type':" + "'post_engagement',"
				+ "'post':" + postId + ", 'page':" + pageId + "}]";
		return trackingSpec;
	}

	public String websiteClicks(String postId, String pageId) {
		String trackingSpec = "[{'action.type':" + "'post_engagement',"
				+ "'post':" + postId + ", 'page':" + pageId + "}]";
		return trackingSpec;
	}

	public String websiteClicks(String pageId) {
		String trackingSpec = "[{'action.type':'like',\n" + "'page':" + pageId
				+ "}]";
		return trackingSpec;
	}

	public String websiteLinkClick(String pageId, String url) {
		String trackingSpec = "[{'action.type':" + "'link_click',"
				+ "'object':" + url + "}, {'action.type':'like'," + "'page':"
				+ pageId + "}]";
		return trackingSpec;
	}

	public String websiteConversions(String pageId, String postId,
			String pixelId) {
		String trackingSpec = "[{'action.type':" + "'offsite_conversion',"
				+ "'offsite_pixel':" + pixelId
				+ "},{'action.type':{'action.type':" + "'post_engagement',"
				+ "'post':" + postId + ", 'page':" + pageId + "},"
				+ "{'action.type':'like'," + "'page':" + pageId + "}]";
		return trackingSpec;
	}

	public String websiteConversions(String pageId, String url) {
		String trackingSpec = "[{'action.type':" + "'link_click',"
				+ "'object':" + url + "}, {'action.type':'like'," + "'page':"
				+ pageId + "}]";
		return trackingSpec;
	}

	public String websiteLinkConversions(String pageId, String pixelId,
			String url) {
		String trackingSpec = "[{'action.type':\n" + "'offsite_conversion',\n"
				+ "'offsite_pixel':\n" + pixelId + "},{'action.type':\n"
				+ "'link_click',\n" + "'object':" + url
				+ "}, {'action.type':'like',\n" + "'page':" + pageId + "}]";
		return trackingSpec;
	}

	public String getTrackingSpec(String objective) {
		if (objective.equals(TrackingSpec.CANVAS_APP_ENGAGEMENT)) {
			
		}
		return objective;
	}
}
