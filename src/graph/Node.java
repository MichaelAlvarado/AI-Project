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

	//Use to Create paths
	Node parent; 
	double value; 

	//Node Info
	E object;
	LinkedList<Edge> edges;
	
	
	public Node(E arg) {
		object = arg;
		edges = new LinkedList<Edge>();
		value = 0;
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
	
	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
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
	
	public Node clone() {
		Node clone = new Node(this.object);
		clone.setParent(this.getParent());
		clone.setValue(this.getValue());
		clone.edges = this.getEdges();
		return clone;
	}

}
