
public class BasePlusCommissionEmployee extends CommissionEmployee
{
	private double basePay;
	
	public BasePlusCommissionEmployee (String First_Name, String Last_Name, String Social_Security_Number, double grossSales, double commRate, double basePay)
	{
		super(First_Name, Last_Name, Social_Security_Number, grossSales, commRate);
		this.basePay = basePay;
	}

	public double getBasePay() 
	{
		return basePay;
	}

	public void setBasePay(double basePay) {
		this.basePay = basePay;
	}
	
	@Override
	public double getPaymentAmount()
	{
		return basePay + super.getCommRate();
	}

	@Override
	public String toString() {
		return "BasePlusCommissionEmployee: \n First Name = " + super.getFirst_Name() + "\n Last Name = " +super.getLast_Name() + "\n Social Security Number = " +super.getSocial_Security_Number() + " \n Base Pay = " + basePay ;
	}
}
