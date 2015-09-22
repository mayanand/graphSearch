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
		//HashMap<String, ArrayList<edge>> adjLists_dict = new HashMap<String, ArrayList<edge>>();


		try {
			String sCurrentLine;
			String fileName = filePath;

			br = new BufferedReader(new FileReader(fileName));

			ArrayList<String> tCase = new ArrayList<String>();			
			Boolean newCase = true;

			while ((sCurrentLine = br.readLine()) != null) {
				//System.out.println(sCurrentLine);
				if (totalTestCases == 0){
					totalTestCases = Integer.parseInt(sCurrentLine);
				}
				else if (sCurrentLine.trim().isEmpty()){
					//clear the arraylist for new test case here

					testCasesList.add(tCase);
					newCase = true;
					tCase = new ArrayList<String>();

				}
				else{
					//add the test cases to arraylist here
					newCase = false;
					tCase.add(sCurrentLine);
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
		return testCasesList;

	}	


}


/*Writer writer = null;

		try {
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("output.txt"), "utf-8"));
			writer.write("B 4\n");
			writer.write("Q 8\n");
			writer.write("BA 6");
		} catch (IOException ex) {
			// report
			System.out.println("got to report somemthing it seems");
		} finally {
			try {writer.close();} catch (Exception ex) {ignore}
		}
 */
