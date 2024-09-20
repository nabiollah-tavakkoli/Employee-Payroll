package contracts;

import salarySchedual.ReferencePeriod;

public class Hourly implements TypeOfContract{
	private int totalHour;
	private double hourlyWage;
	
	public Hourly(double hourlyWage, int totalHour) {
		this.hourlyWage = hourlyWage;
		this.totalHour= totalHour;
	}

	@Override
	public double getFinalSalary() {
		return hourlyWage * totalHour;
	}

	@Override
	public void setInterval(ReferencePeriod referencePeriod){
		referencePeriod.hourlyPaidPeriod(this);
		
	}
	
	public double getHourlyWage() {
		return hourlyWage;
	}
	
	

}
