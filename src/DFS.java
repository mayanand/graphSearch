

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

public class DFS {
	//finding the cost logic is pending
	public static void main(String[] args) {
		HashMap<String, ArrayList<edge>> adjLists_dict = new HashMap<String, ArrayList<edge>>();

		//Create an arraylist of all nodes
		ArrayList<String> nodeList = new ArrayList<String>();
		nodeList.add("P");
		nodeList.add("L");
		nodeList.add("N");
		nodeList.add("M");
		nodeList.add("Q");
		nodeList.add("O");
		nodeList.add("R");
		
		for (String temp : nodeList) {
	//		System.out.println(temp);
			adjLists_dict.put(temp, new ArrayList<edge>());

		}

		adjLists_dict.get("P").add(new edge("L", 10, ""));
		adjLists_dict.get("P").add(new edge("N", 5, "2-3,6-9"));
		adjLists_dict.get("N").add(new edge("M", 5, "1-2"));
		adjLists_dict.get("M").add(new edge("Q", 8, "4-6"));
		adjLists_dict.get("O").add(new edge("R", 6, ""));
		
		String start = "P";
		int startTime = 5;
		ArrayList<String> goals = new ArrayList<String>();
		goals.add("Q");
		goals.add("R");
		
		depthFirstSearch(start, startTime, adjLists_dict, goals);


	}
	
	static String depthFirstSearch(String start, int startTime, HashMap graph, ArrayList<String> goals){
		
		ArrayList<String> explored = new ArrayList<String>();
		
		Stack<String> frontier = new Stack<String>();
		frontier.push(start);
		String currentNode = start;
		
		if (goals.contains(currentNode)){
			return "Success with path";
		}
		do {
			if (frontier.isEmpty()){
				return "Failure";
			}
			else{
				//adding the last tested node to explored
				explored.add(currentNode);
				
				//popping an element from array to test for goal
				currentNode = frontier.pop();
				
				//do the goal test now
				if (goals.contains(currentNode)){
					System.out.println("!!!Solution found: " + currentNode);
					return "!!!Solution found: " + currentNode;
				}
				//System.out.println("this is the current node " +currentNode);

				//we look to expand the current node now
				ArrayList<edge> currentAdjList = (ArrayList<edge>)graph.get(currentNode);				
				ArrayList<String> children = new ArrayList<String>();
				
				// listing out all the children of current node
				for (edge adj : currentAdjList){
					System.out.println("children of current node: "+adj.getDest());
					children.add(adj.getDest());
				} 
				System.out.println("unorderd: "+ children);
				Collections.sort(children, Collections.reverseOrder());
				System.out.println("revere orderd: "+ children);
				
				for (String child : children){
					if (!frontier.contains(child) || !(explored.contains(child))){
						if (goals.contains(child)){
							System.out.println("!!!Solution found: " + child);
							return "!!!Solution found: " + child;
						}
					}
					frontier.add(child);
				}
				System.out.println("frontier now: " + frontier);
			}
			
		}while(!frontier.isEmpty());
		System.out.println("No solution to this problem");
		return "Solution is none";
	}
}
