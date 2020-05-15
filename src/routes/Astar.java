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
	
	static Queue<Node<City>> frontier = new PriorityQueue<Node<City>>();
	//path
	static LinkedList<Node<City>> explored = new LinkedList<Node<City>>();



	/**
	 * A* route path finding
	 * @author Andrea Miranda Acevedo
	 * @date May 13, 2020
	 */
	public static LinkedList<Node<City>> ARoute(Node<City> from, Node<City> goal){
		if(from == goal){
			explored.add(goal);
			return explored;
		}
		
		Node<City> start = from; 
		if(!explored.contains(from)){
			explored.add(start);
		}
		
		LinkedList<Edge> L = from.getEdges();
		
		Node<City> temp;
		
		for (Edge e : L) {
			f = e.getValue() + calculateH(e.getNode(), goal);
			temp = e.getNode();
			temp.setF(f);
			System.out.println("City: " + temp.get().getName() +"     \n"+ " Edge: " + e.getValue() + "   f: " + f +
				"   Coordinates: (" +temp.get().getX() + ", " + temp.get().getY() + ")\n");
			frontier.add(temp);
		}		

		return ARoute(frontier.poll(), goal);
		
	}



	private static double calculateH(Node<City> from, Node<City> goal) {
		//return Road.getDistance(from.get(), goal.get());
		return from.get().CalculationByDistance(goal.get());
	}	
	

	
}
