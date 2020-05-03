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

}
