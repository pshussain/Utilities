package org.hussain.workspace.builders.facebook.enums;

public enum ActionType {
	SHOP_NOW("SHOP_NOW"), BOOK_TRAVEL("BOOK_TRAVEL"), LEARN_MORE("LEARN_MORE"), SIGN_UP(
			"SIGN_UP"), DOWNLOAD("DOWNLOAD"), INSTALL_MOBILE_APP(
			"INSTALL_MOBILE_APP"), USE_MOBILE_APP("USE_MOBILE_APP"), WATCH_VIDEO(
			"WATCH_VIDEO"), WATCH_MORE("WATCH_MORE"), OPEN_LINK("OPEN_LINK"), USE_APP(
			"USE_APP"), PLAY_GAME("PLAY_GAME"), BUY_NOW("BUY_NOW"), GET_OFFER(
			"GET_OFFER");

	private String actionType;

	ActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getActionType() {
		return actionType;
	}
}
