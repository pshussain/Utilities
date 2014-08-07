package com.pocketmath.lucene.helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class Util {
	private static final Pattern SPACE_PATTERN = Pattern.compile(" ");

	public static String removeSpaceInString(String source) {
		return source.replaceAll(SPACE_PATTERN.pattern(), "");
	}

	public static LuceneField[] getDocumentFieldInfo(String formatFile)
			throws IOException {
		final BufferedReader reader = new BufferedReader(new FileReader(
				formatFile));
		String line = null;

		final List<LuceneField> list = new LinkedList<LuceneField>();
		try {
			while ((line = reader.readLine()) != null) {
				list.add(new LuceneField(line, ","));
			}
		} finally {
			reader.close();
		}

		return list.toArray(new LuceneField[] {});

	}
}
