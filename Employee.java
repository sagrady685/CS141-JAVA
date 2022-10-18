/*
 * Author: Sarah Grady
 * Date of Initialization: March 7, 2022
 * Date of Completion: March, 7, 2022
 * Purpose: To gain some skill with creating objects based on other objects (inheritance).
 */
public class Employee extends Person { 
	private double salary; 
	private int staffIdNumber;
	
	public Employee(String fname, String lname, double salary, int staffIdNumber) { 
		super(fname, lname);
		this.salary = salary;
		this.staffIdNumber = staffIdNumber;
		
	}
	public double getSalary() {
		return salary;
	}
	public int getStaffIdNumber() { 
		return staffIdNumber;
	}
	public void setSalary(double salary) { // used to output salary in other class
		 this.salary = salary;
	}
	public String toString() { // overloaded method that calls the first and last names, ID number and salary 
		return super.getFName()+" "+super.getLName()+" (ID#"+staffIdNumber+") Salary $"+salary+".";
	}
	public boolean equals(Employee test) { // overloaded method that calls decides if employees are the same
		if(test.staffIdNumber == this.staffIdNumber) {
			return true;
		}
		return false;
	}
}
