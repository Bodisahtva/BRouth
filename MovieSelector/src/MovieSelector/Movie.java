package MovieSelector;

public class Movie
{
	 String title;
    String actor;
    String genre;
    String era;

    public Movie(String title, String actor, String genre, String era) 
    {
        this.title = title;
        this.actor = actor;
        this.genre = genre;
        this.era = era;
    }

    @Override
    public String toString() 
    {
        return "Title: " + title + ", Actor: " + actor + ", Genre: " + genre + ", Era: " + era;
    }
}
