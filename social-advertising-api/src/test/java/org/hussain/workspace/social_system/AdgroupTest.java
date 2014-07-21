package org.hussain.workspace.social_system;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.hussain.workspace.builders.facebook.bean.AdAccount;
import org.hussain.workspace.builders.facebook.enums.AdgroupStatus;
import org.hussain.workspace.builders.facebook.enums.BidType;
import org.hussain.workspace.builders.facebook.enums.Objective;
import org.hussain.workspace.builders.facebook.impl.FacebookAdaccountBuilder;
import org.hussain.workspace.builders.facebook.impl.FacebookAdgroupBuilder;
import org.hussain.workspace.builders.facebook.targeting.Device;
import org.hussain.workspace.builders.facebook.targeting.Location;
import org.hussain.workspace.builders.facebook.targeting.Target;
import org.hussain.workspace.social.api.SocialEntity;
import org.junit.Test;

public class AdgroupTest {
	private String accessToken = "CAAEDOFD5jeEBAGGH7jSVoC0BEOr24YnOyZCYF1HEl38NavbebgclqFaXGVGcbfWQNsMXuBmpRoK0dPR1KksO4k8FIvVlw9M82uAJUCX1OuLoB9dVZBFZCtfZCZAYqPltQrqv7eZADTgs70WxiAWf8jPzTidWIAvsmcaYqqaIEcGDdoTdOYAmVp";

	@Test
	// To Create A New Audience
	public void createAdgroup() throws UnsupportedEncodingException, Exception {

		FacebookAdgroupBuilder fbAccount = SocialEntity
				.facebookAdgroup(accessToken);
		Target target = new Target();
		Location location = new Location();
		location.setCountries("US");
		location.setCountries("UK");

		Device device = new Device();

		String targetStr = Target.buildTarget(location, device,
				new ArrayList<Integer>(), new String[] { "1" },
				new ArrayList<String>(), new ArrayList<String>());
		
		fbAccount.addAdgroup("1419302888335966", "6021452658331",
				"New Adgroup", BidType.CPC.getBidType(), "{'CLICKS':150}",
				"123", targetStr, null,
				Objective.MOBILE_APP_INSTALLS.getObjective(),
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
