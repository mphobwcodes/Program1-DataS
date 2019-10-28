package linkedlistone;
import java.util.Scanner;
public class Address {

	public static void main(String[] args) {
	
		Table t= new Table();
		
		while(true) {
		    System.out.println("Insert a name(n)");
		    System.out.println("Look up a name(l)");
		    System.out.println("Update address(u)");
		    System.out.println("Delete an entry (d)");
		    System.out.println("Display all entries (a)");
		    System.out.println("Mark to Start(ms)");
		    System.out.println("Advance to mark (am)");
		    System.out.println("Key to Start (km)");
		    System.out.println("Value at Mark(vm)");
		    System.out.println("Quit (q)");
		    System.out.println("->"); 
		    
		    
		    Scanner myObj = new Scanner(System.in);  // Create a Scanner object

		    String userOp = myObj.nextLine();  // Read user input
		    
		    //System.out.println("Username is: " + userName);  // Output user input
		    switch(userOp) {
		    case "n":{
		    System.out.println("Please enter your name and your city");
		    String name = myObj.nextLine();  // Read user input
		    String city = myObj.nextLine();  // Read user input
		    
		    if (t.insert(name, city) == false) {
		      System.out.println("That name already exists!");
		     }
		     else {
		    	 System.out.println("good- you entered the name " + name + " and the city " + city);
		     }
		     break;
		    }
		    case "l":{
			    System.out.println("Please enter a name ");
			    String name = myObj.nextLine();  // Read user input
			    String value = t.lookUp(name);
			    if (value == null) {
			      System.out.println("That name was not found!");
			     }
			     else {
			    	 System.out.println("The name was found, value is " + value);
			     }
			     break;
		    }
			     
		    case "u":{
			    System.out.println("Please enter a name and a new city");
			    String name = myObj.nextLine();  // Read user input
			    String city = myObj.nextLine();  // Read user input
			    if (t.update(name, city) == false) {
			      System.out.println("That name was not found!");
			     }
			     else {
			    	 System.out.println("The information has been updated");
			     }
			     break;
		    }
		    case "d":{
			    System.out.println("Please enter your name and your city");
			    String name = myObj.nextLine();  // Read user input
			    if (t.delete(name) == false) {
			      System.out.println("That name  does not exists!");
			     }
			     else {
			    	 System.out.println("The name has been deleted");
			     }
			     break;
		    }
		     
		    case "a":{
		    	int N = t.displayAll();
		    	if (N==0) {
			      System.out.println("The list is empty!");
			     }
			     else {
			    	 System.out.println("The number is :" +N);
			     }
			     break;
		    }
		    case "ms":{
			    if (t.markToStart() == true) {
			      System.out.println("Marking to start is Successful");
			     }
			     else {
			    	 System.out.println("Marking to start was not found");
			     }
			     break;
		    }
		    case "am":{
			    if (t.advanceMark() == true) {
			      System.out.println("You are at the advance mark!");
			     }
			     else {
			    	 System.out.println("the advace mark wasnt found");
			     }
			     break;
		    }
		    case "km":{
				String key = t.keyAtMark();
		    	if (null != key) {
					System.out.println("The key at mark is "+key);
				}
				else {
					System.out.println("The key at mark was not found");
				}
				break;
		    }
		    case "vm":{
		    	String value = t.valueAtMark();
			    if (null != value) {
			      System.out.println("The value at Mark is: " + value + "!");
			     }
			     else {
			    	 System.out.println("the Value at Mark was not found");
			     }
			     break;
			     
		    }
		    
		    case "q":{
		    	myObj.close();
		    	return;
		    }
		   
		    }
		  }
	}

}

