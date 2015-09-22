
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class waterFlow {
	public static void main(String[] args){

		System.out.println("Hello World!!");

		inputParser input_obj = new inputParser(args[1]);

		List<List<String>> testCases = input_obj.parse(args[1]);


		for (List temp : testCases) {
			String algoType = new String();
			String goalString = new String();
			String midString = new String();
			String pipes = new String();
			String strTime = new String();
			String startNode = new String();
			ArrayList<String> nodeList = new ArrayList<String>();
			Queue<String> nodeCostList = new LinkedList<String>();

			HashMap<String, ArrayList<edge>> adjLists_dict = new HashMap<String, ArrayList<edge>>();
			HashMap<String, Integer> costBfsDfs = new HashMap<String, Integer>();

			algoType = (String)temp.get(0);
			//System.out.println("algo type: "+ algoType);

			startNode = (String)temp.get(1);
			nodeList.add(startNode);
			nodeCostList.add(startNode);

			midString = (String)temp.get(3);
			List<String> midNodes = Arrays.asList(midString.split("\\s+"));
			for (String mid : midNodes){
				nodeList.add(mid);
			}
			//System.out.println("middle string " + midString + midNodes);


			goalString = (String)temp.get(2);
			List<String> goals = Arrays.asList(goalString.split("\\s+"));
			for (String goal : goals){
				nodeList.add(goal);
			}

			pipes = (String)temp.get(4);
			int noOfPipes = Integer.parseInt(pipes);
			//System.out.println("pipe numers " +noOfPipes);

			strTime = (String)temp.get(temp.size() - 1);
			int startTime = Integer.parseInt(strTime);
			//System.out.println("start time "+ startTime);

			for (String nodes : nodeList) {
				//this can be optimized by bypassing the nodeList creation
				adjLists_dict.put(nodes, new ArrayList<edge>());
			}

//			System.out.println("the node list start here");
//			System.out.println(nodeList);

			//M Q 8 1 4-6
			//O R 3 0
			for (int i = 5; i < temp.size() - 1 ; i++)
			{
				//System.out.println(temp.get(i));
				String pipeString = new String();
				String fromNode = new String();
				String toNode = new String();
				String pipeClosedTime= new String();


				pipeString = (String)temp.get(i);
				//System.out.println(pipeString);
				List<String> pipeData = Arrays.asList(pipeString.split("\\s+"));
				fromNode = pipeData.get(0);
				toNode = pipeData.get(1);
				int pipeCost = Integer.parseInt(pipeData.get(2));
				int pipeClosedInstances = Integer.parseInt(pipeData.get(3));
				if (pipeClosedInstances == 0){
					pipeClosedTime = "";
				}
				else{
					for (int j=4; j< pipeData.size() ; j++){
						pipeClosedTime = pipeClosedTime + "," + pipeData.get(j);
					}
				}

				//adjLists_dict.get("AA").add(new edge("BA", 10, "1-2"));
				adjLists_dict.get(fromNode).add(new edge(toNode, pipeCost, pipeClosedTime));

			}

			Boolean rootCostAssigned = false;
			String newNode = new String();
			String targetNode = new String();
			
			while (!nodeCostList.isEmpty()){
				newNode = nodeCostList.poll();
				if (rootCostAssigned == false){
					costBfsDfs.put(newNode, 0);
					rootCostAssigned = true;
				}
				
				for (edge target: adjLists_dict.get(newNode)){
					targetNode = target.getDest();
					if (costBfsDfs.get(targetNode) == null){
						costBfsDfs.put(targetNode, costBfsDfs.get(newNode) + 1 );
						nodeCostList.add(targetNode);
					}

				}

			}
			//System.out.println(costBfsDfs);

			if (algoType.contains("BFS")){
				BFS BFS_obj = new BFS();
				System.out.println("BFS -> -> result");
				System.out.println(BFS_obj.breadthFirstSearch(startNode, startTime, adjLists_dict, goals, costBfsDfs));
			}

			else if (algoType.contains("DFS")){
				DFS DFS_obj= new DFS();
				System.out.println("DFS -> -> result");
				System.out.println(DFS_obj.depthFirstSearch(startNode, startTime, adjLists_dict, goals, costBfsDfs));

			}

			else if (algoType.contains("UCS")){
				UCS UCS_obj = new UCS();
				System.out.println("UCS >>>>>>>>>>>>>>>>>>> result");
				System.out.println(UCS_obj.unifromCostSearch(startNode, startTime, adjLists_dict, goals));

			}
			//			System.out.println(temp);
			//			System.out.println(adjLists_dict);
		}


	}

}

