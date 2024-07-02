package MovieSelector;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * REQUIRES RUN AS > JAVA APPLICATION ON FIRST RUN
 */

public class FlikPik 
{
    private static List<Movie> movies = new ArrayList<>(); //creates array of movies
    private static Random random = new Random(); // random number generator
    private static Scanner scanner = new Scanner(System.in); //Input scanner

    public static void main(String[] args) 
    {
        // Load movies from file
        loadMoviesFromFile("MovieList.txt"); //calls loadMoviesFromFile method

        while (true) 
        {
            System.out.println("\nSearch by: 1. Actor  2. Genre  3. Era");
            int choice = scanner.nextInt(); //
            scanner.nextLine();

            List<Movie> filteredMovies = new ArrayList<>(); //creates new array of movies that meets the users criteria
            switch (choice) 
            {
                case 1:
                    System.out.println("\nEnter Actor:");
                    String actor = scanner.nextLine().trim();
                    System.out.println("\nSearching for actor: " + actor); // Debug statement
                    filteredMovies = searchByActor(actor);
                    break;
                case 2:
                    System.out.println("\nChoose from the following Genres:");
                    System.out.println ( "\n| Action | Adventure | Anime | Biography | Comedy | Crime | Drama | Fantasy | Foreign | Mystery | Romance | Sci-Fi | Thriller | Western |" );
                    String genre = scanner.nextLine().trim();
                    System.out.println("\nSearching for genre: " + genre); // Debug statement
                    filteredMovies = searchByGenre(genre);
                    break;
                case 3:
                    System.out.println("\nEnter Era: ");
                    System.out.println ( "\n| 2020s | 2010s | 2000s | 90s | 80s | 70s | 60s | Silver Screen |");
                    String era = scanner.nextLine().trim();
                    System.out.println("\nSearching for era: " + era); // Debug statement
                    filteredMovies = searchByEra(era);
                    break;
                default:
                    System.out.println("\nInvalid choice, choose 1, 2 or 3");
                    continue;
            }

            if (filteredMovies.isEmpty()) 
            {
                System.out.println("No movies found");
            } 
            else 
            {
                chooseMovie(filteredMovies);
            }
        }
    }

    private static void loadMoviesFromFile(String fileName) 
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) 
        {
            String line;
            while ((line = reader.readLine()) != null) //loop reads until new line is blank/end of doc
            {
                String[] values = line.split(","); //criteria separated by "," on input file
                if (values.length == 4) 
                {
                    movies.add(new Movie(values[0].trim(), values[1].trim(), values[2].trim(), values[3].trim()));
                }
            }
            // Debug print to verify movies are loaded correctly
            for (Movie movie : movies) 
            {
                System.out.println("Loaded Movie: " + movie); //prints movie database
            }
        } catch (IOException e) 
        {
            System.err.println("Error reading the file: " + e.getMessage()); //check if file loads correctly
        }
    }

    private static List<Movie> searchByActor(String actor) 
    {
        List<Movie> result = new ArrayList<>();
        for (Movie movie : movies) 
        {
            if (movie.actor.equalsIgnoreCase(actor)) 
            {
                result.add(movie);
            }
        }
        System.out.println("\nFound " + result.size() + " movies with Actor " + actor); // Debug statement
        return result;
    }

    private static List<Movie> searchByGenre(String genre) 
    {
        List<Movie> result = new ArrayList<>();
        for (Movie movie : movies) 
        {
            if (movie.genre.equalsIgnoreCase(genre)) 
            {
                result.add(movie);
            }
        }
        System.out.println("\nFound " + result.size() + " movies with genre: " + genre); // Debug statement lists no. of movies matching query
        return result;
    }

    private static List<Movie> searchByEra(String era) 
    {
        List<Movie> result = new ArrayList<>();
        for (Movie movie : movies) 
        {
            if (movie.era.equalsIgnoreCase(era)) 
            {
                result.add(movie);
            }
        }
        System.out.println("\nFound " + result.size() + " movies from era: " + era); // Debug statement
        return result;
    }

    private static void chooseMovie(List<Movie> movies) 
    {
        while (true) 
        {
            int index = random.nextInt(movies.size());
            Movie selectedMovie = movies.get(index);
            System.out.println("\nSelected Movie: "); 
            System.out.println (" ");
            System.out.print ("*** ");
            System.out.print ( selectedMovie.title);
            System.out.print (" ***");
            System.out.println (" ");
            System.out.println("\nGenre: " + selectedMovie.genre);
            System.out.println("Actor: " + selectedMovie.actor);
            System.out.println("Era: " + selectedMovie.era);
            System.out.println("\nDo you want to watch this movie? (yes or no)");
            String response = scanner.nextLine().trim();
            
            if (response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y")) 
            {
                System.out.println("Enjoy your movie!");
                break;
            } 
            else if (response.equalsIgnoreCase("no") || response.equalsIgnoreCase("n"))
            {
            	System.out.println ("\nSelecting another movie...");
            }
            else
            {
                System.out.println("Invalid response. Please type 'yes' or 'no'.");
            }
        }
    }
}