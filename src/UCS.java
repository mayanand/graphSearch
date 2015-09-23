

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class UCS {

	/*public static void main(String[] args) {
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


	}*/

	String unifromCostSearch(String start, int startTime, HashMap<String, ArrayList<edge>> graph, List<String> goals){

		ArrayList<String> explored = new ArrayList<String>();
		String currentNode = start;

		Node currentObj = new Node(currentNode, 0);
		HashMap<String, Integer> frontierValues = new HashMap<String, Integer>();
		int currentNodeSrcCost;

		PriorityQueue<Node> frontier = new PriorityQueue<Node>(10);
		frontier.add(currentObj);
		frontierValues.put(currentNode, 0);

		//System.out.println(frontier);

		do {
			if (frontier.isEmpty()){
				return "None";
			}

			currentObj = frontier.poll();
			currentNode = currentObj.getNodeName();
			currentNodeSrcCost = currentObj.getSrcDistance();
			frontierValues.remove(currentNode);		//remove the values from frontier once they are popped

			//check if the popped item satisfies the goal
			if (goals.contains(currentNode)){
				int finishTime = startTime + currentObj.getSrcDistance();
				return (currentNode + " " + finishTime);
			}

			//adding the last tested node to explored
			explored.add(currentNode);

			//we look to expand the current node now
			ArrayList<edge> currentAdjList = (ArrayList<edge>)graph.get(currentNode);				

			// listing out all the children of current node
			for (edge adj : currentAdjList){
				//Need to check if the node is already in explored
				if (explored.contains(adj.getDest())){
					//if it is in explored then dont add feed this node to frontier
				}
				//Need to check if the node is already in the frontier
				else if (frontierValues.get(adj.getDest()) != null){
					int existingCost = frontierValues.get(adj.getDest());
					int newCost = currentNodeSrcCost + adj.getCost();	//combined cost of parent and child node
					int currentTime = startTime + newCost;		//current time of entry in pipe based on start time

					//check if the distance is lower, in that case delete the older node and add the new one.
					if (existingCost > newCost){
						//remove the existing node object from priority list and add the new one
						// do this only if the pipe is functional
						for (Node current : frontier) {
							if (current.getNodeName().equals(adj.getDest())){
								//checking if the pipe is open right now
								if (!(adj.getpipeClosedList().contains(currentTime))){
									frontier.remove(current);
									frontier.add(new Node(adj.getDest(), newCost));
									frontierValues.replace(adj.getDest(), newCost);
									break;
								}
							}
						}						 
					}
				}
				//adding a new node to priority queue
				else{
					//add this node to the frontier only if the pipe is functional
					//so include and if statement to check that
					int currentTime = startTime + adj.getCost();
					if (!(adj.getpipeClosedList().contains(currentTime))){
						//adding the total path cost of new node to root
						frontier.add(new Node(adj.getDest(), currentNodeSrcCost + adj.getCost()));
						frontierValues.put(adj.getDest(), currentNodeSrcCost + adj.getCost());	
						//System.out.println("Priority queue minimum now: "+ frontier.peek().getNodeName() + frontier.peek().getSrcDistance());
					}
				}
			}

		}while(!frontier.isEmpty());
		//System.out.println("No solution to this problem");
		return "None";
	}
}
