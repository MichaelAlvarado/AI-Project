package routes;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

import graph.Edge;
import graph.Node;

public class SimulatedAnnealing {
	
	//Cooling Parameters
	protected static double max_Temp =100;
	protected static double min_Temp = 0.01;
	//For linear Cooling
	protected static double cooling_rate = 0.05;
	//For percentenge Cooling
	protected static double alpha = 0.99; //the temperature decrease (1-alpha) percent each iteration
	//Local Variable of use
	private static Random rand = new Random();

	/**
	 * Generic Optimize Path Search using Simulated Annealing Search method
	 * @author Michael J. Alvarado
	 * @date May 10, 2020
	 * @param start
	 * @param end
	 * @return the goal Node with path on its parents (If used with reconstructPath method it will have a list of nodes making its path)
	 */
	@SuppressWarnings("rawtypes")
	public static Node simulatedAnnealingPath(Node start, Node end) {
		//temparatures starts a its highest
		double t = max_Temp;
		Node s = randomPath(start, end, null); 
		//Uses temperature cooling
		while (t > min_Temp) {
			//Takes random Path
			Node mutate = mutate(start, end);
			double delta_e = s.getValue() - mutate.getValue();
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
	 * Temperature Schedule to use in Simulated Annealing
	 * @author Michael J. Alvarado
	 * @date May 10, 2020
	 * @param temp
	 * @return
	 */
	private static double temperatureSchedule(double temp) {
		return linearTemperatureSchedule(temp);
	}
	
	/**
	 * Linear Cooling Temperature 
	 * @author Michael J. Alvarado
	 * @date May 10, 2020
	 * @return
	 */
	private static double linearTemperatureSchedule(double temp) {
		return temp-(cooling_rate);
	}
	
	/**
	 * Cooling Temperature by a (1-alpha) percent rate
	 * @author Michael J. Alvarado
	 * @date May 10, 2020
	 * @return returns the 
	 */
	private static double AlphaTemperatureSchedule(double temp) {
		return temp *= alpha;
	}

	/**
	 * Used for mutating a already existing path to create a new
	 * It takes a random Node from a already existing path and goes another path
	 * @author Michael J. Alvarado
	 * @date May 13, 2020
	 * @param start
	 * @param end
	 * @return the goal Node with path on its parents
	 */
	@SuppressWarnings("rawtypes")
	private static Node mutate(Node start, Node end) {
		LinkedList<Node> path = GraphTraversal.reconstructPath(start, end);
		int nodeIndex = rand.nextInt(path.size()); //random Node to mutate from
		HashSet<Node> visited = new HashSet<Node>();
		for(int i = 0; i < nodeIndex; i++) {
			visited.add(path.get(i));
		}
//		start = path.get(rand.nextInt(path.size()-2)+1); //take a random node to mutate
		return randomPath(path.get(nodeIndex), end, visited);
	}

	/**
	 * Creates a random path from node start to end
	 * @author Michael J. Alvarado
	 * @date May 11, 2020
	 * @param start - node to start the search
	 * @param end - goal Node
	 * @param visited - Send a HashSet of already visited Node so the Algorithm wont travel through them again, if null it will assume no Nodes has been visited
	 * @return the goal Node with path on its parents
	 */
	@SuppressWarnings("rawtypes")
	private static Node randomPath(Node start, Node end, HashSet<Node> visited) {
		if(visited == null)
			visited = new HashSet<Node>();
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
	 * Testing Purposes
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
