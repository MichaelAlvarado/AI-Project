package testers;

import java.util.LinkedList;

import elements.City;
import graph.Node;
import maps.PuertoRico;
import routes.Astar;

public class AStarTestingPR {
	public static void main(String[] args){
		
		PuertoRico pr1 = new PuertoRico(1,0);
		PuertoRico pr2 = new PuertoRico(0.2,0.8); 
		
		System.out.println("\n----------------------------------------------------------------\n");
		
		Node<City> start2 = pr2.getNode(pr2.fajardo);
		Node<City> goal2 = pr2.getNode(pr2.mayaguez);
		
		LinkedList<Node<City>> list2 = Astar.ARoute(start2, goal2);
		System.out.println("Traveled cities PR2 Conf: \n");
		for(Node<City> node: list2) {
			System.out.println(node.get().getName());
		}
		
		
	}
}
