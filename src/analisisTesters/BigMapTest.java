package analisisTesters;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import elements.City;
import elements.Road;
import graph.Graph;
import graph.GraphTraversal;
import graph.Node;
import maps.PuertoRico;
import routes.RandomSearch;
import routes.SimulatedAnnealing;

public class BigMapTest {

	PuertoRico pr1 = new PuertoRico(1,0); //highways have more traffic
	PuertoRico pr2 = new PuertoRico(0.2,0.8); //streets have more traffic

	/**
	 * Simulated Annealing
	 * From Salinas to Barranquitas with Highway traffic
	 * @author Michael J. Alvarado
	 * @date May 14, 2020
	 */
	@Test
	public void SimulatedAnnealingtest() {
		Node<City> start = pr1.getNode(pr1.salinas);
		Node<City> goal = pr1.getNode(pr1.barranquitas);
		long executeTime = System.currentTimeMillis();
		Node<City> e = SimulatedAnnealing.simulatedAnnealingPath(start, goal);
		System.out.println("Time of execution in Simulated Annealing: " + (System.currentTimeMillis()-executeTime) + " ms");
		LinkedList<Node> result = GraphTraversal.reconstructPath(e);
		LinkedList<City> expected = new LinkedList<City>();
		expected.add(pr1.salinas);
		expected.add(pr1.santaIsabel);
		expected.add(pr1.barranquitas);
		assertTrue("Result is not the same size as expected", result.size()==expected.size());
		for (int i = 0; i < result.size(); i++) {
			assertTrue("Not the optimize solution", result.get(i).get().equals(expected.get(i)));
		}
	}
	
	/**
	 * Random Search
	 * From Salinas to Barranquitas with Highway traffic
	 * @author Michael J. Alvarado
	 * @date May 14, 2020
	 */
	@Test
	public void RandomSearchtest() {
		Node<City> start = pr1.getNode(pr1.salinas);
		Node<City> goal = pr1.getNode(pr1.barranquitas);
		long executeTime = System.currentTimeMillis();
		Node<City> e = RandomSearch.randomSearch(start, goal);
		System.out.println("Time of execution in Random Search: " + (System.currentTimeMillis()-executeTime) + " ms");
		LinkedList<Node> result = GraphTraversal.reconstructPath(e);
		LinkedList<City> expected = new LinkedList<City>();
		expected.add(pr1.salinas);
		expected.add(pr1.santaIsabel);
		expected.add(pr1.barranquitas);
		assertTrue("Result is not the same size as expected", result.size()==expected.size());
		for (int i = 0; i < result.size(); i++) {
			assertTrue("Not the optimize solution", result.get(i).get().equals(expected.get(i)));
		}
	}
	
	/**
	 * Simulated Annealing
	 * From Humacao to Manati with Highway traffic
	 * @author Michael J. Alvarado
	 * @date May 14, 2020
	 */
	@Test
	public void SimulatedAnnealingTest1() {
		Node<City> start = pr1.getNode(pr1.humacao);
		Node<City> goal = pr1.getNode(pr1.manati);
		long executeTime = System.currentTimeMillis();
		Node<City> e = SimulatedAnnealing.simulatedAnnealingPath(start, goal);
		System.out.println("Time of execution in Simulated Annealing: " + (System.currentTimeMillis()-executeTime) + " ms");
		LinkedList<Node> result = GraphTraversal.reconstructPath(e);
		LinkedList<City> expected = new LinkedList<City>();
		expected.add(pr1.humacao);
		expected.add(pr1.caguas);
		expected.add(pr1.cayey);
		expected.add(pr1.barranquitas);
		expected.add(pr1.manati);
		assertTrue("Result is not the same size as expected", result.size()==expected.size());
		for (int i = 0; i < result.size(); i++) {
			assertTrue("Not the optimize solution", result.get(i).get().equals(expected.get(i)));
		}
	}
	
	/**
	 * Simulated Annealing
	 * From Humacao to Manati with street traffic
	 * @author Michael J. Alvarado
	 * @date May 14, 2020
	 */
	@Test
	public void SimulatedAnnealingTest2() {
		Node<City> start = pr2.getNode(pr2.humacao);
		Node<City> goal = pr2.getNode(pr2.manati);
		long executeTime = System.currentTimeMillis();
		Node<City> e = SimulatedAnnealing.simulatedAnnealingPath(start, goal);
		System.out.println("Time of execution in Simulated Annealing: " + (System.currentTimeMillis()-executeTime) + " ms");
		LinkedList<Node> result = GraphTraversal.reconstructPath(e);
		LinkedList<City> expected = new LinkedList<City>();
		expected.add(pr2.humacao);
		expected.add(pr2.caguas);
		expected.add(pr2.sanJuan);
		expected.add(pr2.vegaBaja);
		expected.add(pr2.manati);
		assertTrue("Result is not the same size as expected", result.size()==expected.size());
		for (int i = 0; i < result.size(); i++) {
			assertTrue("Not the optimize solution", result.get(i).get().equals(expected.get(i)));
		}
	}
	
	/**
	 * Simulated Annealing
	 * From Humacao to Manati with Highway traffic
	 * @author Michael J. Alvarado
	 * @date May 14, 2020
	 */
	@Test
	public void RandomSearchTest1() {
		Node<City> start = pr1.getNode(pr1.humacao);
		Node<City> goal = pr1.getNode(pr1.manati);
		long executeTime = System.currentTimeMillis();
		Node<City> e = RandomSearch.randomSearch(start, goal);
		System.out.println("Time of execution in Random Search: " + (System.currentTimeMillis()-executeTime) + " ms");
		LinkedList<Node> result = GraphTraversal.reconstructPath(e);
		LinkedList<City> expected = new LinkedList<City>();
		expected.add(pr1.humacao);
		expected.add(pr1.caguas);
		expected.add(pr1.cayey);
		expected.add(pr1.barranquitas);
		expected.add(pr1.manati);
//		assertTrue("Result is not the same size as expected", result.size()==expected.size());
		for (int i = 0; i < result.size(); i++) {
			System.out.println(((City)result.get(i).get()).getName());
			assertTrue("Not the optimize solution", result.get(i).get().equals(expected.get(i)));
		}
	}
	
	/**
	 * Simulated Annealing
	 * From Humacao to Manati with street traffic
	 * @author Michael J. Alvarado
	 * @date May 14, 2020
	 */
	@Test
	public void RandomSearchTest2() {
		Node<City> start = pr2.getNode(pr2.humacao);
		Node<City> goal = pr2.getNode(pr2.manati);
		long executeTime = System.currentTimeMillis();
		Node<City> e = RandomSearch.randomSearch(start, goal);
		System.out.println("Time of execution in Random Search: " + (System.currentTimeMillis()-executeTime) + " ms");
		LinkedList<Node> result = GraphTraversal.reconstructPath(e);
		LinkedList<City> expected = new LinkedList<City>();
		expected.add(pr2.humacao);
		expected.add(pr2.caguas);
		expected.add(pr2.sanJuan);
		expected.add(pr2.vegaBaja);
		expected.add(pr2.manati);
		assertTrue("Result is not the same size as expected", result.size()==expected.size());
		for (int i = 0; i < result.size(); i++) {
			assertTrue("Not the optimize solution", result.get(i).get().equals(expected.get(i)));
		}
	}
	

}
