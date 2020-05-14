package maps;

import java.util.LinkedList;

import elements.City;
import elements.Road;
import graph.Graph;

public class PuertoRico extends Graph<City>{

	public City cayey = new City("Cayey",18.1147676,-66.1677892);
	public City salinas = new City("Salinas",18.0045791,-66.3244161);
	public City santaIsabel = new City("Santa Isabel",17.9810439,-66.4269804);
	public City barranquitas = new City("Barranquitas",18.1845662,-66.3138549);
	public City ponce = new City("Ponce",17.9702607,-66.6639921);
	public City villalba = new City("Villalba",18.1301094,-66.509399);
	public City caguas = new City("Caguas",18.23931,-66.0770615);
	public City arroyo = new City("Arroyo",17.9965036,-66.0924881);
	public City humacao = new City("Humacao",18.1381108,-65.8387628);
	public City fajardo = new City("Fajardo",18.3332889,-65.6738796);
	public City canovana = new City("Canovana",18.3811414,-65.922932);
	public City sanJuan = new City("San Juan",18.3893875,-66.1305125);
	public City vegaBaja = new City("Vega Baja",18.4430098,-66.4198185);
	public City manati = new City("Manati",18.418203,-66.5262785);
	public City arecibo = new City("Arecibo",18.4049622,-66.745303);
	public City lares = new City("Lares",18.295587,-66.8905283);
	public City adjunta = new City("Adjunta",18.1812148,-66.7859854);
	public City yauco = new City("Yauco",18.0339475,-66.881348);
	public City lajas = new City("Lajas",18.0466201,-67.0668792);
	public City sanGerman = new City("San German",18.0831448,-67.0519916);
	public City mayaguez = new City("Mayaguez",18.2019879,-67.1686796);
	public City aguadilla = new City("Aguadilla",18.419396,-67.1711135);
	
	public PuertoRico() {
		super();
		initNode();
		initEdge();
	}

	private void initNode() {
		addNode(cayey);
		addNode(salinas);
		addNode(santaIsabel);
		addNode(barranquitas);
		addNode(ponce);
		addNode(villalba);
		addNode(caguas);
		addNode(arroyo);
		addNode(humacao);
		addNode(fajardo);
		addNode(canovana);
		addNode(sanJuan);
		addNode(vegaBaja);
		addNode(manati);
		addNode(arecibo);
		addNode(lares);
		addNode(adjunta);
		addNode(yauco);
		addNode(lajas);
		addNode(sanGerman);
		addNode(mayaguez);
		addNode(aguadilla);
	}

	private void initEdge() {
		LinkedList<Road> roads = new LinkedList<Road>();
		Road a0 = new Road(ponce, santaIsabel, 24, 1, 0);
		Road a1 = new Road(salinas, santaIsabel, 12, 1, 0);
		Road a2 = new Road(salinas, cayey, 28, 1, 0);
		Road a3 = new Road(salinas, arroyo, 33, 1, 0);
		Road a4 = new Road(arroyo, humacao, 50, 1, 0);
		Road a5 = new Road(humacao, fajardo, 40, 1, 0);
		Road a6 = new Road(humacao, caguas, 31, 1, 0);
		Road a7 = new Road(canovana, fajardo, 32, 1, 0);
		Road a8 = new Road(canovana, caguas, 36, 1, 0);
		Road a9 = new Road(sanJuan, canovana, 30, 1, 0);
		Road a10 = new Road(sanJuan, vegaBaja, 47, 1, 0);
		Road a11 = new Road(sanJuan, caguas, 33, 1, 0);
		Road a12 = new Road(cayey, caguas, 25, 1, 0);
		Road a13 = new Road(cayey, barranquitas, 30, 1, 0);
		Road a14 = new Road(barranquitas, santaIsabel, 40, 1, 0);
		Road a15 = new Road(barranquitas, villalba, 33, 1, 0);
		Road a16 = new Road(ponce, villalba, 30, 1, 0);
		Road a17 = new Road(ponce, adjunta, 25, 1, 0);
		Road a18 = new Road(ponce, yauco, 35, 1, 0);		
		Road a19 = new Road(yauco, sanGerman, 27, 1, 0);
		Road a20 = new Road(yauco, lajas, 30, 1, 0);
		Road a21 = new Road(lajas, sanGerman, 5, 1, 0);
		Road a22 = new Road(sanGerman, mayaguez, 20, 1, 0);
		Road a23 = new Road(mayaguez, aguadilla, 28, 1, 0);
		Road a24 = new Road(mayaguez, lares, 48, 1, 0);
		Road a25 = new Road(lares, adjunta, 32, 1, 0);
		Road a26 = new Road(lares, arecibo, 29, 1, 0);
		Road a27 = new Road(aguadilla, arecibo, 50, 1, 0);
		Road a28 = new Road(arecibo, manati, 30, 1, 0);
		Road a29 = new Road(manati, barranquitas, 55, 1, 0);
		Road a30 = new Road(manati, vegaBaja, 10, 1, 0);
		Road a31 = new Road(vegaBaja, barranquitas, 47, 1, 0);
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
			addEdge(road.TravelTime(), road.getCity1(), road.getCity2());
		}
	}
}
