package routes;

import java.util.LinkedList;
import java.util.Random;

import graph.Edge;
import graph.Node;

public class Annealing {
	

	@SuppressWarnings("rawtypes")
	public static LinkedList<Node> annealingSearch(Node start, Node end){
		Random rand = new Random();
		int temp; //Temperature
		int maxTemp = 30; //Testing Max Temp
		Node current = start;
		Node next;

		for(temp = 1; temp < maxTemp; temp++) {
			if(temp >= maxTemp) {
				GraphTraversal.reconstructPath(current);
			}
			//Take a random children
			Edge edge = (Edge) current.getEdges().get(current.getNodeChildrens().size()-1);
			next = edge.getNode();
			next.setValue(edge.getValue());
			double E = next.getValue() - current.getValue();
			if(E>0) {
				System.out.println("Next Node: "+current.get());
				next.setParent(current);
				current = next;
			}else if(Math.pow(Math.E, (E/temp))<rand.nextDouble()){
				System.out.println("Possibility Achieved: "+current.get());
				next.setParent(current);
				current = next;
			}
		}
		return GraphTraversal.reconstructPath(current);
	}
}
