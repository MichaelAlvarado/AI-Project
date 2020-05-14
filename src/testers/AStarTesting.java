package testers;

import graph.Graph;
import graph.Node;

import routes.SimulatedAnnealing;

public class AStarTesting {

	public static void main(String[] args) {
		Graph<String> graph = new Graph<String>();
		graph.addNode("NY"); 
		graph.addNode("NJ");
		graph.addNode("Florida");
		graph.addNode("Kansas");
		graph.addNode("Ohio");
		graph.addNode("California");
		graph.addNode("Washington");

		graph.addEdge(1.5,"NY", "NJ");
		graph.addEdge(5, "NY", "Florida");
		graph.addEdge(7, "Florida", "Ohio");
		graph.addEdge(5, "Ohio", "Kansas");
		graph.addEdge(10, "Kansas", "California");
		graph.addEdge(10, "Kansas", "Florida");
		graph.addEdge(3,"Washington", "California");
		graph.addEdge(2, "Washington", "Kansas");
		
		
	}

}
