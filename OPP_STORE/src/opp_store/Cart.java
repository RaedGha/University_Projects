
package opp_store;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;




public class Cart {
    
    // Scanner object
    Scanner keyboard = new Scanner(System.in);
    
    private String customerName;
    private String phoneNumber;
    private String city;
    private double balance;
    private double totalPrice;
    private ArrayList <SmartPhones> smartPhones = new ArrayList<>();
    private ArrayList <Books> books = new ArrayList<>();
    private ArrayList <Clothes> clothes = new ArrayList<>();
    private ArrayList <Laptops> laptops = new ArrayList<>();
    
    public Cart(String customerName, String phoneNumber, String city) throws FileNotFoundException{
        String[] array;
        
        File file = new File(customerName + phoneNumber + ".csv");
        if (file.exists()){
            Scanner read = new Scanner(file);
            this.customerName = customerName;        
            this.phoneNumber = phoneNumber;
            this.city = city;
            totalPrice = 0;
            balance = 0;
            
            while(read.hasNext()){
                array = read.nextLine().split(";");
                switch(array[0]){
                    case "book":
                        Books book = new Books(array[1], array[2], array[3], Integer.parseInt(array[4]), Double.parseDouble(array[5]));
                        books.add(book);
                        increasePrice(book);
                        break;
                    case "smartphone":
                        SmartPhones smartphone = new SmartPhones(array[1], array[2], Integer.parseInt(array[3]), array[4], Double.parseDouble(array[5]));
                        smartPhones.add(smartphone);       
                        increasePrice(smartphone);
                    case "clothe":
                        Clothes clothe = new Clothes(array[1], array[2], array[3], array[4], Double.parseDouble(array[5]));
                        clothes.add(clothe);
                        increasePrice(clothe);
                        break;
                    case "laptop":
                        Laptops laptop = new Laptops(array[1], array[2], array[3], array[4], array[5], array[6], array[7], Double.parseDouble(array[8]));
                        laptops.add(laptop);
                        increasePrice(laptop);
                        break;
                }   
            }
            read.close();
        }
        else{
            PrintWriter newFile = new PrintWriter(customerName + phoneNumber + ".csv");
            this.customerName = customerName;        
            this.phoneNumber = phoneNumber;
            this.city = city;
            balance = 0;
            totalPrice = 0;
            newFile.close();
        }
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ArrayList<SmartPhones> getSmartPhones() {
        return smartPhones;
    }

    public void setSmartPhones(ArrayList<SmartPhones> smartPhones) {
        this.smartPhones = smartPhones;
    }

    public ArrayList<Books> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Books> books) {
        this.books = books;
    }

    public ArrayList<Clothes> getClothes() {
        return clothes;
    }

    public void setClothes(ArrayList<Clothes> clothes) {
        this.clothes = clothes;
    }

    public ArrayList<Laptops> getLaptops() {
        return laptops;
    }

    public void setLaptops(ArrayList<Laptops> laptops) {
        this.laptops = laptops;
    }   
    
    public void saveAfterRemove() throws IOException{
        PrintWriter writer = new PrintWriter(customerName + phoneNumber + ".csv");
        for(int i = 0; i < books.size(); i++)
            books.get(i).writeOnFile(customerName, phoneNumber);
        for(int i = 0; i < smartPhones.size(); i++)
            smartPhones.get(i).writeOnFile(customerName, phoneNumber); 
        for(int i = 0; i < clothes.size(); i++)
            clothes.get(i).writeOnFile(customerName, phoneNumber); 
        for(int i = 0; i < laptops.size(); i++)
            laptops.get(i).writeOnFile(customerName, phoneNumber); 
        writer.close();
    }
    
    public void modifying(){
        
        int inputI;
        // modify customer information (outer loop)
        do{ 
            // ask about any field he want to modifying
            do{  // check from the input value
                System.out.print("\n\tWhich field do you want to modify:\n" + 
                    "\t1. Name\n\t2. Phone Number\n\t3. City\n\t4. Done\n\t--> ");
                                    
                inputI = keyboard.nextInt();
                System.out.println("");
            }while (OPP_STORE.valueRangeChecker(4, inputI)); // check from the input value
                                
            // modify the field
            switch(inputI){ 
            case 1: // name
                customerName = OPP_STORE.custemrName();
                break;
            case 2: // phone number
                phoneNumber = OPP_STORE.phoneNumber();
                break;
            case 3: // city
                city = OPP_STORE.city();
                break;
            case 4: // done (exit from outer loop)
                System.out.println("\tYour information has been modified successfully");
                break; 
            }
        }while (inputI != 4);
    }
    
    public void addBalance(){
        
        double input;
        // Ask user about the amount of increase
        System.out.print("\n\n\tHow much do you want to add to your balance" + 
                "\n\t--> ");    
        input = keyboard.nextDouble();
        balance += input;
        System.out.println("\n\t$" + input + " has been added successfully\n");
    }
    
