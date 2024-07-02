
public class CommissionEmployee extends Employee
{
	private double grossSales;
	private double commRate;
	
	
	public CommissionEmployee() 
	{
		super();
	}
	
	public CommissionEmployee(String First_Name, String Last_Name, String Social_Security_Number, double grossSales, double commRate) 
	{
		super(First_Name, Last_Name, Social_Security_Number);
		this.grossSales = grossSales;
		this.commRate = commRate;
	}

	public double getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(double grossSales) {
		this.grossSales = grossSales;
	}

	public double getCommRate() {
		return commRate;
	}

	public void setCommRate(double commRate) {
		this.commRate = commRate;
	}
	
	@Override
	public double getPaymentAmount()
	{
		return grossSales * commRate;
	}

	@Override
	public String toString() {
		return "CommissionEmployee:  \n First Name = " + super.getFirst_Name() + "\n Last Name = " +super.getLast_Name() + "\n Social Security Number = " +super.getSocial_Security_Number() + "\n Gross Sales = " + grossSales + "\n Commission Rate = " + commRate;
	}
}
