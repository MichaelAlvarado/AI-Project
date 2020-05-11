package graph;
/**
 * 
 * @author Michael J. Alvarado
 * @date 5/1/2020
 */

@SuppressWarnings("rawtypes")
public class Edge{

	double value; //Cost of the path
	Node node;

	public Edge(double value, Node node) {
		this.value = value;
		this.node = node;
	}

	public Node getNode() {
		return node;
	}
	
	public double getValue() {
		return value;
	}

}