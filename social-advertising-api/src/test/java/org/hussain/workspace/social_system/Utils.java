package org.hussain.workspace.social_system;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Utils {
	public static void main(String[] args) {
		List<Integer> names = new ArrayList<Integer>();
        names.add(1);
        names.add(2);
        names.add(3);
        names.add(4);
        Gson gson = new Gson();
        String jsonStudents = gson.toJson(names);
        System.out.println("jsonStudents = " + jsonStudents);
	}
}
