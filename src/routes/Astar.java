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
	
	static Queue<Entry<Node, Double>> frontier = new PriorityQueue<Entry<Node, Double>>();
	//path
	static Queue<Node> explored = new LinkedList<Node>();
	
	

	/**
	 * A* route path finding
	 * @author 
	 * @date May 3, 2020
	 */
	public static void ARoute(Graph graph, Node from, Node goal){
		Node current = from;
		LinkedList<Edge> L = current.getEdges();
		
		for (Edge e : L) {
			f = e.getValue() + calculateH(e.getNode(), goal);
			Map.Entry<Node,Double> entry = new AbstractMap.SimpleEntry<Node, Double>(e.getNode(), f);
			frontier.add(entry);
		}
		
		while(current != goal){
			explored.add(frontier.peek().getKey()); 
			ARoute(graph, frontier.poll().getKey() ,goal);
			
		}
		
	}
	
	
	
	public static double calculateH(Node from, Node to){
		return Road.getDistance(from,to);
	}
	
	

	
}
