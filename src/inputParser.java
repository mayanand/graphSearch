import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class inputParser {

	
	private String filePath;
	
	public inputParser(String filePath){
		this.filePath = filePath;
		System.out.println("$$$$$$$$$$$reached inside parser");
	}
	
	public HashMap parse(String file) {
		
	
	BufferedReader br = null;
	HashMap<String, ArrayList<edge>> adjLists_dict = new HashMap<String, ArrayList<edge>>();


	try {
		String sCurrentLine;
		String currentDir = System.getProperty("user.dir");
		String fileName = currentDir + "/" + filePath;
		System.out.println(fileName);

		br = new BufferedReader(new FileReader(fileName));

		while ((sCurrentLine = br.readLine()) != null) {
			System.out.println(sCurrentLine);
		}

	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		try {
			if (br != null)br.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	return adjLists_dict;

	}	
	
	
}
