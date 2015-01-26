package client;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.List;

public class Searcher {
  
	public static void main(String[] args) throws MalformedURLException, SolrServerException {
	    HttpSolrServer solr = new HttpSolrServer("http://localhost:8983/solr");
	    
	    String q = "dinosaur";
	    
	    SolrQuery query = new SolrQuery();
	    query.setQuery(q); // title:dinosaur vil kun søke i titler f.eks
	    //query.setFilterQueries(""); https://wiki.apache.org/solr/CommonQueryParameters
	    //query.setFields("title"); //Her settes hvilke felt vi vil returnere i dokumentet. Blank er alt.
	    query.setStart(0); //Startrad
	    query.setRows(15); //maksrad
	    query.setHighlight(true).setHighlightSnippets(1);
	    query.setParam("hl.fl", "title");
	    query.setParam("hl.simple.pre", "<em>");
	    query.setParam("hl.simple.post", "</em>");
	    query.setParam("hl.fragsize", "100");

	    QueryResponse response = solr.query(query);
	    
	    Iterator<SolrDocument> iter = response.getResults().iterator();

	    while (iter.hasNext()) {
	      SolrDocument resultDoc = iter.next();
	      String id = (String) resultDoc.getFieldValue("id");
	      
	      System.out.println("Found " + q + " in " + resultDoc);
	      
	      if (response.getHighlighting().get(id) != null) {
	    	  List<String> highlightSnippets = response.getHighlighting().get(id).get("title");
	    	  if (highlightSnippets != null){
	    		  System.out.println("Applied highlighting: " + highlightSnippets);
	    	  }
	      }
	    }
	}
}