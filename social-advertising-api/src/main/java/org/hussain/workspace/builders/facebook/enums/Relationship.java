package org.hussain.workspace.builders.facebook.enums;

public enum Relationship {
	SINGLE("single"), IN_RELATIONSHIP("in_relationship"), MARRIED("married"), ENGAGED(
			"engaged"), NOT_SPECIFIED("not specified"), IN_A_CIVIL_UNION(
			"in a civil union"), IN_A_DOMESTIC_PARTNERSHIP(
			"in a domestic partnership"), IN_AN_OPEN_RELATIONSHIP(
			"in an open relationship"), ITS_COMPLICATED("It\'s complicated"), SEPARATED(
			"separated"), DIVORCED("Divorced"), WIDOWED("Widowed");

	private String relationshipStatus;

	Relationship(String relationshipStatus) {
		this.relationshipStatus = relationshipStatus;
	}

	public String getRelationshipStatus() {
		return relationshipStatus;
	}
}
