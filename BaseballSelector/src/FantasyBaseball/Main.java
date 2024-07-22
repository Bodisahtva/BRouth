package FantasyBaseball;

import java.io.IOException;
import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
        try {
            Scanner scanner = new Scanner(System.in);

            // Prompt users to enter team names
            System.out.println("Enter Team 1 name:");
            String team1Name = scanner.nextLine();

            System.out.println("Enter Team 2 name:");
            String team2Name = scanner.nextLine();

            System.out.println("Enter Team 3 name:");
            String team3Name = scanner.nextLine();

            System.out.println("Enter Team 4 name:");
            String team4Name = scanner.nextLine();

            Draft draft = new Draft("MLBworking.txt");

            FantasyTeam team1 = new FantasyTeam(team1Name);
            FantasyTeam team2 = new FantasyTeam(team2Name);
            FantasyTeam team3 = new FantasyTeam(team3Name);
            FantasyTeam team4 = new FantasyTeam(team4Name);

            draft.addTeam(team1);
            draft.addTeam(team2);
            draft.addTeam(team3);
            draft.addTeam(team4);

            draft.startDraft();

            scanner.close();

        } catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}