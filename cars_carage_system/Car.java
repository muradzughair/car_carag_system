package cars_carage_system;


public class Car extends Vehicle {

	private String type;
	
	public Car(String color, String model, int price, String type) {
		super(color, model, price);
		this.type=type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	//Overriding
	void printInfo() {
    	System.out.println( "model:" + getModel() +", color:" + getColor() + " , price:" + getPrice() + " , type:" + getType());
    }
	
	//overloading
	void printInfo(int numberOfCars ,String mostExpensiveCar ) {
    	System.out.println("You have (" + numberOfCars + ") cars, the most expensive one is(" + mostExpensiveCar + ")");
    }
	

}
	
	


