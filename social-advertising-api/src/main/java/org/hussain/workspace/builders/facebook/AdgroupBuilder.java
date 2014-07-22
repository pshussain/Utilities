package org.hussain.workspace.builders.facebook;

import java.util.List;
import java.util.Map;

import org.hussain.workspace.builders.facebook.targeting.Demographic;
import org.hussain.workspace.builders.facebook.targeting.Location;
import org.hussain.workspace.builders.facebook.targeting.Mobile;
import org.hussain.workspace.builders.facebook.targeting.Placement;

public interface AdgroupBuilder {

	public void addAdgroup(String accountId, String campaignId, String name,
			String bidType, String bidInfo, String creativeId,
			Location location, Mobile mobile, Demographic demographic,
			Placement placement, String trackingSpec, String objective,
			String adgroupStatus, List<String> viewTags,
			List<String> socialPrefs);

	public void fetch(String adgroupId);

	public void fetch(String adgroupId, String fields);

	public void update(String adgroupId, String key, String value);

	public void update(String adgroupId, Map<String, String> keyVal);
}
