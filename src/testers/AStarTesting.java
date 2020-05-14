package testers;

import java.util.LinkedList;

import elements.City;
import graph.Graph;
import graph.Node;
import routes.Astar;

public class AStarTesting {

	public static void main(String[] args) {
		Graph<City> graph = new Graph<City>();
		
		City NY = new City("NY", 3, 0);
		City NJ = new City("NJ", 3, 5);
		City FL = new City("FL", 8, 2);
		City OH = new City("OHIO", 20, 5);
		City CL = new City("CALIFORNIA", 20, 3);
		City KN = new City("KANSAS", 15, 5);
		City WA = new City("WASHINGTON", 12, 6);

		
		graph.addNode(NY);
		graph.addNode(NJ);
		graph.addNode(FL);
		graph.addNode(KN);
		graph.addNode(OH);
		graph.addNode(CL);
		graph.addNode(WA);

		
		graph.addEdge(1.5,NY, NJ);
		graph.addEdge(5, NY, FL);
		graph.addEdge(7, FL, OH);
		graph.addEdge(5, OH , KN );
		graph.addEdge(10, KN, CL);
		graph.addEdge(10, KN, FL);
		graph.addEdge(3,WA, CL);
		graph.addEdge(2, WA, KN);
		
		
		LinkedList<Node<City>> list = Astar.ARoute(graph.getNode(NY), graph.getNode(CL));
		System.out.println("Traveled cities:");
		for(Node<City> node: list) {
			System.out.println(node.get().getName());
		}
		
	}

}
