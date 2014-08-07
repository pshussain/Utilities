package com.pocketmath.lucene;

import java.io.IOException;

import org.apache.lucene.queryParser.ParseException;

public interface LuceneSearch {
	public void index(String contentFile,String formatFile) throws IOException;
	public void search(String query) throws ParseException, IOException;
}
