package employees;

import contracts.Commission;

public class Sale extends Employee {

	private double salesValue;
	private int salesNumber;
	public Sale(String firstName, String lastName, String CF, double salesValue, int salesNumber) {
		super(firstName, lastName, CF, Commission.commissionsSalaryWithFixedMaxedSalesAndcommission(salesValue, salesNumber));
	}
	public double getSalesValue() {
		return salesValue;
	}
	public int getSalesNumber() {
		return salesNumber;
	}

}
