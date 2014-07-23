package org.hussain.workspace.builders.facebook;

import java.util.Map;

public interface ClickTrackTagBuilder {
	public void addTrackingTag(String adgroupId, String url,
			String templateParam);

	public void updateUrl(String adgroupId, String url);

	public void updateTemplateParam(String adgroupId, String templateParam);

	public void update(String adgroupId, String key, String value);

	public void update(String adgroupId, Map<String, String> keyVal);

	public void fetch(String clickTrackTagId);

}
