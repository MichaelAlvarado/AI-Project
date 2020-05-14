package testers;

import java.util.LinkedList;

import graph.Graph;
import graph.Node;
import routes.Astar;
import routes.GraphTraversal;
import routes.RandomSearch;
import routes.SimulatedAnnealing;

public class mainTesting {

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

//		LinkedList<Node> list = Annealing.annealingSearch(graph.getNode("NY"), graph.getNode("California"));
		long executeTime = System.currentTimeMillis();
		Node e = SimulatedAnnealing.simulatedAnnealingPath(graph.getNode("NY"), graph.getNode("California"));
		System.out.println("Execution time of SimulatedAnneling: "+(System.currentTimeMillis()-executeTime)+" ms");
		LinkedList<Node> list = GraphTraversal.reconstructPath(e);
		System.out.println("Simulated Annealing Traveled cities:");
		for(Node<String> node: list) {
			System.out.println(node.get());
		}
		executeTime = System.currentTimeMillis();
		Node r = RandomSearch.randomSearch(graph.getNode("NY"), graph.getNode("California"));
		System.out.println("Execution time of Random Search: "+(System.currentTimeMillis()-executeTime)+" ms");
		list = GraphTraversal.reconstructPath(r);
		System.out.println("Random Search Traveled cities:");
		for(Node<String> node: list) {
			System.out.println(node.get());
		}
		
		
//		Graph<Integer> graph = new Graph<Integer>();
//		graph.addNode(1);
//		graph.addNode(2);
//		graph.addNode(3);
//		graph.addNode(4);
//		graph.addNode(5);
//		graph.addNode(6);
//		graph.addNode(7);
//
//		graph.addEdge(0, 1, 3);
//		graph.addEdge(0, 1, 5);
//		graph.addEdge(0, 3, 2);
//		graph.addEdge(0, 3, 7);
//		graph.addEdge(0, 5, 4);
//		graph.addEdge(0, 4, 6);
//		graph.addEdge(0, 6, 7);
//
//		LinkedList<Node> list = Annealing.annealingSearch(graph.getNode(1), graph.getNode(6));
//		
		
//		System.out.println("Breadth First print:");
//		GraphTraversal.BFSPrint(graph, 0);
//
//		System.out.println("\nDepth First print:");
//		GraphTraversal.DFSPrint(graph, 0);
//		
//		System.out.println("\nBreadth First Search Path from Node 1 to Node 6");
//		for(Node<Integer> node : GraphTraversal.BFSRoute(graph, graph.getNode(0), graph.getNode(5))) {
//			System.out.println(node.get());
//		}
//		
//		System.out.println("\nDepth First Search Path from Node 1 to Node 6");
//		for(Node<Integer> node : GraphTraversal.DFSRoute(graph, graph.getNode(0), graph.getNode(5))) {
//			System.out.println(node.get());
//		}
		//		BreadthFirstSearch.BFS(graph, 0);
		//		
		//		Graph<Integer> graph2 = new Graph<Integer>();
		//		graph.addNode(1);
		//		graph.addNode(2);
		//		graph.addNode(3);
		//		graph.addNode(4);
		//		graph.addNode(5);
		//		graph.addNode(6);
		//		graph.addNode(7);
		//
		//		System.out.println(graph.addEdge(0, 1, 2));
		//		System.out.println(graph.addEdge(0, 1, 3));
		//		System.out.println(graph.addEdge(0, 2, 4));
		//		System.out.println(graph.addEdge(0, 2, 5));
		//		System.out.println(graph.addEdge(0, 3, 6));
		//		System.out.println(graph.addEdge(0, 3, 7));
		//		
		//		BreadthFirstSearch.BFS(graph2, 0);
	}

}
