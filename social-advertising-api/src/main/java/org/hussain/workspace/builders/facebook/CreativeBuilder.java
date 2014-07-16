package org.hussain.workspace.builders.facebook;

public interface CreativeBuilder {

	public void addLinkAd(String accountId, String title, String body,
			String objectUrl, String imageFile, String imageHash, String name,
			String actorId);

	public void addPageLikeAd(String accountId, String obejctId, String body,
			String name, String linkUrl, String imageFile, String imageHash,
			String title);

	public void addEventAd(String accountId, String obejctId, String body,
			String name, String imageFile, String title);

	public void addMobileAppInstall(String accountId, String obejctStoreUrl,
			String imageHash, String body, String actorName, String name,
			String actorImageHash, String callToActionType, String videoId);

	public void addMobileAppEngage(String accountId, String obejctStoreUrl,
			String imageHash, String title, String callToActionType,
			String linkDeepLinkUrl, String body, String name,
			String actorImageHash);

	public void addDesktopApp(String accountId, String objectId,
			String imageHash, String body, String actorName, String urlTags,
			String linkUrl, String name, String actorImageHash);

}
