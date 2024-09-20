package contracts;

import java.util.stream.Collectors;

import salarySchedual.ReferencePeriod;

public class MultiContract extends MultiContractExchange{

	@Override
	public double getFinalSalary() {
		return getContractList()
				.stream()
				.map(contract -> contract.getFinalSalary())
				.collect(Collectors.summingDouble(a -> a));
	}

	@Override
	public void setInterval(ReferencePeriod referencePeriod){
		referencePeriod.multiContractPeriod(this);
		
	}

}
