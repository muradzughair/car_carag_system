package cars_carage_system;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Garage {

	// to let the whole class access them;
	static ArrayList<Car> cars = new ArrayList<>();
    static ArrayList<Truck> trucks = new ArrayList<>();
    
    
    public static void main(String[] args) {
    	
    	  	
    	// make a frame
        JFrame frame = new JFrame("Car Garage System");
        
        frame.setSize(400, 200);
        
        // use place Components method
        placeComponents(frame);

        frame.setVisible(true);
    }

    // method that take the frame as parameter and see user choices
   static void placeComponents(JFrame frame) {
        frame.setLayout(null);
        
        //make a Button for every choice
        JButton newButton = new JButton("New");
        newButton.setBounds(50, 20, 80, 25);
        frame.add(newButton);

        JButton listButton = new JButton("List");
        listButton.setBounds(150, 20, 80, 25);
        frame.add(listButton);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(250, 20, 80, 25);
        frame.add(searchButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(150, 60, 80, 25);
        frame.add(exitButton);
        
        // Action listener for new choice
        newButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	// use create vehicle method
                createNewVehicle();
            }
        });

        // Action listener for list choice
        listButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	// use list vehicle method
                listVehicles();
            }
        });
        
        // Action listener for search choice
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	// use search vehicle method
                searchVehicle();
            }
        });
        
        // Action listener for exit choice
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//Stops all running threads and closes all resources(close the application) 
                System.exit(0);
            }
        });
    }
   

    private static void createNewVehicle() {
    	
    	
        String[] options = {"Car", "Truck"};
        
        // if the user choose car choice=0 and he/she use truck choice=1 because it depends on the array index
        int choice = JOptionPane.showOptionDialog(null, "Choose vehicle type", "New Vehicle",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, null);

        if (choice == 0) { // Car
            try {
            	
            	// take all car detailed from user
                String model = JOptionPane.showInputDialog("Enter model:");
                //I user Integer.parseInt take the integer value from user
                int price = Integer.parseInt(JOptionPane.showInputDialog("Enter price:"));
                String color = JOptionPane.showInputDialog("Enter color:");
                String type = JOptionPane.showInputDialog("Manual or automatic:");
             
                // make a new car object and add it to the array
                Car newCar = new Car(color, model, price, type);
                cars.add(newCar);
                
                JOptionPane.showMessageDialog(null, "New car created.\n" );
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input for price. Please enter a valid integer.");
            }
        } else if (choice == 1) { // Truck
            try {
            	
            	// take trucks car detailed from user
                String model = JOptionPane.showInputDialog("Enter model:");
                int price = Integer.parseInt(JOptionPane.showInputDialog("Enter price:"));
                String color = JOptionPane.showInputDialog("Enter color:");
                int loadCapacity = Integer.parseInt(JOptionPane.showInputDialog("Enter load capacity:"));

                // make a new car object and add it to the array
                Truck newTruck = new Truck(color, model, price, loadCapacity);
                trucks.add(newTruck);
                
                JOptionPane.showMessageDialog(null, "New truck created.\n" );
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input for price or load capacity. Please enter a valid integer.");
            }
        }
    }

    static void listVehicles() {
    	
    	// I use StringBuilder do I can add to the string value more text by using append then print the whole value in the message dialog
        StringBuilder message = new StringBuilder();
        message.append("Your cars:\n");

        bubbleSortCars(cars);

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            message.append((i + 1)).append(") model: ").append( car.getModel() ).append(", color: ").append( car.getColor() ).append(", type: ").append(car.getType()).append(", price: ").append(car.getPrice()).append("\n");
        }

        if (!cars.isEmpty()) {
            Car mostExpensiveCar = cars.get(cars.size() - 1);
            message.append("you have (").append(cars.size()).append(") cars most expensive car: ").append(mostExpensiveCar.getModel()).append("\n");
        }

        message.append("\nYour trucks:\n");
        bubbleSortTrucks(trucks);

        for (int i = 0; i < trucks.size(); i++) {
            Truck truck = trucks.get(i);
            message.append((i + 1)).append(") model: ").append( truck.getModel() ).append(", color: ").append( truck.getColor() ).append(", load capacity: ").append(truck.getLoadCapacity()).append(", price: ").append(truck.getPrice()).append("\n");
        }

        if (!trucks.isEmpty()) {
            Truck mostExpensiveTruck = trucks.get(trucks.size() - 1);
            message.append("you have (").append(trucks.size()).append(") trucks most expensive truck: ").append(mostExpensiveTruck.getModel()).append("\n");
        }
        
        //to show the message is string;
        JOptionPane.showMessageDialog(null, message.toString());
    }

     static void searchVehicle() {
        try {
        	
            int searchPrice = Integer.parseInt(JOptionPane.showInputDialog("Enter the price to search:"));

            bubbleSortCars(cars);
            Car foundCar = binarySearchCars(cars, searchPrice);
            if (foundCar != null) {
                JOptionPane.showMessageDialog(null, "Car with price (" + searchPrice + "$):\n " +foundCar.getModel() + ": ,Type: "+foundCar.getType() + " ,color: " + foundCar.getColor() );
                
                
            } else {
                JOptionPane.showMessageDialog(null, "No car found with the specified price.");
            }

            bubbleSortTrucks(trucks);
            Truck foundTruck = binarySearchTrucks(trucks, searchPrice);
            if (foundTruck != null) {
                JOptionPane.showMessageDialog(null, "Truck with price (" + searchPrice + "$):\n" +foundTruck.getModel() + ": ,load capacity: "+foundTruck.getLoadCapacity() + " ,color: " + foundTruck.getColor() );
            } else {
                JOptionPane.showMessageDialog(null, "No truck found with the specified price.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input for price. Please enter a valid integer.");
        }
    }

    static void bubbleSortCars(ArrayList<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            for (int j = 0; j < cars.size() - 1; j++) {
                if (cars.get(j).getPrice() > cars.get(j + 1).getPrice()) {
                    Car temp = cars.get(j + 1);
                    cars.set(j + 1, cars.get(j));
                    cars.set(j, temp);
                }
            }
        }
    }

    static void bubbleSortTrucks(ArrayList<Truck> trucks) {
        for (int i = 0; i < trucks.size(); i++) {
            for (int j = 0; j < trucks.size() - 1; j++) {
                if (trucks.get(j).getPrice() > trucks.get(j + 1).getPrice()) {
                    Truck temp = trucks.get(j + 1);
                    trucks.set(j + 1, trucks.get(j));
                    trucks.set(j, temp);
                }
            }
        }
    }

    static Car binarySearchCars(ArrayList<Car> cars, int searchPrice) {
        int low = 0;
        int high = cars.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (cars.get(mid).getPrice() == searchPrice) {
                return cars.get(mid);
            } else if (cars.get(mid).getPrice() > searchPrice) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return null;
    }

    static Truck binarySearchTrucks(ArrayList<Truck> trucks, int searchPrice) {
        int low = 0;
        int high = trucks.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (trucks.get(mid).getPrice() == searchPrice) {
                return trucks.get(mid);
            } else if (trucks.get(mid).getPrice() > searchPrice) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return null;
    }
}
