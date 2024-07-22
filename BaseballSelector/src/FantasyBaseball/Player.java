package FantasyBaseball;

public class Player
{
	private String name;
	private String position;
	private String team;
	
	public Player(String name, String position, String team)
	{
		this.name = name;
		this.position = position;
		this.team = team;
	}
	public String getName()
	{
		return name;
	}
	public String getPosition()
	{
		return position;
	}
	public String getTeam()
	{
		return team;
	}
}
