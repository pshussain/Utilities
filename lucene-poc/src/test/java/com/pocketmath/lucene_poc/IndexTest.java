package com.pocketmath.lucene_poc;

import java.io.IOException;

import org.apache.lucene.queryParser.ParseException;
import org.junit.Before;
import org.junit.Test;

import com.pocketmath.lucene.LuceneSearchImpl;

public class IndexTest {
	LuceneSearchImpl lucene = null;

	@Before
	public void init() throws IOException {
		lucene = new LuceneSearchImpl("/Users/hussain/lucene/index");
		lucene.index("/Users/hussain/lucene/content/countries.csv",
				"/Users/hussain/lucene/content/countries_format.csv");
	}

//	@Test
//	@Before
	public void index() throws IOException, ParseException {
		lucene.index("/Users/hussain/lucene/content/countries.csv",
				"/Users/hussain/lucene/content/countries_format.csv");
//		lucene.search("name:hussain");
	}
	
	@Test
	public void searchExist() throws ParseException, IOException{
		lucene.search("name:India");
	}
	
	@Test
	public void searchNotExist() throws ParseException, IOException{
		lucene.search("name:Taiwan");
	}
	
	@Test
	public void searchInvalid() throws ParseException, IOException{
		lucene.search("name:-");
	}
	@Test
	public void searchNull() throws ParseException, IOException{
		lucene.search("name:null");
	}
}
