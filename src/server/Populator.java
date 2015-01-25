package server;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;

public class Populator {
	
	private final static File folder = new File(".//datasets//Part1");

	public static void main(String[] args) throws IOException, SolrServerException {
		
		Parser parser = new Parser();
		Populator populator = new Populator();
		
		ArrayList<File> textfiles = populator.listFilesForFolder(folder, new ArrayList<File>());
		
		HttpSolrServer server = new HttpSolrServer("http://localhost:8983/solr");
		
	    //for(int i = 0; i < textfiles.size(); i ++) {
		for(int i = 0; i < 100; i ++) {

			NsfDocument nsf = parser.readFile(textfiles.get(i));
			SolrInputDocument document = populator.mapNsfDocumentToSolrDocument(nsf, i);

			
			if (document == null){
				continue;
			}
	    	server.add(document);
	    	if(i % 100 == 0) {
	    		server.commit();  // periodically flush
	    	}
	    }
	    System.out.println("It all went well. What the fuck.");
	    server.commit();
    }
	
	private SolrInputDocument mapNsfDocumentToSolrDocument(NsfDocument nsfDocument, int id){
		SolrInputDocument solrDocument = new SolrInputDocument();
		
		if(nsfDocument == null){
			return solrDocument;
		}
		solrDocument.addField("id", id);
		solrDocument.addField("title", nsfDocument.getM_title());
		
		//solrDocument.addField("type", nsfDocument.getM_type());
		solrDocument.addField("cat", nsfDocument.getM_nsf_org());
		/*
		 * solrDocument.addField("latest_amendment_date", nsfDocument.getM_latest_amendment_date());
		solrDocument.addField("file", nsfDocument.getM_file());
		solrDocument.addField("award_number", nsfDocument.getM_award_number());
		solrDocument.addField("award_instr", nsfDocument.getM_award_instr());
		solrDocument.addField("prgm_manager", nsfDocument.getM_prgm_manager());
		solrDocument.addField("start_date", nsfDocument.getM_start_date());
		solrDocument.addField("expires", nsfDocument.getM_expires());
		solrDocument.addField("expected_total_amt", nsfDocument.getM_expected_total_amt());
		solrDocument.addField("investigator", nsfDocument.getM_investigator());
		solrDocument.addField("sponsor", nsfDocument.getM_sponsor());
		solrDocument.addField("nsf_program", nsfDocument.getM_nsf_program());
		solrDocument.addField("fld_applictn", nsfDocument.getM_fld_applictn());
		solrDocument.addField("program_ref", nsfDocument.getM_program_ref());
		solrDocument.addField("_abstract", nsfDocument.getM_abstract());
		 */
		return solrDocument;
	}
	
	private ArrayList<File> listFilesForFolder(final File folder, ArrayList<File> listOfFiles) {
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry, listOfFiles);
	        } else {
	        	listOfFiles.add(fileEntry);
	        }
	    }
	    return listOfFiles;
	}

}
