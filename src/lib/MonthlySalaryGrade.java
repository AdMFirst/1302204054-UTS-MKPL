package lib;

public enum MonthlySalaryGrade {
    GRADE1 (3000000),
    GRADE2 (5000000),
    GRADE3 (7000000);

    private int salary;
    MonthlySalaryGrade(int salary){
        this.salary = salary;
    }
    public int getSalary() { return this.salary; }
}
