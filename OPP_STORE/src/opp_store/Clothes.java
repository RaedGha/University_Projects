
package opp_store;



import java.io.*;
import java.util.*;
         
public class Clothes {


    /**** declaring attributes ****/
    private String gender;
    private String clothestypes;
    private String size;
    private String color;
    private double price;

    Scanner keyboard = new Scanner(System.in);
    
    /****creating a constructor****/
    public Clothes(String gender, String clothestypes, String size, String color, double price) {    
        this.gender = gender;
        this.clothestypes = clothestypes;
        this.size = size;
        this.color = color;
        this.price = price;
    }
    
    public Clothes(){
        
    }
    
    /**** adding Set and Get methods *****/
    /*--------------------------------------------------------------------*/
    public String getColor() {
        return color;
    }

   
    public void setColor( String colors) throws IOException {
            
        this.color = colors;
        
    }
    
    public String getSize() {
        return size;
    }

    public void setSize(String Size) throws IOException {
      
         this.size = Size;
    }
       

    
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
       
         this.gender = gender;
    }

   
    public double getPrice() {
        
        return price;
    }

  
    public void setPrice(double price) throws IOException {
        
       this.price=price;
     
    }
   
    public String getClothestypes() {
        return clothestypes;
    }

    
    public void setClothestypes(String clothes) throws IOException {
       
        
        this.clothestypes =clothes;
           
    }
    
    public void writeOnFile(String customerName, String phoneNumber) throws IOException{
        FileWriter file = new FileWriter(customerName + phoneNumber + ".csv", true);
        PrintWriter filewriter = new PrintWriter(file);
        filewriter.println("clothe;" + gender + ";" + clothestypes + ";" + size + ";" + color + ";" + price);
        filewriter.close();
    }
    
    public int printClothes() throws IOException{
        
        // variable declaration
        int inputI;
        
        // print the products of the section
        OPP_STORE.printFileContents("Clothes", 5, 20);
        
        // Ask the user if he want to add a product to the cart or back to section menu
        do{ // check from the input value
            System.out.print("\n\n\tWhat do want to do" +
                     "\n\t1. Add a clothes to the cart." +
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
            System.out.print("\n\n\tEnter the number of the clothes:" +
                     "\n\t--> ");
            
            inputI = keyboard.nextInt();
        }while(OPP_STORE.valueRangeChecker(20, inputI));// check from the input value
        System.out.print("\n\t--> ");
        
        // Read the line from the Excel and store it in the array
        array = OPP_STORE.readFromFile("Clothes", inputI);
        
        // print the products from array 
        for(int i = 1; i <= 5; i++)
            System.out.print(array[i] + " | ");
        
        return array;    
    }
    
     /******* to string method to return the clothes type and price *******/
     public String toString() {
        
        return String.format("Clothes section\nClothes name: %s\nPrice: %.2f",clothestypes , price);
    } 
    
}
