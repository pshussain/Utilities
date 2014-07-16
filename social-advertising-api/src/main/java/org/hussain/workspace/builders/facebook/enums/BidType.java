package org.hussain.workspace.builders.facebook.enums;

public enum BidType {
	CPM("CPM"), CPC("CPC"), MULTI_PREMIUM("MULTI_PREMIUM"), ABSOLUTE_OCPM(
			"ABSOLUTE_OCPM"), CPA("CPA");

	private String bidType;

	BidType(String bidType) {
		this.bidType = bidType;
	}

	public String getBidType() {
		return bidType;
	}
}
