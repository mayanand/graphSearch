

public class edge {
	private String offPeriods;
	private int cost;
	private String dest;
	
	public edge(String dest, int cost, String offPeriods){
		this.offPeriods = offPeriods;
		this.cost = cost;
		this.dest = dest;
	}
	public String getOffPeriods()
	{
	    return offPeriods;
	}
	public int getCost() {
		return cost;
	}
	public String getDest() {
		return dest;
	}
	
}
