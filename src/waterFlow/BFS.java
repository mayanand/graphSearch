package waterFlow;

import java.util.ArrayList;
import java.util.HashMap;

public class BFS {

	public static void main(String[] args) {
		HashMap<String, ArrayList<edge>> adjLists_dict = new HashMap<String, ArrayList<edge>>();

		//Create an arraylist of all nodes
		ArrayList<String> nodeList = new ArrayList<String>();
		nodeList.add("A");
		nodeList.add("B");
		nodeList.add("C");
		nodeList.add("D");
		nodeList.add("E");
		nodeList.add("F");
		nodeList.add("G");
		nodeList.add("H");
		nodeList.add("I");

		for (String temp : nodeList) {
	//		System.out.println(temp);
			adjLists_dict.put(temp, new ArrayList<edge>());

		}

		adjLists_dict.get("A").add(new edge("B", 12, ""));
		adjLists_dict.get("A").add(new edge("E", 3, "2-4,1-5,9-10"));
		adjLists_dict.get("E").add(new edge("H", 2, "1-2"));
		adjLists_dict.get("H").add(new edge("D", 5, "5-6,2-3"));
		adjLists_dict.get("I").add(new edge("C", 6, "10-14"));


	}
}
