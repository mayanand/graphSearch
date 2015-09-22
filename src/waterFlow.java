
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class waterFlow {
	public static void main(String[] args){

		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		System.out.println("priting arguments" + args[0] + args[1]);
		System.out.println("Hello World!!");

		inputParser input_obj = new inputParser(args[1]);

		List<List<String>> testCases = input_obj.parse(args[1]);
		System.out.println("inside main class");
		//		System.out.println(testCases);

		for (List temp : testCases) {
			System.out.println(temp);
		}


	}

}