    public void addBook(String[] array) throws IOException{
        Books book = new Books(array[1], array[2], array[3], Integer.parseInt(array[4]), Double.parseDouble(array[5]));
        books.add(book);
        increasePrice(book);
        System.out.println("\n\tThe book has been added successfully\n");
        book.writeOnFile(customerName, phoneNumber);
    }
    
    public void addSmartphone(String array[]) throws IOException{
        SmartPhones smartPhone = new SmartPhones(array[1], array[2], Integer.parseInt(array[3]), array[4], Double.parseDouble(array[5]));
        smartPhones.add(smartPhone);
        increasePrice(smartPhone);
        System.out.println("\n\tThe smartphone has been added successfully\n");
        smartPhone.writeOnFile(customerName, phoneNumber);
    }
    
    public void addClothe(String array[]) throws IOException{
        Clothes clothe = new Clothes(array[1], array[2], array[3], array[4], Double.parseDouble(array[5]));
        clothes.add(clothe);
        increasePrice(clothe);
        System.out.println("\n\tThe clothe has been added successfully\n");
        clothe.writeOnFile(customerName, phoneNumber);
    }
    
    public void addLaptop(String array[]) throws IOException{
        Laptops laptop = new Laptops(array[1], array[2], array[3], array[4], array[5], array[6], array[7], Double.parseDouble(array[8]));
        laptops.add(laptop);
        increasePrice(laptop);
        System.out.println("\n\tThe laptop has been added successfully\n");
        laptop.writeOnFile(customerName, phoneNumber);
    }
    
    public void removeBook(int input) throws IOException{
        if (books.size() > 0){
            decreasePrice(books.get(input - 1));
            books.remove(input - 1);
            System.out.println("\n\tThe product has been removed successfully\n");
            saveAfterRemove();
        }    
    }
    
    public void removeSmartphone(int input) throws IOException{
        if (smartPhones.size() > 0){
            decreasePrice(smartPhones.get(input - 1));
            smartPhones.remove(input - 1);
            System.out.println("\n\tThe product has been removed successfully\n");
            saveAfterRemove();
        } 
    }
    
    public void removeClothe(int input) throws IOException{
        if (clothes.size() > 0){
            decreasePrice(clothes.get(input - 1));
            clothes.remove(input - 1);
            System.out.println("\n\tThe product has been removed successfully\n");
            saveAfterRemove();
        } 
    }
    
    public void removeLaptop(int input) throws IOException{
        if (laptops.size() > 0){
            decreasePrice(laptops.get(input - 1));
            laptops.remove(input - 1);
            System.out.println("\n\tThe product has been removed successfully\n");
            saveAfterRemove();
        } 
    }
    
    public void increasePrice(Books book){
        totalPrice += book.getPrice();
    }
    
    public void increasePrice(SmartPhones smartPhone){
        totalPrice += smartPhone.getPrice();
    }
    
    public void increasePrice(Clothes clothe){
        totalPrice += clothe.getPrice();
    }
    
    public void increasePrice(Laptops laptop){
        totalPrice += laptop.getPrice();
    }
    
    public void decreasePrice(Books book){
        totalPrice -= book.getPrice();
    }
    
    public void decreasePrice(SmartPhones smartPhone){
        totalPrice -= smartPhone.getPrice();
    }
    
    public void decreasePrice(Clothes clothe){
        totalPrice -= clothe.getPrice();
    }
    
    public void decreasePrice(Laptops laptop){
        totalPrice -= laptop.getPrice();
    }
    
    public void PurchaseConfirmation () throws IOException{
        if (balance >= totalPrice + (totalPrice * 0.15)){
            books.removeAll(books);
            smartPhones.removeAll(smartPhones);
            clothes.removeAll(clothes);
            laptops.removeAll(laptops);
            balance -= totalPrice + (totalPrice * 0.15);
            totalPrice = 0;
            System.out.println("\n\tYour purchase has been confirmed successfully, thank you for your shopping");
        }
        else
            System.out.println("\n\tYou do not have enough balance to complete the purchase\n");
        saveAfterRemove();
    }
    
    @Override
    public String toString(){
        String s = "";
        for (int i = 0, counter = 1; i < books.size(); i++, counter++)
            s  += "Book " + counter + ":\n" + books.get(i).toString() + "\n\n";
        
        for (int i = 0, counter = 1; i < smartPhones.size(); i++, counter++)
            s  += "Smartphone " + counter + ":\n" + smartPhones.get(i).toString() + "\n\n";
        
        for (int i = 0, counter = 1; i < clothes.size(); i++, counter++)
            s  += "clothe " + counter + ":\n" + clothes.get(i).toString() + "\n\n";
        
        for (int i = 0, counter = 1; i < laptops.size(); i++, counter++)
            s  += "laptop " + counter + ":\n" + laptops.get(i).toString() + "\n\n";
        
        s += "---------------\n\n";
        s += "Sub total: " + String.format("$%.2f", totalPrice) + "\nTax : " + String.format("$%.2f", totalPrice * 0.15) +
                "\nTotal: " + String.format("$%.2f",(totalPrice + (totalPrice * 0.15))) + "\n\nYour balance: " + String.format("$%.2f", balance);
        return s;
    }
}
