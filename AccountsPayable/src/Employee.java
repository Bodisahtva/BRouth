
public class Employee 
{
	private String First_Name;
	private String Last_Name;
	private String Social_Security_Number;
	
	public Employee()
	{
		First_Name = "Unknown";
		Last_Name = "Unkown";
		Social_Security_Number = "Unknown";
	}

	public Employee(String First_Name, String Last_Name, String Social_Security_Number) {
		super();
		this.First_Name = First_Name;
		this.Last_Name = Last_Name;
		this.Social_Security_Number = Social_Security_Number;
	}
	
	public String getFirst_Name() {
		return First_Name;
	}

	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}

	public String getLast_Name() {
		return Last_Name;
	}

	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}

	public String getSocial_Security_Number() {
		return Social_Security_Number;
	}

	public void setSocial_Security_Number(String social_Security_Number) {
		Social_Security_Number = social_Security_Number;
	}

	
	
	public double getPaymentAmount()
	{
		return 0;
	}
	
	
	@Override
	public String toString() 
	{
		return "Employee [First_Name=" + First_Name + "," + "\n" + "Last_Name=" + Last_Name + "," + "\n" + "Social_Security_Number="
			+ Social_Security_Number + "," + "\n"  + "]";
	}
}
