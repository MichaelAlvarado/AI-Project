package testers;

import collection.Graph;
import routes.BreadthFirstSearch;

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

		System.out.println(graph.addEdge(0, 1, 3));
		System.out.println(graph.addEdge(0, 1, 5));
		System.out.println(graph.addEdge(0, 3, 2));
		System.out.println(graph.addEdge(0, 3, 7));
		System.out.println(graph.addEdge(0, 5, 4));
		System.out.println(graph.addEdge(0, 4, 6));
		System.out.println(graph.addEdge(0, 6, 7));

		BreadthFirstSearch.BFS(graph, 0);

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
