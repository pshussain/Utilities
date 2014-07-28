package org.hussain.workspace.social_system;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.hussain.workspace.builders.facebook.bean.AdAccount;
import org.hussain.workspace.builders.facebook.bean.AdImageContainer;
import org.hussain.workspace.builders.facebook.impl.FacebookAdaccountBuilder;
import org.hussain.workspace.builders.facebook.impl.FacebookAdimageBuilder;
import org.hussain.workspace.builders.facebook.impl.FacebookAdsetBuilder;
import org.hussain.workspace.social.api.SocialEntity;
import org.junit.Test;

public class AdimageTest {
	// private String accessToken =
	// "CAAEDOFD5jeEBAGGH7jSVoC0BEOr24YnOyZCYF1HEl38NavbebgclqFaXGVGcbfWQNsMXuBmpRoK0dPR1KksO4k8FIvVlw9M82uAJUCX1OuLoB9dVZBFZCtfZCZAYqPltQrqv7eZADTgs70WxiAWf8jPzTidWIAvsmcaYqqaIEcGDdoTdOYAmVp";
	// private String accessToken =
	// "CAAEDOFD5jeEBAGGH7jSVoC0BEOr24YnOyZCYF1HEl38NavbebgclqFaXGVGcbfWQNsMXuBmpRoK0dPR1KksO4k8FIvVlw9M82uAJUCX1OuLoB9dVZBFZCtfZCZAYqPltQrqv7eZADTgs70WxiAWf8jPzTidWIAvsmcaYqqaIEcGDdoTdOYAmVp";
	private String accessToken = "CAAEDOFD5jeEBAGGH7jSVoC0BEOr24YnOyZCYF1HEl38NavbebgclqFaXGVGcbfWQNsMXuBmpRoK0dPR1KksO4k8FIvVlw9M82uAJUCX1OuLoB9dVZBFZCtfZCZAYqPltQrqv7eZADTgs70WxiAWf8jPzTidWIAvsmcaYqqaIEcGDdoTdOYAmVp";

	// @Test
	// To Create A New Adimage
	public void createAdimage() throws UnsupportedEncodingException, Exception {
		FacebookAdimageBuilder fbAdimage = SocialEntity
				.facebookAdimage(accessToken);
		System.out.println(fbAdimage.uploadImage("", "/home/hussain/CTC6.png"));

		// System.out.println(fbAdimage.create());

	}

	// @Test
	// To Create A Batch Adimage
	public void createAdimageBatch() throws UnsupportedEncodingException,
			Exception {
		FacebookAdimageBuilder fbAdimage = SocialEntity
				.facebookAdimage(accessToken);
		fbAdimage.addImage("275668082617836", "/home/hussain/CTC6.png");
		System.out.println(fbAdimage.create());

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
	@Test
	public void readAdImageByAccount() throws Exception {

		ArrayList<String> fields = new ArrayList<String>();
		fields.add("id");
		fields.add("url");
		fields.add("hash");
		System.out.println(fields.toString());
		FacebookAdimageBuilder fbImage = SocialEntity
				.facebookAdimage(accessToken);
		AdImageContainer container = fbImage.readByAccount("100237586827788",
				fields);
		System.out.println(container.getAfter());
		System.out.println(container.getBefore());
	}
}
