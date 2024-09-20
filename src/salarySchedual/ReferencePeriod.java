package salarySchedual;

import contracts.Commission;
import contracts.FixedSalary;
import contracts.Hourly;
import contracts.MultiContract;

public interface ReferencePeriod {
	abstract void fixedSalaryPeriod(FixedSalary fixedSalarycontract);
	abstract void hourlyPaidPeriod(Hourly hourlycontract);
	abstract void commissionPeriod(Commission commissionBasedcontract);
	abstract void multiContractPeriod(MultiContract multiContractcontract);

}
