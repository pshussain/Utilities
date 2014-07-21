package org.hussain.workspace.builders.facebook.targeting;


public class City {
	private String key;
	private double radius;
	private String distance_mile;

	public City(String key, double radius, String distance_mile) {
		this.key = key;
		this.radius = radius;
		this.distance_mile = distance_mile;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public String getDistance_mile() {
		return distance_mile;
	}

	public void setDistance_mile(String distance_mile) {
		this.distance_mile = distance_mile;
	}
}
