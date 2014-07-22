package org.hussain.workspace.builders.facebook.enums;

public enum Relationship {
	SINGLE(1), IN_RELATIONSHIP(2), MARRIED(3), ENGAGED(4), NOT_SPECIFIED(6), IN_A_CIVIL_UNION(
			7), IN_A_DOMESTIC_PARTNERSHIP(8), IN_AN_OPEN_RELATIONSHIP(9), ITS_COMPLICATED(
			10), SEPARATED(11), DIVORCED(12), WIDOWED(13);

	private Integer relationshipStatus;

	Relationship(Integer relationshipStatus) {
		this.relationshipStatus = relationshipStatus;
	}

	public Integer getRelationshipStatus() {
		return relationshipStatus;
	}
}
