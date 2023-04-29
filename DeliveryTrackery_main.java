import java.util.*;
import java.io.*;
import java.lang.*;


public class Main
{
    
    public static double calculateArea(String[] coor1, String[] coor2) {
        
        float x1 = Float.parseFloat(coor1[0]);
        float x2 = Float.parseFloat(coor2[0]);
        float y1 = Float.parseFloat(coor1[1]);
        float y2 = Float.parseFloat(coor2[1]);
        
        double area = (x2+x1)*(y2-y1);
        
        return area;
    }
    
	public static void main(String[] args) {
	    
	    // Create a scanner object for user input 
	    Scanner scnr = new Scanner(System.in);
	    
	    // Create a new linked list 
	    LinkedList dr_list = new LinkedList(); 
	    
		// Prompt the user for the file containing driver data
		System.out.println("Enter the name of the file containing driver data: ");
		System.out.println();
		System.out.println("**Note: The input file \"driver.txt\" is hard-coded to demonstrate");
		System.out.println("the program's function. This code can easily be modified to allow");
		System.out.println("for input from other files.**");
		String driverFile = "driver.txt"; // scnr.nextLine();
		System.out.println();
		
		// Use try/catch block to open a file stream object
		try {
		    // Create a scanner object for input from file stream 
		    Scanner fscnr = new Scanner(new File(driverFile));
		    
		    while (fscnr.hasNextLine()) {
		        
		        String line = fscnr.nextLine();
		        // System.out.println("Line: " + line);
		        Scanner sscnr = new Scanner(line);
		        
		        double sum = 0.0;
    		    String nameStr = sscnr.next(); // Read in the first token as the driver first name
    		    // System.out.println("Name: " + nameStr);
    		    
    		    String start = sscnr.next();
    		    
    		    if (start.matches("^[a-zA-Z]*$")) {
    		        nameStr = nameStr + " " + start;
    		        // System.out.println("Full name: " + nameStr);
    		        
    		        String coor1 = sscnr.next();
    		        start = coor1;
    		        // System.out.println("Coor 1: " + coor1);
    		        String firstCoor[] = coor1.split(",");
    		        // System.out.println("x: " + firstCoor[0] + ", y: " + firstCoor[1]);
    		           
    		        String coor2 = sscnr.next();
    		        // System.out.println("Coor 2: " + coor2);
    		        String secCoor[] = coor2.split(",");
    		        // System.out.println("x: " + secCoor[0] + ", y: " + secCoor[1]);
    		        
    		        double part = calculateArea(firstCoor, secCoor);
    		        
    		        sum = sum + part;
    		        // System.out.println("Sum: " + sum);
    		        
    		        coor1 = coor2;
    		        // System.out.println("New coor 1: " + coor1);
    		        
    		        for (int i = 0; i < 2; i++) {
    		            firstCoor[i] = secCoor[i];
    		        }
    		        
    		        while (coor1 != start && sscnr.hasNext()) {
    		            coor2 = sscnr.next();
    		            // System.out.println("Coor 2: " + coor2);
    		            secCoor = coor2.split(",");
    		            
    		            part = calculateArea(firstCoor, secCoor);
    		            sum = sum + part;
    		            // System.out.println("New sum: " + sum);
    		            
    		            coor1 = coor2;
    		            // System.out.println("New coor 1: " + coor1);
    		        
        		        for (int i = 0; i < 2; i++) {
        		            firstCoor[i] = secCoor[i];
    		            }
    		        
    		        }
    		    }
    		    
    		    else {
    		        String coor1 = start;
    		        // System.out.println("Coor 1: " + coor1);
    		        String firstCoor[] = coor1.split(",");
    		        // System.out.println("x: " + firstCoor[0] + ", y: " + firstCoor[1]);
    		           
    		        String coor2 = sscnr.next();
    		        // System.out.println("Coor 2: " + coor2);
    		        String secCoor[] = coor2.split(",");
    		        // System.out.println("x: " + secCoor[0] + ", y: " + secCoor[1]);
    		        
    		        double part = calculateArea(firstCoor, secCoor);
    		        
    		        sum = sum + part;
    		        // System.out.println("Sum: " + sum);
    		        
    		        coor1 = coor2;
    		        // System.out.println("New coor 1: " + coor1);
    		        
    		        for (int i = 0; i < 2; i++) {
    		            firstCoor[i] = secCoor[i];
    		        }
    		        
    		        while (coor1 != start && sscnr.hasNext()) {
    		            coor2 = sscnr.next();
    		           //  System.out.println("Coor 2: " + coor2);
    		            secCoor = coor2.split(",");
    		            
    		            part = calculateArea(firstCoor, secCoor);
    		            sum = sum + part;
    		            // System.out.println("New sum: " + sum);
    		            
    		            coor1 = coor2;
    		           //  System.out.println("New coor 1: " + coor1);
    		        
        		        for (int i = 0; i < 2; i++) {
        		            firstCoor[i] = secCoor[i];
    		            }
    		        
    		        }
    		    
    		    
    		       }
    		      
    		      
    		      double area = 0.5*Math.abs(sum);
    		     //  System.out.println("Final sum: " + area);   
    		        
    		      Driver newDriver = new Driver(nameStr, area);
    		      // System.out.println(newDriver);
    		      
    		      Node newNode = new Node(newDriver);
    		      dr_list.appendList(newNode);
    		      String output = dr_list.toString(newNode);
    		      System.out.print(output);
		    
		        }
		        
		    }
		catch (FileNotFoundException e) {
		    // Output error message
		    System.out.println("Failed to open driver input file");
		}
		
		

		
		
		
		
		
		
		
		
		
		
		/* // Prompt the user for the file containing search/sort commands 
		System.out.print("Enter the name of the file containing search/sort commands: ");
		String commFile = scnr.nextLine();
		
		// Use try/catch block to open a file stream object
		try {
		    // Create a scanner object for input from file stream 
		    Scanner commFS = new Scanner(new File(commFile));
		    
		    while (commFS.hasNextLine()) {
		        String command = commFS.nextLine();
		        System.out.println(command);
		        
		        if (command.contains("sort")) {
		            
		        }
		        else {
		    }
		   
		}
		}
		catch (FileNotFoundException e) {
		    // Output error message
		    System.out.println("Failed to open search/sort command file");
		}*/
		
	}
}
