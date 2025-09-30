/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: The driver class gets the user input and uses the patient and procedure class to display its information, and has its functions
 * Due: 09/29/2025
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Paul Huaylinos
*/

import java.util.Scanner;

public class PatientDriverApp {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter patient's first name:");
		String firstName = input.nextLine();
        System.out.println("Enter patient's middle name:"); 
        String middleName = input.nextLine(); 
        System.out.println("Enter patient's last name:"); 
        String lastName = input.nextLine(); 
        System.out.println("Enter street address:"); 
        String street = input.nextLine(); 
        System.out.println("Enter city:"); 
        String city = input.nextLine(); 
        System.out.println("Enter state:"); 
        String state = input.nextLine(); 
        System.out.println("Enter ZIP code:"); 
        String zip = input.nextLine(); 
        System.out.println("Enter phone number (301-123-4567):"); 
        String phone = input.nextLine(); 
        System.out.println("Enter emergency contact name:"); 
        String emergencyName = input.nextLine(); 
        System.out.println("Enter emergency contact phone number:"); 
        String emergencyPhone = input.nextLine(); 
  
        Patient patient = new Patient(firstName, middleName, lastName, 
                                      street, city, state, zip, 
                                      phone, emergencyName, emergencyPhone); 
        
        // 1. Constructor with no attributes
        Procedure proc1 = new Procedure(); 
        proc1.setProcedureName("Physical Exam"); 
        proc1.setProcedureDate("7/20/2019"); 
        proc1.setPractitionerName("Dr. Irvine"); 
        proc1.setCharges(3250.0); 
  
        // 2. Constructor with name and date, then set remaining attributes 
        Procedure proc2 = new Procedure("X-Ray", "7/20/2019"); 
        proc2.setPractitionerName("Dr. Jamison"); 
        proc2.setCharges(5500.43); 
  
        // 3. Constructor with all attributes 
        Procedure proc3 = new Procedure("Blood Test", "7/20/2019", "Dr. Smith", 1400.75); 
  
        displayPatient(patient); 

        displayProcedure(proc1); 
        displayProcedure(proc2); 
        displayProcedure(proc3); 
  
        // --- Calculate Total Charges --- 
        double total = calculateTotalCharges(proc1, proc2, proc3); 
        System.out.printf("\nTotal Charges: $%,.2f", total);
        System.out.println("\nStudent Name: Paul Huaylinos\nMC#: MC20966432\nDue Date: 9/29/2025");
        input.close(); 
	}
	
	public static void displayPatient(Patient patient) { 
		System.out.println(patient); 
	} 
	
	public static void displayProcedure(Procedure procedure) { 
	        System.out.println(procedure);
	} 
	  
	public static double calculateTotalCharges(Procedure p1, Procedure p2, Procedure p3) { 
	        return p1.getCharges() + p2.getCharges() + p3.getCharges(); 
	} 
}