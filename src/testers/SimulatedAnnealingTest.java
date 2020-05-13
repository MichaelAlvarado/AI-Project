package testers;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import graph.Graph;
import graph.Node;
import routes.GraphTraversal;
import routes.SimulatedAnnealing;

/**
 * Tester use for SimulatedAnnealing. 
 * There is a really small probability of SimulatedAnnealing not finding the global Minima and failing the Tests.
 * @author Michael J. Alvarado
 *	
 */
public class SimulatedAnnealingTest {
	
	Graph<String> graph;
	
	@Before
	public void setUp() throws Exception {
		graph = new Graph<String>();
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
	}

	@Test
	public void test() {
		Node<String> e = SimulatedAnnealing.simulatedAnnealingPath(graph.getNode("NY"), graph.getNode("California"));
		LinkedList<Node> result = GraphTraversal.reconstructPath(e);
		LinkedList<String> expected = new LinkedList<String>();
		expected.add("NY");
		expected.add("Florida");
		expected.add("Kansas");
		expected.add("Washington");
		expected.add("California");

		assertTrue("Result is not the same size as expected", result.size()==expected.size());
		for (int i = 0; i < result.size(); i++) {
			assertTrue("Not the optimize solution", result.get(i).get().toString().equals(expected.get(i)));
		}
	
	}

}
