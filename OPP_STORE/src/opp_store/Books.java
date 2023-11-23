package opp_store;

import java.io.*;
import java.util.Scanner;



public class Books {
    
    // Scanner object
    Scanner keyboard = new Scanner(System.in);
    
    private String bookName;
    private String auther; 
    private String genre;
    private int pages;
    private double price;

    
    public Books(String bookName, String auther, String genre, int pages, double price) {
        this.bookName = bookName;
        this.auther = auther;
        this.genre = genre;
        this.pages = pages;
        this.price = price;
    }

    public Books() {
    }
    
    

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
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
        filewriter.println("book;" + bookName + ";" + auther + ";" + genre + ";" + pages + ";" + price );
        filewriter.close();
    }
    
    public int printBooks() throws IOException{
        
        // variables declaration
        int inputI;
        // Print the products of the section
        OPP_STORE.printFileContents("Books", 5, 10); 
                                    
        // Ask the user if he want add a product to the cart or back to section menu
        do{ // check from the input value
            System.out.print("\n\n\tWhat do you want to do" + 
                "\n\t1. Add a book to the cart." + 
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
            System.out.print("\n\n\tEnter the number of the book:" + 
                    "\n\t--> ");
            keyboard.nextLine();
            inputI = keyboard.nextInt();
        }while (OPP_STORE.valueRangeChecker(10, inputI)); // check from the input value
        System.out.print("\n\t--> ");
                                        
        // Read the line from the execl and store it in the array
        array = OPP_STORE.readFromFile("Books", inputI);
                                        
        // Print the product from array
        for (int i = 1; i <= 5; i++)
            System.out.print(array[i] + " | ");
        
        return array;
    }
    
    public String toString(){
        return String.format("Book section\nBook Name: %s\nPrice: %.2f", bookName, price);
    }
    
}
