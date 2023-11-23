package opp_store;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;


public class OPP_STORE {

    
    public static void main(String[] args)throws IOException {

        // A scanner object
        Scanner keyboard = new Scanner(System.in);      
        
        // Variables declaration
        int inputI; // // Holds an integer value from the user
        boolean flag = true; // control the enrire program
          
        System.out.println("\n\n\t\tWelcome to OOP STORE"); // Greating message      
        Cart cus = new Cart(custemrName(), phoneNumber(), city()); // Cart Object and ask user about his information (name, phone number, city)
        
        // Start of the program
        do{
            do{ // print the menu and ask user about his choice
                maintMenu();
                inputI = keyboard.nextInt();
                System.out.println("");
            }while (valueRangeChecker(4, inputI)); // check from the input value    
            
            switch(inputI){ // determine the action based on the choiceS from user
                
                case 1: // Customer information     
                    do{// Many options for the user
                        System.out.println("\tName: " + cus.getCustomerName() + 
                                "\n\tPhone number: " + cus.getPhoneNumber() + 
                                "\n\tCity: " + cus.getCity() + 
                                "\n\tYour balance: $" + cus.getBalance()); // print customer information
                        do{  // ask user if he want to modify his information, add to his balance or back to main menu
                            System.out.print("\n\t1. Modify the information\n" + 
                                    "\t2. Add to your balance\n" +
                                    "\t3. back to main menu\n\t--> ");
                            inputI = keyboard.nextInt();
                        }while(valueRangeChecker(3, inputI)); // check from the input value
                        if (inputI == 1) // if he want to modifying his information                            
                            cus.modifying();
                        else if (inputI == 2)
                            cus.addBalance();
                        else // if he want to back to main menu 
                            break;
                    }while (true);
                    break; // end of case 1
                    
                case 2: // All Section  
                    do{
                        do{
                            sectionsMenu();                            
                            inputI = keyboard.nextInt(); 
                            System.out.println("");
                        }while(valueRangeChecker( 5, inputI));
                        switch (inputI){
                            
                            case 1: // Books
                                do{                                    
                                    Books book = new Books(); // craete a book object.                                    
                                    inputI = book.printBooks(); // print all books from the file and ask the user what he want to do.
                                    if (inputI == 1){ // If he want to add a product to the cart.                                                                                                                                                             
                                        cus.addBook(book.bringProduct());// // Ask the user which book he want and add the book object to cus object (cart class).
                                    } // back to the products table
                                    else
                                        break; 
                                }while(true);
                                break; // back to the section menu
                                
                            case 2: // Clothes
                                do{
                                    Clothes clothe = new Clothes();
                                    inputI = clothe.printClothes();
                                    if (inputI == 1)
                                        cus.addClothe(clothe.bringProduct());
                                    else
                                        break;
                                }while(true);
                                break; // back to the section menu
                                
                            case 3: // SmartPhones
                                do{
                                    SmartPhones smartPhone = new SmartPhones(); // Create a smartphone object
                                    inputI = smartPhone.printSmartPhones(); // print all samrtphones from the file and ask the user what he want to do.                                   
                                    if (inputI == 1){ // If he want to add a product to the cart                                                                                
                                        cus.addSmartphone(smartPhone.bringProduct()); // Ask the user which product he want and add the smartphone object to cus object (cart class)                                                             
                                    } // back to the products table
                                    else
                                        break; 
                                }while(true);
                                break; // back to the section menu
                                
                            case 4: // Laptops
                                do{
                                    Laptops laptop = new Laptops();
                                    inputI = laptop.printLaptops();
                                    if (inputI == 1)
                                        cus.addLaptop(laptop.bringProduct());
                                    else
                                        break;
                                }while(true);
                                break; // back to the section menu
                        }
                    }while (inputI != 5);
                    break; // end of case 2 (All sections)
                
                // Cart    
                case 3:
                    do{
                        System.out.println(cus);
                        do{
                            System.out.print("\n\tSelect what you want to do." + 
                                    "\n\t1. Remove a product" + 
                                    "\n\t2. Purchase confirmation" + 
                                    "\n\t3. Back to main menu" + 
                                    "\n\t--> ");                          
                            inputI = keyboard.nextInt();
                        }while(valueRangeChecker(4, inputI));
                        if(inputI == 1){
                            do{
                                System.out.print("\n\n\tWhich section do you want to remove a product from it" +
                                        "\n\t1. Books" + "\n\t2. Clothes" + "\n\t3. Smartphones" + "\n\t4. Laptops" + 
                                        "\n\t5. Back to the cart" + "\n\t--> ");
                                inputI = keyboard.nextInt();
                            }while (valueRangeChecker(5, inputI));
                            switch(inputI){
                                case 1:
                                    cus.removeBook(numOfProduct(cus.getBooks().size()));
                                    break;
                                case 2:
                                    cus.removeClothe(numOfProduct(cus.getClothes().size()));
                                    break;
                                case 3:
                                    cus.removeSmartphone(numOfProduct(cus.getSmartPhones().size()));
                                    break;
                                case 4:
                                    cus.removeLaptop(numOfProduct(cus.getLaptops().size()));
                                    break;       
                            }
                        }                        
                        else if (inputI == 2)
                            cus.PurchaseConfirmation(); 
                        else
                            break;
                    }while (true);
                    break; // end of case 3 (Cart) 
                
                // exit     
                case 4:
                    System.out.println("Thank you for your visit <3");
                    flag = false;
                    break; // end of case 4 (Exit)
            } 
        }while(flag); 
    }
//----------------------------------------------------------------------------------------------------------------------------------
// Methods
    
