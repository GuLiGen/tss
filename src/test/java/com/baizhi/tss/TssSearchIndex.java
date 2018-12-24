package com.baizhi.tss;

import com.baizhi.tss.service.PoetryService;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.nio.file.Paths;

public class TssSearchIndex {
    @Autowired
    private PoetryService poetryService;
    @Test
    public void test1() throws IOException, ParseException {
        FSDirectory fsDirectory = FSDirectory.open(Paths.get("F:\\index\\08"));
        IndexReader indexReader = DirectoryReader.open(fsDirectory);

        IndexSearcher indexSearcher = new IndexSearcher(indexReader);

        QueryParser queryParser = new QueryParser("content", new IKAnalyzer());

        Query query = null;

        query = queryParser.parse("鹅鹅鹅");

        TopDocs topDocs = indexSearcher.search(query, 1000);

        ScoreDoc[] scoreDocs = topDocs.scoreDocs;

        for (ScoreDoc scoreDoc : scoreDocs) {
            int docID = scoreDoc.doc;
            Document document = indexReader.document(docID);

            System.out.println(
                    scoreDoc.score + " |" +
                            document.get("id") + " |" +
                            document.get("title") + " |" +
                            document.get("content") + " |" +
                            document.get("author")
            );
        }
        indexReader.close();
    }
    @Test
    public void m1(){

    }
}
