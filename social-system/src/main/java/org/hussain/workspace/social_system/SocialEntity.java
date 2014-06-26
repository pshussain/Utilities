package org.hussain.workspace.social_system;

import org.hussain.workspace.builders.facebook.facebook.impl.FacebookAdaccountBuilder;
import org.hussain.workspace.builders.facebook.facebook.impl.FacebookAdcampaignBuilder;
import org.hussain.workspace.builders.facebook.facebook.impl.FacebookAdgroupBuilder;
import org.hussain.workspace.builders.facebook.facebook.impl.FacebookAdimageBuilder;
import org.hussain.workspace.builders.facebook.facebook.impl.FacebookAdsetBuilder;
import org.hussain.workspace.builders.facebook.facebook.impl.FacebookAduserBuilder;
import org.hussain.workspace.builders.facebook.facebook.impl.FacebookCreativeBuilder;

public class SocialEntity {
	public static FacebookCreativeBuilder facebookCreative() {
		return new FacebookCreativeBuilder();
	}

	public static FacebookAdgroupBuilder facebookAdgroup() {
		return new FacebookAdgroupBuilder();
	}

	public static FacebookAdcampaignBuilder facebookAdcampaign() {
		return new FacebookAdcampaignBuilder();
	}

	public static FacebookAdsetBuilder facebookAdset() {
		return new FacebookAdsetBuilder();
	}

	public static FacebookAdimageBuilder facebookAdimage() {
		return new FacebookAdimageBuilder();
	}

	public static FacebookAdaccountBuilder facebookAccount() {
		return new FacebookAdaccountBuilder();
	}

	public static FacebookAduserBuilder facebookUser() {
		return new FacebookAduserBuilder();
	}
}
