package waterFlow;

import java.util.ArrayList;
import java.util.HashMap; 


public class AdjacencyList {
	 
    public static void main(String[] args) {
        // empty dictionary
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
        // insert empty lists for each node
        /*int n = 9;
        for(int v=0; v<n; v++){
            adjLists_dict.put(v, new ArrayList<String>());
        }*/
        
        for (String temp : nodeList) {
			System.out.println(temp);
			adjLists_dict.put(temp, new ArrayList<edge>());
        
        }
         
        // insert (vertex, list) pairs into dictionary
        // insert neighbors into list for vertex A
        adjLists_dict.get("A").add(new edge("B", 12, ""));
        adjLists_dict.get("A").add(new edge("E", 3, "2-4,1-5,9-10"));
         
        // insert neighbors into list for vertex 1
        adjLists_dict.get("E").add(new edge("H", 2, "1-2"));
        adjLists_dict.get("H").add(new edge("D", 5, "5-6,2-3"));
        adjLists_dict.get("I").add(new edge("C", 6, "10-14"));
        
 /*
        // insert neighbors into list for vertex 2
        
        // insert neighbors into list for vertex 3
        adjLists_dict.get(3).add(4);
        adjLists_dict.get(3).add(5);
 
        // insert neighbors into list for vertex 4
        adjLists_dict.get(4).add(5);
 
        // insert neighbors into list for vertex 5
        // -> nothing to do since 5 has no neighbors
         
 */        
        // testing
        System.out.println("Neighbors of vertex A: " + adjLists_dict.get("A"));
        System.out.println(adjLists_dict.get("A").get(0).getOffPeriods());
        System.out.println(adjLists_dict.get("A").get(0).getCost());
        System.out.println(adjLists_dict.get("A").get(0).getDest());
        //System.out.println("Neighbors of vertex C: " + adjLists_dict.get("C"));
         
        System.out.println("\nPrint all adjacency lists with corresponding vertex:");
        for (String temp : nodeList) {
            System.out.println(temp + ": " + adjLists_dict.get(temp));
            for (edge temp1: adjLists_dict.get(temp)) {
            	System.out.println("cost->" + temp1.getCost() + " dest->" + temp1.getDest()+ " off periods->" + temp1.getOffPeriods());
            }
        }
         
    }
 
}