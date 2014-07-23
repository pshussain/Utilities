package org.hussain.workspace.social_system;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hussain.workspace.builders.facebook.bean.AdAccount;
import org.hussain.workspace.builders.facebook.bean.OffsitePixel;
import org.hussain.workspace.builders.facebook.bean.OffsitePixelContainer;
import org.hussain.workspace.builders.facebook.enums.CampaignStatus;
import org.hussain.workspace.builders.facebook.enums.Pixel;
import org.hussain.workspace.builders.facebook.impl.FacebookAdaccountBuilder;
import org.hussain.workspace.builders.facebook.impl.FacebookAdsetBuilder;
import org.hussain.workspace.builders.facebook.impl.FacebookClickTrackingTagBuilder;
import org.hussain.workspace.builders.facebook.impl.FacebookConversionBuilder;
import org.hussain.workspace.social.api.SocialEntity;
import org.junit.Test;

public class ConversionPixelTest {
	// private String accessToken =
	// "CAAEDOFD5jeEBAGGH7jSVoC0BEOr24YnOyZCYF1HEl38NavbebgclqFaXGVGcbfWQNsMXuBmpRoK0dPR1KksO4k8FIvVlw9M82uAJUCX1OuLoB9dVZBFZCtfZCZAYqPltQrqv7eZADTgs70WxiAWf8jPzTidWIAvsmcaYqqaIEcGDdoTdOYAmVp";
	private String accessToken = "CAAEDOFD5jeEBAGGH7jSVoC0BEOr24YnOyZCYF1HEl38NavbebgclqFaXGVGcbfWQNsMXuBmpRoK0dPR1KksO4k8FIvVlw9M82uAJUCX1OuLoB9dVZBFZCtfZCZAYqPltQrqv7eZADTgs70WxiAWf8jPzTidWIAvsmcaYqqaIEcGDdoTdOYAmVp";

	// @Test
	// To Create A New Adset
	public void createPixel() throws UnsupportedEncodingException, Exception {
		FacebookConversionBuilder fbConversionPixel = SocialEntity
				.facebookConversionPixel(accessToken);
		fbConversionPixel.addOffsitePixel("100237586827788", "Test Pixel",
				Pixel.ADD_TO_CART);

		System.out.println(fbConversionPixel.create());

	}

	// To update multiple adsets
	// @Test
	public void updatePixel() throws Exception {

		FacebookConversionBuilder fbConversionPixel = SocialEntity
				.facebookConversionPixel(accessToken);
		fbConversionPixel.updateName("6016905187726", "Updated Pixel");
		System.out.println(fbConversionPixel.update());

	}

	// @Test
	public void updateValue() throws Exception {

		FacebookConversionBuilder fbConversionPixel = SocialEntity
				.facebookConversionPixel(accessToken);
		fbConversionPixel.updateValue("6016905187726", "500");
		System.out.println(fbConversionPixel.update());

	}

	// To read multiple adsets
	// @Test
	public void readPixelById() throws Exception {

		FacebookConversionBuilder fbPixel = SocialEntity
				.facebookConversionPixel(accessToken);
		fbPixel.fetchByPixel("6016905187726");

		List<OffsitePixel> offisitePixelBean = (List<OffsitePixel>) fbPixel
				.read();
		for (OffsitePixel pixel : offisitePixelBean) {
			System.out.println(pixel.toString());
		}

	}

	// To read multiple adsets
	// @Test
	public void readPixelByAccount() throws Exception {

		FacebookConversionBuilder fbPixel = SocialEntity
				.facebookConversionPixel(accessToken);
		fbPixel.fetchByAccount("100237586827788");

		OffsitePixelContainer offisitePixelBean = fbPixel.readAccountPixels();
		for (OffsitePixel pixel : offisitePixelBean.getPixels()) {
			System.out.println(pixel.toString());
		}

	}

	@Test
	public void readPixelCode() throws Exception {

		FacebookConversionBuilder fbPixel = SocialEntity
				.facebookConversionPixel(accessToken);
		OffsitePixel pixel = fbPixel.getPixelCode("6016905187726", 50);
		System.out.println(pixel.getJs_pixel());

	}

	// @Test
	public void authorizeAccount() throws Exception {

		FacebookConversionBuilder fbPixel = SocialEntity
				.facebookConversionPixel(accessToken);
		System.out.println(fbPixel.authorize("6016905187726",
				"1454681918119229"));
		List<Long> accountIds = new ArrayList<Long>();
		accountIds.add(100237586827788L);
		System.out.println(fbPixel.authorize("6016904870526", accountIds));
		// fbAccount.create();

	}

	// @Test
	public void readAuthorizedAccount() throws Exception {

		FacebookConversionBuilder fbPixel = SocialEntity
				.facebookConversionPixel(accessToken);
		fbPixel.fetchAccount("6016905187726");
		System.out.println(fbPixel.readAuthorizedAccounts());
		// fbAccount.create();

	}
}
