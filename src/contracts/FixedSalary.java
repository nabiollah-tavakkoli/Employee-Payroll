package contracts;

import salarySchedual.ReferencePeriod;

public class FixedSalary implements TypeOfContract{

	private double salary;
	private int totalHour;
	private int absentHour;
	
	private FixedSalary(double salary, int totalHour, int absentHour) {
		this.salary = salary;
		this.totalHour = totalHour;
		this.absentHour = absentHour;
		
	}
	
	public static FixedSalary fixedSalaryWithVariableHour(double mySalary, int myHour, int absentHour) {
		return new FixedSalary(mySalary, myHour, absentHour);
	}
	
	public static FixedSalary fixedSalaryWithFixedHour(double mySalary, int absentHour) {
		return new FixedSalary(mySalary, 240, absentHour);
	}
	
	
	public double getFinalSalary() {
		double salaryPerHour = salary / totalHour;
		double absentSalary = salaryPerHour * absentHour;
		return salary - absentSalary;
	}
	
	@Override
	public void setInterval(ReferencePeriod referencePeriod){
		referencePeriod.fixedSalaryPeriod(this);
	}

	public int getTotalHour() {
		return totalHour;
	}
	
	public double getSalary() {
		return salary;
	}


}
