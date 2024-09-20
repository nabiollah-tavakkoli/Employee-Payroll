package contracts;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class FixedSalaryTest {
	
	FixedSalary fixedSalaryWithFixedHour;
	FixedSalary fixedSalary;

	@Before
	public void setUp(){
		fixedSalaryWithFixedHour = FixedSalary.fixedSalaryWithFixedHour(1800, 40);
		fixedSalary = FixedSalary.fixedSalaryWithVariableHour(1500, 200, 50);
	}

	@Test
	public void testGetFinalSalary() {
		assertThat(1500.0).isEqualTo(fixedSalaryWithFixedHour.getFinalSalary());
		assertThat(1125.0).isEqualTo(fixedSalary.getFinalSalary());
	}

}
