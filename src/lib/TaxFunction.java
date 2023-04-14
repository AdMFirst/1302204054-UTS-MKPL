package lib;

public class TaxFunction {
	
	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isSingle, int numberOfChildren) {
		
		int tax = 0;
		int nonTaxable  = 54000000;
		
		if (numberOfMonthWorking > 12) {
			System.err.println("More than 12 month working per year");
		}
		
		if (numberOfChildren > 3) {
			numberOfChildren = 3;
		}
		
		if (!isSingle) {
			nonTaxable  = nonTaxable  + 4500000 + (numberOfChildren * 1500000);
		}

		tax = (int) Math.round(0.05 * (((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - deductible - nonTaxable ));
		
		if (tax < 0) {
			return 0;
		}
		
		return tax;
	}
	
}
