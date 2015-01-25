package test_1;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

import java.net.MalformedURLException;



public class Searcher {
  
	public static void main(String[] args) throws MalformedURLException, SolrServerException {
	    HttpSolrServer solr = new HttpSolrServer("http://localhost:8983/solr");
	
	    SolrQuery query = new SolrQuery();
	    query.setQuery("the hobbit book-104");
	    //query.setFields("id","price","merchant","cat","store");
	    query.setFilterQueries("id:book-101");
	    query.setStart(0); //Startrad
	    query.setRows(15); //maksrad
	    //query.set("defType", "edismax");
	
	    QueryResponse response = solr.query(query);
	    SolrDocumentList results = response.getResults();
	    for (int i = 0; i < results.size(); ++i) {
	      System.out.println(results.get(i));
    }
  }
}