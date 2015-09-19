package waterFlow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class UCS {

	public static void main(String[] args) {
		HashMap<String, ArrayList<edge>> adjLists_dict = new HashMap<String, ArrayList<edge>>();

		//Create an arraylist of all nodes
		ArrayList<String> nodeList = new ArrayList<String>();
		nodeList.add("AA");
		nodeList.add("BA");
		nodeList.add("CA");
		nodeList.add("DA");
		
		for (String temp : nodeList) {
	//		System.out.println(temp);
			adjLists_dict.put(temp, new ArrayList<edge>());
		}

		adjLists_dict.get("AA").add(new edge("BA", 10, "1-2"));
		adjLists_dict.get("AA").add(new edge("CA", 2, "3-4,5-6"));
		adjLists_dict.get("CA").add(new edge("BA", 4, ""));
		
		String start = "AA";
		int startTime = 0;
		ArrayList<String> goals = new ArrayList<String>();
		goals.add("BA");
		
		unifromCostSearch(start, startTime, adjLists_dict, goals);


	}
	
	static String unifromCostSearch(String start, int startTime, HashMap graph, ArrayList<String> goals){
		
		ArrayList<String> explored = new ArrayList<String>();
		String currentNode = start;
		
		Node currentObj = new Node(currentNode, 0);
		HashMap<String, Integer> frontierValues = new HashMap<String, Integer>();
		
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(10);
		frontier.add(currentObj);
		frontierValues.put(currentNode, 0);
		
		System.out.println(frontier);
		
		
		
		/*if (goals.contains(currentNode)){
			return "Success with path";
		}*/
		do {
			if (frontier.isEmpty()){
				return "Failure";
			}
			
			currentObj = frontier.poll();
			currentNode = currentObj.getNodeName();
			frontierValues.remove(currentNode);		//remove the values from frontier once they are popped
			
			//check if the popped item satisfies the goal
			if (goals.contains(currentNode)){
				System.out.println("Solution found "+ currentNode);
				return ("Solution found: " + currentNode);
			}
			
			//adding the last tested node to explored
			explored.add(currentNode);
					
			//we look to expand the current node now
			ArrayList<edge> currentAdjList = (ArrayList<edge>)graph.get(currentNode);				
			ArrayList<String> children = new ArrayList<String>();
			
			// listing out all the children of current node
			for (edge adj : currentAdjList){
				System.out.println("!!!!children of current node: "+adj.getDest());
				
				//Need to check if the node is already in the frontier or explored
				//if it is in explored then dont add feed this node to frontier
				//if it is in frontier then check if the distance is lower, in that case delete the older node and ad the new one.
				//if it is in neither the just add this node to priority queue
				frontier.add(new Node(adj.getDest(), adj.getCost()));
				frontierValues.put(adj.getDest(), adj.getCost());

				System.out.println("Priority queue minimum now: "+ frontier.peek().getNodeName() + frontier.peek().getSrcDistance());
			}
			
		}while(!frontier.isEmpty());
		System.out.println("No solution to this problem");
		return "Solution is none";
	}
}
