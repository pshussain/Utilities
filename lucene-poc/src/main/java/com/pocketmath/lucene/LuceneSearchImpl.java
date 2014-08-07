package com.pocketmath.lucene;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.lucene.analysis.WhitespaceAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.MMapDirectory;
import org.apache.lucene.store.NIOFSDirectory;
import org.apache.lucene.util.Version;

import com.pocketmath.lucene.helper.LuceneField;
import com.pocketmath.lucene.helper.Util;

public class LuceneSearchImpl implements LuceneSearch {
	
	private static final WhitespaceAnalyzer ANALYZER = new WhitespaceAnalyzer(
			Version.LUCENE_34);
	IndexWriterConfig config;
	IndexWriter writer;
	IndexReader reader;
	IndexSearcher searcher;
	private Directory indexDir;
	private File indexDirPath;

	public LuceneSearchImpl(String indexPath) throws IOException {
		this.indexDirPath = new File(indexPath);
		config = new IndexWriterConfig(Version.LUCENE_34,
				new WhitespaceAnalyzer(Version.LUCENE_34));
		config.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
		indexDir = new NIOFSDirectory(this.indexDirPath);
		writer = new IndexWriter(indexDir, config);
		openInMemory(indexPath);
		reader = IndexReader.open(indexDir);
		searcher = new IndexSearcher(reader); 
	}

	public void index(String contentFile, String formatFile) throws IOException {
		FileUtils.deleteDirectory(this.indexDirPath);
		System.out.println("Deleted the old Index files.");
		final long start = System.currentTimeMillis();
		LuceneField[] luceneFields = Util.getDocumentFieldInfo(formatFile);
		final FileInputStream fis = new FileInputStream(contentFile);
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		final BufferedReader reader = new BufferedReader(isr);
		String line = null;
		int lineCount = 0;
		try {

			while ((line = reader.readLine()) != null) {
				addDocument(writer, line, luceneFields);
				lineCount++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			reader.close();
			isr.close();
			fis.close();
		}
		writer.optimize();
		writer.close();
		System.out.println("Created Index of " + lineCount + " lines in "
				+ (System.currentTimeMillis() - start) + " ms");
	}

	public void search(String query)
			throws org.apache.lucene.queryParser.ParseException, IOException {
		
		TopDocs docs = null;
		try {
			Query qry = new QueryParser(Version.LUCENE_34, "", ANALYZER)
					.parse(query);
			docs = searcher.search(qry, 10);

			final ScoreDoc[] matched = docs.scoreDocs;

			int len = matched.length;
			System.out.println(len);
			final ArrayList<Document> docList = new ArrayList<Document>(len);

			for (int i = 0; i < len; i++) {
				docList.add(searcher.doc(matched[i].doc));
			}

			for (Document doc : docList) {
				System.out.println(doc.get("name"));
			}
		} catch (org.apache.lucene.queryParser.ParseException pe) {

		} catch (Throwable t) {
		}
	}

	

	private void addDocument(IndexWriter writer, String line,
			LuceneField[] fields) throws CorruptIndexException, IOException {
		final String[] eachLine = StringUtils.splitPreserveAllTokens(line, ",");
		for (int i = 0; i < fields.length; i++) {
			Document doc = new Document();
			doc.add(new Field(fields[i].name, Util.removeSpaceInString(eachLine[i]), fields[i].store,
					fields[i].index));
			writer.addDocument(doc);

		}

	}

	private void openInMemory(String dirPath) throws IOException {
		this.indexDir = new MMapDirectory(new File(dirPath));
		((MMapDirectory) indexDir).setUseUnmap(true);
	}
}
