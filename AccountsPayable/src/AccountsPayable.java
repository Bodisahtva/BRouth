import java.util.Scanner;

public class AccountsPayable {

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		Employee[] payableEmployees = new Employee[6];
		int empType;
		String firstName;
		String lastName;
		String SSN;
		int weeklySalary;
		double hourlyWage;
		int hours;
		double grossSales;
		double commRate;
		double basePay;
 
		
		for (int i=0; i<payableEmployees.length; i++)
		{
			System.out.println("Enter employee type: \n 1 for Salaried \n 2 for Hourly \n 3 for Commission \n 4 for Base plus Commission");
			empType = input.nextInt();
			System.out.println("Enter First name");
			firstName = input.next();
			System.out.println("Enter Last name");
			lastName = input.next();
			System.out.println("Enter Social Security Number");
			SSN = input.next();

			if (empType == 1) 
			{
				System.out.println("What is your weekly salary?");
				weeklySalary = input.nextInt();
				payableEmployees[i] = new SalariedEmployee(firstName, lastName, SSN, weeklySalary);
			} 
			else if (empType == 2) 
			{
				System.out.println("What is your hourly wage?");
				hourlyWage = input.nextDouble();
				System.out.println("How many hours did you work?");
				hours = input.nextInt();
				payableEmployees[i] = new HourlyEmployee(firstName, lastName, SSN, hourlyWage, hours);
			} 
			else if (empType == 3) 
			{
				System.out.println("What were your gross sales?");
				grossSales = input.nextDouble();
				System.out.println("What is your commission rate?");
				commRate = input.nextDouble();
				payableEmployees[i] = new CommissionEmployee(firstName, lastName, SSN, grossSales, commRate);
			} 
			else if (empType == 4) 
			{
				System.out.println("What were your gross sales?");
				grossSales = input.nextDouble();
				System.out.println("What is your commission rate?");
				commRate = input.nextDouble();
				System.out.println("What is your base pay?");
				basePay = input.nextDouble();
				basePay = basePay * 1.1;
				payableEmployees[i] = new BasePlusCommissionEmployee(firstName, lastName, SSN, grossSales, commRate,
						basePay);
			}
		System.out.println(payableEmployees[i]);
		System.out.println("-----------------------");
		System.out.println("");
		}
		for (Employee Emp : payableEmployees)
		{
			System.out.println("Employee information: \n");
			printEmp(Emp);
		}
		
	}//end of main

	
		public static void printEmp2(Employee Emp, Employee payableEmployees[]) {
			for (int i = 0; i < payableEmployees.length; i++) 
			{
			if (Emp instanceof SalariedEmployee) 
			{
				System.out.println(payableEmployees[i].getFirst_Name() + ((SalariedEmployee) Emp).getWeeklySalary());
			} 
			else if (Emp instanceof CommissionEmployee) 
			{
				System.out.println(payableEmployees[i].getFirst_Name() + ((CommissionEmployee) Emp).getCommRate()
						+ ((CommissionEmployee) Emp).getGrossSales());
			} 
			else if (Emp instanceof BasePlusCommissionEmployee) 
			{
				System.out.println("Base pay = " + ((BasePlusCommissionEmployee) Emp).getBasePay());
			} 
			else if (Emp instanceof HourlyEmployee) 
			{
				System.out.println("Hourly wage = " + ((HourlyEmployee) Emp).getHourlyWage());
				System.out.println("Hours worked = " + ((HourlyEmployee) Emp).getHours());
			}
		}
		}


	// printEmp(payableEmployees[0]);
	// printEmp1(payableEmployees[0]);

	public static void printEmp(Employee Emp) 
	{
		System.out.println(Emp.toString());
	}

	public static void printEmp1(Employee Emp) {
		System.out.println("First name: " + Emp.getFirst_Name());
		System.out.println("Last name: " + Emp.getLast_Name());
		System.out.println("Social Security Number: " + Emp.getSocial_Security_Number());

		if (Emp instanceof SalariedEmployee) {
			System.out.println("Weekly salary = " + ((SalariedEmployee) Emp).getWeeklySalary());
		} else if (Emp instanceof CommissionEmployee) {
			System.out.println("Commission rate = " + ((CommissionEmployee) Emp).getCommRate());
			System.out.println("Gross Sales = " + ((CommissionEmployee) Emp).getGrossSales());

			if (Emp instanceof BasePlusCommissionEmployee) {
				System.out.println("Base pay = " + ((BasePlusCommissionEmployee) Emp).getBasePay());
			}
		} else {
			System.out.println("Hourly wage = " + ((HourlyEmployee) Emp).getHourlyWage());
			System.out.println("Hours worked = " + ((HourlyEmployee) Emp).getHours());
		}
	}

	@Override
	public String toString() {
		return "AccountsPayable [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}
