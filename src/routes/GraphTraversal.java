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
		LinkedList<Node> stack = new LinkedList<Node>(); 

		// Mark the current node as visited and enqueue it 
		visited[initialPosition]=true; 
		stack.add(graph.getNode(initialPosition)); 

		//DFS
		while (stack.size() != 0) 
		{ 
			// Dequeue a Node from queue and print it 
			Node node = stack.pollLast(); 
			visited[graph.indexOf(node)] = true;
			System.out.println(node.get().toString()+" ");  

			LinkedList<Node> childrens = node.getNodeChildrens();

			//Add the childrens not visited or already in queue
			for (Node nodeChildren : childrens) {
				if(!visited[graph.indexOf(nodeChildren)] && stack.indexOf(nodeChildren) < 0)
					stack.add(nodeChildren);	
			}	
		} 
	}

	/**
	 * Depth First Search Traversal Print Graph
	 * @author Michael J. Alvarado
	 * @date May 3, 2020
	 * @param graph
	 * @param initialPosition - index of the Node to start the print of Graph
	 * @return A list of the route from node @param from to @param to
	 * @throws IndexOutOfBoundsException - - if the index is out of range(index < 0 || index >= size()) 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static LinkedList<Node> BFSRoute(Graph graph, Node from, Node to) 
	{
		//Initialize the visited and queue list
		boolean visited[] = new boolean[graph.size()]; 
		LinkedList<Node> queue = new LinkedList<Node>(); 

		// Mark the current node as visited and enqueue it 
		visited[graph.indexOf(from)]=true; 
		queue.add(from); 

		//DFS
		while (queue.size() != 0) 
		{ 
			// Dequeue a Node from queue and print it 
			Node node = queue.poll(); 
			visited[graph.indexOf(node)] = true;
			if(node.equals(to)) {
				return reconstructPath(node);
			}

			LinkedList<Node> childrens = node.getNodeChildrens();

			//Add the childrens not visited or already in queue
			for (Node nodeChildren : childrens) {
				if(!visited[graph.indexOf(nodeChildren)] && queue.indexOf(nodeChildren) < 0) {
					nodeChildren.setParent(node);
					queue.add(nodeChildren);	
				}
			}	
		}
		return null;
	}
	
	/**
	 * Depth First Search Traversal Print Graph
	 * @author Michael J. Alvarado
	 * @date May 3, 2020
	 * @param graph
	 * @param initialPosition - index of the Node to start the print of Graph
	 * @return A list of the route from node @param from to @param to
	 * @throws IndexOutOfBoundsException - - if the index is out of range(index < 0 || index >= size()) 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static LinkedList<Node> DFSRoute(Graph graph, Node from, Node to) 
	{
		//Initialize the visited and queue list
		boolean visited[] = new boolean[graph.size()]; 
		LinkedList<Node> stack = new LinkedList<Node>(); 

		// Mark the current node as visited and enqueue it 
		visited[graph.indexOf(from)]=true; 
		stack.add(from); 

		//DFS
		while (stack.size() != 0) 
		{ 
			// Dequeue a Node from queue and print it 
			Node node = stack.pollLast(); 
			visited[graph.indexOf(node)] = true;
			if(node.equals(to)) {
				return reconstructPath(node);
			}

			LinkedList<Node> childrens = node.getNodeChildrens();

			//Add the childrens not visited or already in queue
			for (Node nodeChildren : childrens) {
				if(!visited[graph.indexOf(nodeChildren)] && stack.indexOf(nodeChildren) < 0) {
					nodeChildren.setParent(node);
					stack.add(nodeChildren);	
				}
			}	
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	public static LinkedList<Node> reconstructPath(Node node){
		LinkedList<Node> path = new LinkedList<Node>();
		while(node != null) {
			path.addFirst(node);
			node = node.getParent();
		}
		return path;
	}
	
	@SuppressWarnings("rawtypes")
	public static LinkedList<Node> reconstructPath(Node start, Node end){
		LinkedList<Node> path = new LinkedList<Node>();
		while(!end.equals(start)) {
			path.addFirst(end);
			end = end.getParent();
		}
		path.addFirst(end);
		return path;
	}


}
