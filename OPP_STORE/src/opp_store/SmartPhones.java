
package opp_store;

import java.io.*;
import java.util.Scanner;



public class SmartPhones  {
    
    // Scanner object
    Scanner keyboard = new Scanner(System.in);
    
    //fields declaration
    private String company;
    private String model;
    private int storage;
    private String color;
    private double price;
    
    public SmartPhones(String company, String model, int storage, String color, double price){
        this.company = company;
        this.model = model;
        this.storage = storage;
        this.color = color;
        this.price = price;
    }

    public SmartPhones() {
    }
    
    

    public String getCompany() {
        return company;
    }

    public void setCompany(String logo) {
        this.company = logo;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public String getColor() {
        
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public void writeOnFile(String customerName, String phoneNumber) throws IOException{
        FileWriter file = new FileWriter(customerName + phoneNumber + ".csv", true);
        PrintWriter filewriter = new PrintWriter(file);
        filewriter.println("smartphone;" + company + ";" + model + ";" + storage + ";" + color + ";" + price);
        filewriter.close();
    }
    
    public int printSmartPhones() throws IOException{
        
        // variables declaration
        int inputI;
        
        // Print the products of the section
        OPP_STORE.printFileContents("SmartPhones", 5, 15);
        
        // Ask the user if he want add a product to the cart or back to section menu
        do{ // check from the input value
            System.out.print("\n\n\tWhat do you want to do" + 
                    "\n\t1. Add a smartphone to the cart." + 
                    "\n\t2. Back to sections menu." + 
                    "\n\t--> ");
                                        
            inputI = keyboard.nextInt();
            }while(OPP_STORE.valueRangeChecker(2, inputI)); // check from the input value
    
        return inputI;
    }
    
    public String[] bringProduct() throws IOException{
        
        int inputI;
        String[] array;
        // Ask the user about the number of the product from the table
        do{ // check from the input value
            System.out.print("\n\n\tEnter the number of the smartphone:" + 
                    "\n\t--> ");
                                            
            inputI = keyboard.nextInt();
        }while (OPP_STORE.valueRangeChecker(15, inputI)); // check from the input value
        System.out.print("\n\t--> ");
                                        
        // Read the line from the execl and store it in the array
        array = OPP_STORE.readFromFile("SmartPhones", inputI);
                                        
        // Print the product from array
        for (int i = 1; i <= 5; i++)
            System.out.print(array[i] + " | ");
        
        return array;
    }

    public String toString(){
        return String.format("SmartPhone section\nModel: %s\nPrice: %.2f", model, price);
    }  
}
