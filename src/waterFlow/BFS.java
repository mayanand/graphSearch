package waterFlow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import javax.print.DocFlavor.STRING;

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
		
		String start = "A";
		int startTime = 3;
		ArrayList<String> goals = new ArrayList<String>();
		goals.add("B");
		goals.add("D");
		goals.add("C");
		
		
		breadthFirstSearch(start, startTime, adjLists_dict, goals);


	}
	
	static String breadthFirstSearch(String start, int startTime, HashMap graph, ArrayList<String> goals){
		
		ArrayList<String> explored = new ArrayList<String>();
		//System.out.println("starttime: "+startTime);
		//System.out.println(graph);
		Queue<String> frontier=new LinkedList<String>();
		
		frontier.add(start);
		String currentNode = start;
		
		if (goals.contains(currentNode)){
			return "Success with path";
		}
		if (frontier.isEmpty()){
			return "Failure";
		}
		else{
			currentNode = frontier.poll();
			explored.add(currentNode);
			//do the goal test now
			System.out.println("this is teh current node " +currentNode);
			System.out.println(graph.get(currentNode).getClass().getName());
			ArrayList<edge> currentAdjList = (ArrayList<edge>)graph.get(currentNode);
			
			for (edge adj : currentAdjList){
				System.out.println(adj.getDest());
			} 
			return "Working on this";
		}
		
		
		/*System.out.println(goals.contains("A"));
		System.out.println(goals.contains("B"));
        myQ.add(1);
        myQ.add(6);
        myQ.add(3);
        System.out.println(myQ); //1 6 3
        int first=myQ.poll();// retrieve and remove the first element
        System.out.println(first);//1
        System.out.println(myQ);//6 3
        */
		
		
		
		
		
	}
}
