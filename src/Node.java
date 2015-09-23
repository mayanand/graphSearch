

public class Node implements Comparable<Node> {
	private String nodeName;
	private int srcDistance;

	public Node(String nodeName, int srcDistance){
		this.nodeName =nodeName;
		this.srcDistance = srcDistance;
	}

	@Override
	public int compareTo(Node otherNode)
	{	
		int compare = Integer.compare(srcDistance, otherNode.srcDistance);
		if (compare == 0){
			compare = nodeName.compareTo(otherNode.nodeName);
		}
		return compare;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public int getSrcDistance() {
		return srcDistance;
	}

	public void setSrcDistance(int srcDistance) {
		this.srcDistance = srcDistance;
	}

}
