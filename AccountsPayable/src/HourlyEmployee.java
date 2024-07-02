
public class HourlyEmployee extends Employee
{
	private double hourlyWage;
	private int hours;
	
	public HourlyEmployee(String First_Name, String Last_Name, String Social_Security_Number, double hourlyWage, int hours)
	{
		super(First_Name, Last_Name, Social_Security_Number);
		this.hourlyWage = hourlyWage;
		this.hours = hours;
	}

	public double getHourlyWage() {
		return hourlyWage;
	}

	public void setHourlyWage(double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}
	
	@Override
	public double getPaymentAmount()
	{
		return hourlyWage * hours;
	}

	@Override
	public String toString() {
		return "HourlyEmployee: \n First Name = " + super.getFirst_Name() + "\n Last Name = " +super.getLast_Name() + "\n Social Security Number = " +super.getSocial_Security_Number() + "\n Hourly Wage = " + hourlyWage + " hours = " + hours;
	}
}
