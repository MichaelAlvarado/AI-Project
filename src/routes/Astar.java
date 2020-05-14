package routes;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

import elements.Road;
import graph.Edge;
import graph.Graph;
import graph.Node;

public class Astar {
	
	// total cost
	static double f;
	
	static Queue<Node> frontier = new PriorityQueue<Node>();
	//path
	static LinkedList<Node> explored = new LinkedList<Node>();



	/**
	 * A* route path finding
	 * @author Andrea Miranda Acevedo
	 * @date May 13, 2020
	 */
	public static LinkedList<Node> ARoute(Node from, Node goal){
		if(from == goal){
			explored.add(goal);
			return explored;
		}
		
		Node start = from; 
		explored.add(start);
		
		LinkedList<Edge> L = from.getEdges();
		Node temp;
		for (Edge e : L) {
			f = e.getValue() + calculateH(e.getNode(), goal);
			temp = e.getNode();
			
			temp.setF(f);
			frontier.add(temp);
		}		

		return ARoute(frontier.poll(), goal);
		
	}
	
	
	
	public static double calculateH(Node from, Node to){
		return Road.getDistance(from,to);
	}
	
	

	
}
