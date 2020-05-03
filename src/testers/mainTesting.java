package testers;

import graph.Graph;
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

		System.out.println("breadth first print:");
		GraphTraversal.BFSPrint(graph, 0);

		System.out.println("\ndepth first print:");
		GraphTraversal.DFSPrint(graph, 0);
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
