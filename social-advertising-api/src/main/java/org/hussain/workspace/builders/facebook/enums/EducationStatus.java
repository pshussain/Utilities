package org.hussain.workspace.builders.facebook.enums;

public enum EducationStatus {
	HIGH_SCHOOL("HIGH_SCHOOL"), UNDERGRAD("UNDERGRAD"), ALUM("ALUM"), HIGH_SCHOOL_GRAD(
			"HIGH_SCHOOL_GRAD"), SOME_COLLEGE("SOME_COLLEGE"), IN_GRAD_SCHOOL(
			"IN_GRAD_SCHOOL"), ASSOCIATE_DEGREE("ASSOCIATE_DEGREE"), SOME_GRAD_SCHOOL(
			"SOME_GRAD_SCHOOL"), MASTER_DEGREE("MASTER_DEGREE"), PROFESSIONAL_DEGREE(
			"PROFESSIONAL_DEGREE"), DOCTORATE_DEGREE("DOCTORATE_DEGREE"), UNSPECIFIED(
			"UNSPECIFIED");

	private String status;

	EducationStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
