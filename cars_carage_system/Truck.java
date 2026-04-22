package cars_carage_system;

public class Truck extends Vehicle {
	
	
    private	int loadCapacity;

	public Truck(String color, String model, int price, int loadCapacity) {
		super(color, model, price);
		this.loadCapacity=loadCapacity;
	}

	public int getLoadCapacity() {
		
		return loadCapacity;
	}
	
	// Overriding
	void printInfo() {
    	System.out.println( "model:" + getModel() +", color:" + getColor() + " , price:" + getPrice() + " ,load capacity:" + getLoadCapacity() + " people");
    }

	
	//overloading
	void printInfo(int numberOfTrucks,String mostExpensiveTruck ) {
    	System.out.println("You have (" + numberOfTrucks + ") cars, the most expensive one is(" + mostExpensiveTruck + ")");
    }
	
	
	
	
	
	

}
