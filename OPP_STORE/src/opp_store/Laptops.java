
package opp_store;


import java.io.*;
import java.util.*;


public class Laptops {
    
     Scanner keyboard = new Scanner(System.in);
     
   //initialize fields
      private String company;
      private String model;
      private String core;
      private String ram;
      private String graphics_card;
      private String storage;
      private String color;
      private double price;
      
    /****** creating a Constructor ******/
    public Laptops(String company, String model, String core, String ram, String graphics_card, String storage, String color, double price) {
        this.company = company;
        this.model = model;
        this.core = core;
        this.ram = ram;
        this.graphics_card = graphics_card;
        this.storage = storage;
        this.color = color;
        this.price = price;
    }
    
    public Laptops(){
        
    }
    
    /****** adding set and get method *******/
    public String getcompany() {
        return company;
    }

    
    public void setcompany(String company) throws IOException {
       this.company=company;
    }
   
    public String getcore() {
        return core;
    }

   
    public void setcore(String core) throws IOException{ 
        this.core=core;
    }

   
    public String getColor() {
        return color;
    }

   
    public void setColor(String color) throws IOException {
         
        this.color = color;
        
    }

   
    public double getPrice() {
        return price;
    }

   
    public void setPrice(double price) {
        this.price = price;
    }

    
    public String getModel() {
        return model;
    }

    
    public void setModel(String model) {
        this.model = model;
    }

    public String getRam() {
        return ram;
    }

    
    public void setRam(String ram) {
        this.ram = ram;
    }

   
    public String getGraphics_card() {
        return graphics_card;
    }

   
    public void setGraphics_card(String graphics_card) {
        this.graphics_card = graphics_card;
    }

   
    public String getStorage() {
        return storage;
    }

   
    public void setStorage(String storage) {
        this.storage = storage;
    }
    public void writeOnFile(String customerName, String phoneNumber) throws IOException{
        FileWriter file = new FileWriter(customerName + phoneNumber + ".csv", true);
        PrintWriter filewriter = new PrintWriter(file);
        filewriter.println("laptop;" + company + ";" + model + ";" + core + ";" + ram + ";" + graphics_card + ";" + storage + ";" + color + ";" + price);
        filewriter.close();
    }
    
     public int printLaptops() throws IOException{
        // variable declaration
        int inputI;
        
        // print the products of the section
        OPP_STORE.printFileContents("Laptops", 8, 16);
        
        // Ask the user if he want to add a product to the cart or back to section menu
        do{ // check from the input value
            System.out.print("\n\n\tWhat do want to do" +
                     "\n\t1. Add a Laptop to the cart." +
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
            System.out.print("\n\n\tEnter the number of the Laptop:" +
                     "\n\t--> ");
            
            inputI = keyboard.nextInt();
        }while(OPP_STORE.valueRangeChecker(16, inputI));// check from the input value
        System.out.print("\n\t--> ");
        
        // Read the line from the Excel and store it in the array
        array = OPP_STORE.readFromFile("Laptops", inputI);
        
        // print the products from array 
        for(int i = 1; i <= 8; i++)
            System.out.print(array[i] + " | ");
        
        return array;    
    }
    
      /*******to string method to return the laptop name and price*******/
    public String toString() {
        
        return String.format("Laptop section\nLaptop name: %s\nPrice: %.2f", model, price);
    } 
            
}
