
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;



public class waterFlow {
	public static void main(String[] args){
		
		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		System.out.println("priting arguments" + args[0] + args[1]);
		System.out.println("Hello World!!");
		
		inputParser input_obj = new inputParser(args[1]);
		
		HashMap<String, ArrayList<edge>> adjLists_dict = input_obj.parse(args[1]);
		
	}
	
}
