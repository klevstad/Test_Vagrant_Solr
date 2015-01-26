package client;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Searcher {
  
	public static void main(String[] args) throws MalformedURLException, SolrServerException {
	    HttpSolrServer solr = new HttpSolrServer("http://localhost:8983/solr");
	
	    SolrQuery query = new SolrQuery();
	    query.setQuery("*");
	    query.setFilterQueries("April", "1992");
	    query.setStart(0); //Startrad
	    query.setRows(15); //maksrad
	    query.setHighlight(true).setHighlightSnippets(1);
	    query.setParam("hl.fl", "latest_amendment_date");

	    QueryResponse response = solr.query(query);
	    SolrDocumentList results = response.getResults();
	    for (int i = 0; i < results.size(); ++i) {
	      System.out.println(results.get(i));
	    }
	    /*
	    Iterator<SolrDocument> iter = response.getResults().iterator();

	    while (iter.hasNext()) {
	      SolrDocument resultDoc = iter.next();
	      
	      String id = (String) resultDoc.getFieldValue("id");
	      
	      
	      //String id = (String) resultDoc.getFieldValue("id"); //id is the uniqueKey field
	      if (response.getHighlighting().get(id) != null) {
	    	  List<String> highlightSnippets = response.getHighlighting().get(id).get("title");
	    	  System.out.println(highlightSnippets.size());
	    	  
	      }
	      
	      
	    }*/
	}
}