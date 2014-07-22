package org.hussain.workspace.builders.facebook.enums;

public enum EducationStatus {
	HIGH_SCHOOL(1), UNDERGRAD(2), ALUM(3), HIGH_SCHOOL_GRAD(4), SOME_COLLEGE(5), IN_GRAD_SCHOOL(
			7), ASSOCIATE_DEGREE(6), SOME_GRAD_SCHOOL(8), MASTER_DEGREE(9), PROFESSIONAL_DEGREE(
			10), DOCTORATE_DEGREE(11), UNSPECIFIED(12);

	private Integer status;

	EducationStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}
}
