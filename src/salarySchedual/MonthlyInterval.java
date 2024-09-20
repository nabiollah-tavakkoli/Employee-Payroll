package salarySchedual;

import contracts.Commission;
import contracts.FixedSalary;
import contracts.Hourly;
import contracts.MultiContract;

public class MonthlyInterval implements ReferencePeriod{
	
	private AccountingDate startingDate;
	private AccountingDate endingDate;
	
	public MonthlyInterval(AccountingDate startingDate) {
		this.startingDate = startingDate;
	}

	@Override
	public void fixedSalaryPeriod(FixedSalary fixedSalarycontract) {
		endingDate = startingDate.addDays(31);
	}

	@Override
	public void hourlyPaidPeriod(Hourly hourlycontract) {
		endingDate = startingDate.addDays(31);
	}

	@Override
	public void commissionPeriod(Commission commissionBasedcontract) {
		endingDate = startingDate.addDays(31);
	}

	@Override
	public void multiContractPeriod(MultiContract multiContractcontract) {
		endingDate = startingDate.addDays(31);
	}
	

	public AccountingDate getStartingDate() {
		return startingDate;
	}

	public AccountingDate getEndingDate() {
		return endingDate;
	}

	@Override
	public String toString() {
		return "MonthlyInterval [startingDate=" + startingDate + ", endingDate=" + endingDate + "]";
	}
	


}
