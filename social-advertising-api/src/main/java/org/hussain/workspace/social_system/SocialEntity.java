package org.hussain.workspace.social_system;

import org.hussain.workspace.builders.facebook.impl.FacebookAdaccountBuilder;
import org.hussain.workspace.builders.facebook.impl.FacebookAdcampaignBuilder;
import org.hussain.workspace.builders.facebook.impl.FacebookAdgroupBuilder;
import org.hussain.workspace.builders.facebook.impl.FacebookAdimageBuilder;
import org.hussain.workspace.builders.facebook.impl.FacebookAdsetBuilder;
import org.hussain.workspace.builders.facebook.impl.FacebookAduserBuilder;
import org.hussain.workspace.builders.facebook.impl.FacebookCreativeBuilder;

public class SocialEntity {
	public static FacebookCreativeBuilder facebookCreative() {
		return new FacebookCreativeBuilder();
	}

	public static FacebookAdgroupBuilder facebookAdgroup() {
		return new FacebookAdgroupBuilder(null);
	}

	public static FacebookAdcampaignBuilder facebookAdcampaign() {
		return new FacebookAdcampaignBuilder(null);
	}

	public static FacebookAdsetBuilder facebookAdset() {
		return new FacebookAdsetBuilder(null);
	}

	public static FacebookAdimageBuilder facebookAdimage() {
		return new FacebookAdimageBuilder(null);
	}

	public static FacebookAdaccountBuilder facebookAccount() {
		return new FacebookAdaccountBuilder(null);
	}

	public static FacebookAduserBuilder facebookUser() {
		return new FacebookAduserBuilder(null);
	}
}
