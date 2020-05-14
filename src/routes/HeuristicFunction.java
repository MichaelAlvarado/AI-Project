package routes;

import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;


import graph.Node;

public class HeuristicFunction {
	
	public static double h;
	Queue<Entry<Node, Double>> q = new LinkedList<Entry<Node, Double>>();
	
	public static double calculateH(Node from, Node to){
		
		double h = 0;	
		double min = 0;
		
		//Initialize the visited and queue list
		Queue<Entry<Node, Double>> visited = new LinkedList<Entry<Node, Double>>();
		LinkedList<Node> temp = from.getEdges();
		
		
		
		
				

		return min;

	}




}
