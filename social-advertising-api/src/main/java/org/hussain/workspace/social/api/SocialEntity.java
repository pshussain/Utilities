package org.hussain.workspace.social.api;

import org.hussain.workspace.builders.facebook.impl.FacebookAdaccountBuilder;
import org.hussain.workspace.builders.facebook.impl.FacebookAdcampaignBuilder;
import org.hussain.workspace.builders.facebook.impl.FacebookAdgroupBuilder;
import org.hussain.workspace.builders.facebook.impl.FacebookAdimageBuilder;
import org.hussain.workspace.builders.facebook.impl.FacebookAdsetBuilder;
import org.hussain.workspace.builders.facebook.impl.FacebookAduserBuilder;
import org.hussain.workspace.builders.facebook.impl.FacebookAdcreativeBuilder;
import org.hussain.workspace.builders.facebook.impl.FacebookClickTrackingTagBuilder;
import org.hussain.workspace.builders.facebook.impl.FacebookConversionBuilder;

public class SocialEntity {
	public static FacebookAdcreativeBuilder facebookCreative(String accessToken) {
		return new FacebookAdcreativeBuilder(accessToken);
	}

	public static FacebookAdgroupBuilder facebookAdgroup(String accessToken) {
		return new FacebookAdgroupBuilder(accessToken);
	}

	public static FacebookAdcampaignBuilder facebookAdcampaign(
			String accessToken) {
		return new FacebookAdcampaignBuilder(accessToken);
	}

	public static FacebookAdsetBuilder facebookAdset(String accessToken) {
		return new FacebookAdsetBuilder(accessToken);
	}

	public static FacebookAdimageBuilder facebookAdimage(String accessToken) {
		return new FacebookAdimageBuilder(accessToken);
	}

	public static FacebookAdaccountBuilder facebookAccount(String accessToken) {
		return new FacebookAdaccountBuilder(accessToken);
	}

	public static FacebookAduserBuilder facebookUser(String accessToken) {
		return new FacebookAduserBuilder(accessToken);
	}

	public static FacebookClickTrackingTagBuilder facebookClickTag(
			String accessToken) {
		return new FacebookClickTrackingTagBuilder(accessToken);
	}

	public static FacebookConversionBuilder facebookConversionPixel(
			String accessToken) {
		return new FacebookConversionBuilder(accessToken);
	}

	
}
