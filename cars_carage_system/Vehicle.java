package cars_carage_system;

public class Vehicle {
	
	private String color;
    private String model;
    private int price;

    // Constructor
    public Vehicle(String color, String model, int price) {
        this.color = color;
        this.model = model;
        this.price = price;
    }

    // Getter methods
    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }
    
    
    void printInfo() {
    	System.out.println( "model:" + getModel() +", color:" + getColor() + " , price:" + getPrice() );
    }

}
