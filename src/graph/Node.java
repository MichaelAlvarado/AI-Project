package graph;

import java.util.LinkedList;

import graph.Edge;

/**
 * 
 * @author Michael J. Alvarado
 * @date 5/1/2020
 */
@SuppressWarnings("rawtypes")
public class Node<E>{

	Node parent; //Use to have a path
	E object;
	LinkedList<Edge> edges;

	public Node(E arg) {
		object = arg;
		edges = new LinkedList<Edge>();
	}
	
	/**
	 * Use to build a path
	 * @author Michael J. Alvarado
	 * @date May 3, 2020
	 * @param parent
	 */
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	/**
	 * Use to build a path
	 * @author Michael J. Alvarado
	 * @date May 3, 2020
	 * @param parent
	 */
	public Node getParent() {
		return parent;
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

}
