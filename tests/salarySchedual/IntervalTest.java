package salarySchedual;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import contracts.Commission;
import contracts.FixedSalary;
import contracts.Hourly;
import contracts.MultiContract;
import contracts.TypeOfContract;

public class IntervalTest {
	AccountingDate fixedSalaryStartingDate;
	AccountingDate hourStartingDate;
	AccountingDate commissionStartingDate;
	AccountingDate multiContractStartingDate;
	
	ReferencePeriod fixedSalaryReferencePeriod;
	ReferencePeriod hourlyReferencePeriod;
	ReferencePeriod commissionReferencePeriod;
	ReferencePeriod multiContractReferencePeriod;
	
	TypeOfContract fixedSalaryContractWithFixedHour;
	TypeOfContract fixedSalaryContract;
	TypeOfContract hourlyWageContract;
	TypeOfContract fixedCommissionContract;
	TypeOfContract commissionContract;
	MultiContract multiContract = new MultiContract();

	@Before
	public void setUp(){
		fixedSalaryStartingDate = new AccountingDate(1, 2, 2024);
		hourStartingDate = new AccountingDate(7, 10, 2024);
		commissionStartingDate = new AccountingDate(4, 4, 2024);
		multiContractStartingDate = new AccountingDate(4, 3, 2024);
		
		fixedSalaryReferencePeriod = new WeeklyInterval(fixedSalaryStartingDate);
		hourlyReferencePeriod = new WeeklyInterval(hourStartingDate);
		commissionReferencePeriod = new MonthlyInterval(commissionStartingDate);
		multiContractReferencePeriod = new MonthlyInterval(multiContractStartingDate);
		
		fixedSalaryContractWithFixedHour = FixedSalary.fixedSalaryWithFixedHour(1800, 40); 
		hourlyWageContract = new Hourly(10, 40);
		commissionContract = Commission.commissionsSalary(0.05, 200, 10000, 500);
		multiContract.addContract(fixedSalaryContract);
		multiContract.addContract(commissionContract);
	}

	@Test
	public void testFixedSalaryPeriod() {
		fixedSalaryContractWithFixedHour.setInterval(fixedSalaryReferencePeriod);
		assertThat(fixedSalaryReferencePeriod.toString())
		.isEqualTo(""
				+ "WeeklyInterval ["
				+ "startingDate=AccountingDate [day=1, month=2, year=2024], "
				+ "endingDate=AccountingDate [day=8, month=2, year=2024]"
				+ "]");
		
	}
	
	@Test
	public void testHourlyPaidPeriod() {
		hourlyWageContract.setInterval(hourlyReferencePeriod);
		assertThat(hourlyReferencePeriod.toString())
		.isEqualTo(""
				+ "WeeklyInterval ["
				+ "startingDate=AccountingDate [day=7, month=10, year=2024], "
				+ "endingDate=AccountingDate [day=14, month=10, year=2024]"
				+ "]");
		
	}
	
	@Test
	public void testCommissionPeriod() {
		commissionContract.setInterval(commissionReferencePeriod);
		assertThat(commissionReferencePeriod.toString())
		.isEqualTo(""
				+ "MonthlyInterval ["
				+ "startingDate=AccountingDate [day=4, month=4, year=2024], "
				+ "endingDate=AccountingDate [day=5, month=5, year=2024]"
				+ "]");
		
	}
	
	@Test
	public void testMultiContractPeriod() {
		multiContract.setInterval(multiContractReferencePeriod);
		assertThat(multiContractReferencePeriod.toString())
		.isEqualTo(""
				+ "MonthlyInterval ["
				+ "startingDate=AccountingDate [day=4, month=3, year=2024], "
				+ "endingDate=AccountingDate [day=4, month=4, year=2024]"
				+ "]");
		
	}

}
