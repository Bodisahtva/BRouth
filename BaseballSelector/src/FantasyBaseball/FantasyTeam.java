package FantasyBaseball;

import java.util.ArrayList;
import java.util.List;

public class FantasyTeam 
{
    private String teamName;
    private List<Player> players;
    private int Pitchers;
    private int Catchers;
    private int FirstBasemen;
    private int SecondBasemen;
    private int Shortstops;
    private int ThirdBasemen;
    private int LeftFielders;
    private int CenterFielders;
    private int RightFielders;

    public FantasyTeam(String teamName) 
    {
        this.teamName = teamName;
        players = new ArrayList<>();
        Pitchers = 0;
        Catchers = 0;
        FirstBasemen = 0;
        SecondBasemen = 0;
        Shortstops = 0;
        ThirdBasemen = 0;
        LeftFielders = 0;
        CenterFielders = 0;
        RightFielders = 0;
    }
    
    public boolean addPlayer(Player player) 
    {
        String position = player.getPosition();
        switch (position) 
        {
            case "P":
                if (Pitchers < 4) 
                {
                    Pitchers++;
                    players.add(player);
                    return true;
                }
                break;
            case "C":
                if (Catchers < 2) 
                {
                    Catchers++;
                    players.add(player);
                    return true;
                }
                break;
            case "1B":
                if (FirstBasemen < 2) 
                {
                    FirstBasemen++;
                    players.add(player);
                    return true;
                }
                break;
            case "2B":
                if (SecondBasemen < 2) 
                {
                    SecondBasemen++;
                    players.add(player);
                    return true;
                }
                break;
            case "SS":
                if (Shortstops < 2) 
                {
                    Shortstops++;
                    players.add(player);
                    return true;
                }
                break;
            case "3B":
                if (ThirdBasemen < 2) 
                {
                    ThirdBasemen++;
                    players.add(player);
                    return true;
                }
                break;
            case "LF":
                if (LeftFielders < 2) 
                {
                    LeftFielders++;
                    players.add(player);
                    return true;
                }
                break;
            case "CF":
                if (CenterFielders < 2) 
                {
                    CenterFielders++;
                    players.add(player);
                    return true;
                }
                break;
            case "RF":
                if (RightFielders < 2) 
                {
                    RightFielders++;
                    players.add(player);
                    return true;
                }
                break;
            default:
                if (players.size() < 20) // 12 is the maximum roster size
                { 
                    players.add(player);
                    return true;
                }
                break;
        }
        return false;
    }
    
    public List<Player> getPlayers() 
    {
        return players;
    }
    
    public String getTeamName() 
    {
        return teamName;
    }
}