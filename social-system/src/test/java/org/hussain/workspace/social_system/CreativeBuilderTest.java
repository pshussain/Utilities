package org.hussain.workspace.social_system;

import org.hussain.workspace.builders.facebook.impl.FacebookAdgroupBuilder;
import org.hussain.workspace.builders.facebook.impl.FacebookCreativeBuilder;
import org.hussain.workspace.social_system.SocialEntity;

public class CreativeBuilderTest {
	public static void main(String[] args) {
		FacebookCreativeBuilder builder = SocialEntity.facebookCreative();
		builder.addCreative(10);
		builder.addCreative(5);
		builder.addCreative("Hussain");
		System.out.println(builder.create());

		FacebookAdgroupBuilder builder1 = SocialEntity.facebookAdgroup();
		builder1.addAdgroup(10);
		System.out.println(builder1.create());
	}
}
