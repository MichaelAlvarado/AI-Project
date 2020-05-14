package testers;

import java.util.LinkedList;

import graph.Graph;
import graph.GraphTraversal;
import graph.Node;
import routes.RandomSearch;
import routes.SimulatedAnnealing;

/**
 * This class get the test graph and test the algorithm to calculate what's the Success Rate of finding the optimize path
 * @author Michael J. Alvarado
 * @date 5/14/2020
 */
public class SuccessRate {

	protected static int test_Quantity = 500;
	protected static int failed = 0;

	public static void main(String[] arg) {
		//Set Up a testing Graph
		Graph<String> test = setUp();
		//Expected Value
		LinkedList<String> expected = new LinkedList<String>();
		expected.add("NY");
		expected.add("Florida");
		expected.add("Kansas");
		expected.add("Washington");
		expected.add("California");
		//Simulated Annealing Test
		double successRate = SimulatedAnnealingSuccessRate(test.getNode("NY"), test.getNode("California"), expected);
		System.out.println("Simulated Annealing Success Rate: "+successRate);
		
		successRate = RandomSearchSuccessRate(test.getNode("NY"), test.getNode("California"), expected);
		System.out.println("Random Search Success Rate: "+successRate);
	}
	private static Graph<String> setUp() {
		Graph<String> graph = new Graph<String>();
		graph.addNode("NY"); 
		graph.addNode("NJ");
		graph.addNode("Florida");
		graph.addNode("Kansas");
		graph.addNode("Ohio");
		graph.addNode("California");
		graph.addNode("Washington");

		graph.addEdge(1.5,"NY", "NJ");
		graph.addEdge(5, "NY", "Florida");
		graph.addEdge(7, "Florida", "Ohio");
		graph.addEdge(5, "Ohio", "Kansas");
		graph.addEdge(10, "Kansas", "California");
		graph.addEdge(10, "Kansas", "Florida");
		graph.addEdge(3,"Washington", "California");
		graph.addEdge(2, "Washington", "Kansas");
		return graph;
	}
	
	private static double SimulatedAnnealingSuccessRate(Node start, Node goal, LinkedList<String> expected) {
		for(int t = 0; t < test_Quantity; t++) {
			Node<String> e = SimulatedAnnealing.simulatedAnnealingPath(start, goal);
			LinkedList<Node> result = GraphTraversal.reconstructPath(e);
			//Verify if optimize value was found
			for (int i = 0; i < result.size(); i++) {
				if(!result.get(i).get().toString().equals(expected.get(i))) {
					failed++;
					break;
				}
			}
		}
		return 1-(failed/test_Quantity);
	}
	
	private static double RandomSearchSuccessRate(Node start, Node goal, LinkedList<String> expected) {
		for(int t = 0; t < test_Quantity; t++) {
			Node<String> e = RandomSearch.randomSearch(start, goal);
			LinkedList<Node> result = GraphTraversal.reconstructPath(e);
			//Verify if optimize value was found
			for (int i = 0; i < result.size(); i++) {
				if(!result.get(i).get().toString().equals(expected.get(i))) {
					failed++;
					break;
				}
			}
		}
		return 1-(failed/test_Quantity);
	}
}
