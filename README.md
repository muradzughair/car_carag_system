# Car Garage System

## Project Overview
The Car Garage System is a Java-based desktop application designed to manage a small inventory of vehicles, specifically cars and trucks. The system provides a graphical user interface (GUI) built with Swing, allowing users to add new vehicles, list existing inventory, and search for specific vehicles based on their price.

The project demonstrates fundamental object-oriented programming (OOP) principles such as inheritance, method overriding, and method overloading, alongside basic data structures and algorithms.

## Technical Features
The application is built using several core programming concepts:

* **Object-Oriented Design**: A base `Vehicle` class provides common attributes like color, model, and price. Subclasses `Car` and `Truck` extend this base class to include specific features like transmission type or load capacity.
* **Sorting Algorithms**: The system uses a Bubble Sort algorithm to organize vehicles by price before they are listed or searched.
* **Search Algorithms**: A Binary Search algorithm is implemented to efficiently find vehicles within the sorted lists based on a specific price point.
* **GUI Components**: The interface uses `JFrame`, `JButton`, and `JOptionPane` to interact with the user, making the process of entering data and viewing results straightforward.

## File Structure
The project consists of the following source files:

1.  **Vehicle.java**: The parent class containing shared attributes (model, color, price) and the default info printing method.
2.  **Car.java**: A subclass of Vehicle that adds a "type" attribute (e.g., Manual or Automatic) and includes examples of method overloading and overriding.
3.  **Truck.java**: A subclass of Vehicle that adds a "loadCapacity" attribute.
4.  **Garage.java**: The main entry point of the application. It handles the GUI logic, manages the ArrayLists for storage, and contains the logic for sorting and searching.

## How to Use the System
When you run the application, a small window will appear with four main options:

1.  **New**: Opens a series of dialog boxes to input details for either a new car or a new truck. This data is then stored in the system memory.
2.  **List**: Displays a summary of all vehicles currently in the garage. The list is automatically sorted by price from lowest to highest and identifies the most expensive vehicle in each category.
3.  **Search**: Prompts the user for a specific price. The system then searches through the inventory and returns the details of any car or truck that matches that price exactly.
4.  **Exit**: Safely closes the application.

## Requirements
* Java Development Kit (JDK) 8 or higher.
* A Java IDE (such as Eclipse, IntelliJ IDEA, or NetBeans) or a command-line environment to compile and run the .java files.
