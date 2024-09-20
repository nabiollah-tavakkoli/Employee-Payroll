package salarySchedual;

import java.time.Year;

public class AccountingDate {
	private int day;
	private int month;
	private int year;
	
	public AccountingDate(int day, int month, int year){
		if((day > 31 || day <= 0) || (month > 12 || month < 1) || (year != Year.now().getValue())) {
			throw new IllegalArgumentException("inserted date value is incorrect");
		}
		if(month == 2) {
			if((isLeapYear(year) && day > 29) || (!isLeapYear(year) && day > 28)) {
				throw new IllegalArgumentException("inserted day is incorrect");
			}
		}else if((month == 4 || month == 6 || month == 9 || month == 11 ) && day > 30) {
			throw new IllegalArgumentException("inserted day a 30day-monthis incorrect");
		}
		this.day = day;
		this.month = month;
		this.year = year;
		
	}
	
	private Boolean isLeapYear(int year) {
		return (year % 100 == 0) ? false : (year % 4 == 0 || year % 400 == 0);
	}

	public AccountingDate addDays(int daysToAdd) {
		int updatedDay = day + daysToAdd;
		if(month == 2) {
			if((isLeapYear(year) && updatedDay > 29)) {
				return toggleMonth(updatedDay, 29);
			}
			if ((!isLeapYear(year) && updatedDay > 28)) {
				return toggleMonth(updatedDay, 28);
			}
		}else if((month == 4 || month == 6 || month == 9 || month == 11 ) && updatedDay > 30) {
			return toggleMonth(updatedDay, 30);
			
		}else if(updatedDay > 31){
			if(month == 12) {
				return new AccountingDate(31, month, year);
			}
			return toggleMonth(updatedDay, 31);
		}
		return new AccountingDate(updatedDay, month, year);
	}

	private AccountingDate toggleMonth(int updatedDay, int lastDayOfMonth){
		return new AccountingDate(updatedDay - lastDayOfMonth, month + 1, year);
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	@Override
	public String toString() {
		return "AccountingDate [day=" + day + ", month=" + month + ", year=" + year + "]";
	}
	
	

}
