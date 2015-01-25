package server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parser {
	
	
	/* 
	 * Idé for klassen:
	 * 
	 * Vi må parse hver tekstfil i datasettet slik at vi kan poste det i Populator.java.
	 * Jeg tenkte at det smarteste kanskje kunne være å introdusere vårt eget hjelpeobjekt "NsfDocument".
	 * Og så bygge det underveis som vi leser filen, for så å mappe det til et SolrDocument i Populator-klassen.
	 * 
	 * Tekstfilen er et helvete å parse. Det er vrient å bare splitte på : da noen titler og slikt inneholder både
	 * en og to ':'.
	 * 
	 * Jeg har prøvd meg på en liste med keywords også delt opp derfra. Den er veldig stygg, så hvis noen har bedre ideer hadde det vært flott.
	 * 
	 */
	
	private String[] keywords = {"Title", "Type", "NSF Org", "Latest Amendment Date", "File", "Award Number", "Award Instr.", "Prgm Manager", "Start Date", "Expires", "Expected Total Amt.", "Investigator", "Sponsor", "NSF Program", "Fld Applictn", "Program Ref", "Abstract"};
	
	public NsfDocument readFile(File filename){
		BufferedReader reader;
		NsfDocument doc = new NsfDocument();
		//HashMap<String, String> rec = new HashMap<String, String>();
		
		boolean first_line = true;
		
		try {
			String line;
			String cumulative_lines = "";

			int keyword_position = 1;
			String current_keyword = keywords[0];
			String next_keyword = keywords[1];
			
			reader = new BufferedReader(new FileReader(filename));
			while ((line = reader.readLine()) != null)
		    {
				
				if(first_line){
					int index_of_split = line.indexOf(":");
					String title = line.substring(index_of_split + 1).trim().replaceAll(" +", " ");
					cumulative_lines += title;
					first_line = false;
					continue;	
				}
			
				// Dritstygg logikk for å bare komme gjennom en tekstfil. Fucka format.
				if(line.startsWith(next_keyword) || cumulative_lines.trim().contains(next_keyword) || line.equals("Latest") || line.equals("Expected")){
										
					if(current_keyword.equals(keywords[3]) || current_keyword.equals(keywords[10])){
						int index_of_split = cumulative_lines.indexOf(":");
						String value = cumulative_lines.substring(index_of_split+1).trim().replaceAll(" +", " ");
						//rec.put(current_keyword, value);
						doc.mapToNsfDocumentObject(current_keyword, value);
					}
					else{
						//rec.put(current_keyword, cumulative_lines.replaceAll(" +", " "));
						doc.mapToNsfDocumentObject(current_keyword, cumulative_lines.replaceAll(" +", " "));

					}
					
					cumulative_lines = "";
					
					current_keyword = next_keyword;
					if (keyword_position < keywords.length - 1){
						next_keyword = keywords[keyword_position + 1];
					}
					
					int index_of_split = line.indexOf(":");
					String value = line.substring(index_of_split+1).trim();
					cumulative_lines += value;
					//System.out.println(value);

					keyword_position ++;
				}

				else {
					cumulative_lines += " " + line.trim();
					//System.out.println(cumulative_lines);
				}
		    }
		    reader.close();
			//rec.put(current_keyword, cumulative_lines);
			doc.mapToNsfDocumentObject(current_keyword, cumulative_lines);

		} catch (FileNotFoundException e) {
			System.out.println("File not found: '" + filename + "'");
		    e.printStackTrace();
		    return null;
		} catch (IOException e) {
			System.out.println("Exception occurred trying to read '" + filename + "'");
		    e.printStackTrace();
		    return null;
		}
		//parseListToDocument(records);

		//for(String key : rec.keySet()){
		//	System.out.println(key + ":" + rec.get(key));	
		//}
		return doc;
	}

}
