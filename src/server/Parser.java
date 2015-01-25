package server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.solr.common.SolrInputDocument;

public class Parser {
	
	private String[] keywords = {"Title", "Type", "kj"};
	
	
	public static void main(String[] args) {
		
		String filename = "testfile.txt";
		File file = new File(filename);
		Parser parser = new Parser();
		
		ArrayList<String> myList = parser.readFile(file);
		
		String x = "s";
		
		
	}
	
	
	public ArrayList<String> readFile(File filename){
		BufferedReader reader;
		
		NsfDocument doc = new NsfDocument();
		
		ArrayList<String> records = new ArrayList<String>();
		
		String splitter = ":";
		
		try {
			String line;
			reader = new BufferedReader(new FileReader(filename));
			while ((line = reader.readLine()) != null)
		    {
				String[] list = line.split(" ");
				if (list.length > 1){
					String first_word = line.split(" ")[0];
					String second_word = line.split(" ")[1];
					System.out.println(first_word + " " + second_word);
				}
				else{
					System.out.println(list[0]);
				}
			
				if (line.contains(splitter)){
					String[] asd = line.split(splitter);
					//String key = asd[0];
					//String value = asd[1];
				}
				
				records.add(line);
		    }
		    reader.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found: '" + filename + "'");
		    e.printStackTrace();
		    reader = null;
		} catch (IOException e) {
			System.out.println("Exception occurred trying to read '" + filename + "'");
		    e.printStackTrace();
		    reader = null;
		}
		parseListToDocument(records);
		return records;
	}
	
	
	public SolrInputDocument parseListToDocument(ArrayList<String> records){
		SolrInputDocument doc = new SolrInputDocument();
		
		for(String item: records){
			System.out.println("-" + item);
			
		}

		return doc;
	}


}
