package contracts;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

public class MultiContractTest {
	
	MultiContract multiContract;
	FixedSalary fixedSalary;
	Hourly hourly;

	@Before
	public void setUp(){
		multiContract = new MultiContract();
		fixedSalary = FixedSalary.fixedSalaryWithVariableHour(1500, 200, 50);
		hourly = new Hourly(10, 40);
		
	}

	@Test
	public void testAddContract() {
		multiContract.addContract(fixedSalary);
		Collection<TypeOfContract> contractList = multiContract.getContractList();
		assertThat(contractList.size()).isEqualTo(1);
		assertThat(contractList).containsExactlyInAnyOrder(fixedSalary);
		
		multiContract.addContract(hourly);
		Collection<TypeOfContract> newContractList = multiContract.getContractList();
		assertThat(newContractList.size()).isEqualTo(2);
		assertThat(newContractList).containsExactlyInAnyOrder(fixedSalary, hourly);
	}
	
	@Test
	public void testModifyContractWithOutException() {
		multiContract.addContract(fixedSalary);
		multiContract.addContract(hourly);
		Collection<TypeOfContract> contractList = multiContract.getContractList();
		assertThat(contractList.size()).isEqualTo(2);
		assertThat(contractList).containsExactlyInAnyOrder(fixedSalary, hourly);
		
		Commission commission = Commission.commissionsSalary(0.05, 200, 10000, 500);
		multiContract.modifyAContract(commission, 1);
		Collection<TypeOfContract> newContractList = multiContract.getContractList();
		assertThat(newContractList.size()).isEqualTo(2);
		assertThat(newContractList).containsExactlyInAnyOrder(fixedSalary, commission);
		
	}
	
	@Test
	public void testModifyContractWithException() {
		multiContract.addContract(fixedSalary);
		multiContract.addContract(hourly);
		Collection<TypeOfContract> contractList = multiContract.getContractList();
		assertThat(contractList.size()).isEqualTo(2);
		assertThat(contractList).containsExactlyInAnyOrder(fixedSalary, hourly);
		
		Commission commission = Commission.commissionsSalary(0.05, 200, 10000, 500);
		assertThrows(
				"the INSERTED POSITION is Incorrect (out of bound)", 
				IndexOutOfBoundsException.class,
				() -> multiContract.modifyAContract(commission, 4));
		
	}
	
	@Test
	public void testGetFinalSalary() {
		Commission commission = Commission.commissionsSalary(0.05, 200, 10000, 500);
		multiContract.addContract(hourly);
		multiContract.addContract(fixedSalary);
		multiContract.addContract(commission);
		Collection<TypeOfContract> contractList = multiContract.getContractList();
		assertThat(contractList.size()).isEqualTo(3);
		assertThat(contractList).containsExactlyInAnyOrder(fixedSalary, hourly, commission);
		
		assertThat(2775.0).isEqualTo(multiContract.getFinalSalary());
		
	}

}
