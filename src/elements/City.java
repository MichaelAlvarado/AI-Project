package elements;

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

	
	
	
}
