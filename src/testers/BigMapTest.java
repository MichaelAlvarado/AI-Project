package testers;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import elements.City;
import elements.Road;
import graph.Graph;
import graph.Node;
import routes.GraphTraversal;
import routes.SimulatedAnnealing;

public class BigMapTest {

	Graph<City> graph = new Graph<City>();
	City cayey = new City("Cayey",0,0);
	City salinas = new City("Salinas",0,0);
	City santaIsabel = new City("Santa Isabel",0,0);
	City barranquitas = new City("Barranquitas",0,0);
	City ponce = new City("Ponce",0,0);
	City villalba = new City("Villalba",0,0);
	City caguas = new City("Caguas",0,0);
	City arroyo = new City("Arroyo",0,0);
	City humacao = new City("Humacao",0,0);
	City fajardo = new City("Fajardo",0,0);
	City canovana = new City("Canovana",0,0);
	City sanJuan = new City("San Juan",0,0);
	City vegaBaja = new City("Vega Baja",0,0);
	City manati = new City("Manati",0,0);
	City arecibo = new City("Arecibo",0,0);
	City lares = new City("Lares",0,0);
	City adjunta = new City("Adjunta",0,0);
	City yauco = new City("Yauco",0,0);
	City lajas = new City("Lajas",0,0);
	City sanGerman = new City("San German",0,0);
	City mayaguez = new City("Mayaguez",0,0);
	City Aguadilla = new City("Aguadilla",0,0);

	@Before
	public void setUp() throws Exception {
		graph.addNode(cayey);
		graph.addNode(salinas);
		graph.addNode(santaIsabel);
		graph.addNode(barranquitas);

		graph.addEdge(1, cayey, barranquitas); //Cayey to Barranquitas
		graph.addEdge(1, salinas, cayey); //Salinas to Cayey
		graph.addEdge(2, salinas, santaIsabel); //Salinas to Santa Isabel
		graph.addEdge(1, santaIsabel, barranquitas); // Santa Isabel to Barranquita
		
	}

	@Test
	public void test() {
		Node<City> e = SimulatedAnnealing.simulatedAnnealingPath(graph.getNode(salinas), graph.getNode(barranquitas));
		LinkedList<Node> result = GraphTraversal.reconstructPath(e);
		LinkedList<City> expected = new LinkedList<City>();
		expected.add(salinas);
		expected.add(cayey);
		expected.add(barranquitas);

		assertTrue("Result is not the same size as expected", result.size()==expected.size());
		for (int i = 0; i < result.size(); i++) {
			assertTrue("Not the optimize solution", result.get(i).get().equals(expected.get(i)));
		}
		assertTrue("Not the right value of the Path", e.getValue()==2);
	}

}
