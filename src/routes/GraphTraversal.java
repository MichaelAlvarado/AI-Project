package routes;

import java.util.LinkedList;

import graph.Graph;
import graph.Node;

public class GraphTraversal {

	/**
	 * Breadth First Search Traversal Print Graph
	 * @author Michael J. Alvarado
	 * @date May 3, 2020
	 * @param graph
	 * @param initialPosition - index of the Node to start the print of Graph
	 * @throws IndexOutOfBoundsException - - if the index is out of range(index < 0 || index >= size())
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void BFSPrint(Graph graph, int initialPosition) 
	{
		//Initialize the visited and queue list
		boolean visited[] = new boolean[graph.size()]; 
		LinkedList<Node> queue = new LinkedList<Node>(); 

		// Mark the current node as visited and enqueue it 
		visited[initialPosition]=true; 
		queue.add(graph.getNode(initialPosition)); 
		
		//BTS
		while (queue.size() != 0) 
		{ 
			// Dequeue a Node from queue and print it 
			Node node = queue.poll(); 
			visited[graph.indexOf(node)] = true;
			System.out.println(node.get().toString()+" ");  

			LinkedList<Node> childrens = node.getNodeChildrens();
			
			//Add the childrens not visited or already in queue
			for (Node nodeChildren : childrens) {
				if(!visited[graph.indexOf(nodeChildren)] && queue.indexOf(nodeChildren) < 0)
					queue.add(nodeChildren);	
			}	
		} 
	}
	
	/**
	 * Depth First Search Traversal Print Graph
	 * @author Michael J. Alvarado
	 * @date May 3, 2020
	 * @param graph
	 * @param initialPosition - index of the Node to start the print of Graph
	 * @throws IndexOutOfBoundsException - - if the index is out of range(index < 0 || index >= size())
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void DFSPrint(Graph graph, int initialPosition) 
	{
		//Initialize the visited and queue list
		boolean visited[] = new boolean[graph.size()]; 
		LinkedList<Node> queue = new LinkedList<Node>(); 

		// Mark the current node as visited and enqueue it 
		visited[initialPosition]=true; 
		queue.add(graph.getNode(initialPosition)); 
		
		//DFS
		while (queue.size() != 0) 
		{ 
			// Dequeue a Node from queue and print it 
			Node node = queue.pollLast(); 
			visited[graph.indexOf(node)] = true;
			System.out.println(node.get().toString()+" ");  

			LinkedList<Node> childrens = node.getNodeChildrens();
			
			//Add the childrens not visited or already in queue
			for (Node nodeChildren : childrens) {
				if(!visited[graph.indexOf(nodeChildren)] && queue.indexOf(nodeChildren) < 0)
					queue.add(nodeChildren);	
			}	
		} 
	}
	
}
