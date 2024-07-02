package edu.frcc.csc1061j.PlaylistManager;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.w3c.dom.Node;

public class PlaylistDriver {

	public static void main(String[] args) {
		MyDoubleLinkedList<Song> playlist = new MyDoubleLinkedList<Song>();
		Scanner input = new Scanner(System.in);
		int userChoice;
		String artistInput;
		String songInput;
		
		do {
			System.out.println("Functions: \n" + "1 = Add \n" + "2 = Remove \n" + "3 = Play \n" + "4 = Count \n"
					+ "5 = Shuffle \n" + "6 = Reverse \n" + "7 = Quit \n");
			System.out.println("Enter a number:");
			userChoice = input.nextInt();
			input.nextLine();

			if (userChoice == 1) {
				System.out.println("Enter Artist");
				artistInput = input.nextLine();
				System.out.println("Enter Song title");
				songInput = input.nextLine();
				playlist.add(new Song(artistInput, songInput));
				System.out.println("");
			}
			if (userChoice == 2) {
				System.out.println("Enter Artist");
				artistInput = input.nextLine();
				System.out.println("Enter Song title");
				songInput = input.nextLine();
				System.out.println("");
				for (int i = 0; i < playlist.size(); i++)
				{
				if (artistInput.equals(playlist.get(i).getArtistName()) && songInput.equals(playlist.get(i).getSongName()))
				{
					playlist.remove(i);
				}
				else
				{
					System.out.println("Song is not in playlist");
				}
				}
			}
			if (userChoice == 3) 
			{
				for (Song s : playlist)
				{
					System.out.print("Artist = " + s.getArtistName());
					System.out.println(" Song = " + s.getSongName());
					System.out.println("");
				}
			}
			if (userChoice == 4) {
				System.out.println("Count = " + playlist.size());
			}
			if (userChoice == 5) {
				System.out.println("Shuffling songs");
				shuffleList(playlist);
			}
			if (userChoice == 6) {
				System.out.println("Reverse play");
				playlist.reverseList();
			}
		} while (userChoice != 7);

	}

	public static void shuffleList(MyDoubleLinkedList<Song> playlist) {
		Random rand = new Random();
		Song temp;
		int random;
		
		for (int i = 0; i < playlist.size(); i++) {
			random = rand.nextInt(playlist.size());
			System.out.println(random);
			temp = playlist.get(i);
			playlist.set(i, playlist.get(random));
			playlist.set(random , temp);
		}
	}
}
