package collection;

import java.util.LinkedList;

/**
 * Generic Graph
 * @author Michael J. Alvarado
 * @date 5/1/2020
 * @param <E> Node type
 * @param <T> Edge type
 */
public class Graph<E>{

	LinkedList<Node> nodes;
	
	public Graph() {
		nodes = new LinkedList<Node>();
	}

	public void addNode(E arg) {
		nodes.add(new Node(arg));
	}

	/**
	 *
	 * @param arg0
	 * @param arg1
	 * @return true if edge was added succesfully. If a argument was not found in the graph then return false (Wont add if there is no node with arguments given)
	 */
	public boolean addEdge(double value, E arg0, E arg1) {
			Node node1 = getNode(arg0);
			Node node2 = getNode(arg1);
			if(node1 == null || node2 == null) {
				return false;
			}
			node1.addEdge(new Edge(value, node2));
			node2.addEdge(new Edge(value, node1));
			return true;
	
	}
	
	public int size() {
		return nodes.size();
	}
	
	public Node getNode(int index) {
		return nodes.get(index);
	}
	
	public LinkedList<Node> nodesList(){
		return nodes;
	}
	
	private Node getNode(E arg) {
		for (Node node : nodes) {
			if(node.get().equals(arg))
				return node;
		}
		return null;
	}
	
	public int getNodeIndex(Node node) {
		for (int i = 0; i < nodes.size(); i++) {
			if(nodes.get(i).equals(node))
				return i;
		}
		return -1;
	}
	

	/**
	 * 
	 * @author Michael J. Alvarado
	 * @date 5/1/2020
	 */
	public class Node{

		E object;
		LinkedList<Edge> edges;

		public Node(E arg) {
			object = arg;
			edges = new LinkedList<Edge>();
		}

		public E get() {
			return object;
		}
		public LinkedList<Edge> getEdges(){
			return edges;
		}
		public void addEdge(Edge edge) {
			edges.add(edge);
		}
		public LinkedList<Node> getNodeChildrens() {
			LinkedList<Node> childrens = new LinkedList<Node>();
			for(Edge e: edges) {
				childrens.add(e.getNode());
			}
			return childrens;
		}
		public LinkedList<E> getChildrens() {
			LinkedList<E> childrens = new LinkedList<E>();
			for(Edge e: edges) {
				childrens.add(e.getNode().get());
			}
			return childrens;
		}


	}

	/**
	 * 
	 * @author Michael J. Alvarado
	 * @date 5/1/2020
	 */
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
	}
}
