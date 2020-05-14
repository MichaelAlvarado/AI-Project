package elements;

import graph.Node;

public class Road {
	
	Node<City> from;
	Node<City> to;
	
	int speedLimit;
	double traffic;
	
	public Road(Node<City> from, Node<City>  to, int speedLimit) {
		this.from = from;
		this.to = to;
		this.speedLimit = speedLimit;
	}
	
	public static double TravelTime(double distance, int speedLimit, double traffic) {
		double time = distance/speedLimit;
		//traffic affects travel-time, is given by a percentage of extra-time
		//traffic depends on the current time it takes
		//the effective time will be equal to the base time, plus the extra time given by traffic
		//the effective time will be equal to time, when traffic is 0
		double effTime = time + time*traffic;
		//output time will be in terms of hours
		return effTime;
	}
	
	public static double getDistance(Node<City>  from, Node<City>  to) {
		double dX = (from.get().getX() - to.get().getX());
		double dY = (from.get().getY() - to.get().getY());
		
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
