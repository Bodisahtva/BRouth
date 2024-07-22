package FantasyBaseball;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Draft 
{
    private List<Player> playerPool;
    private List<FantasyTeam> teams;
    private int currentTeamIndex;
    private boolean forward;

    public Draft(String playerFile) throws IOException 
    {
        playerPool = new ArrayList<>();
        teams = new ArrayList<>();
        currentTeamIndex = 0;
        forward = true;
        readPlayersFromFile(playerFile);
    }

    private void readPlayersFromFile(String playerFile) throws IOException 
    {
        BufferedReader reader = new BufferedReader(new FileReader(playerFile));
        String line;
        while ((line = reader.readLine()) != null) 
        {
            String[] parts = line.split(",");
            if (parts.length == 3) 
            {
                playerPool.add(new Player(parts[0], parts[1], parts[2]));
            } else 
            {
                System.out.println("Invalid line format: " + line);
            }
        }
        reader.close();
    }

    public void addTeam(FantasyTeam team) 
    {
        teams.add(team);
    }

    public boolean draftPlayer(String playerName) 
    {
        Iterator<Player> iterator = playerPool.iterator();
        while (iterator.hasNext()) 
        {
            Player player = iterator.next();
            if (player.getName().equalsIgnoreCase(playerName)) 
            {
                FantasyTeam currentTeam = teams.get(currentTeamIndex);
                if (currentTeam.addPlayer(player)) 
                {
                    iterator.remove();
                    advanceTurn();
                    displayCurrentTeamRoster(); // Display updated roster after drafting
                    return true;
                }
                break;
            }
        }
        return false;
    }

    private void advanceTurn() 
    {
        if (forward) 
        {
            currentTeamIndex++;
            if (currentTeamIndex >= teams.size()) 
            {
                currentTeamIndex = teams.size() - 1;
                forward = false;
            }
        } else 
        {
            currentTeamIndex--;
            if (currentTeamIndex < 0) 
            {
                currentTeamIndex = 0;
                forward = true;
            }
        }
    }

    public void startDraft() 
    {
        Scanner scanner = new Scanner(System.in);
        while (!playerPool.isEmpty()) 
        {
            FantasyTeam currentTeam = teams.get(currentTeamIndex);

            // Display available players
            System.out.println("\nAvailable Players:");
            for (Player player : playerPool) 
            {
                System.out.println(player.getName() + " (" + player.getPosition() + ", " + player.getTeam() + ")");
            }

            // Display current team's roster
            System.out.println("\n" + currentTeam.getTeamName() + "'s Current Roster:");
            displayCurrentTeamRoster();

            // Prompt for player pick including team name
            System.out.print("\n" + currentTeam.getTeamName() + ", select the player you want to draft: ");
            String playerName = scanner.nextLine();

            // Check if the player name is valid
            if (!draftPlayer(playerName)) 
            {
                // If invalid, display error message
                System.out.println("\n***Invalid pick. Select a valid player.***");
            }
        }
        scanner.close();
        displayTeams();
    }

    private void displayCurrentTeamRoster() 
    {
        FantasyTeam currentTeam = teams.get(currentTeamIndex);
        List<Player> roster = currentTeam.getPlayers();
        for (Player player : roster) 
        {
            System.out.println(" - " + player.getName() + " (" + player.getPosition() + ", " + player.getTeam() + ")");
        }
    }

    public void displayTeams() 
    {
        for (FantasyTeam team : teams) {
            System.out.println("\n" + team.getTeamName() + ":");
            for (Player player : team.getPlayers()) 
            {
                System.out.println(" - " + player.getName() + " (" + player.getPosition() + ", " + player.getTeam() + ")");
            }
        }
    }

    public List<Player> getPlayerPool() {
        return playerPool;
    }
}