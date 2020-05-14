package testers;

import java.util.LinkedList;

import graph.Graph;
import graph.Node;
import routes.Astar;
import routes.SimulatedAnnealing;

public class AStarTesting {

	public static void main(String[] args) {
		Graph<String> graph = new Graph<String>();
		graph.addNode("NY");
		graph.getNode("NY").setX(3);
		graph.getNode("NY").setY(0);
		
		graph.addNode("NJ");
		graph.getNode("NJ").setX(3);
		graph.getNode("NJ").setY(5);
		
		graph.addNode("FL");
		graph.getNode("FL").setX(8);
		graph.getNode("FL").setY(2);
		
		graph.addNode("Kansas");
		graph.getNode("Kansas").setX(15);
		graph.getNode("Kansas").setY(5);
		
		graph.addNode("Ohio");
		graph.getNode("Ohio").setX(20);
		graph.getNode("Ohio").setY(2);
		
		graph.addNode("Cali");
		graph.getNode("Cali").setX(20);
		graph.getNode("Cali").setY(3);
		
		graph.addNode("Wash");
		graph.getNode("Wash").setX(15);
		graph.getNode("Wash").setY(6);

		
		graph.addEdge(1.5,"NY", "NJ");
		graph.addEdge(5, "NY", "FL");
		graph.addEdge(7, "Florida", "Ohio");
		graph.addEdge(5, "Ohio", "Kansas");
		graph.addEdge(10, "Kansas", "Cali");
		graph.addEdge(10, "Kansas", "FL");
		graph.addEdge(3,"Wash", "Cali");
		graph.addEdge(2, "Wash", "Kansas");
		
		
		LinkedList<Node> list = Astar.ARoute(graph.getNode("NY"), graph.getNode("Cali"));
		System.out.println("Traveled cities:");
		for(Node node: list) {
			System.out.println(node.get());
		}
		
	}

}
