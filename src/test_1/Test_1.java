package test_1;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;

public class Test_1 {
	
	
	public static void main(String[] args) throws IOException, SolrServerException {
		HttpSolrServer server = new HttpSolrServer("http://localhost:8983/solr");
	    for(int i = 0; i < 1000; ++i) {
	    	SolrInputDocument doc = new SolrInputDocument();
	    	doc.addField("cat", "book");
	    	doc.addField("id", "book-" + i);
	    	doc.addField("name", "The Legend of the Hobbit part " + i);
	    	server.add(doc);
	    	if(i % 100 == 0) {
	    		server.commit();  // periodically flush
	    	}
	    }
	    System.out.println("donw");
	    server.commit();
    }
	
	
	private void addDocument() {
		
	}

}
