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
	City aguadilla = new City("Aguadilla",0,0);

	private void initNodes() {
		graph.addNode(cayey);
		graph.addNode(salinas);
		graph.addNode(santaIsabel);
		graph.addNode(barranquitas);
		graph.addNode(ponce);
		graph.addNode(villalba);
		graph.addNode(caguas);
		graph.addNode(arroyo);
		graph.addNode(humacao);
		graph.addNode(fajardo);
		graph.addNode(canovana);
		graph.addNode(sanJuan);
		graph.addNode(vegaBaja);
		graph.addNode(manati);
		graph.addNode(arecibo);
		graph.addNode(lares);
		graph.addNode(adjunta);
		graph.addNode(yauco);
		graph.addNode(lajas);
		graph.addNode(sanGerman);
		graph.addNode(mayaguez);
		graph.addNode(aguadilla);
	}
	
	private void initRoad() {
		LinkedList<Road> roads = new LinkedList<Road>();
		Road a0 = new Road(ponce, santaIsabel, 4, 1, 0);
		Road a1 = new Road(salinas, santaIsabel, 2, 1, 0);
		Road a2 = new Road(salinas, cayey, 4, 1, 0);
		Road a3 = new Road(salinas, arroyo, 4, 1, 0);
		Road a4 = new Road(arroyo, humacao, 4, 1, 0);
		Road a5 = new Road(humacao, fajardo, 4, 1, 0);
		Road a6 = new Road(humacao, caguas, 4, 1, 0);
		Road a7 = new Road(canovana, fajardo, 4, 1, 0);
		Road a8 = new Road(canovana, caguas, 4, 1, 0);
		Road a9 = new Road(sanJuan, canovana, 4, 1, 0);
		Road a10 = new Road(sanJuan, vegaBaja, 4, 1, 0);
		Road a11 = new Road(sanJuan, caguas, 4, 1, 0);
		Road a12 = new Road(cayey, caguas, 4, 1, 0);
		Road a13 = new Road(cayey, barranquitas, 4, 1, 0);
		Road a14 = new Road(barranquitas, santaIsabel, 4, 1, 0);
		Road a15 = new Road(barranquitas, villalba, 4, 1, 0);
		Road a16 = new Road(ponce, villalba, 4, 1, 0);
		Road a17 = new Road(ponce, adjunta, 4, 1, 0);
		Road a18 = new Road(ponce, yauco, 4, 1, 0);		
		Road a19 = new Road(yauco, sanGerman, 4, 1, 0);
		Road a20 = new Road(yauco, lajas, 4, 1, 0);
		Road a21 = new Road(lajas, sanGerman, 4, 1, 0);
		Road a22 = new Road(sanGerman, mayaguez, 4, 1, 0);
		Road a23 = new Road(mayaguez, aguadilla, 4, 1, 0);
		Road a24 = new Road(mayaguez, lares, 4, 1, 0);
		Road a25 = new Road(lares, adjunta, 4, 1, 0);
		Road a26 = new Road(lares, arecibo, 4, 1, 0);
		Road a27 = new Road(aguadilla, arecibo, 4, 1, 0);
		Road a28 = new Road(arecibo, manati, 4, 1, 0);
		Road a29 = new Road(manati, barranquitas, 4, 1, 0);
		Road a30 = new Road(manati, vegaBaja, 4, 1, 0);
		Road a31 = new Road(vegaBaja, barranquitas, 4, 1, 0);
		roads.add(a0);
		roads.add(a1);
		roads.add(a2);
		roads.add(a3);
		roads.add(a4);
		roads.add(a5);
		roads.add(a6);
		roads.add(a7);
		roads.add(a8);
		roads.add(a9);
		roads.add(a10);
		roads.add(a11);
		roads.add(a12);
		roads.add(a13);
		roads.add(a14);
		roads.add(a15);
		roads.add(a16);
		roads.add(a17);
		roads.add(a18);
		roads.add(a19);
		roads.add(a20);
		roads.add(a21);
		roads.add(a22);
		roads.add(a23);
		roads.add(a24);
		roads.add(a25);
		roads.add(a26);
		roads.add(a27);
		roads.add(a28);
		roads.add(a29);
		roads.add(a30);
		roads.add(a31);
		for(Road road: roads) {
			graph.addEdge(road.TravelTime(), road.getCity1(), road.getCity2());
		}
		
	}
	
	@Before
	public void setUp() throws Exception {
		initNodes();
		initRoad();
	}

	@Test
	public void test() {
		Node<City> e = SimulatedAnnealing.simulatedAnnealingPath(graph.getNode(salinas), graph.getNode(barranquitas));
		LinkedList<Node> result = GraphTraversal.reconstructPath(e);
		LinkedList<City> expected = new LinkedList<City>();
		expected.add(salinas);
		expected.add(santaIsabel);
		expected.add(barranquitas);

		assertTrue("Result is not the same size as expected", result.size()==expected.size());
		for (int i = 0; i < result.size(); i++) {
			System.out.println(expected.get(i).getName());
			System.out.println(((City)result.get(i).get()).getName());

			assertTrue("Not the optimize solution", result.get(i).get().equals(expected.get(i)));
		}
		assertTrue("Not the right value of the Path", e.getValue()==6);
	}

}
