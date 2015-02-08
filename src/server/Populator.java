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
		ArrayList<File> textfiles = listFilesForFolder(folder, new ArrayList<File>());
		System.out.println("Number of files in Part1: " + textfiles.size());
		HttpSolrServer server = new HttpSolrServer("http://localhost:8983/solr");

	    //for(int i = 0; i < textfiles.size(); i ++) {
		long t1 = System.currentTimeMillis();
		for(int i = 0; i < 500; i ++) {

			NsfDocument nsf = Parser.parseFile(textfiles.get(i));
			SolrInputDocument document = mapNsfDocumentToSolrDocument(nsf, i);

			if (document == null){
				continue;
			}
	    	server.add(document);
	    	if(i % 100 == 0) {
	    		server.commit();  // periodically flush
	    	}
	    }
		long t2 = System.currentTimeMillis();
		System.out.println("Time used populating: "+(t2-t1)+" ms.");
	    server.commit();
    }
	
	private static SolrInputDocument mapNsfDocumentToSolrDocument(NsfDocument nsfDocument, int id){
		SolrInputDocument solrDocument = new SolrInputDocument();
		
		if(nsfDocument == null){
			return solrDocument;
		}
		solrDocument.addField("id", id);
		solrDocument.addField("title", nsfDocument.getM_title());
		solrDocument.addField("_type_", nsfDocument.getM_type());
		solrDocument.addField("nsf_org", nsfDocument.getM_nsf_org());
		solrDocument.addField("latest_amendment_date", nsfDocument.getM_latest_amendment_date());
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
		solrDocument.addField("_abstract_", nsfDocument.getM_abstract());
		
		return solrDocument;
	}
	
	private static ArrayList<File> listFilesForFolder(final File folder, ArrayList<File> listOfFiles) {
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry, listOfFiles);
	        } else {
	        	if (fileEntry.getName().endsWith(".txt")) listOfFiles.add(fileEntry);
	        }
	    }
	    return listOfFiles;
	}

}
