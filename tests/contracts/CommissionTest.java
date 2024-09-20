package contracts;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;


public class CommissionTest {

	Commission fixedCommission;
	Commission commission;
	
	@Before
	public void setUp() {
		fixedCommission = Commission.commissionsSalaryWithFixedMaxedSalesAndcommission(10000, 30);
		commission = Commission.commissionsSalary(0.05, 200, 10000, 500);
	}

	@Test
	public void testGetFinalSalary() {
		assertThat(480.0).isEqualTo(fixedCommission.getFinalSalary());
		assertThat(1250.0).isEqualTo(commission.getFinalSalary());
		
	}

}
