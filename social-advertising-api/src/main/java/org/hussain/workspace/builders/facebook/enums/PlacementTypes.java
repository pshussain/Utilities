package org.hussain.workspace.builders.facebook.enums;

public enum PlacementTypes {
	DESKTOP("desktop"), FEED("feed"), DESKTOPFEED("desktopfeed"), MOBILE(
			"mobile"), RIGHTCOLUMN("rightcolumn"), HOME("home"), MOBILEFEEDEXTERNAL(
			"mobilefeed-and-external");

	private String placement;

	PlacementTypes(String placement) {
		this.placement = placement;
	}

	public String getPlacement() {
		return placement;
	}
}