    public static String custemrName(){
        Scanner keyboard = new Scanner(System.in); // A scanner object
        String custemrName;
        do{
            System.out.print("\tEnter your name: \n\t--> ");
            custemrName = keyboard.nextLine();            
        }while (thereInt(custemrName));
        return custemrName;
        }

    public static String phoneNumber(){
        Scanner keyboard = new Scanner(System.in); // A scanner object    
        String phoneNumber;
        do{
            System.out.print("\tEnter your phone number\n\t--> ");
            phoneNumber = keyboard.nextLine();            
        }while (thereString(phoneNumber));    
        return phoneNumber;
    }
        
    public static String city(){
        Scanner keyboard = new Scanner(System.in); // A scanner object
        String city;
        do{
            System.out.print("\tEnter your city: \n\t--> ");
            city = keyboard.nextLine();
        } while (thereInt(city));
        return city;
    }
    
    public static void maintMenu(){
        System.out.println("\n\t\tSelect what do you want to do.\n" + 
                "\t\t1 to show your information\n" + 
                "\t\t2 to show all section \n" + 
                "\t\t3 to open the cart\n" + 
                "\t\t4 to exit from the application");
        System.out.print("\t\t --> ");
    }
    
    public static void sectionsMenu(){
        System.out.println("\n\n\tPlease select the section\n"
                + "\t1. Books\n\t2. Clothes\n\t3. Smartphones\n\t4. Laptops\n\t5. back to main menu");
        System.out.print("\t--> ");
    }
    
    public static boolean thereInt(String s){
        if (s.matches(".*[0-9,!,@,#,$,%,^,&,*,?, ].*")){
            System.out.println("\tYour input should have only String (no space, use underscore_ instead), please try again.");
            return true;
        }
        else
            return false;           
    }
    
    public static boolean thereString(String s){
        if (s.matches(".*[a-z,A-Z,!,@,#,$,%,^,&,*,?, , ,, .].*")){
            System.out.println("\tYour input should have only integer (no space), please try again.");
            return true;
        }    
        else
            return false;
    }
    
    public static boolean valueRangeChecker(int max, int input){
        if (input < 1 || input > max){
            System.out.println("Your input is out of range, please try again.");
            return true;
        }
        else
            return false;
    }
    
    public static String[] readFromFile(String fileName, int row) throws IOException{
        return (Files.readAllLines(Paths.get(fileName + ".csv")).get(row)).split(";");
        }
    
    public static void printFileContents(String fileName, int numOfFeilds, int numOfProducts) throws IOException{
        
        System.out.print(" ");
        
        for (int i = 0; i <= numOfProducts; i++){
            String readRow[] = readFromFile(fileName, i);
            
            for (int j = 0; j <= numOfFeilds; j++){
                System.out.printf("%27s ", readRow[j]); 
               
                if (j == numOfFeilds)
                    System.out.print("$");
                
                System.out.print(" |");
            }
            
            System.out.println();
            if (i == 0){
                    for (int j = 0; j <= numOfFeilds; j++)
                        System.out.print(new String(new char[29]).replace("\0", "-") + "|");
                System.out.println();
                }
            
        }
    }
    
    public static int numOfProduct(int size){
        Scanner keyboard = new Scanner(System.in); // Scanner Object
        int n;
        if (size > 0){
            do{
                System.out.print("\n\n\tEnter the number of the product" + 
                        "\n\t--> ");
                n = keyboard.nextInt();
            }while(valueRangeChecker(size, n));
            return n;
        }
        else{
            System.out.println("\n\tThere are no products from this section.");
            return 0;
        }
    }  
    
}
    

