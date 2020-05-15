package testers;

import java.util.LinkedList;

import elements.City;
import graph.Graph;
import graph.GraphTraversal;
import graph.Node;
import maps.PuertoRico;
import routes.SimulatedAnnealing;

public class SimulatedAnnealingAnalisis {
	
	//Quantity of how many times to run the test
	protected static int test_Quantity = 1000;
	
	//Local variables
	private static int failed = 0;
	private static double executionTime = 0;

	public static void main(String[] arg) {
		//Set Up a testing Graph
		PuertoRico pr1 = new PuertoRico(1,0);
		//Expected Value
		LinkedList<City> expected = new LinkedList<City>();
		expected.add(pr1.humacao);
		expected.add(pr1.caguas);
		expected.add(pr1.cayey);
		expected.add(pr1.barranquitas);
		expected.add(pr1.manati);
		//Simulated Annealing Test
		Node<City> start = pr1.getNode(pr1.humacao);
		Node<City> goal = pr1.getNode(pr1.manati);
		/*
		 * Test and Analyze Simulated Annealing
		 */
		System.out.println("Simulated Annealing Analisis");
		double successRate = simulatedAnnealingAnalisis(start, goal, expected);
		System.out.println("Average Execution Time: "+(executionTime/test_Quantity)+" ms");
		System.out.println("Success Rate: "+ (successRate*100)+"%");
		
	}
	
	private static double simulatedAnnealingAnalisis(Node<City> start, Node<City> goal, LinkedList<City> expected) {
		for(int t = 0; t < test_Quantity; t++) {
			long timer = System.currentTimeMillis();
			Node<String> e = SimulatedAnnealing.simulatedAnnealingPath(start, goal);
			executionTime += System.currentTimeMillis()-timer;
			LinkedList<Node> result = GraphTraversal.reconstructPath(e);
			//Verify if optimize value was found
			for (int i = 0; i < result.size(); i++) {
				if(!((City)result.get(i).get()).getName().equals(expected.get(i).getName())) {
					failed++;
					break;
				}
			}
		}
		return 1-((double)(failed)/(double)test_Quantity);
	}
	
}
