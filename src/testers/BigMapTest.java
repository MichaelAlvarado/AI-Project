package testers;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import elements.City;
import elements.Road;
import graph.Graph;
import graph.Node;
import maps.PuertoRico;
import routes.GraphTraversal;
import routes.RandomSearch;
import routes.SimulatedAnnealing;

public class BigMapTest {

	PuertoRico pr = new PuertoRico();
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void SimulatedAnnealingtest() {
		Node<City> start = pr.getNode(pr.salinas);
		Node<City> goal = pr.getNode(pr.barranquitas);
		long executeTime = System.currentTimeMillis();
		Node<City> e = SimulatedAnnealing.simulatedAnnealingPath(start, goal);
		System.out.println("Time of execution in Simulated Annealing: " + (System.currentTimeMillis()-executeTime) + " ms");
		LinkedList<Node> result = GraphTraversal.reconstructPath(e);
		LinkedList<City> expected = new LinkedList<City>();
		expected.add(pr.salinas);
		expected.add(pr.santaIsabel);
		expected.add(pr.barranquitas);

		assertTrue("Result is not the same size as expected", result.size()==expected.size());
		for (int i = 0; i < result.size(); i++) {
			assertTrue("Not the optimize solution", result.get(i).get().equals(expected.get(i)));
		}
		//assertTrue("Not the right value of the Path", e.getValue()==6);
	}
	@Test
	public void RandomSearchtest() {
		Node<City> start = pr.getNode(pr.salinas);
		Node<City> goal = pr.getNode(pr.barranquitas);
		long executeTime = System.currentTimeMillis();
		Node<City> e = RandomSearch.randomSearch(start, goal);
		System.out.println("Time of execution in Random Search: " + (System.currentTimeMillis()-executeTime) + " ms");
		LinkedList<Node> result = GraphTraversal.reconstructPath(e);
		LinkedList<City> expected = new LinkedList<City>();
		expected.add(pr.salinas);
		expected.add(pr.santaIsabel);
		expected.add(pr.barranquitas);

		assertTrue("Result is not the same size as expected", result.size()==expected.size());
		for (int i = 0; i < result.size(); i++) {
			assertTrue("Not the optimize solution", result.get(i).get().equals(expected.get(i)));
		}
		//assertTrue("Not the right value of the Path", e.getValue()==6);
	}

}
