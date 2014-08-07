package com.pocketmath.lucene.helper;

import org.apache.commons.lang.StringUtils;
import org.apache.lucene.document.Field;

public class LuceneField {
	public final String name;
	public final Field.Index index;
	public final Field.Store store;

	public LuceneField(String line, String sep) {
		final String[] values = StringUtils.split(line, sep);
		name = values[0];
		if (values[1].equals("NOT_ANALYZED"))
			index = Field.Index.NOT_ANALYZED;
		else
			index = Field.Index.ANALYZED;

		if (values[2].equals("YES"))
			store = Field.Store.YES;
		else
			store = Field.Store.NO;

	}
}
