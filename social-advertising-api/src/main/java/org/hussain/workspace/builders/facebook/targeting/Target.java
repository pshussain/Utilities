package org.hussain.workspace.builders.facebook.targeting;

import java.util.List;

import org.hussain.workspace.utils.FacebookUtil;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Target {
	public static String buildTarget(Location location, Device device,
			List<Integer> genderList, String[] age, List<String> keywordList,
			List<String> pageType) {
		JsonObject target = new JsonObject();
		target.addProperty("geo_locations", new Gson().toJson(location));
		target.addProperty("gender",
				FacebookUtil.buildIntegerTarget(genderList));
		target.addProperty("age_min", age[0]);
		target.addProperty("age_max", "99");
		if (keywordList.size() > 0)
			target.addProperty("keyword",
					FacebookUtil.buildStringTarget(keywordList));
		if (!device.getUser_device().isEmpty())
			target.addProperty("user_device", device.getUser_device());
		if (!device.getUser_os().isEmpty())
			target.addProperty("user_os", device.getUser_os());
		target.addProperty("page_types",
				FacebookUtil.buildStringTarget(pageType));
		System.out.println(target);
		return new Gson().toJson(target).toString();
	}
}
