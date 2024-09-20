package salarySchedual;

import employees.Employee;

public class Salary {
	
	private ReferencePeriod referencePeriod;
	private Employee empl;
	
	public Salary(Employee empl, AccountingDate startingDate){
		this.empl = empl;
		
		referencePeriod = new MonthlyInterval(startingDate);
		this.empl.getTypeofContract().setInterval(referencePeriod);
	}
	
	public double getEmployeeSalary() {
		return empl.getTypeofContract().getFinalSalary();
	}
	
	public ReferencePeriod getReferencePeriod() {
		return referencePeriod;
	}

	public Employee getEmpl() {
		return empl;
	}


}
