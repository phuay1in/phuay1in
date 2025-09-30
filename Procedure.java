/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: Holds the information for a procedure, and can display its details
 * Due: 09/29/2025
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Paul Huaylinos
*/

public class Procedure {
	private String procedureName;
	private String procedureDate;
	private String practitionerName;
	private double charges;
	
	public Procedure() {
		this("", "", "", 0.0);
	}
	
	public Procedure(String procedureName, String procedureDate) {
		this(procedureName, procedureDate, "", 0.0);
	}
	
	public Procedure(String procedureName, String procedureDate, String practitionerName, double charges) {
		this.procedureName = procedureName;
		this.procedureDate = procedureDate;
		this.practitionerName = practitionerName;
		this.charges = charges;
	}
	
	public String getProcedureName() { return procedureName; }
	public String getProcedureDate() { return procedureDate; }
	public String getPractitionerName() { return practitionerName; }
	public double getCharges() { return charges; }
	
	public void setProcedureName(String procedureName) { this.procedureName = procedureName; }
	public void setProcedureDate(String procedureDate) { this.procedureDate = procedureDate; }
	public void setPractitionerName(String practitionerName) { this.practitionerName = practitionerName; }
	public void setCharges(double charges) { this.charges = charges; }
	
	public String toString() {
		return "\n          Procedure: " + procedureName + "\n          ProcedureDate=" + procedureDate
				+ "\n          PractitionerName=" + practitionerName + "\n          Charges=" + charges;
	}
}
