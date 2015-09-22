

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
		
		
		System.out.println(adjLists_dict);
		
		unifromCostSearch(start, startTime, adjLists_dict, goals);


	}
	
	static String unifromCostSearch(String start, int startTime, HashMap graph, ArrayList<String> goals){
		
		ArrayList<String> explored = new ArrayList<String>();
		String currentNode = start;
		
		Node currentObj = new Node(currentNode, 0);
		HashMap<String, Integer> frontierValues = new HashMap<String, Integer>();
		int currentNodeSrcCost;
		
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(10);
		frontier.add(currentObj);
		frontierValues.put(currentNode, 0);
		
		System.out.println(frontier);
		
		do {
			if (frontier.isEmpty()){
				return "Failure";
			}
			
			currentObj = frontier.poll();
			currentNode = currentObj.getNodeName();
			currentNodeSrcCost = currentObj.getSrcDistance();
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
				//if it is in neither the just add this node to priority queue
				
				//Need to check if the node is already in explored
				if (explored.contains(adj.getDest())){
					//if it is in explored then dont add feed this node to frontier
					System.out.println("This node has already been explored");
				}
				//Need to check if the node is already in the frontier
				else if (frontierValues.get(adj.getDest()) != null){
					 int existingCost = frontierValues.get(adj.getDest());
					 int newCost = currentNodeSrcCost + adj.getCost();	//combined cost of parent and child node
					//check if the distance is lower, in that case delete the older node and add the new one.
					 if (existingCost > newCost){
						 //remove the existing node object from priority list and add the new one
						 Iterator<Node> iter = frontier.iterator();
						 while (iter.hasNext()) {
						     Node current = iter.next();
						     /*System.out.println("!!!!!!!!!!!!!!!!!!1");
						     System.out.println(current.getNodeName());*/
						     if (current.getNodeName() == adj.getDest()){
						    	 System.out.println("Node name: "+ current.getNodeName()+ adj.getDest());
						    	 System.out.println(current.getSrcDistance());
						    	 System.out.println(adj.getCost());
							     frontier.remove(current);
							     frontierValues.replace(adj.getDest(), adj.getCost());
								 frontier.add(new Node(adj.getDest(), adj.getCost()));
								 break;
						     }
						 }						 
					 }
				}
				else{
					frontier.add(new Node(adj.getDest(), adj.getCost()));
					frontierValues.put(adj.getDest(), adj.getCost());	
					System.out.println("Priority queue minimum now: "+ frontier.peek().getNodeName() + frontier.peek().getSrcDistance());
				}
			}
			
		}while(!frontier.isEmpty());
		System.out.println("No solution to this problem");
		return "Solution is none";
	}
}
