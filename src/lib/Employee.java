package lib;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

public class Employee extends Person{

	private String employeeId;
	private String address;
	
	private LocalDate joinedDate; 
	private int monthWorkingInYear;
	
	private boolean isForeigner;
	private Gender gender; 
	
	private int monthlySalary;
	private int otherMonthlyIncome;
	private int annualDeductible;
	
	private Person spouse;

	private List<Person> children;
	
	public Employee(String employeeId, String name, String idNumber, String address, LocalDate joinedDate, boolean isForeigner, Gender gender) {
		super(name, idNumber);

		this.employeeId = employeeId;
		this.address = address;
		this.joinedDate = joinedDate;
		this.isForeigner = isForeigner;
		this.gender = gender;
		
		children = new LinkedList<Person>();
		
	}
	
	public void setMonthlySalary(MonthlySalaryGrade grade) {	
		this.monthlySalary = grade.getSalary();
		if (isForeigner) {
			this.monthlySalary = (int) (this.monthlySalary * 1.5);
		}
	}
	
	public void setAnnualDeductible(int deductible) {	
		this.annualDeductible = deductible;
	}
	
	public void setAdditionalIncome(int income) {	
		this.otherMonthlyIncome = income;
	}
	
	public void setSpouse(Person spouse) {
		this.spouse = spouse;
	}
	
	public void addChild(Person child) {
		children.add(child);
	}
	
	public int getAnnualIncomeTax() {
		LocalDate date = LocalDate.now();
		
		if (date.getYear() == joinedDate.getYear()) {
			monthWorkingInYear = date.getMonthValue() - joinedDate.getMonthValue();
		}else {
			monthWorkingInYear = 12;
		}
		
		return TaxFunction.calculateTax(
			monthlySalary, 
			otherMonthlyIncome, 
			monthWorkingInYear, 
			annualDeductible, 
			spouse.equals(null), 
			children.size()
		);
	}
}
