package routes;


import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import elements.City;
import elements.Road;
import graph.Edge;
import graph.Node;

public class Astar {
	
	// total cost
	static double f;
	
	static LinkedList<Node<City>> frontier = new LinkedList<Node<City>>();
	//path
	static LinkedList<Node<City>> explored = new LinkedList<Node<City>>();

	/**
	 * A recursively implementation of A* algorithm
	 * @author Andrea Miranda Acevedo
	 * @param Node<City> from
	 * @param Node<City> goal
	 * @date May 13, 2020
	 */
	public static LinkedList<Node<City>> ARoute(Node<City> from, Node<City> goal){
		explored = new LinkedList<Node<City>>();
		frontier = new LinkedList<Node<City>>();
		return ARouteH(from, goal);
	}
	
	/**
	 * A* helper recursive method
	 */
	public static LinkedList<Node<City>> ARouteH(Node<City> from, Node<City> goal){
		
		if(explored.contains(goal)){
			return explored;
		}
		
		if(!explored.contains(from)){
			explored.add(from);
		}
		LinkedList<Edge> L = from.getEdges();
		
		for (Edge edge : L) {
			if(!frontier.contains(edge)){
				frontier.add(edge.getNode());
			}
		}
		Node<City> temp = L.getFirst().getNode();

		for (Edge e : L) {
			f = e.getValue() + calculateH(e.getNode(), goal);
			e.getNode().setF(f);
			if(temp.getF() > f){
				temp = e.getNode();
			}
		}
		
		return ARouteH(temp, goal);		
	}


	/**
	 * Method to calculate the Heuristic function from a state node to the goal state node.
	 * @author Andrea C. Miranda Acevedo
	 * @param Node<City> from
	 * @param Node<City> goal
	 * @return double
	 */
	private static double calculateH(Node<City> from, Node<City> goal) {
		return from.get().CalculationByDistance(goal.get())/40.0;
	}	
	

	
}
