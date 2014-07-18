package org.hussain.workspace.social_system;

import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;

import org.hussain.workspace.builders.facebook.bean.AdAccount;
import org.hussain.workspace.builders.facebook.enums.CampaignStatus;
import org.hussain.workspace.builders.facebook.enums.Objective;
import org.hussain.workspace.builders.facebook.impl.FacebookAdaccountBuilder;
import org.hussain.workspace.builders.facebook.impl.FacebookAdcampaignBuilder;
import org.hussain.workspace.social.api.SocialEntity;
import org.junit.Test;

public class CampaignTest {
	private String accessToken = "CAAEDOFD5jeEBAGGH7jSVoC0BEOr24YnOyZCYF1HEl38NavbebgclqFaXGVGcbfWQNsMXuBmpRoK0dPR1KksO4k8FIvVlw9M82uAJUCX1OuLoB9dVZBFZCtfZCZAYqPltQrqv7eZADTgs70WxiAWf8jPzTidWIAvsmcaYqqaIEcGDdoTdOYAmVp";

	// @Test
	// To Create A New Campaign
	public void createCampaign() throws UnsupportedEncodingException, Exception {

		FacebookAdcampaignBuilder fbCampaign = SocialEntity
				.facebookAdcampaign(accessToken);
		fbCampaign.addCampaign("1419302888335966", "New Test Campaign",
				Objective.NONE.getObjective(),
				CampaignStatus.ACTIVE.getCampaignStatus(), "FIXED_CPM");

		assertNotNull(fbCampaign.create());

	}

	// To update multiple campaigns
	@Test
	public void updateCampaign() throws Exception {

		FacebookAdcampaignBuilder fbCampaign = SocialEntity
				.facebookAdcampaign(accessToken);
		fbCampaign.update("6021452658331", "name", "Updated New Test Account");

		System.out.println(fbCampaign.update());
	}

	// To read multiple campaigns
	// @Test
	public void readCampaign() throws Exception {

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
