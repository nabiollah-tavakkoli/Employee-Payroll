package employees;

import contracts.FixedSalary;

public class Engineer extends Employee{

	private double engineerFixedSalary;
	private int absenteeHours;

	public Engineer(String firstName, String lastName, String CF, double engineerFixedSalary, int absenteeHours ) {
		super(firstName, lastName, CF, FixedSalary.fixedSalaryWithFixedHour(engineerFixedSalary, absenteeHours));
	}

	public double getEngineerFixedSalary() {
		return engineerFixedSalary;
	}

	public int getAbsenteeHours() {
		return absenteeHours;
	}
	
	

}
