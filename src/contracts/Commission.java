package contracts;

import salarySchedual.ReferencePeriod;

public class Commission implements TypeOfContract{
	
	private double commission;
	private int SpecifiedMaxSales;
	private double salesValue;
	private int salesNumber;

	private Commission(double commission, int SpecifiedMaxSales, double salesValue, int salesNumber) {
		this.SpecifiedMaxSales = SpecifiedMaxSales;
		this.salesValue = salesValue;
		this.commission = commission;
		this.salesNumber = salesNumber;

	}
	
	public static Commission commissionsSalaryWithFixedMaxedSalesAndcommission(double salesValue, int salesNumber) {
		return new Commission(0.04, 25, salesValue, salesNumber);
		
	}
	public static Commission commissionsSalary(double commission, int SpecifiedMaxSales, double salesValue, int salesNumber) {
		return new Commission(commission, SpecifiedMaxSales, salesValue, salesNumber);
		
	}
	@Override
	public double getFinalSalary() {
		double commissionPerProduct = commission * salesValue / SpecifiedMaxSales;
		return (salesNumber > SpecifiedMaxSales) ? salesNumber * commissionPerProduct : commission * salesValue;
	}

	@Override
	public void setInterval(ReferencePeriod referencePeriod){
		referencePeriod.commissionPeriod(this);
		
	}
	
	public double getCommission() {
		return commission;
	}
	public int getSpecifiedMaxSales() {
		return SpecifiedMaxSales;
	}
	public double GetSalesValue() {
		return salesValue;
	}

	public int getSalesNumber() {
		return salesNumber;
	}

}
