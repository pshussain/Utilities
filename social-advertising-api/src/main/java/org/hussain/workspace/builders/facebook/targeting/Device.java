package org.hussain.workspace.builders.facebook.targeting;

import java.util.List;

import org.hussain.workspace.utils.FacebookUtil;

public class Device {
	private List<String> user_device;
	private List<String> user_os;
	private List<String> wireless_carrier;
	private List<String> site_category;

	public String getUser_device() {
		return FacebookUtil.buildStringTarget(user_device);
	}

	public void setUser_device(String userDevice) {
		this.user_device.add(userDevice);
	}

	public String getUser_os() {
		return FacebookUtil.buildStringTarget(user_os);
	}

	public void setUser_os(String userOs) {
		this.user_os.add(userOs);
	}

	public String getWireless_carrier() {
		return FacebookUtil.buildStringTarget(wireless_carrier);
	}

	public void setWireless_carrier(String wirelessCarrier) {
		this.wireless_carrier.add(wirelessCarrier);
	}

	public String getSite_category() {
		return FacebookUtil.buildStringTarget(site_category);
	}

	public void setSite_category(String siteCategory) {
		this.site_category.add(siteCategory);
	}
}
