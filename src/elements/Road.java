package elements;

import graph.Node;

public class Road {
	
	City city1;
	City city2;
	
	double distance;
	int speedLimit;
	double traffic;
	
	public Road(City from, City  to, double distance, int speedLimit, double traffic) {
		this.city1 = from;
		this.city2 = to;
		this.distance = distance;
		this.speedLimit = speedLimit;
		this.traffic = traffic;
	}
	
	public City getCity1() {
		return city1;
	}

	public void setCity1(City city1) {
		this.city1 = city1;
	}

	public City getCity2() {
		return city2;
	}

	public void setCity2(City city2) {
		this.city2 = city2;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public int getSpeedLimit() {
		return speedLimit;
	}

	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
	}

	public double getTraffic() {
		return traffic;
	}

	public void setTraffic(double traffic) {
		this.traffic = traffic;
	}

	public double TravelTime() {
		double time = minimumTravelTime();
		//traffic affects travel-time, is given by a percentage of extra-time
		//traffic depends on the current time it takes
		//the effective time will be equal to the base time, plus the extra time given by traffic
		//the effective time will be equal to time, when traffic is 0
		time += time*traffic;
		//output time will be in terms of hours
		return time;
	}
	
	/**
	 * Returns the time to travel this road with no traffic
	 * @author Michael J. Alvarado
	 * @date May 14, 2020
	 * @return
	 */
	public double minimumTravelTime() {
		return distance/speedLimit;
	}
	
	public static double getDistance(City  from, City  to) {
		double dX = (from.getX() - to.getX());
		double dY = (from.getY() - to.getY());
		
		return Math.sqrt(dX * dX + dY * dY);
	}
	
	/*
	private int speedLimit() {
		return this.speedLimit;
	}
	
	private double getTraffic() {
		return this.traffic;
	}
	*/
}
