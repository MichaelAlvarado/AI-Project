package elements;

import java.text.DecimalFormat;

public class City {
	
	String name;
	
	//Coordinates (x, y) position on map
	double x;
	double y;
	
	public City(String name, double x, double y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}
	
	//Setters and getters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	/**
	 * This method Calculate the distance from this to city in Kilometers using google maps pin locations
	 * @date May 14, 2020
	 * @param city
	 * @return
	 */
	public double CalculationByDistance(City city) {
        int Radius=6371;//radius of earth in Km         
        double lat1 = this.x;
        double lat2 = city.x;
        double lon1 = this.y;
        double lon2 = city.y;
        double dLat = Math.toRadians(lat2-lat1);
        double dLon = Math.toRadians(lon2-lon1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
        Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
        Math.sin(dLon/2) * Math.sin(dLon/2);
        double c = 2 * Math.asin(Math.sqrt(a));
        double valueResult= Radius*c;

        return valueResult;
     }
	
	
	
}
