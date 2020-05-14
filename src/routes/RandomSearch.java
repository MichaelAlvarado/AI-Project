package routes;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

import graph.Edge;
import graph.Node;

public class RandomSearch {

	protected static int iterations = 100;

	protected static Random rand = new Random();

	/**
	 * This methods give you the optimize Node Path from goal to start
	 * @author Michael J. Alvarado
	 * @date May 14, 2020
	 * @param start
	 * @param goal
	 * @return the goal Node with path on its parents	
	 */
	public static Node randomSearch(Node start, Node goal) {
		Node min = randomPath(start,goal);
		for(int i = 0; i < iterations; i++) {
			Node randomPath = randomPath(start, goal);
			if(randomPath.getValue()<min.getValue()) {
				min = randomPath;
			}
		}
		System.out.println("Route Value: "+min.getValue());
		return min;
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
	private static Node randomPath(Node start, Node end) {

		HashSet<Node> visited = new HashSet<Node>();

		Node currentNode = start;

		while(!currentNode.equals(end)) {
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
		return currentNode.pathClone(start);
	}
}
