package contracts;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class HourlyTest {
	Hourly hourlyWage;

	@Before
	public void setUp(){
		hourlyWage = new Hourly(10, 40);
	}

	@Test
	public void testGetFinalSalary() {
		assertThat(400.0).isEqualTo(hourlyWage.getFinalSalary());
	}

}
