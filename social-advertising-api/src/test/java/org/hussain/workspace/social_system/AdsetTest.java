package org.hussain.workspace.social_system;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;

import org.hussain.workspace.builders.facebook.bean.AdAccount;
import org.hussain.workspace.builders.facebook.enums.CampaignStatus;
import org.hussain.workspace.builders.facebook.impl.FacebookAdaccountBuilder;
import org.hussain.workspace.builders.facebook.impl.FacebookAdsetBuilder;
import org.hussain.workspace.social.api.SocialEntity;
import org.junit.Test;

public class AdsetTest {
	private String accessToken = "CAAEDOFD5jeEBAGGH7jSVoC0BEOr24YnOyZCYF1HEl38NavbebgclqFaXGVGcbfWQNsMXuBmpRoK0dPR1KksO4k8FIvVlw9M82uAJUCX1OuLoB9dVZBFZCtfZCZAYqPltQrqv7eZADTgs70WxiAWf8jPzTidWIAvsmcaYqqaIEcGDdoTdOYAmVp";

	@Test
	// To Create A New Adset
	public void createAdset() throws UnsupportedEncodingException, Exception {
		System.out.println(Calendar.getInstance().getTimeInMillis());
		FacebookAdsetBuilder fbAdset = SocialEntity.facebookAdset(accessToken);
		fbAdset.addSet("6021452658331", "New Adset", "1419302888335966",
				CampaignStatus.ACTIVE.getCampaignStatus(), Calendar
						.getInstance().getTimeInMillis() / 1000, Calendar
						.getInstance().getTimeInMillis() / 1000 + 86400, "{}",
				"{}", 10000, 10000);

		System.out.println(fbAdset.create());

	}

	// To update multiple adsets
	// @Test
	public void updateAdset() throws Exception {

		FacebookAdsetBuilder fbAccount = SocialEntity
				.facebookAdset(accessToken);
		fbAccount.update("1", "name", "Updated Adset Name");
		System.out.println(fbAccount.update());
	}

	// To read multiple adsets
	// @Test
	public void readAdset() throws Exception {

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
