import java.util.List;



public class edge {
	private List<Integer> pipeClosedList;
	private int cost;
	private String dest;
	
	public edge(String dest, int cost, List<Integer> pipeClosedList){
		this.pipeClosedList = pipeClosedList;
		this.cost = cost;
		this.dest = dest;
	}
	public List<Integer> getpipeClosedList()
	{
	    return pipeClosedList;
	}
	public int getCost() {
		return cost;
	}
	public String getDest() {
		return dest;
	}
	
}
