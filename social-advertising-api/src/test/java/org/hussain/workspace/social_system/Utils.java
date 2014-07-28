package org.hussain.workspace.social_system;

import java.util.ArrayList;
import java.util.List;

import org.hussain.workspace.builders.facebook.targeting.Demographic;
import org.hussain.workspace.builders.facebook.targeting.Location;
import org.hussain.workspace.builders.facebook.targeting.Mobile;

import com.google.gson.Gson;

public class Utils {
	public static void main(String[] args) {
		// List<Integer> names = new ArrayList<Integer>();
		// names.add(1);
		// names.add(2);
		// names.add(3);
		// names.add(4);
		// Gson gson = new Gson();
		// String jsonStudents = gson.toJson(names);
		// System.out.println("jsonStudents = " + jsonStudents);
		Location loc = new Location();
		loc.addCountry("US");
		loc.addCountry("UK");
		loc.addCity("2430536", 12, "mile");
		loc.addCity("123456", 100, "km");
		loc.addRegion("3847");
		loc.addZipcode("US", "94304");
		// System.out.println(loc.makeLocation());

		Mobile mobile = new Mobile();
		mobile.addDevice("samsung_galaxy_note_10.1_2014");
		mobile.addDevice("htc_one_2013");
		mobile.addOS("android");
		System.out.println(mobile.makeMobile());

		Demographic demo = new Demographic();
		demo.addGender(1);
		demo.setMaxAge("10");
		demo.setMinAge("1");
		// System.out.println(demo.makeDemographic());

	}
}
