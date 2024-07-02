/**
 * 
 * @author bwrouth
 *	Date: 1/21/23
 *	Description: Fans with different attributes
 */

public class Fan
{
	final int SLOW = 1;
	final int MEDIUM = 2;
	final int FAST = 3;
	
	private int speed = 1;
	private boolean on = false;
	private double radius = 5;
	private String color = new String ("blue");
	private static int  id = 0;
	private int idCount = 0;
	
	public Fan()
	{
		speed = SLOW;
		on = false;
		radius = 5;
		color = "blue";
		id++;
		idCount = id;
	}
	
	
	
	public int getSpeed( )
	{
		return speed;
	}
	public void setSpeed( int speed )
	{
		this.speed = speed;
	}
	public boolean isOn( )
	{
		return on;
	}
	public void setOn( boolean on )
	{
		this.on = on;
	}
	public double getRadius( )
	{
		return radius;
	}
	public void setRadius( double radius )
	{
		this.radius = radius;
	}
	public String getColor( )
	{
		return color;
	}
	public void setColor( String color )
	{
		this.color = color;
	}
	public int getId() 
	{
		return  id;
	}
	public void setId(int id) 
	{
		this. id = id;
	}

	
	
	@Override
	public String toString( )
	{
		if (on)
		{
			return "Fan [SLOW=" + SLOW + ", MEDIUM=" + MEDIUM + ", FAST=" + FAST + ", on=" + on + ", radius=" + radius
			+ ", color=" + color + ", ID=" +  idCount + "]" ;
		}
		else
		{
			return "Fan [SLOW=" + SLOW + ", MEDIUM=" + MEDIUM + ", FAST=" + FAST + ", on=" + on + ", radius=" + radius
					+ ", color=" + color + ", ID=" +  idCount + " fan is off" + "]" ;
		}
		}
	}


