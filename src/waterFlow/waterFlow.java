package waterFlow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class waterFlow {
	public static void main(String[] args){
		System.out.println("Hello World!!");
		// a simple hashMap declaration with default size and load factor	
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		// hashMap with multiple values with default size and load factor
		HashMap<String, HashMap<String, Integer>> multiMap = new HashMap<String, HashMap<String, Integer>>();	
		
		ArrayList<String> vertices= new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I")); 
//		System.out.println(vertices);
		String start = "A";
		hashMap.put("E", 3);
		hashMap.put("B", 12);
		
		System.out.println("print start variable" + start);
		System.out.println("print all vertices" + vertices);
		System.out.println(hashMap);
		HashMap<String, Integer> newHashMap = new HashMap<String, Integer>(hashMap); 
		multiMap.put("A", newHashMap);
		System.out.println(multiMap);
		hashMap.clear();
		System.out.println("1st iteration of hashmap after clear" + hashMap);
		System.out.println(multiMap);
		
		hashMap.put("E", 2);
		multiMap.put("H", hashMap);
		System.out.println(("2nd iteration of before clear" + hashMap));
		hashMap.clear();
		System.out.println(multiMap);
//		hashMap.put("D", 5);
//		multiMap.put("H", hashMap);
//		hashMap.clear();
//		hashMap.put("C", 6);
//		multiMap.put("I", hashMap);
		
		
		
		System.out.println(hashMap);
		System.out.println(multiMap);
		
	}
	
}
