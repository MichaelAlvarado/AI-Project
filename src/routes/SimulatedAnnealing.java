package routes;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

import graph.Edge;
import graph.GraphTraversal;
import graph.Node;

public class SimulatedAnnealing {

	//Cooling Parameters
	protected static double max_Temp = 100;
	protected static double min_Temp = 0.0001;
	//For linear Cooling (Use on linearTemperatureSchedule)
	protected static double cooling_rate = 0.05;
	//For percentage Cooling (Use on AlphaTemperatureSchedule)
	protected static double alpha = 0.99; //the temperature decrease (1-alpha) percent each iteration
	//Local Variable of use
	private static Random rand = new Random();

	/**
	 * Generic Optimize Path Search using Simulated Annealing Search method
	 * @author Michael J. Alvarado
	 * @date May 10, 2020
	 * @param start
	 * @param goal
	 * @return the goal Node with path on its parents (If used with reconstructPath method it will have a list of nodes making its path)
	 */
	@SuppressWarnings("rawtypes")
	public static Node simulatedAnnealingPath(Node start, Node goal) {
		//temparatures starts a its highest
		double t = max_Temp;
		Node s = randomPath(start, goal, null); 
		//Uses temperature cooling
		while (t > min_Temp) {
			//Takes random Path
			Node mutate = mutate(start, s);
			double delta_e = s.getValue() - mutate.getValue();
			//Change paths to most effective
			if(delta_e>0) {
				s = mutate.pathClone(start);
			}
			//Changes of accepting a wrong move
			else if (Math.random() < Math.exp(delta_e/t)) {
				s = mutate.pathClone(start);
			}
			t = temperatureSchedule(t);
		}
		return s;
	}

	/**
	 * Temperature Schedule to use in Simulated Annealing
	 * @author Michael J. Alvarado
	 * @date May 10, 2020
	 * @param temp
	 * @return temperature use in the Simulated Annealing Process
	 */
	private static double temperatureSchedule(double temp) {
		return AlphaTemperatureSchedule(temp);
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
	 * Cooling Temperature by a (1-alpha) percent rate (Better than linear Temperature Schedule)
	 * @author Michael J. Alvarado
	 * @date May 10, 2020
	 * @return 
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
		//List of visited Node to avoid revisiting
		if(visited == null)
			visited = new HashSet<Node>();
		
		Node currentNode = start;
		//Make a random path till the goal is reach
		while(!currentNode.get().equals(end.get())) {
			visited.add(currentNode);
			//Random Children
			Edge edge = (Edge) currentNode.getEdges().get(rand.nextInt(currentNode.getNodeChildrens().size()));
			Node children = edge.getNode();
			//Travel if the Node hasn't been visited
			if(!visited.contains(children)) {
				children.setParent(currentNode);
				children.setValue(0);
				children.setValue(currentNode.getValue()+edge.getValue());
				currentNode = children;
			}
			//Return the a previous Node if its stuck in a loop
			else{
				boolean stuck = true;
				for(Node node: (LinkedList<Node>)currentNode.getNodeChildrens()) {
					if(!visited.contains(node)) {
						stuck = false;
					}
				}
				if(stuck) {
					currentNode = currentNode.getParent();
				}
			}
		}
		return currentNode;
	}


	/**
	 * Makes a clone path
	 * @author Michael J. Alvarado
	 * @date May 13, 2020
	 * @param start
	 * @param end
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private static LinkedList<Node> reconstructPath(Node start, Node end){
		Node pathNode = end.pathClone(start);
		LinkedList<Node> path = new LinkedList<Node>();
		while(!pathNode.get().equals(start.get())) {
			path.addFirst(pathNode);
			pathNode = pathNode.getParent();
		}
		path.addFirst(end);
		return path;
	}
}
