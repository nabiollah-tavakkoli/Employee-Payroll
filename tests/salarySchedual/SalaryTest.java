package salarySchedual;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import contracts.Commission;
import contracts.FixedSalary;
import contracts.Hourly;
import contracts.MultiContract;
import contracts.TypeOfContract;
import employees.Employee;
import employees.Engineer;

public class SalaryTest {

	AccountingDate fixedSalaryStartingDate;
	AccountingDate hourStartingDate;
	AccountingDate commissionStartingDate;
	AccountingDate multiContractStartingDate;
	
	TypeOfContract fixedSalaryContractWithFixedHour;
	TypeOfContract hourlyWageContract;
	TypeOfContract fixedCommissionContract;
	TypeOfContract commissionContract;
	MultiContract multiContract = new MultiContract();
	
	Employee empl;
	Employee engineer;
	Employee sale;
	Employee multiContractEmpl;
	
	Salary emplSalary;
	Salary engineerSalary;
	Salary saleSalary;
	Salary multiContractSalary;
	
	@Before
	public void setUp(){
		fixedSalaryStartingDate = new AccountingDate(1, 2, 2024);
		hourStartingDate = new AccountingDate(7, 10, 2024);
		commissionStartingDate = new AccountingDate(4, 4, 2024);
		multiContractStartingDate = new AccountingDate(4, 3, 2024);
		
		fixedSalaryContractWithFixedHour = FixedSalary.fixedSalaryWithFixedHour(1800, 40); 
		hourlyWageContract = new Hourly(10, 40);
		commissionContract = Commission.commissionsSalary(0.05, 200, 10000, 500);
		multiContract.addContract(fixedSalaryContractWithFixedHour);
		multiContract.addContract(commissionContract);
		
		empl = new Employee("Bill", "Niel", "BN20LL24", fixedSalaryContractWithFixedHour);
		engineer = new Engineer("Richard", "Feynman", "1AM90TM4DW1TH90T90ING", 1800, 40);
		sale = new Engineer("Madam", "Curry", "P01S09", 10000, 30);
		multiContractEmpl = new Employee("Bill", "Niel", "BN20LL24", multiContract);
		
		emplSalary = new Salary(empl, fixedSalaryStartingDate);
		engineerSalary = new Salary(engineer, fixedSalaryStartingDate);
		saleSalary = new Salary(sale, commissionStartingDate);
		multiContractSalary = new Salary(multiContractEmpl, multiContractStartingDate);
	}

	@Test
	public void testGetEmployeeSalary() {
		assertThat(emplSalary.getEmployeeSalary()).isEqualTo(1500.0);
		assertThat(engineerSalary.getEmployeeSalary()).isEqualTo(1500.0);
		assertThat(saleSalary.getEmployeeSalary()).isEqualTo(8750.0);
		assertThat(multiContractSalary.getEmployeeSalary()).isEqualTo(2750.0);
		
	}

}
