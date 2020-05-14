package testers;

import java.text.DecimalFormat;

import elements.City;

public class distanceTesting {
	public static void main(String[] args) {
		City salinas = new City("Salinas",18.0045791,-66.3244161);
		City manati = new City("Manati",18.418203,-66.5262785);

		System.out.println(salinas.CalculationByDistance(manati));
	}

}
