package routes;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

import graph.Edge;
import graph.Node;

public class SimulatedAnnealing {
	
	//Cooling Parameters
	protected static double max_Temp =100;
	protected static double cooling_rate = 0.5;
	//Local Variable of use
	private static Random rand = new Random();

	/**
	 * Generic Optimize Path Search using Simulated Annealing Search method
	 * @author Michael J. Alvarado
	 * @date May 13, 2020
	 * @param start
	 * @param end
	 * @return the goal Node with path on its parents (If used with reconstructPath method it will have a list of nodes making its path)
	 */
	public static Node simulatedAnnealingPath(Node start, Node end) {
		//temparatures starts a its highest
		double t = max_Temp;
		Node s = randomPath(start, end); //Optimize Path
		//Uses temperature cooling
		while (t > 0) {
			//Takes random Path
			Node mutate = randomPath(start, end);
			double delta_e = s.getValue() - mutate.getValue();
//			System.out.println(mutate.getValue()+" - " +s.getValue()+" = " +delta_e);
			//Change paths to most effective
			if(delta_e>0) {
				s = reconstructPath(start, mutate).getLast();
			}
			//Changes of accepting a wrong move
			else if (Math.random() < Math.exp(delta_e/t)) {
				s = reconstructPath(start, mutate).getLast();
			}
			System.out.println(Math.exp(delta_e/t));
			t = temperatureSchedule(t);
		}
		System.out.println(s.getValue());
		return s;
	}

	/**
	 * Linear Cooling Temperature 
	 * @author Michael J. Alvarado
	 * @date May 13, 2020
	 * @return
	 */
	private static double temperatureSchedule(double temp) {
		return temp-(cooling_rate);
	}

	/**
	 * Used for mutating a already existing path to create a new (Not Delevop Yet)
	 * @author Michael J. Alvarado
	 * @date May 13, 2020
	 * @param start
	 * @param end
	 * @return
	 */
	private static Node mutate(Node start, Node end) {
		LinkedList<Node> path = GraphTraversal.reconstructPath(start, end);
		for (Node node : path) {
			System.out.println(node.get().toString());
		}
		Node randomMutation = path.get(rand.nextInt(path.size()-2)+1); //take a random node to mutate
		return randomPath(randomMutation, end);
	}

	/**
	 * Creates a random path from node start to end
	 * @author Michael J. Alvarado
	 * @date May 13, 2020
	 * @param start - node to start the search
	 * @param end - goal Node
	 * @return the goal Node with path on its parents
	 */
	@SuppressWarnings("rawtypes")
	private static Node randomPath(Node start, Node end) {
		HashSet<Node> visited = new HashSet<Node>();
		while(!start.equals(end)) {
			visited.add(start);
			Edge edge = (Edge) start.getEdges().get(rand.nextInt(start.getNodeChildrens().size()));
			Node children = edge.getNode();
			if(!visited.contains(children)) {
				children.setParent(start);
				children.setValue(0);
				children.setValue(start.getValue()+edge.getValue());
				start = children;
			}else{
				for(Node node: visited) {
					if(start.getNodeChildrens().contains(node)) {
						start = children;
					}
				}
			}
		}
		return start;
	}

	
	/**
	 * 
	 * @author Michael J. Alvarado
	 * @date May 13, 2020
	 * @param start
	 * @param end
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static LinkedList<Node> reconstructPath(Node start, Node end){
		LinkedList<Node> path = new LinkedList<Node>();
		while(!end.equals(start)) {
			path.addFirst(end.clone());
			end = end.getParent();
		}
		path.addFirst(end);
		return path;
	}
}
