package org.hussain.workspace.builders.facebook.targeting;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Country {
	private List<String> countries;

	public Country() {

		this.countries = new ArrayList<String>(10);
	}

	public String getCountries() {
		return new Gson().toJson(countries);
	}

	public void addCountries(String country) {
		this.countries.add(country);
	}

	public void setCountries(List<String> countries) {
		this.countries = countries;
	}

}
