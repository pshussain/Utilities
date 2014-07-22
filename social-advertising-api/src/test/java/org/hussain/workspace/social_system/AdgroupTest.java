package org.hussain.workspace.social_system;

import java.io.UnsupportedEncodingException;

import org.hussain.workspace.builders.facebook.bean.AdAccount;
import org.hussain.workspace.builders.facebook.enums.AdgroupStatus;
import org.hussain.workspace.builders.facebook.enums.BidType;
import org.hussain.workspace.builders.facebook.enums.Objective;
import org.hussain.workspace.builders.facebook.enums.PlacementTypes;
import org.hussain.workspace.builders.facebook.impl.FacebookAdaccountBuilder;
import org.hussain.workspace.builders.facebook.impl.FacebookAdgroupBuilder;
import org.hussain.workspace.builders.facebook.targeting.Demographic;
import org.hussain.workspace.builders.facebook.targeting.Location;
import org.hussain.workspace.builders.facebook.targeting.Mobile;
import org.hussain.workspace.builders.facebook.targeting.Placement;
import org.hussain.workspace.social.api.SocialEntity;
import org.junit.Test;

public class AdgroupTest {
	private String accessToken = "CAAEDOFD5jeEBAGGH7jSVoC0BEOr24YnOyZCYF1HEl38NavbebgclqFaXGVGcbfWQNsMXuBmpRoK0dPR1KksO4k8FIvVlw9M82uAJUCX1OuLoB9dVZBFZCtfZCZAYqPltQrqv7eZADTgs70WxiAWf8jPzTidWIAvsmcaYqqaIEcGDdoTdOYAmVp";

	@Test
	// To Create A New Audience
	public void createAdgroup() throws UnsupportedEncodingException, Exception {

		FacebookAdgroupBuilder fbAccount = SocialEntity
				.facebookAdgroup(accessToken);
		Location location = new Location();
		location.addCountry("US");
		// location.addCountry("UK");

		Mobile mobile = new Mobile();
		mobile.addOS("iOS");
		mobile.addDevice("iPhone");
		// mobile.addCategory("feature_phones");
		Demographic demographic = new Demographic();
		demographic.setMinAge("10");
		demographic.setMaxAge("17");

		Placement placement = new Placement();
		placement.addPlacement(PlacementTypes.FEED.getPlacement());
		 demographic.addGender(1);
		// demographic.addKeyword("movies");

		// fbAccount.addAdgroup("1419302888335966", "6021452658331",
		// "New Adgroup", BidType.CPC.getBidType(), "{'CLICKS':150}",
		// "123", targetStr, null,
		// Objective.MOBILE_APP_INSTALLS.getObjective(),
		// AdgroupStatus.ACTIVE.getAdgroupStatus(), null, null);

		fbAccount.addAdgroup("100237586827788", "6016891738526",
				"This is my third New Adgroup", BidType.CPC.getBidType(),
				"{'CLICKS':1}", "6016643019726", location, mobile, demographic,
				placement, null, Objective.MOBILE_APP_INSTALLS.getObjective(),
				AdgroupStatus.ACTIVE.getAdgroupStatus(), null, null);
		System.out.println(fbAccount.create());

	}

	// To update multiple accounts
	// @Test
	public void updateAdgroup() throws Exception {

		FacebookAdaccountBuilder fbAccount = SocialEntity
				.facebookAccount(accessToken);
		fbAccount.addAccount("New Test AdAccount", "USD", 1);
		// fbAccount.create();

		fbAccount.updateAccountName("275668082617836",
				"Update Test New AdAccount");
		fbAccount.updateAccountName("1419302888335966",
				"Batch AdAccount Name Update");
		System.out.println(fbAccount.update());
	}

	// To read multiple accounts
	// @Test
	public void readAdgroup() throws Exception {

		FacebookAdaccountBuilder fbAccount = SocialEntity
				.facebookAccount(accessToken);
		fbAccount.addAccount("New Test AdAccount", "USD", 1);
		// fbAccount.create();

		fbAccount.fetch("275668082617836", "name,timezone_name,users");
		// fbAccount.fetch("578846975538588");
		for (AdAccount account : fbAccount.read()) {
			System.out.println(account.getAccountId());
			System.out.println(account.getTimezone_name());
			System.out.println(account.getName());
			System.out.println(account.getUsers().get(0).getRole());
		}
	}

}
