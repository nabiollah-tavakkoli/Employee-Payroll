package salarySchedual;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

public class AccountingDateTest {
	AccountingDate accountingDateLeapMonth;
	AccountingDate accountingDate30DayMonth;
	AccountingDate accountingDate31DayMonth;
	AccountingDate accountingDate31DayMonthAt12thMonth;

	@Before
	public void setUp(){
		accountingDateLeapMonth = new AccountingDate(1, 2, 2024);
		accountingDate30DayMonth = new AccountingDate(1, 4, 2024);
		accountingDate31DayMonth = new AccountingDate(1, 1, 2024);
		accountingDate31DayMonthAt12thMonth = new AccountingDate(1, 12, 2024);
	}

	@Test
	public void testConstructor() {
		assertThat(accountingDateLeapMonth.toString())
		.isEqualTo("AccountingDate [day=1, month=2, year=2024]");
		
		assertThat(accountingDate30DayMonth.toString())
		.isEqualTo("AccountingDate [day=1, month=4, year=2024]");
		
		assertThrows(
				"inserted date value is incorrect", 
				IllegalArgumentException.class,
				() -> new AccountingDate(1, 12,2023));
		
		assertThrows(
				"inserted date value is incorrect", 
				IllegalArgumentException.class,
				() -> new AccountingDate(1, 13,2024));
		
		assertThrows(
				"inserted date value is incorrect", 
				IllegalArgumentException.class,
				() -> new AccountingDate(-1, 13,2024));
		
		assertThrows(
				"inserted day is incorrect", 
				IllegalArgumentException.class,
				() -> new AccountingDate(30, 2,2024));
		
		assertThrows(
				"inserted day a 30day-monthis incorrect", 
				IllegalArgumentException.class,
				() -> new AccountingDate(31, 4,2024));

	}
	@Test
	public void testAddDays() {
		assertThat(accountingDateLeapMonth.addDays(5).toString())
		.isEqualTo("AccountingDate [day=6, month=2, year=2024]");
		
		assertThat(accountingDateLeapMonth.addDays(30).toString())
		.isEqualTo("AccountingDate [day=2, month=3, year=2024]");
		
		assertThat(accountingDate30DayMonth.addDays(5).toString())
		.isEqualTo("AccountingDate [day=6, month=4, year=2024]");
		
		assertThat(accountingDate30DayMonth.addDays(30).toString())
		.isEqualTo("AccountingDate [day=1, month=5, year=2024]");
		
		assertThat(accountingDate31DayMonth.addDays(5).toString())
		.isEqualTo("AccountingDate [day=6, month=1, year=2024]");
		
		assertThat(accountingDate31DayMonth.addDays(31).toString())
		.isEqualTo("AccountingDate [day=1, month=2, year=2024]");
		
		assertThat(accountingDate31DayMonthAt12thMonth.addDays(31).toString())
		.isEqualTo("AccountingDate [day=31, month=12, year=2024]");
	}

}
