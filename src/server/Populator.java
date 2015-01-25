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
		
	    for(int i = 0; i < textfiles.size(); i ++) {
			NsfDocument nsf = parser.readFile(textfiles.get(i));
			SolrInputDocument document = populator.mapNsfDocumentToSolrDocument(nsf);
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
	
	private SolrInputDocument mapNsfDocumentToSolrDocument(NsfDocument nsfDocument){
		SolrInputDocument solrDocument = new SolrInputDocument();
		
		if(nsfDocument == null){
			return solrDocument;
		}
		
		solrDocument.addField(NsfDocument.TITLE, nsfDocument.getM_title());
		solrDocument.addField(NsfDocument.TYPE, nsfDocument.getM_type());
		solrDocument.addField(NsfDocument.NSF_ORG, nsfDocument.getM_nsf_org());
		solrDocument.addField(NsfDocument.LATEST_AMENDMENT_DATE, nsfDocument.getM_latest_amendment_date());
		solrDocument.addField(NsfDocument.FILE, nsfDocument.getM_file());
		solrDocument.addField(NsfDocument.AWARD_NUMBER, nsfDocument.getM_award_number());
		solrDocument.addField(NsfDocument.AWARD_INSTR, nsfDocument.getM_award_instr());
		solrDocument.addField(NsfDocument.PRGM_MANAGER, nsfDocument.getM_prgm_manager());
		solrDocument.addField(NsfDocument.START_DATE, nsfDocument.getM_start_date());
		solrDocument.addField(NsfDocument.EXPIRES, nsfDocument.getM_expires());
		solrDocument.addField(NsfDocument.EXPECTED_TOTAL_AMT, nsfDocument.getM_expected_total_amt());
		solrDocument.addField(NsfDocument.INVESTIGATOR, nsfDocument.getM_investigator());
		solrDocument.addField(NsfDocument.SPONSOR, nsfDocument.getM_sponsor());
		solrDocument.addField(NsfDocument.NSF_PROGRAM, nsfDocument.getM_nsf_program());
		solrDocument.addField(NsfDocument.FLD_APPLICTN, nsfDocument.getM_fld_applictn());
		solrDocument.addField(NsfDocument.PROGRAM_REF, nsfDocument.getM_program_ref());
		solrDocument.addField(NsfDocument.ABSTRACT, nsfDocument.getM_abstract());

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
