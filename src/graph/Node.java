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

	
	/**
	 * @author Andrea Miranda & Ramphis Lopez
	 */

	// Coordinates
	double X;
	double Y;



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


	public double getX() {
		return X;
	}


	public double getY() {
		return Y;
	}

	

	public LinkedList<Node> getNodeChildrens() {
		LinkedList<Node> childrens = new LinkedList<Node>();
		for(Edge e: edges) {
			childrens.add(e.getNode());
		}
		return childrens;
	}

	/**
	 * clone this node and its parent hierarchy till stop Node found
	 * @author Michael J. Alvarado
	 * @date May 14, 2020
	 * @param stop - parent node to stop the cloning
	 * @return clone intanceof this with clone parents
	 * @throws StackOverflow if stop is not in the parents hierarchy.
	 */
	public Node pathClone(Node stop) {
		Node clone = new Node(this.object);
		clone.setValue(new Double(this.getValue()));
		clone.edges = this.getEdges();
		if(this.get().equals(stop.get())) {
			return this; 
		}
		clone.setParent(this.getParent().pathClone(stop));
		return clone;
	}

}
