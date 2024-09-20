package salarySchedual;

import contracts.Commission;
import contracts.FixedSalary;
import contracts.Hourly;
import contracts.MultiContract;

public class WeeklyInterval implements ReferencePeriod{
	private AccountingDate startingDate;
	private AccountingDate endingDate;
	
	public WeeklyInterval(AccountingDate startingDate) {
		this.startingDate = startingDate;
	}

	@Override
	public void fixedSalaryPeriod(FixedSalary fixedSalarycontract) {
		endingDate = startingDate.addDays(7);
	}

	@Override
	public void hourlyPaidPeriod(Hourly hourlycontract) {
		endingDate = startingDate.addDays(7);
	}

	@Override
	public void commissionPeriod(Commission commissionBasedcontract) {
		endingDate = startingDate.addDays(7);
	}

	@Override
	public void multiContractPeriod(MultiContract multiContractcontract) {
		endingDate = startingDate.addDays(7);
	}
	

	public AccountingDate getStartingDate() {
		return startingDate;
	}

	public AccountingDate getEndingDate() {
		return endingDate;
	}

	@Override
	public String toString() {
		return "WeeklyInterval [startingDate=" + startingDate + ", endingDate=" + endingDate + "]";
	}
	
	

}
