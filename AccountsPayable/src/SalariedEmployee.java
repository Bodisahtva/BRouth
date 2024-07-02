
public class SalariedEmployee extends Employee
{
	private int weeklySalary;

	public SalariedEmployee() {
		super();
	}

	public SalariedEmployee(String First_Name, String Last_Name, String Social_Security_Number, int weeklySalary) 
	{
		super(First_Name, Last_Name, Social_Security_Number);
		this.weeklySalary = weeklySalary;
	}

	public int getWeeklySalary() {
		return weeklySalary;
	}

	public void setWeeklySalary(int weeklySalary) {
		this.weeklySalary = weeklySalary;
	}
	
	@Override
	public double getPaymentAmount()
	{
		return weeklySalary;
	}

	@Override
	public String toString() {
		return "SalariedEmployee: \n First Name = " + super.getFirst_Name() + "\n Last Name = " +super.getLast_Name() + "\n Social Security Number = " +super.getSocial_Security_Number() +  "\n Weekly Salary = " + weeklySalary;
	}
}

