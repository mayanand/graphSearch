import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class inputParser {


	private String filePath;
	private int totalTestCases = 0;

	public inputParser(String filePath){
		this.filePath = filePath;
	}

	public List parse(String file) {

		BufferedReader br = null;
		List<List<String>> testCasesList = new ArrayList<List<String>>();
		List<String> algoTypes = new ArrayList<String>();
		algoTypes.add("UCS");
		algoTypes.add("BFS");
		algoTypes.add("DFS");
		//HashMap<String, ArrayList<edge>> adjLists_dict = new HashMap<String, ArrayList<edge>>();


		try {
			String sCurrentLine;
			String fileName = filePath;

			br = new BufferedReader(new FileReader(fileName));

			ArrayList<String> tCase = null;

			while ((sCurrentLine = br.readLine()) != null) {
				//System.out.println(sCurrentLine);
				if (totalTestCases == 0){
					totalTestCases = Integer.parseInt(sCurrentLine);
				}
				else if (algoTypes.contains(sCurrentLine.trim())){
					//clear the arraylist for new test case here
					if (tCase != null){
						testCasesList.add(tCase);
					}
					tCase = new ArrayList<String>();
					tCase.add(sCurrentLine);
				}
				else{
					//add the test cases to arraylist here
					tCase.add(sCurrentLine.trim());
				}

			}
			//adding the last test case to outer arraylist
			testCasesList.add(tCase);
			//System.out.println(testCasesList);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		//taking care of the blank line between after every case
		for (List<String> tc : testCasesList){
			if (tc.get(tc.size() - 1).isEmpty()){
				tc.remove(tc.size() - 1);
			}
		}
//		System.out.println(testCasesList);
		return testCasesList;

	}	


}


