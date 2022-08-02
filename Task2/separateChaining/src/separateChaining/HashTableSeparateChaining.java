package separateChaining;

import java.util.Scanner;

// Reference - Help received at https://www.sanfoundry.com/java-program-implement-hash-tables-chaining-singly-linked-list/
// Existing Code is modified for the purpose of this Task


public class HashTableSeparateChaining{ 
	
    public static void main(String[] args) {
        
        // Make object of HashTableSeparateChaining
        //Initialize Table size of 9
        HashTableChainingSinglyLinkedList hashTable = new HashTableChainingSinglyLinkedList(9);
        
        //Add the initializing values in the table
        hashTable.insert( 55 );
        hashTable.insert( 22 );
        hashTable.insert( 19 );
        hashTable.insert( 1 );
        hashTable.insert( 111 );
        hashTable.insert( 39 );
        hashTable.insert( 72 );
        hashTable.insert( 3 );
     
        //Display on console the current Table after initialization
        System.out.println("Hash Table:");
        hashTable.printHashTable();
        
        //Initialize the scanner function
        Scanner scan = new Scanner(System.in);
 
        // Use ch as a value keeper 
        char ch;
        // Perform a Do and While function
        do    
        {	//Display options for user on console
            System.out.println("\nWhat would you like to do next? \nHash Table Operations:\n");
            System.out.println("1. insert ");
            System.out.println("2. remove");
            
            // Scan the answer given
            int choice = scan.nextInt();
            // Execute method based on answer 
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer element to insert");
                hashTable.insert( scan.nextInt() ); 
                break;                          
            case 2 :                 
                System.out.println("Enter integer element to delete");
                hashTable.remove( scan.nextInt() ); 
                break;                        

            //Default if user entered a wrong character -  display message on console & go to end while loop
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            
            // Display in console the new Hash Table after operation is executed 
            hashTable.printHashTable();  
            
            // Ask the user if they want to perform another operation or stop
            System.out.println("\nDo you want to continue? \nTo continue enter any key, to End type n or N \n");
            
            // Capture response from user
            ch = scan.next().charAt(0);                        
        } 
        //Continue the "do" function N or n is not entered. 
        while (!(ch == 'N'|| ch == 'n'));  
        
        scan.close();
    }
}