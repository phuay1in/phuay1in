/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: Holds all the details of a patient, and can display the information
 * Due: 09/29/2025
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Paul Huaylinos
*/

public class Patient {
	private String firstName, middleName, lastName;
	private String streetAddress, city, state, zipCode, phoneNumber;
	private String emergencyName, emergencyNumber;
	
	public Patient() {
		this("", "", "", "", "", "", "", "", "", "");
	}
	
	public Patient(String firstName, String middleName, String lastName) {
		this(firstName, middleName, lastName, "", "", "", "", "", "", "");
	}
	
	public Patient(String firstName, String middleName, String lastName,
			String streetAddress, String city, String state, String zipCode, String phoneNumber,
			String emergencyName, String emergencyNumber) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
		this.emergencyName = emergencyName;
		this.emergencyNumber = emergencyNumber;
	}
	
	public String getFirstName() { return firstName; }
	public String getMiddleName() { return middleName; }
	public String getLastName() { return lastName; }
	public String getStreetAddress() { return streetAddress; }
	public String getCity() { return city; }
	public String getState() { return state; }
	public String getZipCode() { return zipCode; }
	public String getPhoneNumber() { return phoneNumber; }
	public String getEmergencyName() { return emergencyName; }
	public String getEmergencyNumber() { return emergencyNumber; }
	
	public void setFirstName(String firstName) { this.firstName = firstName; }
	public void setMiddleName(String middleName) { this.middleName = middleName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	public void setStreetAddress(String streetAddress) { this.streetAddress = streetAddress; }
	public void setCity(String city) { this.city = city; }
	public void setState(String state) { this.state = state; }
	public void setZipCode(String zipCode) { this.zipCode = zipCode; }
	public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
	public void setEmergencyName(String emergencyName) { this.emergencyName = emergencyName; }
	public void setEmergencyNumber(String emergencyNumber) { this.emergencyNumber = emergencyNumber; }
	
	public String buildFullName() {
		return firstName + " " + middleName + " " + lastName;
	}
	public String buildAddress() {
		return streetAddress + " " + city + " " + state + " " + zipCode;
	}
	public String buildEmergencyContact() {
		return emergencyName + " " + emergencyNumber;
	}
	
	public String toString() {
		return "Patient info:\n  Name: " + buildFullName() + "\n  Address: " + buildAddress()
		+ "\n  EmergencyContact: " + buildEmergencyContact();
	}
}
