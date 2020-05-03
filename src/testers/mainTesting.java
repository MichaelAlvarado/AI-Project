package testers;

import graph.Graph;
import graph.Node;
import routes.GraphTraversal;

public class mainTesting {

	public static void main(String[] args) {
		Graph<Integer> graph = new Graph<Integer>();
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		graph.addNode(4);
		graph.addNode(5);
		graph.addNode(6);
		graph.addNode(7);

		graph.addEdge(0, 1, 3);
		graph.addEdge(0, 1, 5);
		graph.addEdge(0, 3, 2);
		graph.addEdge(0, 3, 7);
		graph.addEdge(0, 5, 4);
		graph.addEdge(0, 4, 6);
		graph.addEdge(0, 6, 7);

		System.out.println("Breadth First print:");
		GraphTraversal.BFSPrint(graph, 0);

		System.out.println("\nDepth First print:");
		GraphTraversal.DFSPrint(graph, 0);
		
		System.out.println("\nBreadth First Search Path from Node 1 to Node 6");
		for(Node<Integer> node : GraphTraversal.BFSRoute(graph, graph.getNode(0), graph.getNode(5))) {
			System.out.println(node.get());
		}
		
		System.out.println("\nDepth First Search Path from Node 1 to Node 6");
		for(Node<Integer> node : GraphTraversal.DFSRoute(graph, graph.getNode(0), graph.getNode(5))) {
			System.out.println(node.get());
		}
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
